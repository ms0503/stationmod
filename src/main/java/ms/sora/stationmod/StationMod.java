package ms.sora.stationmod;

import ms.sora.stationmod.block.BlockRailNoSleeper;
import ms.sora.stationmod.item.ItemTicket;
import ms.sora.stationmod.item.ItemTicketPunch;
import ms.sora.stationmod.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(acceptedMinecraftVersions = "[1.12.2]", dependencies = "required-after:FML[8.0.99.99,);required-after:forge[14.23.5.2860,);required-after:mcp[9.42,)", modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, updateJSON = "https://raw.githubusercontent.com/ms0503/modupdate/master/stationmod.json", version = ModInfo.MOD_VERSION)
public class StationMod {
    public static final CreativeTabs STATION_TAB = new StationTab("tabStation");

    @SidedProxy(clientSide = "ms.sora.stationmod.proxy.ClientProxy", modId = ModInfo.MOD_ID, serverSide = "ms.sora.stationmod.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static Logger logger = LogManager.getLogger(ModInfo.MOD_ID);
    @Instance(ModInfo.MOD_ID)
    public static StationMod instance;

    @EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(StationEventHandler.class);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger.info("Welcome to " + ModInfo.MOD_NAME + " Ver." + ModInfo.MOD_VERSION + " !");
    }

    @ObjectHolder(ModInfo.MOD_ID)
    public static class Blocks {
        public static final Block rail_no_sleeper = new BlockRailNoSleeper();
    }
    
    @ObjectHolder(ModInfo.MOD_ID)
    public static class Items {
        public static final Item ticket = new ItemTicket();
        public static final Item ticket_punch = new ItemTicketPunch();
    }
}
