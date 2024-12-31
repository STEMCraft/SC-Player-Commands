<p align="center"><img src="https://github.com/STEMMechanics/.github/blob/main/stemcraft-sky-logo.jpg?raw=true" width="666" height="198" alt="STEMMechanics"></p>

# STEMCraft Player Commands

This plugin enables certain commands which modify the time and weather for a specific player only. Key features include:

- **Setting The Time And Weather For A Specific Player**: Players and admins can modify the time of day for themselves or other people, allowing for adapting creative builds for any lighting conditions, or filmmaking.
- **No Mob Spawning Or Other Effects**: Since the time and weather is only set for the player - no other effects, such as mob spawning or lightning, will occur (except if the player time and/or weather matches the server time and/or weather).

## Commands

### /playerweather
The /playerweather (and its aliases) will set the player weather of a player.

#### Usage
/playerweather [type] [player]

/pweather [type] [player]

#### Arguments
type (required): Can be "reset", "clear", "rain", or "lookup".
- reset: Resynchronises the player weather with the server weather.
- clear, rain: Sets the player weather to "clear", or "rain", respectively.
- lookup: Gets the current set player weather.

player (optional): The name of the player whose player weather is to be changed. If not specified, it changes your own weather.

#### Behavior
- If no player is specified, the command sets the player weather of whoever ran the command.
- If a player is specified, the command sets the player weather of the player specified.
- When run from the console, a player name must be provided.

#### Permission
Requires the `stemcraft.pweather` permission to use this command. Using it on other players requires the `stemcraft.pweather.other` permission.

> [!CAUTION]
> Granting players with the `stemcraft.pweather.other` permission may cause confusion for other players. Grant with caution.

## Commands

### /playertime
The /playertime (and its aliases) will set the player time of a player.

#### Usage
/playertime [time] [player]

/ptime [time] [player]

#### Arguments
type (required): Can be "reset", "day", "noon", "night", "midnight", "lookup", or any number.
- reset: Resynchronises the player time with the server time.
- day, noon, night, midnight: Sets the player time to 1000, 6000, 13000, and 18000, in ticks, respectively.
- lookup: Gets the current set player time.

player (optional): The name of the player whose player time is to be changed. If not specified, it changes your own time.

#### Behavior
- If no player is specified, the command sets the player time of whoever ran the command.
- If a player is specified, the command sets the player time of the player specified.
- When run from the console, a player name must be provided.

#### Permission
Requires the `stemcraft.ptime` permission to use this command. Using it on other players requires the `stemcraft.ptime.other` permission.

> [!CAUTION]
> Granting players with the `stemcraft.ptime.other` permission may cause confusion for other players. Grant with caution.

## Data Storage

No data is stored for any player.

## Changes

### 1.0

-    Initial release

## Get in touch!

Learn more about what we're doing at [stemmechanics.com.au](https://stemmechanics.com.au).

👋 [@STEMMechanics](https://twitter.com/STEMMechanics)


