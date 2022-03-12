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

package com.tamrielnetwork.vitalrules.commands;

import com.tamrielnetwork.vitalrules.utils.Chat;
import com.tamrielnetwork.vitalrules.utils.commands.Cmd;
import com.tamrielnetwork.vitalrules.utils.commands.CmdSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class VitalRulesCmd
		implements CommandExecutor {

	@Override
	public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
	                         @NotNull String[] args) {
		if (Cmd.isArgsLengthGreaterThan(sender, args, 1)) {
			return false;
		}
		if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
			doRules(sender, args[0]);
			return true;
		}
		doRules(sender);
		return true;
	}

	private void doRules(@NotNull CommandSender sender, String arg) {
		if (CmdSpec.isInvalidCmd(sender, arg, "vitalrules.rules")) {
			return;
		}
		int page = Integer.parseInt(arg);
		Chat.sendMessage(sender, page);
	}

	private void doRules(@NotNull CommandSender sender) {
		if (Cmd.isNotPermitted(sender, "vitalrules.rules")) {
			return;
		}
		Chat.sendMessage(sender, 1);
	}
}