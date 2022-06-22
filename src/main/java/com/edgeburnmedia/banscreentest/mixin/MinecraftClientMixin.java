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
public class MinecraftClientMixin {
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
	private static Text getReasonText(BanDetails banDetails) {
		Text text = null;
		String string = banDetails.reason();
		if (StringUtils.isNumeric(string)) {
			text = AbuseReportReason.getText(Integer.parseInt(string));
		}
		if (text != null) {
			return Text.translatable("gui.banned.description.reason", Texts.setStyleIfAbsent(text.copy(), Style.EMPTY.withBold(true)));
		}
		return Text.translatable("gui.banned.description.unknownreason");
	}

	/**
	 * @author Edgeburn Media
	 * @reason Testing ban screens
	 */
	@Overwrite
	private static Text getDurationText(BanDetails banDetails) {
		return Text.translatable("gui.banned.description.permanent").formatted(Formatting.BOLD);
	}

	/**
	 * @author Edgeburn Media
	 * @reason Testing ban screens
	 */
	@Overwrite
	private static Text getTemporaryBanDurationText(BanDetails banDetails) {
		Duration duration = Duration.between(Instant.now(), banDetails.expires());
		long l = duration.toHours();
		if (l > 72L) {
			return ScreenTexts.days(duration.toDays());
		}
		if (l < 1L) {
			return ScreenTexts.minutes(duration.toMinutes());
		}
		return ScreenTexts.hours(duration.toHours());
	}

	/**
	 * @author Edgeburn Media
	 * @reason Testing ban screens
	 */
	@Overwrite
	private static boolean isTemporary(BanDetails banDetails) {
		return banDetails.expires() != null;
	}
}
