package io.dpteam.AnarchySpawn.util;

import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Util {
	public Util() {
		super();
	}

	public static boolean inRange(int i, int min, int max) {
		return i <= max && i >= min;
	}

	public static Color matchColor(String c) {
		String color = c.toUpperCase();
		if (color.equals("BLUE")) {
			return Color.BLUE;
		} else if (color.equals("RED")) {
			return Color.RED;
		} else if (color.equals("WHITE")) {
			return Color.WHITE;
		} else if (color.equals("GRAY")) {
			return Color.GRAY;
		} else if (color.equals("GREEN")) {
			return Color.GREEN;
		} else if (color.equals("YELLOW")) {
			return Color.YELLOW;
		} else if (color.equals("AQUA")) {
			return Color.AQUA;
		} else if (color.equals("BLACK")) {
			return Color.BLACK;
		} else if (color.equals("FUCHSIA")) {
			return Color.FUCHSIA;
		} else if (color.equals("LIME")) {
			return Color.LIME;
		} else if (color.equals("MAROON")) {
			return Color.MAROON;
		} else if (color.equals("NAVY")) {
			return Color.NAVY;
		} else if (color.equals("OLIVE")) {
			return Color.OLIVE;
		} else if (color.equals("ORANGE")) {
			return Color.ORANGE;
		} else if (color.equals("PURPLE")) {
			return Color.PURPLE;
		} else if (color.equals("SILVER")) {
			return Color.SILVER;
		} else {
			return color.equals("TEAL") ? Color.TEAL : null;
		}
	}

	public static void setName(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&r" + name));
		item.setItemMeta(meta);
	}

	public static void setLore(ItemStack item, List lore) {
		ItemMeta meta = item.getItemMeta();
		List loreList = lore;

		for(int i = 0; i < loreList.size(); ++i) {
			loreList.set(i, ChatColor.translateAlternateColorCodes('&', "&r" + (String)loreList.get(i)));
		}

		meta.setLore(lore);
		item.setItemMeta(meta);
	}

	public static int randomRange(int min, int max) {
		return min + (int)(Math.random() * (double)(max - min + 1));
	}

	public static int randomRange(int min, int max, int min1, int max1) {
		return (int)(Math.random() * 2.0D) == 0 ? min + (int)(Math.random() * (double)(max - min + 1)) : min1 + (int)(Math.random() * (double)(max1 - min1 + 1));
	}

	public static int randomRange(int min, int max, Random random) {
		return random.nextInt(max - min + 1) + min;
	}

	public static boolean randomChance(float i) {
		return (double)i >= Math.random();
	}

	public static boolean randomChance(float i, Random random) {
		return i <= (float)randomRange(0, 100, random) / 100.0F;
	}

	public static int sqDist(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

	public static int safeToInt(String s) {
		return isNumeric(s) ? Integer.parseInt(s) : -1;
	}

	public static boolean isNumeric(String s) {
		for(int i = 0; i < s.length(); ++i) {
			try {
				Integer.parseInt(s.substring(i));
			} catch (NumberFormatException var3) {
				return false;
			}
		}

		return true;
	}

	public static Enchantment matchEnchant(String enchant) {
		String e = enchant.toUpperCase();
		if (!e.equals("DURABILITY") && !e.equals("UNBREAKING")) {
			if (!e.equals("ARROW_DAMAGE") && !e.equals("POWER")) {
				if (!e.equals("ARROW_FIRE") && !e.equals("FLAME")) {
					if (!e.equals("ARROW_INFINITE") && !e.equals("INFINITY")) {
						if (!e.equals("ARROW_KNOCKBACK") && !e.equals("PUNCH")) {
							if (!e.equals("BINDING_CURSE") && !e.equals("CURSE_OF_BINDING")) {
								if (e.equals("CHANELLING")) {
									return Enchantment.CHANNELING;
								} else if (!e.equals("DAMAGE_ALL") && !e.equals("SHARPNESS")) {
									if (!e.equals("DAMAGE_ANTHROPODS") && !e.equals("BANE_OF_ANTHROPODS")) {
										if (!e.equals("DAMAGE_UNDEAD") && !e.equals("SMITE")) {
											if (e.equals("DEPTH_STRIDER")) {
												return Enchantment.DEPTH_STRIDER;
											} else if (!e.equals("DIG_SPEED") && !e.equals("EFFICIENCY")) {
												if (e.equals("DURABILITY")) {
													return Enchantment.DURABILITY;
												} else if (e.equals("FIRE_ASPECT")) {
													return Enchantment.FIRE_ASPECT;
												} else if (e.equals("FROST_WALKER")) {
													Enchantment var10000 = Enchantment.FIRE_ASPECT;
													return Enchantment.FROST_WALKER;
												} else if (e.equals("IMPALING")) {
													return Enchantment.IMPALING;
												} else if (e.equals("KNOCKBACK")) {
													return Enchantment.KNOCKBACK;
												} else if (!e.equals("LOOT_BONUS_BLOCKS") && !e.equals("FORTUNE")) {
													if (!e.equals("LOOT_BONUS_MOBS") && !e.equals("LOOTING")) {
														if (e.equals("LOYALTY")) {
															return Enchantment.LOYALTY;
														} else if (!e.equals("LUCK") && !e.equals("LUCK_OF_THE_SEA")) {
															if (e.equals("LURE")) {
																return Enchantment.LURE;
															} else if (e.equals("MENDING")) {
																return Enchantment.MENDING;
															} else if (e.equals("MULTISHOT")) {
																return Enchantment.MULTISHOT;
															} else if (!e.equals("OXYGEN") && !e.equals("RESPIRATION")) {
																if (e.equals("PIERCING")) {
																	return Enchantment.PIERCING;
																} else if (!e.equals("PROTECTION_ENVIRONMENTAL") && !e.equals("PROTECTION")) {
																	if (!e.equals("PROTECTION_FIRE") && !e.equals("FIRE_PROTECTION")) {
																		if (!e.equals("PROTECTION_FALL") && !e.equals("FEATHER_FALLING")) {
																			if (!e.equals("PROTECTION_EXPLOSIONS") && !e.equals("BLAST_PROTECTION")) {
																				if (!e.equals("PROTECTION_PROJECTILE") && !e.equals("PROJECTILE_PROTECTION")) {
																					if (e.equals("QUICK_CHARGE")) {
																						return Enchantment.QUICK_CHARGE;
																					} else if (e.equals("RIPTIDE")) {
																						return Enchantment.RIPTIDE;
																					} else if (e.equals("SILK_TOUCH")) {
																						return Enchantment.SILK_TOUCH;
																					} else if (e.equals("SWEEPING_EDGE")) {
																						return Enchantment.SWEEPING_EDGE;
																					} else if (e.equals("THORNS")) {
																						return Enchantment.THORNS;
																					} else if (!e.equals("VANISHING_CURSE") && !e.equals("CURSE_OF_VANISHING")) {
																						return !e.equals("WATER_WORKER") && !e.equals("AQUA_AFFINITY") ? null : Enchantment.WATER_WORKER;
																					} else {
																						return Enchantment.VANISHING_CURSE;
																					}
																				} else {
																					return Enchantment.PROTECTION_PROJECTILE;
																				}
																			} else {
																				return Enchantment.PROTECTION_EXPLOSIONS;
																			}
																		} else {
																			return Enchantment.PROTECTION_FALL;
																		}
																	} else {
																		return Enchantment.PROTECTION_FIRE;
																	}
																} else {
																	return Enchantment.PROTECTION_ENVIRONMENTAL;
																}
															} else {
																return Enchantment.OXYGEN;
															}
														} else {
															return Enchantment.LUCK;
														}
													} else {
														return Enchantment.LOOT_BONUS_MOBS;
													}
												} else {
													return Enchantment.LOOT_BONUS_BLOCKS;
												}
											} else {
												return Enchantment.DIG_SPEED;
											}
										} else {
											return Enchantment.DAMAGE_UNDEAD;
										}
									} else {
										return Enchantment.DAMAGE_ARTHROPODS;
									}
								} else {
									return Enchantment.DAMAGE_ALL;
								}
							} else {
								return Enchantment.BINDING_CURSE;
							}
						} else {
							return Enchantment.ARROW_KNOCKBACK;
						}
					} else {
						return Enchantment.ARROW_INFINITE;
					}
				} else {
					return Enchantment.ARROW_FIRE;
				}
			} else {
				return Enchantment.ARROW_DAMAGE;
			}
		} else {
			return Enchantment.DURABILITY;
		}
	}
}
