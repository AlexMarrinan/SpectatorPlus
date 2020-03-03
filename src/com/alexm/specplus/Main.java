package com.alexm.specplus;

import java.util.ArrayList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public static ArrayList<PlayerData> playerCoors = new ArrayList<PlayerData>();
	
	public void onEnable() {
		getLogger().info("Spectator Enabled.");
		this.getCommand("s").setExecutor((CommandExecutor) new SPCommand());
	}
	public void onDisable() {
		getLogger().info("Spectator Disabled.");
	}
}