package io.dpteam.AnarchySpawn.listeners;

import io.dpteam.AnarchySpawn.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

public class ListenerLethalDamage extends BaseListener {
	public ListenerLethalDamage(Main plugin) {
		super(plugin);
	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		if (plugin.getConfig().getBoolean("debug")) {
			plugin.debug("Player died " + e.getPlayer().getDisplayName());
		}

		if (e.getPlayer().getBedSpawnLocation() == null) {
			e.setRespawnLocation(BaseListener.plugin.locateSafeLocation(e.getPlayer()));
		}

	}
}
