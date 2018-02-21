package doph.niho.cookmod.init;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import doph.niho.cookmod.system.Define;
import doph.niho.cookmod.system.DummyRecipe;
import net.minecraft.item.ItemFood;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RecipeDeleter {

	public static void DeleteRecipe() {
		IForgeRegistry<IRecipe> Registry = ForgeRegistries.RECIPES;
		List<ResourceLocation> res = new ArrayList<>();
		Set<ResourceLocation> rl = Registry.getKeys();

		Iterator<ResourceLocation> it = rl.iterator();
		while (it.hasNext()) {
			IRecipe recipe = Registry.getValue(it.next());
			if ((recipe.getRecipeOutput().getItem() instanceof ItemFood) || Registry.getKey(recipe).getResourcePath().equals("cake")) {
				if (!Registry.getKey(recipe).getResourceDomain().equals(Define.MODID)) {
					res.add(Registry.getKey(recipe));
				}
			}
		}
		if (!res.isEmpty()) {
			for (ResourceLocation key : res) {
				((IForgeRegistryModifiable<IRecipe>) Registry).remove(key);
				Registry.register(new DummyRecipe().setRegistryName(key));
			}
			res.clear();
		}
	}
}
