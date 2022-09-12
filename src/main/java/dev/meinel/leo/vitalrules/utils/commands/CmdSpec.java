/*
 * File: CmdSpec.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalrules.utils.commands;

import dev.meinel.leo.vitalrules.utils.Chat;
import java.util.stream.IntStream;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CmdSpec {

    private CmdSpec() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isInvalidCmd(
            @NotNull CommandSender sender,
            @NotNull String arg,
            @NotNull String perm) {
        return Cmd.isNotPermitted(sender, perm) || isInvalidNumber(sender, arg);
    }

    public static boolean isInvalidNumber(
            @NotNull CommandSender sender,
            @NotNull String arg) {
        if (!isNumeric(arg) || Integer.parseInt(arg) <= 0) {
            Chat.sendMessage(sender, "invalid-rule");
            return true;
        }
        return false;
    }

    private static boolean isNumeric(final CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        final int sequenceSize = charSequence.length();
        return IntStream
                .range(0, sequenceSize)
                .allMatch(i -> Character.isDigit(charSequence.charAt(i)));
    }

    private static boolean isEmpty(final CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
