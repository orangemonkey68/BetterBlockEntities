package me.s0vi.betterblockentities.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.BiFunction;

public class FallingBlockWithEntity<T extends BlockEntity> extends FallingBlockEntity {
    private T oldBlockEntity;
    private BiFunction<BlockPos, T, T> generatorFunc;

    /**
     * Don't call this constructor unless you know what you're doing!
     * @param entityType
     * @param world
     */
    public FallingBlockWithEntity(EntityType<? extends FallingBlockEntity> entityType, World world) {
        super(entityType, world);
    }

    public FallingBlockWithEntity(World world, double x, double y, double z, BlockState block, T oldBlockEntity, BiFunction<BlockPos, T, T> generatorFunc) {
        super(world, x, y, z, block);
        this.oldBlockEntity = oldBlockEntity;
        this.generatorFunc = generatorFunc;
    }

    public void setGeneratorFunc(BiFunction<BlockPos, T, T> generatorFunc) {
        this.generatorFunc = generatorFunc;
    }

    public void setOldBlockEntity(T oldBlockEntity) {
        this.oldBlockEntity = oldBlockEntity;
    }

    public T getOldBlockEntity() {
        return oldBlockEntity;
    }

    public void replaceBlockEntity(BlockPos pos) {
        getWorld().addBlockEntity(generatorFunc.apply(pos, oldBlockEntity));
        getWorld().removeBlockEntity(oldBlockEntity.getPos());
    }
}
