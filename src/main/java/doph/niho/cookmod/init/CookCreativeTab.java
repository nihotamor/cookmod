package doph.niho.cookmod.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookCreativeTab extends CreativeTabs {
	public static final CreativeTabs cookModFood = new CookCreativeTab("CookModFood");
	public static final CreativeTabs cookModBlock = new CookCreativeTab("CookModBlock");
	public static final CreativeTabs cookModTool = new CookCreativeTab("CookModTool");

	public CookCreativeTab(String label) {
		super(label);
	}

	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem() {
		switch (this.getTabLabel()) {
		case "CookModFood":
			return new ItemStack(CookModFood.food);
		case "CookModBlock":
			return new ItemStack(CookModFood.food);
		case "CookModTool" :
			return new ItemStack(CookModFood.food);
		default:
			return ItemStack.EMPTY;
		}
	}
}
