package com.orbmover;

import com.google.inject.Provides;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetPositionMode;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Orb Mover",
	description = "Move the minimap orbs to custom positions.",
	tags = {"minimap", "orb", "orbs", "move", "mover", "reposition", "position", "interface", "layout"}
)
public class OrbMoverPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private OrbMoverConfig config;

	private final List<RestoreEntry> originals = new ArrayList<>();

	private static final class RestoreEntry
	{
		final int componentId;
		final int x;
		final int y;
		final int xMode;
		final int yMode;

		RestoreEntry(int componentId, int x, int y, int xMode, int yMode)
		{
			this.componentId = componentId;
			this.x = x;
			this.y = y;
			this.xMode = xMode;
			this.yMode = yMode;
		}
	}

	@Provides
	OrbMoverConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(OrbMoverConfig.class);
	}

	@Override
	protected void shutDown()
	{
		clientThread.invoke(() ->
		{
			for (RestoreEntry e : originals)
			{
				Widget w = client.getWidget(e.componentId);
				if (w != null)
				{
					w.setXPositionMode(e.xMode);
					w.setYPositionMode(e.yMode);
					w.setOriginalX(e.x);
					w.setOriginalY(e.y);
					w.revalidate();
				}
			}
			originals.clear();
		});
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		for (OrbWidget orb : OrbWidget.values())
		{
			Widget w = client.getWidget(orb.componentId);
			if (w == null)
			{
				continue;
			}

			if (orb.isEnabled(config))
			{
				// Remember original position AND position modes, once.
				if (!isRemembered(orb.componentId))
				{
					originals.add(new RestoreEntry(orb.componentId,
						w.getOriginalX(), w.getOriginalY(),
						w.getXPositionMode(), w.getYPositionMode()));
				}

				if (w.getXPositionMode() != WidgetPositionMode.ABSOLUTE_LEFT)
				{
					w.setXPositionMode(WidgetPositionMode.ABSOLUTE_LEFT);
				}
				if (w.getYPositionMode() != WidgetPositionMode.ABSOLUTE_TOP)
				{
					w.setYPositionMode(WidgetPositionMode.ABSOLUTE_TOP);
				}

				int targetX = orb.getX(config);
				int targetY = orb.getY(config);

				Widget parent = w.getParent();
				if (parent != null)
				{
					int maxX = parent.getWidth() - w.getWidth();
					int maxY = parent.getHeight() - w.getHeight();

					// Horizontal: used directly, clamped to the parent.
					if (maxX >= 0 && targetX > maxX)
					{
						targetX = maxX;
					}
					if (targetX < 0)
					{
						targetX = 0;
					}

					// Vertical is stored as distance UP from the bottom, so a
					// higher value (up arrow) moves the orb up. Convert to a
					// top-relative Y here: 0 = bottom of parent, maxY = top.
					if (maxY >= 0)
					{
						int vertical = targetY;
						if (vertical > maxY)
						{
							vertical = maxY;
						}
						if (vertical < 0)
						{
							vertical = 0;
						}
						targetY = maxY - vertical;
					}
				}

				if (w.getOriginalX() != targetX || w.getOriginalY() != targetY)
				{
					w.setOriginalX(targetX);
					w.setOriginalY(targetY);
					w.revalidate();
				}
			}
			else
			{
				restoreOriginal(orb.componentId, w);
			}
		}
	}

	private boolean isRemembered(int componentId)
	{
		for (RestoreEntry e : originals)
		{
			if (e.componentId == componentId)
			{
				return true;
			}
		}
		return false;
	}

	private void restoreOriginal(int componentId, Widget w)
	{
		for (int i = 0; i < originals.size(); i++)
		{
			RestoreEntry e = originals.get(i);
			if (e.componentId == componentId)
			{
				w.setXPositionMode(e.xMode);
				w.setYPositionMode(e.yMode);
				w.setOriginalX(e.x);
				w.setOriginalY(e.y);
				w.revalidate();
				originals.remove(i);
				return;
			}
		}
	}
}
