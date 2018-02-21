package doph.niho.cookmod.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BaseItemBlock extends ItemBlock {

	public BaseItemBlock(Block block) {
		super(block);
		this.setRegistryName(this.getBlock().getRegistryName());
		this.setUnlocalizedName(this.getBlock().getUnlocalizedName());
	}

	public BaseItemBlock setUnlocalizedName(String name) {
		super.setUnlocalizedName(name);
		return this;
	}
}
