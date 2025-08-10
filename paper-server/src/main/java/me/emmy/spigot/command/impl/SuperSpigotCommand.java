package me.emmy.spigot.command.impl;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.jetbrains.annotations.NotNull;

/**
 * @author Emmy
 * @project super-spigot
 * @since 10/08/2025
 */
public class SuperSpigotCommand extends BukkitCommand {

    protected SuperSpigotCommand(@NotNull final String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull final CommandSender sender, @NotNull final String commandLabel, final @NotNull String @NotNull [] args) {
        return false;
    }
}
