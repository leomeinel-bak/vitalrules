/*
 * File: Rules.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalrules.files;

import dev.meinel.leo.vitalrules.VitalRules;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Rules {

    private final VitalRules main = JavaPlugin.getPlugin(VitalRules.class);
    private final File rulesFile;
    private final FileConfiguration rulesConf;

    public Rules() {
        rulesFile = new File(main.getDataFolder(), "rules.yml");
        saveRulesFile();
        rulesConf = YamlConfiguration.loadConfiguration(rulesFile);
    }

    private void saveRulesFile() {
        if (!rulesFile.exists()) {
            main.saveResource("rules.yml", false);
        }
    }

    public FileConfiguration getRulesConf() {
        return rulesConf;
    }
}
