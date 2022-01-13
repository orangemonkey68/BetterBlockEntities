package me.s0vi.betterblockentities.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.listener.GameEventListener;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

/**
 * A mostly-generated class that wraps another block's functionality around the logic of a falling block
 * @param <T>
 */
@SuppressWarnings({"deprecation", "CommentedOutCode"})
public class FallingWrapperBlock<T extends BlockWithEntity> extends BlockWithEntity{
    private final T parent;

    protected FallingWrapperBlock(Settings settings, T parent) {
        super(settings);
        this.parent = parent;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return parent.hasRandomTicks(state);
    }

    @Override
    public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos) {
        return parent.isTranslucent(state, world, pos);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        parent.randomDisplayTick(state, world, pos, random);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        parent.onBroken(world, pos, state);
    }

//    @Override
//    protected void dropExperience(ServerWorld world, BlockPos pos, int size) {
//        parent.dropExperience(world, pos, size);
//    }

    @Override
    public float getBlastResistance() {
        return parent.getBlastResistance();
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        parent.onDestroyedByExplosion(world, pos, explosion);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        parent.onSteppedOn(world, pos, state, entity);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return parent.getPlacementState(ctx);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        parent.afterBreak(world, player, pos, state, blockEntity, stack);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        parent.onPlaced(world, pos, state, placer, itemStack);
    }

    @Override
    public boolean canMobSpawnInside() {
        return parent.canMobSpawnInside();
    }

    @Override
    public MutableText getName() {
        return parent.getName();
    }

    @Override
    public String getTranslationKey() {
        return parent.getTranslationKey();
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        parent.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        parent.onEntityLand(world, entity);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return parent.getPickStack(world, pos, state);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        parent.appendStacks(group, stacks);
    }

    @Override
    public float getSlipperiness() {
        return parent.getSlipperiness();
    }

    @Override
    public float getVelocityMultiplier() {
        return parent.getVelocityMultiplier();
    }

    @Override
    public float getJumpVelocityMultiplier() {
        return parent.getJumpVelocityMultiplier();
    }

//    @Override
//    protected void spawnBreakParticles(World world, PlayerEntity player, BlockPos pos, BlockState state) {
//        parent.spawnBreakParticles(world, player, pos, state);
//    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        parent.onBreak(world, pos, state, player);
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        parent.precipitationTick(state, world, pos, precipitation);
    }

    @Override
    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return parent.shouldDropItemsOnExplosion(explosion);
    }

//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        parent.appendProperties(builder);
//    }

    @Override
    public StateManager<Block, BlockState> getStateManager() {
        return parent.getStateManager();
    }

    @Override
    public BlockSoundGroup getSoundGroup(BlockState state) {
        return parent.getSoundGroup(state);
    }

    @Override
    public Item asItem() {
        return parent.asItem();
    }

    @Override
    public boolean hasDynamicBounds() {
        return parent.hasDynamicBounds();
    }

    @Override
    public String toString() {
        return parent.toString();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        parent.appendTooltip(stack, world, tooltip, options);
    }

//    @Override
//    protected Block asBlock() {
//        return parent.asBlock();
//    }

//    @Override
//    protected ImmutableMap<BlockState, VoxelShape> getShapesForStates(Function<BlockState, VoxelShape> stateToShape) {
//        return parent.getShapesForStates(stateToShape);
//    }

    @Override
    public void prepare(BlockState state, WorldAccess world, BlockPos pos, int flags, int maxUpdateDepth) {
        parent.prepare(state, world, pos, flags, maxUpdateDepth);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return parent.canPathfindThrough(state, world, pos, type);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return parent.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return parent.isSideInvisible(state, stateFrom, direction);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        parent.neighborUpdate(state, world, pos, block, fromPos, notify);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        parent.onBlockAdded(state, world, pos, oldState, notify);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        parent.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return parent.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return parent.hasSidedTransparency(state);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return parent.emitsRedstonePower(state);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return parent.getPistonBehavior(state);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return parent.getFluidState(state);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return parent.hasComparatorOutput(state);
    }

    @Override
    public OffsetType getOffsetType() {
        return parent.getOffsetType();
    }

    @Override
    public float getMaxHorizontalModelOffset() {
        return parent.getMaxHorizontalModelOffset();
    }

    @Override
    public float getVerticalModelOffsetMultiplier() {
        return parent.getVerticalModelOffsetMultiplier();
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return parent.rotate(state, rotation);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return parent.mirror(state, mirror);
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return parent.canReplace(state, context);
    }

    @Override
    public boolean canBucketPlace(BlockState state, Fluid fluid) {
        return parent.canBucketPlace(state, fluid);
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
        return parent.getDroppedStacks(state, builder);
    }

    @Override
    public long getRenderingSeed(BlockState state, BlockPos pos) {
        return parent.getRenderingSeed(state, pos);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return parent.getCullingShape(state, world, pos);
    }

    @Override
    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return parent.getSidesShape(state, world, pos);
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return parent.getRaycastShape(state, world, pos);
    }

    @Override
    public int getOpacity(BlockState state, BlockView world, BlockPos pos) {
        return parent.getOpacity(state, world, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return parent.canPlaceAt(state, world, pos);
    }

    @Override
    public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos) {
        return parent.getAmbientOcclusionLightLevel(state, world, pos);
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return parent.getComparatorOutput(state, world, pos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return parent.getOutlineShape(state, world, pos, context);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return parent.getCollisionShape(state, world, pos, context);
    }

    @Override
    public boolean isShapeFullCube(BlockState state, BlockView world, BlockPos pos) {
        return parent.isShapeFullCube(state, world, pos);
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return parent.getCameraCollisionShape(state, world, pos, context);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        parent.randomTick(state, world, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        parent.scheduledTick(state, world, pos, random);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        return parent.calcBlockBreakingDelta(state, player, world, pos);
    }

    @Override
    public void onStacksDropped(BlockState state, ServerWorld world, BlockPos pos, ItemStack stack) {
        parent.onStacksDropped(state, world, pos, stack);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        parent.onBlockBreakStart(state, world, pos, player);
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return parent.getWeakRedstonePower(state, world, pos, direction);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        parent.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return parent.getStrongRedstonePower(state, world, pos, direction);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        parent.onProjectileHit(world, state, hit, projectile);
    }

    @Override
    public MapColor getDefaultMapColor() {
        return parent.getDefaultMapColor();
    }

    @Override
    public float getHardness() {
        return parent.getHardness();
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return parent.createBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <U extends BlockEntity> BlockEntityTicker<U> getTicker(World world, BlockState state, BlockEntityType<U> type) {
        return parent.getTicker(world, state, type);
    }

    @Nullable
    @Override
    public <U extends BlockEntity> GameEventListener getGameEventListener(World world, U blockEntity) {
        return parent.getGameEventListener(world, blockEntity);
    }
}
