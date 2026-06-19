package com.orbmover;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(OrbMoverConfig.GROUP)
public interface OrbMoverConfig extends Config
{
	String GROUP = "orbmover";

	// Hitpoints
	@ConfigSection(
		name = "Hitpoints",
		description = "Reposition the hitpoints orb",
		position = 0
	)
	String hpSection = "hpSection";

	@ConfigItem(
		keyName = "hpEnabled",
		name = "Custom position",
		description = "Enable the custom position to the hitpoints orb",
		section = hpSection,
		position = 0
	)
	default boolean hpEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "hpX", name = "Horizontal",
		description = "Increased value moves orb right",
		section = hpSection, position = 1)
	default int hpX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "hpY", name = "Vertical",
		description = "Increased value moves orb up",
		section = hpSection, position = 2)
	default int hpY() { return 0; }

	// Prayer
	@ConfigSection(
		name = "Prayer",
		description = "Reposition the prayer orb",
		position = 1
	)
	String prayerSection = "prayerSection";

	@ConfigItem(keyName = "prayerEnabled", name = "Custom position",
		description = "Enable the custom position to the prayer orb",
		section = prayerSection, position = 0)
	default boolean prayerEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "prayerX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = prayerSection, position = 1)
	default int prayerX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "prayerY", name = "Vertical",
			description = "Increased value moves orb up",
		section = prayerSection, position = 2)
	default int prayerY() { return 0; }

	// Run
	@ConfigSection(
		name = "Run energy",
		description = "Reposition the run energy orb",
		position = 2
	)
	String runSection = "runSection";

	@ConfigItem(keyName = "runEnabled", name = "Custom position",
		description = "Enable the custom position to the run energy orb",
		section = runSection, position = 0)
	default boolean runEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "runX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = runSection, position = 1)
	default int runX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "runY", name = "Vertical",
			description = "Increased value moves orb up",
		section = runSection, position = 2)
	default int runY() { return 0; }

	// Special attacks
	@ConfigSection(
		name = "Special attacks",
		description = "Reposition the special attacks orb",
		position = 3
	)
	String specSection = "specSection";

	@ConfigItem(keyName = "specEnabled", name = "Custom position",
		description = "Enable the custom position to the special attacks orb",
		section = specSection, position = 0)
	default boolean specEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "specX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = specSection, position = 1)
	default int specX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "specY", name = "Vertical",
			description = "Increased value moves orb up",
		section = specSection, position = 2)
	default int specY() { return 0; }

	// Store
	@ConfigSection(
		name = "Store",
		description = "Reposition the store",
		position = 4
	)
	String storeSection = "storeSection";

	@ConfigItem(keyName = "storeEnabled", name = "Custom position",
		description = "Enable the custom position to the store",
		section = storeSection, position = 0)
	default boolean storeEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "storeX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = storeSection, position = 1)
	default int storeX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "storeY", name = "Vertical",
			description = "Increased value moves orb up",
		section = storeSection, position = 2)
	default int storeY() { return 0; }

	// Activity Adviser
	@ConfigSection(
		name = "Activity Adviser",
		description = "Reposition the activity adviser",
		position = 5
	)
	String adviserSection = "adviserSection";

	@ConfigItem(keyName = "adviserEnabled", name = "Custom position",
		description = "Enable the custom position to the activity adviser",
		section = adviserSection, position = 0)
	default boolean adviserEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "adviserX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = adviserSection, position = 1)
	default int adviserX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "adviserY", name = "Vertical",
			description = "Increased value moves orb up",
		section = adviserSection, position = 2)
	default int adviserY() { return 0; }

	// Wiki
	@ConfigSection(
		name = "Wiki",
		description = "Reposition the wiki",
		position = 6
	)
	String wikiSection = "wikiSection";

	@ConfigItem(keyName = "wikiEnabled", name = "Custom position",
		description = "Enable the custom position to the wiki",
		section = wikiSection, position = 0)
	default boolean wikiEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "wikiX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = wikiSection, position = 1)
	default int wikiX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "wikiY", name = "Vertical",
			description = "Increased value moves orb up",
		section = wikiSection, position = 2)
	default int wikiY() { return 0; }

	// World map
	@ConfigSection(
		name = "World map",
		description = "Reposition the world map",
		position = 7
	)
	String worldmapSection = "worldmapSection";

	@ConfigItem(keyName = "worldmapEnabled", name = "Custom position",
		description = "Enable the custom position to the world map",
		section = worldmapSection, position = 0)
	default boolean worldmapEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "worldmapX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = worldmapSection, position = 1)
	default int worldmapX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "worldmapY", name = "Vertical",
			description = "Increased value moves orb up",
		section = worldmapSection, position = 2)
	default int worldmapY() { return 0; }

	// XP drops
	@ConfigSection(
		name = "XP drops",
		description = "Reposition the XP drops orb",
		position = 8
	)
	String xpdropsSection = "xpdropsSection";

	@ConfigItem(keyName = "xpdropsEnabled", name = "Custom position",
		description = "Enable the custom position to the XP drops orb",
		section = xpdropsSection, position = 0)
	default boolean xpdropsEnabled() { return false; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "xpdropsX", name = "Horizontal",
			description = "Increased value moves orb right",
		section = xpdropsSection, position = 1)
	default int xpdropsX() { return 0; }

	@Range(min = 0, max = 1337)
	@ConfigItem(keyName = "xpdropsY", name = "Vertical",
			description = "Increased value moves orb up",
		section = xpdropsSection, position = 2)
	default int xpdropsY() { return 0; }
}
