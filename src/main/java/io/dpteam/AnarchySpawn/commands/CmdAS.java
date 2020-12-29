package io.dpteam.AnarchySpawn.commands;

import io.dpteam.AnarchySpawn.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CmdAS extends BaseCommand {
	public CmdAS(Main plugin) {
		super(plugin, "as");
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
			plugin.reloadConfig();
			plugin.loadCFG();
			this.feedback(sender, "Reloaded config");
			return true;
		} else {
			return false;
		}
	}
}
