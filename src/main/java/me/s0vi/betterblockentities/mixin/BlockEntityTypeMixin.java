package me.s0vi.betterblockentities.mixin;

import me.s0vi.betterblockentities.BetterBlockEntities;
import me.s0vi.betterblockentities.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin {
    @Inject(at = @At(value = "RETURN"), method = "create")
    static <T extends BlockEntity> void preventBlockEntityTypeRegistration(String id, BlockEntityType.Builder<T> builder, CallbackInfoReturnable<BlockEntityType<T>> cir) {
        ModConfig.ToggledListSection section = BetterBlockEntities.getConfig().getFallingBlocks();
        if(section.isEnabled()) {
            if(section.isWhitelist()) {
                //Blocks that this BlockEntity is associated with
//                Set<Block> blocks = ((BlockEntityTypeBuilderAccessor)(Object)builder).getBlocks(); // the (Object) cast could be a problem
                Set<Block> blockSet = ((BlockEntityTypeBuilderAccessor)(Object)builder).getBlocks();
                Set<String> blockIdStrings = blockSet.stream()
                        .map(block -> Registry.BLOCK.getId(block))
                        .filter(Objects::nonNull)
                        .map(Identifier::toString)
                        .collect(Collectors.toSet());
                Set<String> blocksToMatch = section.getBlocks().stream()
                        .map(Identifier::toString)
                        .collect(Collectors.toSet());
                if(anyMatch(blocksToMatch, blockIdStrings)) {
                    ((BlockEntityTypeBuilderAccessor)(Object)builder).setBlocks(blockSet);
                }
            } else {

            }
        }
    }

    private static <T> boolean anyMatch(Set<T> a, Set<T> b) {
        for (T t : a) {
            if(b.contains(t)) {
                return true;
            }
        }

        return false;
    }
}
