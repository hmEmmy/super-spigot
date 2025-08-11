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
public class SuperSpigotVersionCommand extends BukkitCommand {
    /**
     * Constructor for the SuperSpigotVersionCommand class.
     *
     * @param name the name of the command
     */
    public SuperSpigotVersionCommand(@NotNull final String name) {
        super(name);
        this.description = "Displays the version of the server";
        this.usageMessage = "/version";
        this.setPermission(SuperSpigot.getInstance().NAME.toLowerCase() + ".command.version");
        this.setAliases(List.of("ver", "v", "about", "info", "icanhasbukkit"));
    }

    @Override
    public boolean execute(@NotNull final CommandSender sender, @NotNull final String commandLabel, final @NotNull String @NotNull [] args) {
        String versionMessage = CC.translateLegacy("&fRunning &b&l" + SuperSpigot.getInstance().NAME + " &fversion &b&l" + SuperSpigot.getInstance().VERSION + " &fmade by &b&l" + SuperSpigot.getInstance().AUTHOR.toUpperCase() + " &ffor &b&lMinecraft 1.21");
        sender.sendMessage(versionMessage);

        return false;
    }
}
