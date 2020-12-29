package io.dpteam.AnarchySpawn.listeners;

import io.dpteam.AnarchySpawn.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BaseListener implements Listener {
	static Main plugin;

	public BaseListener(Main plugin) {
		super();
		Bukkit.getPluginManager().registerEvents(this, plugin);
		BaseListener.plugin = plugin;
	}
}
