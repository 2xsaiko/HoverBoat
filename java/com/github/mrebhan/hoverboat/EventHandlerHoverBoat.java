package com.github.mrebhan.hoverboat;

import com.github.mrebhan.hoverboat.entity.EntityHoverBoat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

public class EventHandlerHoverBoat {
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent e) {
		//		if (e.phase == Phase.END) {
		Minecraft mc = Minecraft.getMinecraft();
		if (mc.currentScreen == null) {                
			GuiIngame gig = new GuiIngame(mc);
			if (mc.thePlayer.ridingEntity != null && mc.thePlayer.ridingEntity instanceof EntityHoverBoat) {
				EntityHoverBoat hoverBoat = (EntityHoverBoat) mc.thePlayer.ridingEntity;
				mc.fontRenderer.drawStringWithShadow(((Boolean) hoverBoat.playerascend).toString(), 1, 1, -1);
				mc.fontRenderer.drawStringWithShadow(((Boolean) hoverBoat.playerdescend).toString(), 1, 10, -1);
			}
		}
	}
	
	@SubscribeEvent
	public void onKeyPress(KeyInputEvent e) {
		if (Minecraft.getMinecraft().theWorld != null) {
			HoverBoat.instance.wrapper.sendToServer(new PacketKeys(Keybindings.instance().ascendHoverboat.getIsKeyPressed(), Keybindings.instance().descendHoverboat.getIsKeyPressed()));
		}
	}
}
