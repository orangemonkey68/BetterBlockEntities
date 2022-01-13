package me.s0vi.betterblockentities.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(BlockEntityType.Builder.class)
public interface BlockEntityTypeBuilderAccessor {
    @Accessor
    Set<Block> getBlocks();
    @Accessor
    void setBlocks(Set<Block> blocks);
}
