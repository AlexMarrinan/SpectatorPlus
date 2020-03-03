package com.alexm.specplus;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;


public class SPCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label, String[] args) {
		Player player = (Player)sender;
		if (sender instanceof Player) {
			if( player.getGameMode() == GameMode.SPECTATOR) {
				for (int i = 0; i<=Main.playerCoors.size(); i++) {
					PlayerData foundPlayer = Main.playerCoors.get(i);
					if (foundPlayer.name.equals( player.getName()) ) {
						double tpX = foundPlayer.x;
						double tpY = foundPlayer.y;
						double tpZ = foundPlayer.z;
						float tpPitch = foundPlayer.pitch;
						float tpYaw = foundPlayer.yaw;
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Set to " + modeToString(foundPlayer.oldMode)));
						player.teleport((Location) new Location(player.getWorld(), tpX, tpY, tpZ, tpYaw, tpPitch));
						player.setGameMode(GameMode.SURVIVAL);
						Main.playerCoors.remove(i);
					}
				}
			}else {
				Location loc = player.getLocation();
				double pX = loc.getX();
				double pY = loc.getY();
				double pZ = loc.getZ();
				float pitch = loc.getPitch();
				float yaw = loc.getYaw();
				//
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Set to Spectator"));
				Main.playerCoors.add((PlayerData) new PlayerData(player.getName(), pX, pY, pZ, pitch, yaw, player.getGameMode()));
				player.setGameMode(GameMode.SPECTATOR);
			}
		}else {
			sender.sendMessage("You're not a player, why are you using /s?");
		}
		return true;
	}
	private String modeToString(GameMode mode) {
		switch(mode) {
		case SURVIVAL: return "Survival";
		case CREATIVE: return "Creative";
		case ADVENTURE: return "Adventure";
		default: return "ERROR";
		}
	}

}
