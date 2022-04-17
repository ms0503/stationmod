package ms.sora.stationmod;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StationEventHandler {
    @SubscribeEvent
    public void registerItems(Register<Item> event) {
        event.getRegistry().register(StationMod.Items.ticket);
        event.getRegistry().register(StationMod.Items.ticket_punch);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(StationMod.Items.ticket, 0, new ModelResourceLocation(new ResourceLocation(ModInfo.MOD_ID, StationMod.Items.ticket.getUnlocalizedName()), "inventory"));
        ModelLoader.setCustomModelResourceLocation(StationMod.Items.ticket_punch, 0, new ModelResourceLocation(new ResourceLocation(ModInfo.MOD_ID, StationMod.Items.ticket_punch.getUnlocalizedName()), "inventory"));
    }
}
