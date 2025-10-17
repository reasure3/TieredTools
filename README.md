[![Download On Curseforge](https://img.shields.io/curseforge/dt/1364524?logo=curseforge)](https://www.curseforge.com/minecraft/mc-mods/tiered-tools)
[![Download On Modrinth](https://img.shields.io/modrinth/dt/tiered-tools?logo=modrinth)](https://modrinth.com/mod/tiered-tools) &ensp;
[![License](https://img.shields.io/badge/license-MIT-green)](./LICENSE)

[한국어 문서 보기](./README_KR.md)

# Tiered Tools Mod

This mod completely overhauls Minecraft's tool progression system. You can no longer craft higher-tier tools directly. Instead, you must upgrade them step-by-step using a Smithing Table.

## 📝 Key Features

- **Tiered Tool Progression**: Introduces a new system where you upgrade your tools sequentially, starting from wood/leather all the way to netherite.
- **Vanilla Recipes Disabled**: All default tool crafting recipes (except for wood/leather) are disabled.
- **Gold Tool Buff**: The performance of gold tools has been buffed to be better than iron tools.
- **Upgrade Templates**: Adds unique "Upgrade Smithing Templates" required for each tier.
- **New Block: Stone Smithing Table**: Adds an early-game Stone Smithing Table. It can be damaged and destroyed with use.
- **New Block: Reversion Table**: A new workbench that allows you to revert tools to their previous tier.
- **Infinite Durability (Default)**: By default, all tools have infinite durability.

## 🚀 Gameplay Guide

### 1. Getting Started

Your journey begins by crafting basic **Wooden Tools**. Everything starts here!

### 2. Crafting the Stone Smithing Table

For your initial upgrades, you'll need to craft a **Stone Smithing Table**. Be careful! This block has a chance to break upon use, just like an anvil.

### 3. How to Upgrade

Tool upgrades are performed in the Smithing Table UI.

> **[Previous Tier Tool] + [Upgrade Smithing Template] + [Upgrade Material] = [Next Tier Tool]**

see [JEI](https://www.curseforge.com/minecraft/mc-mods/jei) for more details.

### 4. Upgrade Tiers, Templates, & Materials

| Smithing Template                   | How to Obtain Smithing Template   |
|:------------------------------------|:----------------------------------|
| Stone Upgrade Smithing Template     | **Crafting**: Stone x8 + Stick x1 |
| Chainmail Upgrade Smithing Template | Overworld Chests                  |
| Iron Upgrade Smithing Template      | Blacksmith Chests (Villages)      |
| Gold Upgrade Smithing Template      | Bastion Remnant Chests            |
| Diamond Upgrade Smithing Template   | Villager Trading                  |
| Netherite Upgrade Smithing Template | The End Structure Chests          |

**※ IMPORTANT:** The Netherite Upgrade Smithing Template is no longer found in Bastion Rememnants.You must now search for it in The End.

### 5. Reverting Tools

If you've upgraded a tool by mistake or need a lower-tier tool, you can use the Reversion Table.
Placing an upgraded item in it will instantly convert it to its previous tier (e.g., Iron Pickaxe → Stone Pickaxe).

## 🏷️ Tag

Items affected by the `durabilityMode` config are determined by the `unbreakable` item tag.
You can change this list by creating a datapack or directly modifying the file at the path below.

- File Path: `data/tieredtools/tags/items/unbreakable.json`

## ⚙️ Configuration

**(The following feature is planned for a future update.)**

- `durabilityMode`: Sets how tool durability works.
  - `Infinite` (Default): All tools have infinite durability.
  - `Downgrade`: Tools have durability. When it runs out, the tool downgrades to the previous tier.
  - `Vanilla`: Uses the default Minecraft durability system (tools break and disappear).

---

Happy upgrading!
