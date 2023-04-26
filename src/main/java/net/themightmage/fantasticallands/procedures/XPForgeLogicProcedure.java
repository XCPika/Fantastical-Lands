package net.themightmage.fantasticallands.procedures;

import net.themightmage.fantasticallands.network.Variables;
import net.themightmage.fantasticallands.init.Items;
import net.themightmage.fantasticallands.FantasticalLandsMod;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class XPForgeLogicProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency world for procedure XPForgeLogic!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency x for procedure XPForgeLogic!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency y for procedure XPForgeLogic!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				FantasticalLandsMod.LOGGER.warn("Failed to load dependency z for procedure XPForgeLogic!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		double prev_recipe = 0;
		prev_recipe = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getExtraCustomData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "recipe");
		if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, (new BlockPos(x, y, z)), 0)).getItem() == Items.EMERALD_COIN && ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, (new BlockPos(x, y, z)), 1)).getItem() == Items.XP_TOKEN && new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 1) <= 63 || new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 1) == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getExtraCustomData().putDouble("recipe", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, (true)), 3);
			}
		} else if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, (new BlockPos(x, y, z)), 0)).getItem() == Items.NETHERITE_COIN && ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, (new BlockPos(x, y, z)), 1)).getItem() == Items.XP_TOKEN && new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 1) <= 64 - Variables.MapVariables.get(world).coins_to_convert || new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 1) == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getExtraCustomData().putDouble("recipe", 1);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, (true)), 3);
			}
		} else if ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, (new BlockPos(x, y, z)), 0)).getItem() == Items.GOLD_COIN && new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 0) >= Variables.MapVariables.get(world).coins_to_convert && ((new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> stack = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					stack.set(((RandomizableContainerBlockEntity) _ent).getItem(slotid).copy());
				return stack.get();
			}
		}.getItemStack(world, (new BlockPos(x, y, z)), 1)).getItem() == Items.XP_TOKEN && new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 1) <= 63 || new Object() {
			public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicInteger count = new AtomicInteger(0);
				BlockEntity _ent = world.getBlockEntity(pos);
				RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
				if (_ent != null)
					count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
				return count.get();
			}
		}.getAmount(world, (new BlockPos(x, y, z)), 1) == 0)) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getExtraCustomData().putDouble("recipe", 2);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, (true)), 3);
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getExtraCustomData().putDouble("recipe", (-1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			{
				BlockPos _pos = new BlockPos(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("lit") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, (false)), 3);
			}
		}
		if (prev_recipe != new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getExtraCustomData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "recipe")) {
			if (!world.isClientSide()) {
				BlockPos _bp = new BlockPos(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getExtraCustomData().putDouble("timer", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getExtraCustomData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "recipe") >= 0) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getExtraCustomData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "timer") >= 20) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getExtraCustomData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "recipe") == 0) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						ItemStack stack = new ItemStack(Items.XP_TOKEN);
						stack.setCount((int) (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicInteger count = new AtomicInteger(0);
								BlockEntity _ent = world.getBlockEntity(pos);
								RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
								if (_ent != null)
									count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
								return count.get();
							}
						}.getAmount(world, (new BlockPos(x, y, z)), 1) + 1));
						if (_ent != null) {
							((RandomizableContainerBlockEntity) _ent).setItem(1, stack);
						}
					}
					BlockEntity _ent35 = world.getBlockEntity(new BlockPos(x, y, z));
					if (_ent35 != null) {
						((RandomizableContainerBlockEntity) _ent35).removeItem(0, 1);
					}
				} else if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getExtraCustomData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "recipe") == 1) {
					BlockEntity _ent37 = world.getBlockEntity(new BlockPos(x, y, z));
					if (_ent37 != null) {
						((RandomizableContainerBlockEntity) _ent37).removeItem(0, 1);
					}
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						ItemStack stack = new ItemStack(Items.XP_TOKEN);
						stack.setCount((int) (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicInteger count = new AtomicInteger(0);
								BlockEntity _ent = world.getBlockEntity(pos);
								RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
								if (_ent != null)
									count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
								return count.get();
							}
						}.getAmount(world, (new BlockPos(x, y, z)), 1) + Variables.MapVariables.get(world).coins_to_convert));
						if (_ent != null) {
							((RandomizableContainerBlockEntity) _ent).setItem(1, stack);
						}
					}
				} else if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getExtraCustomData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "recipe") == 2) {
					BlockEntity _ent41 = world.getBlockEntity(new BlockPos(x, y, z));
					if (_ent41 != null) {
						((RandomizableContainerBlockEntity) _ent41).removeItem(0, (int) Variables.MapVariables.get(world).coins_to_convert);
					}
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
						ItemStack stack = new ItemStack(Items.XP_TOKEN);
						stack.setCount((int) (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicInteger count = new AtomicInteger(0);
								BlockEntity _ent = world.getBlockEntity(pos);
								RandomizableContainerBlockEntity ent = (RandomizableContainerBlockEntity) _ent;
								if (_ent != null)
									count.set((int) ent.countItem(ent.getItem(slotid).getItem()));
								return count.get();
							}
						}.getAmount(world, (new BlockPos(x, y, z)), 1) + 1));
						if (_ent != null) {
							((RandomizableContainerBlockEntity) _ent).setItem(1, stack);
						}
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = new BlockPos(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getExtraCustomData().putDouble("timer", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = new BlockPos(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getExtraCustomData().putDouble("timer", (new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getExtraCustomData().getDouble(tag);
								return -1;
							}
						}.getValue(world, new BlockPos(x, y, z), "timer") + 1));
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (Math.random() < 0.5) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
