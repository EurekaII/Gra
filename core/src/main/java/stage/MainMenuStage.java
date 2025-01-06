package stage;

public class MainMenuStage extends BaseStage {
    private Texture background;

    @Override
    public void initialize() {
        background = new Texture("menu_background.png");
        // Inicjalizacja tła i innych elementów sceny
    }

    @Override
    public void update(float delta) {
        // Aktualizacja animacji tła itp.
    }
}
