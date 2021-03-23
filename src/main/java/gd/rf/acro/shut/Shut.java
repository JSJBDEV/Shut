package gd.rf.acro.shut;

import net.fabricmc.api.ModInitializer;

import java.util.Map;

public class Shut implements ModInitializer {
	public static Map<String,String> config;
	@Override
	public void onInitialize() {
		config=ConfigUtils.checkConfigs();

	}

}
