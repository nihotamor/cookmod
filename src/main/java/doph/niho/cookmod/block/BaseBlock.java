package doph.niho.cookmod.block;

import doph.niho.cookmod.init.CookCreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BaseBlock extends Block{
	ResourceLocation registryName;

	public BaseBlock(Material materialIn) {
		super(materialIn);
		this.setCreativeTab(CookCreativeTab.cookModBlock);
	}

	public int getMetadata(int damage) {
		return damage;
	}
}
