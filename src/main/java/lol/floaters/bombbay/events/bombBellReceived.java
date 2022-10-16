package lol.floaters.bombbay.events;


import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class bombBellReceived {
    @SubscribeEvent
    public void receiveMessage(final ClientChatReceivedEvent e) {
        String message = e.getMessage().getUnformattedText();
        if (message.startsWith("[Bomb Bell]")) {
            System.out.println(message);
            try {
                URL url = new URL("https://api.wynnbombs.xyz/live/register");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                String payload = "{\"message\": \"" + message + "\"}";
                byte[] out = payload.getBytes(StandardCharsets.UTF_8);
                OutputStream stream = connection.getOutputStream();
                stream.write(out);
                System.out.println(connection.getResponseCode() + " " + connection.getResponseMessage());
                connection.disconnect();
            } catch(Exception err) {
                System.out.println("failed");
            }
        }
    }
}
