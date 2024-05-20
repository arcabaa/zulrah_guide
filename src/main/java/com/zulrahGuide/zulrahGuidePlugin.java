package com.zulrahGuide;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.NpcID;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;

import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "Zulrah Guide",
	description = "the best zulrah guide",
	tags = {"zulrah", "boss", "guide"}
)
public class zulrahGuidePlugin extends Plugin {
	private static final int ZULRAH_MELEE = 2042;
	private static final int ZULRAH_RANGED = 2043;
	private static final int ZULRAH_MAGE = 2044;

	@Inject
	private Client client;

	@Inject
	private zulrahGuideConfig config;

	@Inject
	private ClientToolbar clientToolbar;

	private ZulrahGuidePanel panel;
	private NavigationButton navButton;

	@Override
	protected void startUp() throws Exception {
		panel = injector.getInstance(ZulrahGuidePanel.class);

		BufferedImage iconImage = ImageUtil.loadImageResource(getClass(), "/zulrah_turq.png");

		navButton = NavigationButton.builder()
				.tooltip("Zulrah Guide")
				.icon(iconImage)
				.priority(70)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception {
		clientToolbar.removeNavigation(navButton);
		log.info("Zulrah Guide stopped!");
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		for (NPC npc : client.getNpcs()) {
			if (npc.getId() == NpcID.ZULRAH || npc.getId() == 2042 || npc.getId() == 2043 || npc.getId() == 2044) {
				handleZulrah(npc);
			}
		}
	}

	private void handleZulrah(NPC zulrah) {
		switch (zulrah.getId()) {
			case ZULRAH_MELEE:
				// MELEE FORM
				break;
			case ZULRAH_RANGED:
				// RANGED FORM
				break;
			case ZULRAH_MAGE:
				// MAGE FORM
				break;
		}
	}

	@Provides
	zulrahGuideConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(zulrahGuideConfig.class);
	}
}
