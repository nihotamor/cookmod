package doph.niho.cookmod.itemblock;

import doph.niho.cookmod.block.BlockManaita;
import doph.niho.cookmod.init.BlockRegisterer;
import net.minecraft.item.ItemStack;

public class ItemBlockManaita extends BaseItemBlock{

	public ItemBlockManaita() {
		super(BlockRegisterer.manaita);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int damage) {
		return damage;
	}

	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "." + ((BlockManaita)this.block).getUnlocalizedName(stack);
	}
}
