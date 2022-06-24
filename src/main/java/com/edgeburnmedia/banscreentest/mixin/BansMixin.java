package com.edgeburnmedia.banscreentest.mixin;

import com.mojang.authlib.minecraft.BanDetails;
import net.minecraft.client.network.Bans;
import net.minecraft.client.network.abusereport.AbuseReportReason;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.Formatting;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.time.Duration;
import java.time.Instant;

@Mixin(Bans.class)
public class BansMixin {
	@Shadow @Final private static Text PERMANENT_TITLE;
	@Shadow @Final public static String JAVA_MODERATION_URL;

	/**
	 * @author Edgeburn Media
	 * @reason Testing ban screens
	 */
	@Overwrite
	private static Text getTitle(BanDetails banDetails) {
		return PERMANENT_TITLE;
	}

	/**
	 * @author Edgeburn Media
	 * @reason Testing ban screens
	 */
	@Overwrite
	private static Text getDescriptionText(BanDetails banDetails) {
		return Text.translatable("gui.banned.description", Text.translatable("gui.banned.description.unknownreason"),Text.translatable("gui.banned.description.permanent").formatted(Formatting.BOLD), JAVA_MODERATION_URL);
	}

	/**
	 * @author Edgeburn Media
	 * @reason Testing ban screens
	 */
	@Overwrite
	private static Text getDurationText(BanDetails banDetails) {
		return Text.translatable("gui.banned.description.permanent").formatted(Formatting.BOLD);
	}
}
