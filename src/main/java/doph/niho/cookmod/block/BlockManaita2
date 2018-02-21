package doph.niho.cookmod.block;

import doph.niho.cookmod.system.Define;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockManaita2 extends BaseBlock {
	public static final PropertyEnum<BlockManaita2.EnumType> VARIANT = PropertyEnum.<BlockManaita2.EnumType>create("meta",
			BlockManaita2.EnumType.class);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	protected static final AxisAlignedBB X_AXIS_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.25D, 0.9375D, 0.0625D, 0.75D);
	protected static final AxisAlignedBB Z_AXIS_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.0625D, 0.75D, 0.0625D, 0.9375D);

	public BlockManaita2() {
		super(Material.WOOD);
		this.setRegistryName(new ResourceLocation(Define.MODID, "manaita2"));
		this.setUnlocalizedName("manaita");
		this.setHardness(0.25F);
		this.setResistance(0.5F);
		this.setSoundType(SoundType.WOOD);
		this.setLightOpacity(1);
		this.setLightLevel(0.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockManaita2.EnumType.ACACIA));
	}

	public boolean isFulllCube(IBlockState state) {
		return false;
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	public boolean isOpequeCube(IBlockState state) {
		return false;
	}

	@SuppressWarnings("deprecation")
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();

		try {
			return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing).withProperty(VARIANT, BlockManaita2.EnumType.byMetadata(meta));
		} catch(IllegalArgumentException var11) {
			if(!worldIn.isRemote) {
				if(placer instanceof EntityPlayer) {
					placer.sendMessage(new TextComponentTranslation("Invalid damage property. Please pick in [0, 1]", new Object[0]));
				}
			}
			return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing).withProperty(VARIANT, BlockManaita2.EnumType.ACACIA);
		}
	}

	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return true;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		return enumfacing.getAxis() == EnumFacing.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
	}

	public AxisAlignedBB getCollisionBoudingBox(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		return enumfacing.getAxis() == EnumFacing.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
	}

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }

	public String getUnlocalizedName(ItemStack item) {
		return BlockManaita2.EnumType.byMetadata(item.getMetadata()).getUnlocalizedName();
	}

	public int damageDropped(IBlockState state) {
		return ((BlockManaita2.EnumType) state.getValue(VARIANT)).getMetadata();
	}

	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (BlockManaita2.EnumType blockmanaita$enumtype : BlockManaita2.EnumType.values()) {
			items.add(new ItemStack(this, 1, blockmanaita$enumtype.getMetadata()));
		}
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.AIR;
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 4)).withProperty(VARIANT, BlockManaita2.EnumType.byMetadata(meta));
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
		i = i | ((BlockManaita2.EnumType)state.getValue(VARIANT)).getMetadata();
		return i;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.getBlock() != this ? state : state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, VARIANT });
	}

	public static enum EnumType implements IStringSerializable {
		ACACIA(0, "acacia"), DARK_OAK(1, "dark_oak");

		private static final BlockManaita2.EnumType[] META_LOOKUP = new BlockManaita2.EnumType[values().length];
		private final int meta;
		private final String name;

		private EnumType(int metaIn, String nameIn) {
			this.meta = metaIn;
			this.name = nameIn;
		}

		public int getMetadata() {
			return this.meta;
		}

		public String toString() {
			return this.name;
		}

		public static BlockManaita2.EnumType byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}
			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.name;
		}

		public String getUnlocalizedName() {
			return this.name;
		}

		static {
			for (BlockManaita2.EnumType blockmanaita$enumtype : values()) {
				META_LOOKUP[blockmanaita$enumtype.getMetadata()] = blockmanaita$enumtype;
			}
		}
	}
}
