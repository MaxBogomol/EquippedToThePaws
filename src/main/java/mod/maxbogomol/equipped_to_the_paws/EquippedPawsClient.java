package mod.maxbogomol.equipped_to_the_paws;

import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurMod;
import mod.maxbogomol.fluffy_fur.client.language.LanguageHandler;
import mod.maxbogomol.fluffy_fur.client.splash.SplashHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class EquippedPawsClient {
    public static Random random = new Random();

    public static class ClientOnly {
        public static void clientInit() {
            IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
            IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        }
    }

    public static void clientSetup(final FMLClientSetupEvent event) {
        setupMenu();
        setupSplashes();
    }

    public static FluffyFurMod MOD_INSTANCE;

    public static void setupMenu() {
        MOD_INSTANCE = new FluffyFurMod(EquippedPaws.MOD_ID, EquippedPaws.NAME, EquippedPaws.VERSION).setDev("MaxBogomol").setItem(new ItemStack(Items.DIRT))
                .setEdition(EquippedPaws.VERSION_NUMBER).setNameColor(new Color(255, 0, 0)).setVersionColor(new Color(0, 255, 0))
                .setDescription(Component.translatable("mod_description.equipped_to_the_paws"))
                .addFluffyVillageLink("https://fluffy-village.dev/pages/eng/creations/equipped_to_the_paws.html")
                .addGitHubLink("https://github.com/MaxBogomol/EquippedToThePaws")
                .addCurseForgeLink("https://www.curseforge.com/minecraft/mc-mods/equipped-to-the-paws")
                .addModrinthLink("https://modrinth.com/mod/equipped_to_the_paws")
                .addDiscordLink("https://discord.fluffy-village.dev/");

        FluffyFurClient.registerMod(MOD_INSTANCE);
    }

    public static void setupSplashes() {
        List<String> strings = LanguageHandler.getStringsFromFile(new ResourceLocation(EquippedPaws.MOD_ID, "texts/splashes.txt"));
        for (String string : strings) {
            SplashHandler.addSplash(string);
        }
    }
}
