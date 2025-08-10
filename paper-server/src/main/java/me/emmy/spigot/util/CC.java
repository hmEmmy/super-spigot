package me.emmy.spigot.util;

import net.minecraft.network.protocol.game.ClientboundCustomChatCompletionsPacket;
import org.bukkit.ChatColor;

/**
 * @author Emmy
 * @project super-spigot
 * @since 10/08/2025
 */
public class CC {
    public static final String red = "\u00A7c";
    public static final String green = "\u00A7a";
    public static final String yellow = "\u00A7e";
    public static final String blue = "\u00A79";
    public static final String purple = "\u00A7d";
    public static final String aqua = "\u00A7b";
    public static final String white = "\u00A7f";
    public static final String gray = "\u00A77";
    public static final String black = "\u00A70";

    private CC() {
        // Prevent instantiation
    }

    /**
     * Translates legacy color codes (&) to Minecraft's ChatColor format.
     *
     * @param message the message containing legacy color codes
     * @return the message with translated color codes
     */
    public static String translateLegacy(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
