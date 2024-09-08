package cursedbread.touchgrass;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;


public class GRASS implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
    public static final String MOD_ID = "touchgrass";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("Touching grass.");
    }
	public static int mobdeath;

	static {
		Properties prop = new Properties();
		prop.setProperty("Grass allergic mobs (0 or 1)","0");

		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		mobdeath = config.getInt("Grass allergic mobs (0 or 1)");
	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
