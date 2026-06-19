package com.orbmover;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import net.runelite.api.gameval.InterfaceID;

enum OrbWidget
{
	HITPOINTS(
		InterfaceID.Orbs.ORB_HEALTH,
		OrbMoverConfig::hpEnabled,
		OrbMoverConfig::hpX, OrbMoverConfig::hpY,
		"hpX", "hpY"
	),
	PRAYER(
		InterfaceID.Orbs.ORB_PRAYER,
		OrbMoverConfig::prayerEnabled,
		OrbMoverConfig::prayerX, OrbMoverConfig::prayerY,
		"prayerX", "prayerY"
	),
	RUN(
		InterfaceID.Orbs.ORB_RUNENERGY,
		OrbMoverConfig::runEnabled,
		OrbMoverConfig::runX, OrbMoverConfig::runY,
		"runX", "runY"
	),
	SPECIAL(
		InterfaceID.Orbs.ORB_SPECENERGY,
		OrbMoverConfig::specEnabled,
		OrbMoverConfig::specX, OrbMoverConfig::specY,
		"specX", "specY"
	),

	STORE(
		packId(160, 43),
		OrbMoverConfig::storeEnabled,
		OrbMoverConfig::storeX, OrbMoverConfig::storeY,
		"storeX", "storeY"
	),
	ACTIVITY_ADVISER(
		packId(160, 48),
		OrbMoverConfig::adviserEnabled,
		OrbMoverConfig::adviserX, OrbMoverConfig::adviserY,
		"adviserX", "adviserY"
	),
	WIKI(
		packId(160, 50),
		OrbMoverConfig::wikiEnabled,
		OrbMoverConfig::wikiX, OrbMoverConfig::wikiY,
		"wikiX", "wikiY"
	),
	WORLDMAP(
		packId(160, 49),
		OrbMoverConfig::worldmapEnabled,
		OrbMoverConfig::worldmapX, OrbMoverConfig::worldmapY,
		"worldmapX", "worldmapY"
	),
	XP_DROPS(
		packId(160, 6),
		OrbMoverConfig::xpdropsEnabled,
		OrbMoverConfig::xpdropsX, OrbMoverConfig::xpdropsY,
		"xpdropsX", "xpdropsY"
	);

	final int componentId;
	final String xKey;
	final String yKey;
	private final Predicate<OrbMoverConfig> enabled;
	private final ToIntFunction<OrbMoverConfig> xFn;
	private final ToIntFunction<OrbMoverConfig> yFn;

	OrbWidget(int componentId,
			  Predicate<OrbMoverConfig> enabled,
			  ToIntFunction<OrbMoverConfig> xFn,
			  ToIntFunction<OrbMoverConfig> yFn,
			  String xKey,
			  String yKey)
	{
		this.componentId = componentId;
		this.enabled = enabled;
		this.xFn = xFn;
		this.yFn = yFn;
		this.xKey = xKey;
		this.yKey = yKey;
	}

	boolean isEnabled(OrbMoverConfig c) { return enabled.test(c); }
	int getX(OrbMoverConfig c) { return xFn.applyAsInt(c); }
	int getY(OrbMoverConfig c) { return yFn.applyAsInt(c); }

	private static int packId(int group, int child)
	{
		return (group << 16) | child;
	}
}
