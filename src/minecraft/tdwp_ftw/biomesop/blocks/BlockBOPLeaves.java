package tdwp_ftw.biomesop.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import tdwp_ftw.biomesop.mod_BiomesOPlenty;
import tdwp_ftw.biomesop.configuration.BOPBlocks;

import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockBOPLeaves extends BlockLeavesBase implements IShearable
{
    private static final String[] leaves = new String[] {"autumn", "bamboo", "blue", "dark", "dead", "fir", "holy", "orange", "origin", "pink", "red", "white"};
    @SideOnly(Side.CLIENT)
    private Icon[][] textures;
    
    public BlockBOPLeaves(int blockID)
    {
        super(blockID, Material.leaves, false);
        setBurnProperties(this.blockID, 30, 60);
        this.setTickRandomly(true);
        this.setCreativeTab(mod_BiomesOPlenty.tabBiomesOPlenty);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        textures = new Icon[2][leaves.length];
        
        for (int i = 0; i < leaves.length; ++i)
        {
            textures[0][i] = iconRegister.registerIcon("BiomesOPlenty:" + leaves[i] + "leaves1");
            textures[1][i] = iconRegister.registerIcon("BiomesOPlenty:" + leaves[i] + "leaves2");
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int side, int meta)
    {
        if (meta < 0 || meta >= textures[0].length)
            meta = 0;

        return textures[(!isOpaqueCube() ? 0 : 1)][meta];
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int blockID, CreativeTabs creativeTabs, List list) {
        for (int i = 0; i < textures[0].length; ++i)
            list.add(new ItemStack(blockID, 1, i));
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return BOPBlocks.yellowSapling.blockID;
    }
    
    @Override
    public int damageDropped(int meta)
    {
        return meta & textures[0].length;
    }
    
    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z) 
    {
        return true;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) 
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }
}
