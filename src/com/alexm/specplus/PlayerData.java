package com.alexm.specplus;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerData{
	public String name;
	public double x;
	public double y;
	public double z;
	public float pitch;
	public float yaw;
	public GameMode oldMode;
	
	public PlayerData(String name, double pX, double pY, double pZ, float pitch, float yaw, GameMode oldMode) {
		this.name = name;
		this.x = pX;
		this.y = pY;
		this.z = pZ;
		this.pitch = pitch;
		this.yaw = yaw;
		this.oldMode = oldMode;
	}
}
