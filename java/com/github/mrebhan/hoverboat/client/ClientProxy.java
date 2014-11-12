package com.github.mrebhan.hoverboat.client;

import com.github.mrebhan.hoverboat.CommonProxy;
import com.github.mrebhan.hoverboat.client.render.RenderHoverBoat;
import com.github.mrebhan.hoverboat.entity.EntityHoverBoat;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityHoverBoat.class, new RenderHoverBoat());
	}
}
