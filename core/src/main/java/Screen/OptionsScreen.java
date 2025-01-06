package Screen;

import UI.GameSettings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.resolvers.ResolutionFileResolver;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.MyGame.MyGame;

public class OptionsScreen extends BaseScreen {
    private Stage stage;
    private Skin skin;
    private Table mainTable;

    public OptionsScreen(MyGame game) {
        super(game);
        create();
    }

    private void create() {
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        mainTable = new Table();
        mainTable.setFillParent(true);

        // Dodanie wyboru rozdzielczości
        SelectBox<ResolutionFileResolver.Resolution> resolutionSelect = new SelectBox<>(skin);
        resolutionSelect.setItems(GameSettings.AVAILABLE_RESOLUTIONS);
        resolutionSelect.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                ResolutionFileResolver.Resolution selected = resolutionSelect.getSelected();
                GameSettings.getInstance().setResolution(selected.width, selected.height);
            }
        });

        // Dodanie wyboru języka
        SelectBox<String> languageSelect = new SelectBox<>(skin);
        languageSelect.setItems(GameSettings.AVAILABLE_LANGUAGES);
        languageSelect.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String selected = languageSelect.getSelected();
                GameSettings.getInstance().setLanguage(selected);
                updateTexts();
            }
        });

        // Przycisk powrotu
        TextButton backButton = new TextButton(I18NBundle.get("back"), skin);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenuScreen(game));
            }
        });

        // Układanie elementów
        mainTable.add(new Label(I18NBundle.get("resolution"), skin)).pad(10);
        mainTable.add(resolutionSelect).pad(10);
        mainTable.row();
        mainTable.add(new Label(I18NBundle.get("language"), skin)).pad(10);
        mainTable.add(languageSelect).pad(10);
        mainTable.row();
        mainTable.add(backButton).colspan(2).pad(20);

        stage.addActor(mainTable);
        Gdx.input.setInputProcessor(stage);
    }

    private void updateTexts() {
        // Aktualizacja wszystkich tekstów po zmianie języka
        ((Label)mainTable.findActor("resolutionLabel")).setText(I18NBundle.get("resolution"));
        ((Label)mainTable.findActor("languageLabel")).setText(I18NBundle.get("language"));
        ((TextButton)mainTable.findActor("backButton")).setText(I18NBundle.get("back"));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
        skin.dispose();
    }
}
