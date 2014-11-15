package com.github.mrebhan.hoverboat;

import com.github.mrebhan.hoverboat.entity.EntityHoverBoat;
import com.github.mrebhan.hoverboat.item.ItemHopperEngine;
import com.github.mrebhan.hoverboat.item.ItemHoverBoat;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
		GameRegistry.registerItem(ItemHopperEngine.item, "ItemHopperEngine");
	}
	
	private static void addRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ItemHoverBoat.item), "gcg", "ggg", " e ", 'g', new ItemStack(Items.gold_ingot), 'c', new ItemStack(Blocks.glass), 'e', new ItemStack(ItemHopperEngine.item));
		GameRegistry.addShapedRecipe(new ItemStack(ItemHopperEngine.item, Integer.MAX_VALUE), "drd", "iii", "RhR", 'd', stack(Items.diamond), 'r', stack(Items.redstone), 'i', stack(Items.iron_ingot), 'R', stack(Blocks.redstone_block), 'h', stack(Blocks.hopper));
	}

	private static void addEntities() {
		HoverBoat.instance.registerEntity(EntityHoverBoat.class, "HoverBoat", true);
	}
	
	private static ItemStack stack(Item i) {
		return new ItemStack(i);
	}
	
	private static ItemStack stack(Block b) {
		return new ItemStack(b);
	}
}
