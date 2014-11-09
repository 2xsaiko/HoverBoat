package com.github.mrebhan.hoverboat;

import java.util.Random;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;

@Mod(modid = "hoverboat", name="HoverBoat", version="r0")
public class HoverBoat {
	@Instance(value="hoverboat")
	public static HoverBoat instance;
	
	@SidedProxy(clientSide="com.github.mrebhan.hoverboat.client.ClientProxy", serverSide="com.github.mrebhan.hoverboat.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		Registry.addAll();	
		proxy.registerRenderers();
	}

	public int registerEntity(Class entityClass, String entityName, boolean generateEgg) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = entityName.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;

		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityID);
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, instance, 64, 1, true);
		if (generateEgg)
			EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
		return entityID;
	}

}
