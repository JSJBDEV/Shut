package gd.rf.acro.shut.mixin;

import gd.rf.acro.shut.ConfigUtils;
import gd.rf.acro.shut.Shut;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ShutMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		if(Shut.config.get("doReload").equals("true"))
		{
			System.out.println("Shut");
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.MUSIC,Float.parseFloat(Shut.config.get("music")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.HOSTILE,Float.parseFloat(Shut.config.get("hostile")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.WEATHER,Float.parseFloat(Shut.config.get("weather")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.RECORDS,Float.parseFloat(Shut.config.get("records")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.AMBIENT,Float.parseFloat(Shut.config.get("ambient")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.BLOCKS,Float.parseFloat(Shut.config.get("blocks")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.NEUTRAL,Float.parseFloat(Shut.config.get("neutral")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.PLAYERS,Float.parseFloat(Shut.config.get("players")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.VOICE,Float.parseFloat(Shut.config.get("voice")));
			MinecraftClient.getInstance().options.setSoundVolume(SoundCategory.MASTER,Float.parseFloat(Shut.config.get("master")));
			ConfigUtils.dontReload();
			Shut.config.replace("doReload","false");
		}
	}
}
