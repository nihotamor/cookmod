package doph.niho.cookmod.itemblock;

import doph.niho.cookmod.block.BlockManaita2;
import doph.niho.cookmod.init.BlockRegisterer;
import net.minecraft.item.ItemStack;

public class ItemBlockManaita2 extends BaseItemBlock {
	public ItemBlockManaita2() {
		super(BlockRegisterer.manaita2);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int damage) {
		return damage;
	}

	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((BlockManaita2)this.block).getUnlocalizedName(stack);
	}
}
