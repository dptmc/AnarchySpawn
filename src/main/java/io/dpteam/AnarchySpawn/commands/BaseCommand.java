package io.dpteam.AnarchySpawn.commands;

import io.dpteam.AnarchySpawn.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class BaseCommand implements CommandExecutor {
	static Main plugin;

	public BaseCommand(Main plugin, String name) {
		super();
		plugin.getCommand(name).setExecutor(this);
		BaseCommand.plugin = plugin;
	}

	boolean error(CommandSender sender, String message) {
		return plugin.error(sender, message);
	}

	boolean feedback(CommandSender sender, String message) {
		return plugin.feedback(sender, message);
	}

	public abstract boolean onCommand(CommandSender var1, Command var2, String var3, String[] var4);
}
