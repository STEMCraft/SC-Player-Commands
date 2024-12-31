package com.stemcraft;

import com.stemcraft.util.SCTabCompletion;
import org.bukkit.WeatherType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerCommands extends STEMCraftPlugin {
    @Override
    public void onEnable() {
        super.onEnable();

        List<String> listOfTime = com.stemcraft.command.PlayerTime.getPossiblePresetTimes().keySet().stream().sorted().toList();
        List<String> listOfWeather = Arrays.stream(WeatherType.values()).map((WeatherType weatherType) -> weatherType.name().toLowerCase()).sorted().toList();

        SCTabCompletion.register("timeOfDay", () -> listOfTime);
        SCTabCompletion.register("weather", () -> listOfWeather);

        registerCommand(new com.stemcraft.command.PlayerTime(), "playertime", Arrays.stream(new String[] { "ptime" }).toList(), generateTabCompletionsForPlayerCommands("{timeOfDay}"));
        registerCommand(new com.stemcraft.command.PlayerWeather(), "playerweather", Arrays.stream(new String[] { "pweather" }).toList(), generateTabCompletionsForPlayerCommands("{weather}"));
    }

    // note: not general method, only for this plugin
    private List<String[]> generateTabCompletionsForPlayerCommands(String placeholderToUse) {
        ArrayList<String[]> tabCompletions = new ArrayList<>();

        tabCompletions.add(new String[] { "reset", "{player}" });
        tabCompletions.add(new String[] { "lookup", "{player}" });
        tabCompletions.add(new String[] { placeholderToUse, "{player}" });

        return tabCompletions;
    }
}