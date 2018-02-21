package doph.niho.cookmod.init;

import doph.niho.cookmod.block.BaseBlock;
import doph.niho.cookmod.block.BlockManaita;
import doph.niho.cookmod.block.BlockManaita2;
import doph.niho.cookmod.itemblock.BaseItemBlock;
import doph.niho.cookmod.itemblock.ItemBlockManaita;
import doph.niho.cookmod.itemblock.ItemBlockManaita2;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class BlockRegisterer {

	public static BaseBlock manaita;
	public static BaseBlock manaita2;

	public static BaseItemBlock manaitaItem;
	public static BaseItemBlock manaitaItem2;

	public static void RegisterModel() {
		RegisterRender(manaita);
		RegisterRender(manaita2);
	}

	public static void RegisterBlock(RegistryEvent.Register<Block> e) {
		e.getRegistry().register(manaita);
		e.getRegistry().register(manaita2);
	}

	public static void RegisterItemBlock(RegistryEvent.Register<Item> e) {
		e.getRegistry().register(manaitaItem);
		e.getRegistry().register(manaitaItem2);
	}

	public static void RegisterRender(Block block, String... subName) {
		int len = subName.length;
		if (len == 0) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
					new ModelResourceLocation(block.getRegistryName(), "inventory"));
		} else {
			ResourceLocation[] rl = new ResourceLocation[subName.length];
			for(int i = 0; i < subName.length; i++) {
				rl[i] = new ResourceLocation(block.getRegistryName() + subName[i]);
			}
			ModelBakery.registerItemVariants(Item.getItemFromBlock(block), rl);
			for (int i = 0; i < len; i++) {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), i,
						new ModelResourceLocation(block.getRegistryName() + subName[i], "inventory"));
			}
		}
	}

	public static void Init() {
		manaita = new BlockManaita();
		manaita2 = new BlockManaita2();

		manaitaItem = new ItemBlockManaita();
		manaitaItem2 = new ItemBlockManaita2();
	}
}
