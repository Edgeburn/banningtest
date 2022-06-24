package com.edgeburnmedia.banscreentest.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

	/**
	 * @author Edgeburn Media
	 * @reason Force the ban screen to show
	 */
	@Overwrite
	public boolean isMultiplayerBanned() {
		return true;
	}
}
