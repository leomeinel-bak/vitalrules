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
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalRules/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalrules.utils.commands;

import com.tamrielnetwork.vitalrules.utils.Chat;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CmdSpec {

	private CmdSpec() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean isInvalidCmd(@NotNull CommandSender sender, @NotNull String arg, @NotNull String perm) {
		return Cmd.isNotPermitted(sender, perm) || isInvalidNumber(sender, arg);
	}

	public static boolean isInvalidNumber(@NotNull CommandSender sender, @NotNull String arg) {
		if (!StringUtils.isNumeric(arg) || Integer.parseInt(arg) <= 0) {
			Chat.sendMessage(sender, "invalid-rule");
			return true;
		}
		return false;
	}
}
