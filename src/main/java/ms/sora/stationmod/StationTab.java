package ms.sora.stationmod;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class StationTab extends CreativeTabs {
    public StationTab(String label) {
        super(label);
    }

    @Override
    @MethodsReturnNonnullByDefault
    public ItemStack getTabIconItem() {
        return new ItemStack(Blocks.RAIL);
    }
}
