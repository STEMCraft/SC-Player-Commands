package com.stemcraft.command;

import com.stemcraft.STEMCraftCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class PlayerTime extends STEMCraftCommand {
    @Override
    public void execute(CommandSender sender, String command, List<String> args) {
        String usage = "Usage: " + command.split(" ")[0] + " [(+/-)time] (player)";

        if (args.isEmpty() || args.size() >= 3) {
            error(sender, usage);
            return;
        }

        if (args.getFirst().equals("0") || args.getFirst().equals("+0") || args.getFirst().equals("-0")) {
            args.set(0, "reset");
        }

        String basePermission = args.getFirst().equals("lookup") ? "stemcraft.playertime.lookup" : "stemcraft.playertime";

        if (!sender.hasPermission(basePermission)) {
            error(sender, "You do not have permission to use this command.");
            return;
        }

        long time = 0;
        boolean relative = false;

        boolean wasTimeSet = false;

        try {
            if (!args.getFirst().equals("reset") || !args.getFirst().equals("lookup")) {
                wasTimeSet = true;

                if (!getPossiblePresetTimes().containsKey(args.getFirst())) {
                    relative = args.getFirst().startsWith("+") || args.getFirst().startsWith("-");

                    time = Long.parseLong(relative ? args.getFirst().substring(1) : args.getFirst());
                } else {
                    time = getPossiblePresetTimes().get(args.getFirst());
                }
            }
        } catch (Exception ignored) {
            error(sender, "The time must be a valid time, \"reset\", or \"lookup\"");
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
        if (wasTimeSet) {
            playerToAffect.setPlayerTime(time, relative);

            success(sender, "{player} is now seeing time " + (!relative ? "at " : "") + time + " ticks" + (relative ? (time > 0 ? " ahead " : " behind ") + "the server" : "") + ".");
        } else {
            if (args.getFirst().equals("reset")) {
                playerToAffect.resetPlayerTime();

                success(sender, "{player} is now seeing server time.");
            } else if (args.getFirst().equals("lookup")) {
                time = playerToAffect.getPlayerTimeOffset();
                relative = playerToAffect.isPlayerTimeRelative();
                String message = !(time == 0 && relative) ? "{player} is currently seeing time " + (!relative ? "at " : "") + time + " ticks" + (relative ? (time > 0 ? " ahead " : " behind ") + "the server" : "") + "." : "{player} is currently seeing server time.";

                success(sender, message);
            }
        }
    }
    
    public static HashMap<String, Long> getPossiblePresetTimes() {
        HashMap<String, Long> presetTimes = new HashMap<>();

        presetTimes.put("day",      1000L);
        presetTimes.put("noon",     6000L);
        presetTimes.put("night",    13000L);
        presetTimes.put("midnight", 18000L);

        return presetTimes;
    }
}
