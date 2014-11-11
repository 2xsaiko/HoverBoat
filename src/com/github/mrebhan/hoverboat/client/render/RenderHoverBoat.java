package com.github.mrebhan.hoverboat.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.RotationHelper;

import org.lwjgl.opengl.GL11;

import com.github.mrebhan.hoverboat.entity.EntityHoverBoat;

@SideOnly(Side.CLIENT)
public class RenderHoverBoat extends Render
{
    private static final ResourceLocation boatTextures = new ResourceLocation("textures/entity/boat.png");
    /** instance of ModelBoat for rendering */
    protected ModelBase modelBoat;
    private static final String __OBFID = "CL_00000981";

    public RenderHoverBoat()
    {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelBoat();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntityHoverBoat p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        GL11.glPushMatrix();
        GL11.glColor4d(1, 223D / 225D, 0, 1);
        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_ + MathHelper.sin(((float) p_76986_1_.ticksExisted)) / 50, (float)p_76986_6_);
        GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);
        double rot =  (p_76986_1_.rotationYaw - p_76986_1_.prevRotationYaw) * 5;
        GL11.glRotated(rot < 0 ? -Math.min(-rot, 20) : Math.min(rot, 20), 1, 0, 0);
        float f2 = (float)p_76986_1_.getTimeSinceHit() - p_76986_9_;
        float f3 = p_76986_1_.getDamageTaken() - p_76986_9_;

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        if (f2 > 0.0F)
        {
            GL11.glRotatef(MathHelper.sin(f2) * f2 * f3 / 10.0F * (float)p_76986_1_.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float f4 = 0.75F;
        GL11.glScalef(f4, f4, f4);
        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
        this.bindEntityTexture(p_76986_1_);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelBoat.render(p_76986_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityHoverBoat p_110775_1_)
    {
        return boatTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityHoverBoat)p_110775_1_);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
    {
        this.doRender((EntityHoverBoat)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
    }
}