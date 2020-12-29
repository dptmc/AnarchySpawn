package io.dpteam.AnarchySpawn.listeners;

import io.dpteam.AnarchySpawn.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ListenerJoin extends BaseListener {
	public ListenerJoin(Main plugin) {
		super(plugin);
	}

	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		if (!e.getPlayer().hasPlayedBefore()) {
			(new BukkitRunnable() {
				public void run() {
					BaseListener.plugin.locateSafeLocation(e.getPlayer());
				}
			}).runTaskLater(plugin, 1L);
		}

	}
}
