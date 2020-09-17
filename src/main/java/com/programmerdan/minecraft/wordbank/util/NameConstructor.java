package com.programmerdan.minecraft.wordbank.util;

import com.programmerdan.minecraft.wordbank.NameRecord;
import com.programmerdan.minecraft.wordbank.WordBank;
import com.programmerdan.minecraft.wordbank.random.RandomSource;
import org.bukkit.ChatColor;

/**
 * Utility to build a name. Optionally marks it as "used" in the data store.
 * @author ProgrammerDan
 *
 */
public class NameConstructor {
	private static ChatColor[] COLOURS = new ChatColor[] {
			ChatColor.BLACK,
			ChatColor.DARK_BLUE,
			ChatColor.DARK_GREEN,
			ChatColor.DARK_AQUA,
			ChatColor.DARK_RED,
			ChatColor.DARK_PURPLE,
			ChatColor.GOLD,
			ChatColor.GRAY,
			ChatColor.DARK_GRAY,
			ChatColor.BLUE,
			ChatColor.GREEN,
			ChatColor.AQUA,
			ChatColor.RED,
			ChatColor.LIGHT_PURPLE,
			ChatColor.YELLOW,
			ChatColor.WHITE
	};

	/**
	 * Constructing a name is a several step process.
	 *
	 * First, the color is computed.
	 * Then, the number of words is computed.
	 * Finally, each word is computed.
	 * All these parts are joined and returned.
	 *
	 * @param key The character sequence used to construct a WordBank name.
	 * @return The converted key.
	 */
	public static NameRecord buildName(String key) {
		WordBank plugin = WordBank.instance();
		RandomSource rng = plugin.getRandomSource();

		ChatColor color = rng.pick(COLOURS);
		int words = rng.getInt(plugin.config().getWordMax()) + 1;

		StringBuilder name = new StringBuilder();
		name.append(color);
		for (int nWord = 0; nWord < words; nWord++) {
			if (nWord > 0) {
				name.append(" ");
			}
			name.append(plugin.config().getWords().getWord(rng.getFloat()));
		}

		return new NameRecord(key, name.toString(), false);
	}
}
