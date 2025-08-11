package me.emmy.spigot;

import me.emmy.spigot.command.CommandRegistry;
import me.emmy.spigot.command.impl.PingCommand;
import me.emmy.spigot.command.impl.SuperSpigotVersionCommand;
import me.emmy.spigot.util.CC;
import net.minecraft.server.MinecraftServer;
import java.util.Arrays;

/**
 * @author Emmy
 * @project super-spigot
 * @since 10/08/2025
 */
public class SuperSpigot {
    private static SuperSpigot instance;

    public final String AUTHOR = "Emmy";
    public final String NAME = "SuperSpigot";
    public final String VERSION = "1.0.0";
    public final String COMMAND_PREFIX = CC.white + "[" + CC.aqua + NAME + CC.white + "] " + CC.white;

    private final MinecraftServer minecraftServer;

    private final CommandRegistry commandRegistry = new CommandRegistry();

    /**
     * Constructor for the SuperSpigot class.
     * Minecraft Server software - fork of Spigot and Paper.
     *
     * @param minecraftServer the Minecraft server instance.
     */
    public SuperSpigot(MinecraftServer minecraftServer) {
        instance = this;

        this.minecraftServer = minecraftServer;

        Arrays.asList(
            new PingCommand("ping"),
            new SuperSpigotVersionCommand("version")
        ).forEach(this.commandRegistry::addCommand);
    }

    public void outputSpigotDetails() {
        Arrays.asList(
            "",
            "&b&lSUPERSPIGOT &fmade by &b" + this.AUTHOR.toUpperCase(),
            " &7▢ &fVersion: &b" + this.VERSION + " &7&o(PaperSpigot fork)",
            ""
        ).forEach(line -> this.minecraftServer.server.getConsoleSender().sendMessage(CC.translateLegacy(line)));
    }

    /**
     * Method to access the singleton instance of SuperSpigot.
     *
     * @return the singleton instance of SuperSpigot
     */
    public static SuperSpigot getInstance() {
        return instance;
    }

    /**
     * Method to get the Minecraft server instance.
     *
     * @return the Minecraft server instance
     */
    public MinecraftServer getMinecraftServer() {
        return this.minecraftServer;
    }

    /**
     * Method to get the command registry.
     *
     * @return the command registry
     */
    public CommandRegistry getCommandRegistry() {
        return this.commandRegistry;
    }
}
