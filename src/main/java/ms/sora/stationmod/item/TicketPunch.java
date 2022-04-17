package ms.sora.stationmod.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import javax.annotation.ParametersAreNonnullByDefault;
import mcp.MethodsReturnNonnullByDefault;
import ms.sora.stationmod.ModInfo;
import ms.sora.stationmod.StationMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TicketPunch extends StationItem {
    public TicketPunch() {
        super();
        this.setCreativeTab(StationMod.STATION_TAB);
        this.setHasSubtypes(false);
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setRegistryName(ModInfo.MOD_ID, "ticket_punch");
        this.setUnlocalizedName("ticketPunch");
    }

    @Override
    @MethodsReturnNonnullByDefault
    public ActionResult<ItemStack> onItemRightClick(@ParametersAreNonnullByDefault World world, @ParametersAreNonnullByDefault EntityPlayer player, @ParametersAreNonnullByDefault EnumHand hand) {
        if(hand == EnumHand.MAIN_HAND && player.getHeldItem(EnumHand.OFF_HAND).getUnlocalizedName().equals(new ItemStack(StationMod.Items.ticket).getUnlocalizedName())) {
            ItemStack ticket = player.getHeldItem(EnumHand.OFF_HAND);
            ticket.setItemDamage(1);
            player.setHeldItem(EnumHand.OFF_HAND, ticket);
            return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
        } else if(hand == EnumHand.OFF_HAND && player.getHeldItem(EnumHand.MAIN_HAND).getUnlocalizedName().equals(new ItemStack(StationMod.Items.ticket).getUnlocalizedName())) {
            ItemStack ticket = player.getHeldItem(EnumHand.MAIN_HAND);
            ticket.setItemDamage(1);
            player.setHeldItem(EnumHand.MAIN_HAND, ticket);
            return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
        }
        return new ActionResult<>(EnumActionResult.FAIL, player.getHeldItem(hand));
    }

    @Override
    @MethodsReturnNonnullByDefault
    public EnumActionResult onItemUse(@ParametersAreNonnullByDefault EntityPlayer player, @ParametersAreNonnullByDefault World world, @ParametersAreNonnullByDefault BlockPos pos, @ParametersAreNonnullByDefault EnumHand hand, @ParametersAreNonnullByDefault EnumFacing facing, float hitX, float hitY, float hitZ) {
        return onItemRightClick(world, player, hand).getType();
    }

    @Override
    @MethodsReturnNonnullByDefault
    public Multimap<String, AttributeModifier> getAttributeModifiers(@ParametersAreNonnullByDefault EntityEquipmentSlot slot, @ParametersAreNonnullByDefault ItemStack item) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if(slot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 10.0F, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.5D, 0));
        }
        return multimap;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@ParametersAreNonnullByDefault CreativeTabs tab, @ParametersAreNonnullByDefault NonNullList<ItemStack> subItems) {
        if(!isInCreativeTab(tab)) return;
        subItems.add(new ItemStack(this, 1, 0));
    }
}
