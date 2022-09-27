package lol.floaters.bombbay.events;


import lol.floaters.bombbay.main;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


public class handler {
    public static void registerEvents() {
        bombBellReceived messageReceived = new bombBellReceived();
        MinecraftForge.EVENT_BUS.register(messageReceived);
    }
}
