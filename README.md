<p align="center"><img src="https://github.com/STEMMechanics/.github/blob/main/stemcraft-sky-logo.jpg?raw=true" width="666" height="198" alt="STEMMechanics"></p>

# STEMCraft Template

> [!TIP]
> When modifying this README, there will be further comments inside giving examples on how to format the README.
>
> These comments can be safely deleted and will not impact the rest of the document.
>
> Comments are formatted as so:
>
> ```
> <!-- This is a comment. It won't appear in the HTML Rendering of the document. -->
> ```
> They will also appear greyed-out in the GitHub Web Editor.

This template can be freely used as a template for building plugins which extend on STEMCraftLib's features.

In this section, you should provide a one-sentence description of the plugin you are making, then listing the key features of it.

<!--
Here is an example from the "SC-Inventories" plugin:

This plugin enables separate inventories for different worlds and game modes on Minecraft servers. Key features include:

- **World-Specific Inventories**: Players have distinct inventories for each world, preventing item transfer between unrelated game areas.
- **World Grouping**: Worlds are grouped based on their names, with inventories shared within each group (ie world, world_nether and world_the_end all share the same inventories).
- **Game Mode Separation**: Players have a separate inventory for different game modes (e.g., survival, creative) within the same world.
- **More Than Inventories**: When switching inventories, the complete players profile is switched including health, hunger, effects, etc.
- **Stored As YAML**: Data is stored in the YAML format to use the built-in server serialization methods and should limit issues with future versions.
-->

## Commands

In this section, you should list the various commands that your plugin provides, including their usage, arguments, behaviour, and the permissions required (if needed). If the command is destructive, you should declare that it is.

<!--
Here is an example from the "SC-Inventories" plugin:

### /speed
The /clearinventory command removes all items from a player's inventory, including their hotbar, main inventory, and armor slots.

#### Usage
/clearinventory [player]

#### Arguments
player (optional): The name of the player whose inventory you want to clear. If not specified, it clears your own inventory.

#### Behavior
- If no player is specified, the command clears the inventory of the player who executed it.
- When run from the console, a player name must be provided.

#### Permission
Requires the `stemcraft.inventory.clear` permission to use this command.

> [!CAUTION]
> Use this command with caution, as it permanently removes all items from the specified player's inventory without any way to undo the action
-->

## Data Storage

In this section, you should list where the various data storage locations are, and any warnings for modifying them, if any. There is not specific format for this section.

<!--
Here is an example from the "SC-Inventories" plugin:

Player data is stored in YAML files in /worlds/\<world-name\>/\<player-uuid\>.yml in a serialized format.

While this can be modified using a text editor, it is not recommended as it could break the players inventory restoration.
-->

## Changes

In this section, you should keep the changelog for the plugin.

<!-- Example is provided below. -->

### 1.0

-    Initial release

## Get in touch!

<!-- If you are not developing this plugin for STEMMechanics, please replace this contact info. -->

Learn more about what we're doing at [stemmechanics.com.au](https://stemmechanics.com.au).

👋 [@STEMMechanics](https://twitter.com/STEMMechanics)


