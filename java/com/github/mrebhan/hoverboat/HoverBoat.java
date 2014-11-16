package com.github.mrebhan.hoverboat;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = "hoverboat", name="HoverBoat", version="r0", dependencies="required-after:CraftCore")
public class HoverBoat {
	@Instance(value="hoverboat")
	public static HoverBoat instance;
	
	public SimpleNetworkWrapper wrapper;
	
	@SidedProxy(clientSide="com.github.mrebhan.hoverboat.client.ClientProxy", serverSide="com.github.mrebhan.hoverboat.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Registry.addAll();	
		proxy.registerRenderers();
		MinecraftForge.EVENT_BUS.register(new EventHandlerHoverBoat());
		FMLCommonHandler.instance().bus().register(new EventHandlerHoverBoat());
		this.wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("MRebhan:hoverboat");
		Keybindings.instance();
		this.wrapper.registerMessage(PacketKeys.Handler.class, PacketKeys.class, 0, Side.CLIENT);
		this.wrapper.registerMessage(PacketKeys.Handler.class, PacketKeys.class, 0, Side.SERVER);
	}

}
