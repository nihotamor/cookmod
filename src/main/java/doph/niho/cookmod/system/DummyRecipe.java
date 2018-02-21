package doph.niho.cookmod.system;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class DummyRecipe implements IRecipe {
	private ResourceLocation registryName = null;

	@Override
	public boolean matches(final InventoryCrafting inv, final World worldIn) {
		return false;
	}

	@Override
	public ItemStack getCraftingResult(final InventoryCrafting inv) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canFit(final int width, final int height) {
		return false;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		registryName = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return registryName;
	}

	@Override
	public Class<IRecipe> getRegistryType() {
		return IRecipe.class;
	}
}
