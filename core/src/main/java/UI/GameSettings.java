package UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;

public class GameSettings {
    private static final GameSettings INSTANCE = new GameSettings();
    private Preferences prefs;

    public static final ResolutionFileResolver.Resolution[] AVAILABLE_RESOLUTIONS = {
        new Resolution(1920, 1080),
        new Resolution(1600, 900),
        new Resolution(1280, 720),
        new Resolution(1024, 768)
    };

    public static final String[] AVAILABLE_LANGUAGES = {
        "en", "pl", "de", "es"
    };

    private GameSettings() {
        prefs = Gdx.app.getPreferences("game_settings");
    }

    public static GameSettings getInstance() {
        return INSTANCE;
    }

    public void setResolution(int width, int height) {
        prefs.putInteger("width", width);
        prefs.putInteger("height", height);
        prefs.flush();
        applyResolution();
    }

    public void setLanguage(String lang) {
        prefs.putString("language", lang);
        prefs.flush();
        I18NBundle.reload();
    }

    private void applyResolution() {
        Gdx.graphics.setWindowedMode(
            prefs.getInteger("width", 1280),
            prefs.getInteger("height", 720)
        );
    }
}
