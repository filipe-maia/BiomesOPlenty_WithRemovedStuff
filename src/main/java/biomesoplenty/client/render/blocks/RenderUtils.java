package biomesoplenty.client.render.blocks;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

public class RenderUtils 
{
	public static int foliageModel = -1;
	public static int plantsModel = -1;
	public static int bonesModel = -1;
	public static int graveModel = -1;
	public static int bambooModel = -1;
	
	public static void renderStandardInvBlock(RenderBlocks renderblocks, Block block, int meta)
	{
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		//TODO:		renderFaceYNeg								   getIcon()
		renderblocks.func_147768_a(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(0, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		//TODO:		renderFaceYPos								   getIcon()
		renderblocks.func_147806_b(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(1, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		//TODO:		renderFaceZNeg								   getIcon()
		renderblocks.func_147761_c(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(2, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		//TODO:		renderFaceZPos								   getIcon()
		renderblocks.func_147734_d(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(3, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		//TODO:		renderFaceXNeg								   getIcon()
		renderblocks.func_147798_e(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(4, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		//TODO:		renderFaceXPos								   getIcon()
		renderblocks.func_147764_f(block, 0.0D, 0.0D, 0.0D, block.func_149691_a(5, meta));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}
