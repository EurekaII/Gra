package UI;

import UI.UIComponent;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.MyGame.MyGame;

public class MainMenuUI implements UIComponent {
    private final MyGame game;
    private Stage uiStage;
    private Table mainTable;
    private Skin skin;

    public MainMenuUI(MyGame game) {
        this.game = game;
        this.uiStage = new Stage(new ScreenViewport());
    }

    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        createUI();
    }

    private void createUI() {
        mainTable = new Table();
        mainTable.setFillParent(true);

        TextButton playButton = new TextButton("Play", skin);
        TextButton optionsButton = new TextButton("Options", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        // Dodawanie przycisków do zmiany pory roku (dla testów)
        TextButton springButton = new TextButton("Spring", skin);
        TextButton summerButton = new TextButton("Summer", skin);
        TextButton autumnButton = new TextButton("Autumn", skin);
        TextButton winterButton = new TextButton("Winter", skin);

        // Ustawianie akcji dla przycisków
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Rozpoczęcie gry
                game.setScreen(new GameScreen(game));
            }
        });

        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        // Układanie przycisków w tabeli
        mainTable.add(playButton).pad(10).row();
        mainTable.add(optionsButton).pad(10).row();
        mainTable.add(exitButton).pad(10).row();

        // Dodawanie przycisków sezonowych
        Table seasonTable = new Table();
        seasonTable.add(springButton).pad(5);
        seasonTable.add(summerButton).pad(5);
        seasonTable.add(autumnButton).pad(5);
        seasonTable.add(winterButton).pad(5);

        mainTable.add(seasonTable).pad(20);

        uiStage.addActor(mainTable);
    }

    @Override
    public void update(float delta) {
        uiStage.act(delta);
        uiStage.draw();
    }

    @Override
    public void dispose() {
        uiStage.dispose();
        skin.dispose();
    }
}
