package me.emmy.spigot.command.impl;

import me.emmy.spigot.SuperSpigot;
import me.emmy.spigot.util.CC;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/**
 * @author Emmy
 * @project super-spigot
 * @since 10/08/2025
 */
public class SuperVersionCommand extends BukkitCommand {
    /**
     * Constructor for the VersionCommand class.
     *
     * @param name the name of the command
     */
    public SuperVersionCommand(@NotNull final String name) {
        super(name);
        this.description = "Displays the version of the server";
        this.usageMessage = "/version";
        this.setPermission(SuperSpigot.getInstance().NAME.toLowerCase() + ".command.version");
        this.setAliases(List.of("ver", "v", "about", "info", "icanhasbukkit"));
    }

    @Override
    public boolean execute(@NotNull final CommandSender sender, @NotNull final String commandLabel, final @NotNull String @NotNull [] args) {
        String versionMessage = CC.translateLegacy("&fRunning &b" + SuperSpigot.getInstance().NAME + " &fversion &b" + SuperSpigot.getInstance().VERSION + " &ffor &bMinecraft 1.21");
        sender.sendMessage(versionMessage);

        return false;
    }
}
