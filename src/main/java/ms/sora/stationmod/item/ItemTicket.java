package ms.sora.stationmod.item;

import javax.annotation.ParametersAreNonnullByDefault;
import mcp.MethodsReturnNonnullByDefault;
import ms.sora.stationmod.ModInfo;
import ms.sora.stationmod.StationMod;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.StringUtils;

public class ItemTicket extends StationItem {
    public ItemTicket() {
        super();
        this.setCreativeTab(StationMod.STATION_TAB);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setMaxStackSize(1);
        this.setNoRepair();
        this.setRegistryName(ModInfo.MOD_ID, "ticket");
        this.setUnlocalizedName("ticket.0");
    }

    @Override
    public int getMetadata(int meta) {
        return meta & 1;
    }

    @Override
    @MethodsReturnNonnullByDefault
    public String getUnlocalizedName(@ParametersAreNonnullByDefault ItemStack item) {
        if((item.getItemDamage() & 1) == 1) return StringUtils.removeEnd(super.getUnlocalizedName(), "0") + '1';
        return super.getUnlocalizedName();
    }
}
