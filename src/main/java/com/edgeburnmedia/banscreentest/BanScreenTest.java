package com.edgeburnmedia.banscreentest;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class BanScreenTest implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	@SuppressWarnings("unused")
	public static final Logger LOGGER = LoggerFactory.getLogger("banscreentest");
	public static final UUID BAN_ID = UUID.randomUUID();

	@Override public void onInitialize() {}
}
