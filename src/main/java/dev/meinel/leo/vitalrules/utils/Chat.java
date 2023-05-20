/*
 * File: Chat.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2023 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalrules.utils;

import dev.meinel.leo.vitalrules.VitalRules;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

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
        player.sendMessage(replaceColors(
                Objects.requireNonNull(main.getMessages().getMessagesConf().getString(message))));
    }

    private static List<String> getMessages(@NotNull CommandSender player, int page) {
        Set<String> keys = main.getRules().getRulesConf().getKeys(false);
        List<List<String>> messagesList = new ArrayList<>();
        for (String key : keys) {
            List<String> temp = main.getRules().getRulesConf().getStringList(key);
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
