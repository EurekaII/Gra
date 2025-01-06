package UI;

public class I18NBundle {
    private static com.badlogic.gdx.utils.I18NBundle bundle;
    private static String currentLanguage;

    public static void init() {
        currentLanguage = GameSettings.getInstance().getLanguage();
        reload();
    }

    public static void reload() {
        FileHandle baseFileHandle = Gdx.files.internal("i18n/messages");
        Locale locale = new Locale(currentLanguage);
        bundle = com.badlogic.gdx.utils.I18NBundle.createBundle(baseFileHandle, locale);
    }

    public static String get(String key) {
        return bundle.get(key);
    }
}
