package Screen;

import Screen.BaseScreen;
import Screen.Season;
import UI.I18NBundle;
import UI.MainMenuUI;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import stage.SeasonalMenuStage;

import java.util.Calendar;

public class MainMenuScreen extends BaseScreen {
    private SeasonalMenuStage menuStage;
    private MainMenuUI menuUI;
    private Season currentSeason;

    public MainMenuScreen(MyGame game) {
        super(game);
        currentSeason = calculateCurrentSeason(); // Początkowo ustawiamy aktualną porę roku
        menuStage = new SeasonalMenuStage(game, currentSeason);
        menuUI = new MainMenuUI(game);
    }

    private Season calculateCurrentSeason() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);

        if (month >= 2 && month <= 4) return Season.SPRING;
        if (month >= 5 && month <= 7) return Season.SUMMER;
        if (month >= 8 && month <= 10) return Season.AUTUMN;
        return Season.WINTER;
    }

    @Override
    public void show() {
        menuStage.initialize();
        menuUI.create();
        Gdx.input.setInputProcessor(new InputMultiplexer(menuStage, menuUI));
    }

    TextButton optionsButton = new TextButton(I18NBundle.get("options"), skin);
    optionsButton.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
            game.setScreen(new OptionsScreen(game));
        }
    });


    @Override
    public void render(float delta) {
        super.render(delta);

        // Obsługa klawiszy do zmiany pory roku
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            menuStage.changeSeason(Season.SPRING);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            menuStage.changeSeason(Season.SUMMER);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            menuStage.changeSeason(Season.AUTUMN);
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            menuStage.changeSeason(Season.WINTER);
        }

        // Aktualizacja sezonu i efektów
        menuStage.update(delta);
        menuUI.update(delta);

        // Renderowanie
        batch.begin();
        menuStage.draw();
        batch.end();
    }
}
