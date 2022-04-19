package ms.sora.stationmod.block;

import ms.sora.stationmod.ModInfo;
import ms.sora.stationmod.StationMod;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockRailNoSleeper extends StationBlock {
    public BlockRailNoSleeper() {
        super(Material.CIRCUITS);
        this.setCreativeTab(StationMod.STATION_TAB);
        this.setHardness(0.7F);
        this.setSoundType(SoundType.METAL);
        this.setRegistryName(ModInfo.MOD_ID, "rail_no_sleeper");
        this.setUnlocalizedName("railNoSleeper");
    }
}
