package com.zulrahGuide;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class zulrahGuidePluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(zulrahGuidePlugin.class);
		RuneLite.main(args);
	}
}