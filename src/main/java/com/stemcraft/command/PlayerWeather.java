package com.stemcraft.command;

import com.stemcraft.STEMCraftCommand;
import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerWeather extends STEMCraftCommand {
    @Override
    public void execute(CommandSender sender, String command, List<String> args) {
        String usage = "Usage: " + command.split(" ")[0] + " [weather] (player)";

        if (args.isEmpty() || args.size() >= 3) {
            error(sender, usage);
            return;
        }

        String basePermission = args.getFirst().equals("lookup") ? "stemcraft.playerweather.lookup" : "stemcraft.playweather";

        if (!sender.hasPermission(basePermission)) {
            error(sender, "You do not have permission to use this command.");
            return;
        }

       WeatherType weatherType = null;

        try {
            if (!args.getFirst().equals("reset") || !args.getFirst().equals("lookup"))
                weatherType = WeatherType.valueOf(args.getFirst().toUpperCase());
        } catch (Exception ignored) {
            error(sender, "The weather type must be a valid weather type, \"reset\", or \"lookup\"");
        }

        Player playerToAffect;

        if (args.size() > 1) {
            if (sender.hasPermission(basePermission + ".other")) {
                playerToAffect = Bukkit.getPlayerExact(args.get(1));
            } else {
                error(sender, "You do not have permission to use this command on other players.");
                return;
            }
        } else {
            if (!(sender instanceof Player)) {
                error(sender, "You must specify a player when using this command from the server console.");
                return;
            }

            playerToAffect = (Player) sender;
        }

        assert playerToAffect != null;
        if (weatherType != null) {
            playerToAffect.setPlayerWeather(weatherType);

            success(sender, "{player} is now seeing {} weather.");
        } else {
            if (args.getFirst().equals("reset")) {
                playerToAffect.resetPlayerWeather();

                success(sender, "{player} is now seeing server weather.");
            } else if (args.getFirst().equals("lookup")) {
                String message = playerToAffect.getPlayerWeather() != null ? "The current player weather for {player} is " + playerToAffect.getPlayerWeather() : "{player} is currently seeing server weather.";

                success(sender, message);
            }
        }
    }
}
