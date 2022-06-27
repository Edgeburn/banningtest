package com.edgeburnmedia.banscreentest.mixin;

import com.edgeburnmedia.banscreentest.BanScreenTest;
import com.mojang.authlib.minecraft.BanDetails;
import net.minecraft.client.MinecraftClient;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.UUID;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

	/**
	 * @author Edgeburn Media, Codetoil
	 * @reason Trick the game into thinking the game is banned.
	 */
	@Overwrite
	@Nullable
	public BanDetails getMultiplayerBanDetails() {
		return new BanDetails(BanScreenTest.BAN_ID, null, null, null);
	}
}
