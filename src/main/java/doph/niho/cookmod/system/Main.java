package doph.niho.cookmod.system;

import doph.niho.cookmod.init.BlockRegisterer;
import doph.niho.cookmod.init.CookModFood;
import doph.niho.cookmod.init.RecipeDeleter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Define.MODID, name = Define.MOD_NAME, version = Define.MOD_VERSION, acceptedMinecraftVersions = Define.MOD_MC_VERSION)
@EventBusSubscriber
public class Main {

	@SubscribeEvent
	public static void OnItemsRegistered(RegistryEvent.Register<Item> e) {
		CookModFood.RegisterFood();
		BlockRegisterer.RegisterItemBlock(e);
	}

	@SubscribeEvent
	public static void OnBlocksRegistered(RegistryEvent.Register<Block> e) {
		BlockRegisterer.RegisterBlock(e);
	}

	@SubscribeEvent
	public static void OnModelRegistered(ModelRegistryEvent e) {

	}

	@SubscribeEvent
	public static void OnRecipesRegistered(RegistryEvent.Register<IRecipe> e) {
		RecipeDeleter.DeleteRecipe();
	}

	@EventHandler
	public void PreInit(FMLPreInitializationEvent e) {
		CookModFood.Init();
		BlockRegisterer.Init();
	}

	@EventHandler
	public void Init(FMLInitializationEvent e) {
		BlockRegisterer.RegisterModel();
		CookModFood.RegisterModel();
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent e) {
	}
}
