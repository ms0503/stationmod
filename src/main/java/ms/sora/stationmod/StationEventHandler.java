package ms.sora.stationmod;

import ms.sora.stationmod.StationMod.Blocks;
import ms.sora.stationmod.StationMod.Items;
import net.minecraft.block.Block;
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
    public void registerBlocks(Register<Block> event) {
        event.getRegistry().register(Blocks.rail_no_sleeper);
    }
    
    @SubscribeEvent
    public void registerItems(Register<Item> event) {
        event.getRegistry().register(Items.ticket);
        event.getRegistry().register(Items.ticket_punch);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(Blocks.rail_no_sleeper), 0, new ModelResourceLocation(new ResourceLocation(ModInfo.MOD_ID, Blocks.rail_no_sleeper.getUnlocalizedName()), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.ticket, 0, new ModelResourceLocation(new ResourceLocation(ModInfo.MOD_ID, Items.ticket.getUnlocalizedName()), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.ticket_punch, 0, new ModelResourceLocation(new ResourceLocation(ModInfo.MOD_ID, Items.ticket_punch.getUnlocalizedName()), "inventory"));
    }
}
