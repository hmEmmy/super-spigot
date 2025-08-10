package me.emmy.spigot.command.impl;

import java.util.Arrays;
import me.emmy.spigot.SuperSpigot;
import me.emmy.spigot.util.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * @author Emmy
 * @project super-spigot
 * @since 10/08/2025
 */
public class PingCommand extends BukkitCommand {
    /**
     * Constructor for the PingCommand class.
     *
     * @param name the name of the command
     */
    public PingCommand(@NotNull String name) {
        super(name);
        this.description = "Gets the ping of a player";
        this.usageMessage = "/ping";
        this.setPermission(SuperSpigot.getInstance().NAME.toLowerCase() + ".command.ping");
        this.setAliases(Arrays.asList("ms", "latency"));
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String currentAlias, @NotNull String[] args) {
        if (!testPermission(sender)) {
            return true;
        }

        Player target;

        if (args.length >= 1) {
            target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                sender.sendMessage(CC.red + "No player with that name is currently online.");
                return true;
            }
        } else {
            if (!(sender instanceof Player)) {
                sender.sendMessage(CC.red + "This command can only be run by a player.");
                return true;
            }

            target = (Player) sender;
        }

        int ping = target.getPing();
        String pingMessage = CC.translateLegacy("&b" + target.getName() + "&f's ping is &b" + ping + "ms&f.");
        sender.sendMessage(SuperSpigot.getInstance().COMMAND_PREFIX + pingMessage);

        return true;
    }
}
