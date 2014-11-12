package com.github.mrebhan.hoverboat;

import com.github.mrebhan.hoverboat.entity.EntityHoverBoat;
import com.github.mrebhan.hoverboat.item.ItemHoverBoat;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
	public static void addAll() {
		addItems();
		addRecipes();
		addEntities();
	}
	
	private static void addItems() {
		GameRegistry.registerItem(ItemHoverBoat.item, "ItemHoverBoat");
	}
	
	private static void addRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ItemHoverBoat.item), "gcg", "ggg", "R R", 'g', new ItemStack(Items.gold_ingot), 'c', new ItemStack(Blocks.carpet), 'R', new ItemStack(Blocks.redstone_block));
	}
	
	private static void addEntities() {
		HoverBoat.instance.registerEntity(EntityHoverBoat.class, "HoverBoat", true);
	}
}
