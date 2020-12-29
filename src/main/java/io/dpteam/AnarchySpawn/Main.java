package io.dpteam.AnarchySpawn;

import io.dpteam.AnarchySpawn.commands.CmdAS;
import io.dpteam.AnarchySpawn.listeners.ListenerJoin;
import io.dpteam.AnarchySpawn.listeners.ListenerLethalDamage;
import io.dpteam.AnarchySpawn.util.Util;
import java.util.HashSet;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private String prefix;
	FileConfiguration config;
	private HashSet materials;

	public Main() {
		super();
		this.prefix = ChatColor.GOLD + "[" + this.getName() + "] ";
		this.config = null;
		this.materials = new HashSet();
	}

	public void loadCFG() {
		if (Bukkit.getWorld(this.config.getString("default-world")) == null) {
			this.error("World '" + this.config.getString("default-world") + " doesn't exist.");
		}

		Iterator var1 = this.config.getStringList("disallowed-blocks").iterator();

		while(var1.hasNext()) {
			String material = (String)var1.next();
			Material mat = Material.matchMaterial(material.toUpperCase());
			if (mat != null) {
				this.materials.add(mat);
				this.feedback("Adding " + mat.name() + " as disallowed");
			} else {
				this.error("Material " + material + " is an invalid material");
			}
		}

	}

	public void onEnable() {
		System.out.println("[AnarchySpawn] Plugin loaded and enabled");
		this.config = this.getConfig();
		this.saveDefaultConfig();
		new ListenerLethalDamage(this);
		new ListenerJoin(this);
		new CmdAS(this);
		this.loadCFG();
	}

	@Override
	public void onDisable() {
		System.out.println("[AnarchySpawn] Plugin unloaded and disabled");
	}

	private boolean isRoof(Location location) {
		int MIN_REQUIRED = true;
		int current = 0;

		for(int x = location.getBlockX() - 30; x < location.getBlockX() + 30; x += 4) {
			for(int z = location.getBlockZ() - 30; z < location.getBlockZ() + 30; z += 4) {
				if (current > 20) {
					return true;
				}

				this.debug("" + x + " " + location.getBlockY() + " " + z + ", block type: " + location.getWorld().getBlockAt(x, location.getBlockY(), z).getType().name());
				if (location.getWorld().getBlockAt(x, location.getBlockY(), z).getType() == Material.OBSIDIAN) {
					++current;
				}
			}
		}

		return false;
	}

	public Location locateSafeLocation(Player p) {
		Location last = null;

		for(int i = 0; i < this.config.getInt("max-trys"); ++i) {
			World w = Bukkit.getWorld(this.config.getString("default-world"));
			int x = Util.randomRange(this.config.getInt("minX"), this.config.getInt("maxX"));
			int z = Util.randomRange(this.config.getInt("minZ"), this.config.getInt("maxZ"));
			int y = w.getHighestBlockYAt(x, z);
			last = new Location(w, (double)x, (double)y, (double)z);
			if (last.add(0.0D, -1.0D, 0.0D).getBlock().getType() == Material.OBSIDIAN) {
				if (!this.isRoof(last)) {
					return last;
				}

				this.debug("Obsidian roof");

				int newY;
				for(newY = y - 2; newY > 1 && w.getBlockAt(x, newY, z).getType() == Material.AIR; --newY) {
				}

				last.setY((double)newY);
				this.debug("newY: " + newY);
				return last;
			}

			if (!this.materials.contains(last.add(0.0D, -1.0D, 0.0D).getBlock().getType())) {
				this.debug("Passed check (#" + i + ")");
				return last;
			}

			this.debug("Failed check (#" + i + ")");
		}

		this.debug("Failed all checks");
		return last;
	}

	public boolean feedback(String s) {
		return this.feedback(this.getServer().getConsoleSender(), s);
	}

	public boolean important(String s) {
		return this.important(this.getServer().getConsoleSender(), s);
	}

	public boolean error(String s) {
		return this.error(this.getServer().getConsoleSender(), s);
	}

	public boolean feedback(CommandSender sender, String s) {
		sender.sendMessage(this.prefix + ChatColor.GRAY + s);
		return true;
	}

	public boolean important(CommandSender sender, String s) {
		sender.sendMessage(this.prefix + ChatColor.AQUA + s);
		return true;
	}

	public boolean error(CommandSender sender, String s) {
		sender.sendMessage(this.prefix + ChatColor.RED + s);
		return true;
	}

	public void debug(String s) {
		if (this.config.getBoolean("debug")) {
			this.getServer().getConsoleSender().sendMessage(this.prefix + ChatColor.YELLOW + s);
		}

	}
}
