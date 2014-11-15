package com.github.mrebhan.hoverboat.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHopperEngine extends Item {
	public static Item item = new ItemHopperEngine()
	.setCreativeTab(CreativeTabs.tabMisc)
	.setTextureName("minecraft:hopper")
	.setUnlocalizedName("ItemHopperEngine");
	
}
