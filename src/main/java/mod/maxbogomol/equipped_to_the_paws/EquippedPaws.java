package mod.maxbogomol.equipped_to_the_paws;

import mod.maxbogomol.fluffy_fur.common.proxy.ClientProxy;
import mod.maxbogomol.fluffy_fur.common.proxy.ISidedProxy;
import mod.maxbogomol.fluffy_fur.common.proxy.ServerProxy;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("equipped_to_the_paws")
public class EquippedPaws {
    public static final String MOD_ID = "equipped_to_the_paws";
    public static final String NAME = "Equipped to the Paws";
    public static final String VERSION = "0.1";
    public static final int VERSION_NUMBER = 1;

    public static final ISidedProxy proxy = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);
    public static final Logger LOGGER = LogManager.getLogger();

    public EquippedPaws() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.unsafeCallWhenOn(Dist.CLIENT, () -> () -> {
            EquippedPawsClient.ClientOnly.clientInit();
            return new Object();
        });

        eventBus.addListener(this::setup);
        eventBus.addListener(EquippedPawsClient::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        hi();
    }

    public static void hi() {

    }
}