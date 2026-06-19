package com.orbmover;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class OrbMoverTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(OrbMoverPlugin.class);
		RuneLite.main(args);
	}
}