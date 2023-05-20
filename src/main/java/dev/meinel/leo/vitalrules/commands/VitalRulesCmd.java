/*
 * File: VitalRulesCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2023 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalrules.commands;

import dev.meinel.leo.vitalrules.utils.Chat;
import dev.meinel.leo.vitalrules.utils.commands.Cmd;
import dev.meinel.leo.vitalrules.utils.commands.CmdSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class VitalRulesCmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String label, @NotNull String[] args) {
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
