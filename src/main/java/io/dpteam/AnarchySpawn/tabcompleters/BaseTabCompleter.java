package io.dpteam.AnarchySpawn.tabcompleters;

import io.dpteam.AnarchySpawn.Main;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public abstract class BaseTabCompleter implements TabCompleter {
	static Main plugin;

	public BaseTabCompleter(Main plugin, String name) {
		super();
		plugin.getCommand(name).setTabCompleter(this);
		BaseTabCompleter.plugin = plugin;
	}

	public abstract List onTabComplete(CommandSender var1, Command var2, String var3, String[] var4);
}
