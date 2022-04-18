package ms.sora.stationmod.block;

import ms.sora.stationmod.StationMod;
import net.minecraft.block.material.Material;

public class BlockRailNoSleeper extends StationBlock {
    public BlockRailNoSleeper() {
        super(Material.CIRCUITS);
        this.setCreativeTab(StationMod.STATION_TAB);
    }
}
