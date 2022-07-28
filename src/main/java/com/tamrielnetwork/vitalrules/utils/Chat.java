/*
 * VitalRules is a Spigot Plugin that gives players the ability to see server rules.
 * Copyright © 2022 Leopold Meinel & contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/LeoMeinel/VitalRules/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalrules.utils;

import com.tamrielnetwork.vitalrules.VitalRules;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Chat {

	private static final VitalRules main = JavaPlugin.getPlugin(VitalRules.class);

	private Chat() {
		throw new IllegalStateException("Utility class");
	}

	public static void sendMessage(@NotNull CommandSender player, int page) {
		List<String> messages = getMessages(player, page);
		if (messages.isEmpty()) {
			return;
		}
		for (String string : messages) {
			player.sendMessage(replaceColors(string));
		}
	}

	public static void sendMessage(@NotNull CommandSender player, @NotNull String message) {
		player.sendMessage(replaceColors(Objects.requireNonNull(main.getMessages()
		                                                            .getMessagesConf()
		                                                            .getString(message))));
	}

	private static List<String> getMessages(@NotNull CommandSender player, int page) {
		Set<String> keys = main.getRules()
		                       .getRulesConf()
		                       .getKeys(false);
		List<List<String>> messagesList = new ArrayList<>();
		for (String key : keys) {
			List<String> temp = main.getRules()
			                        .getRulesConf()
			                        .getStringList(key);
			messagesList.add(temp);
		}
		if (page >= messagesList.size() + 1) {
			sendMessage(player, "invalid-rule");
			return Collections.emptyList();
		}
		player.sendMessage("");
		player.sendMessage(replaceColors("&5Page &d" + page + "&5/&d" + messagesList.size()));
		player.sendMessage("");
		return messagesList.get(page - 1);
	}

	public static String replaceColors(@NotNull String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
}