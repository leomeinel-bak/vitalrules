/*
 * VitalRules is a Spigot Plugin that gives players the ability to see server rules.
 * Copyright © 2022 Leopold Meinel
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

package com.tamrielnetwork.vitalrules.files;

import com.tamrielnetwork.vitalrules.VitalRules;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

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
