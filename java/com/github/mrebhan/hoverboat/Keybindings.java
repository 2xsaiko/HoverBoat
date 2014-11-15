package com.github.mrebhan.hoverboat;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class Keybindings {
	private static Keybindings instance;
	
	public KeyBinding ascendHoverboat;
	public KeyBinding descendHoverboat;
	
	public static Keybindings instance() {
		if (instance == null)
			instance = new Keybindings();
		return instance;
	}
	
	private Keybindings() {
		this.ascendHoverboat = new KeyBinding("key.hoverboat.ascend", Keyboard.KEY_R, "key.categories.hoverboat");
		this.descendHoverboat = new KeyBinding("key.hoverboat.descend", Keyboard.KEY_F, "key.categories.hoverboat");
		
		ClientRegistry.registerKeyBinding(ascendHoverboat);
		ClientRegistry.registerKeyBinding(descendHoverboat);
	}
}
