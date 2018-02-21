package doph.niho.cookmod.init;

import doph.niho.cookmod.food.ItemTestFood;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CookModFood {

	public static Item food;

	public static void Init() {
		food = new ItemTestFood();
	}

	public static void RegisterModel() {
		RegisterRender(food);
	}

	public static void RegisterFood() {
		ForgeRegistries.ITEMS.register(food);
	}

	public static void RegisterRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
