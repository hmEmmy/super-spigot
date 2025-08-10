package me.emmy.spigot.command;

import java.util.HashMap;
import java.util.Map;
import me.emmy.spigot.SuperSpigot;
import me.emmy.spigot.util.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;

/**
 * @author Emmy
 * @project super-spigot
 * @since 10/08/2025
 */
public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    /**
     * Adds a command to the map of commands to be initialized upon {@link net.minecraft.server.dedicated.DedicatedServer} startup.
     *
     * @param command the command to register.
     */
    public void addCommand(Command command) {
        this.commands.put(command.getName(), command);
    }

    public void registerInitializedCommands() {
        CommandMap commandMap = SuperSpigot.getInstance().getMinecraftServer().server.getCommandMap();
        for (Command command : this.commands.values()) {
            if (commandMap.getCommand(command.getName()) == null) {
                commandMap.register(SuperSpigot.getInstance().NAME.toLowerCase(), command);
            } else {
                commandMap.getCommand(command.getName()).unregister(commandMap);
                commandMap.register(SuperSpigot.getInstance().NAME.toLowerCase(), command);
                SuperSpigot.getInstance().getMinecraftServer().server.getConsoleSender().sendMessage(CC.translateLegacy("&cCommand " + command.getName() + " was already registered, re-registering it."));
            }
        }
    }
}
