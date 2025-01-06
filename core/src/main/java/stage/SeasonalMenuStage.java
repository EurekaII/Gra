package stage;

import Screen.Season;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.utils.Array;
import io.github.MyGame.MyGame;

public class SeasonalMenuStage extends BaseStage {
    private Season currentSeason;
    private Texture background;
    private Array<ParticleEffect> seasonalEffects;

    public SeasonalMenuStage(MyGame game, Season initialSeason) {
        super(game);
        this.currentSeason = initialSeason;
        this.seasonalEffects = new Array<>();
    }

    @Override
    public void initialize() {
        loadBackground();
        createSeasonalEffects();
    }

    private void loadBackground() {
        if (background != null) background.dispose();
        background = new Texture(currentSeason.getBackgroundPath());
    }

    private void createSeasonalEffects() {
        seasonalEffects.clear();
        switch (currentSeason) {
            case WINTER:
                addSnowEffect();
                break;
            case SPRING:
                addRainEffect();
                addPetalsEffect();
                break;
            case SUMMER:
                addSunlightEffect();
                break;
            case AUTUMN:
                addFallingLeavesEffect();
                break;
        }
    }

    @Override
    public void update(float delta) {
        // Aktualizacja efektów cząsteczkowych
        for (ParticleEffect effect : seasonalEffects) {
            effect.update(delta);
        }
    }

    @Override
    public void draw() {
        // Rysowanie tła
        getBatch().draw(background, 0, 0, getWidth(), getHeight());

        // Rysowanie efektów
        for (ParticleEffect effect : seasonalEffects) {
            effect.draw(getBatch());
        }
    }

    public void changeSeason(Season newSeason) {
        if (currentSeason != newSeason) {
            currentSeason = newSeason;
            loadBackground();
            createSeasonalEffects();
        }
    }

    // Metody dodające efekty cząsteczkowe
    private void addSnowEffect() {
        ParticleEffect snow = new ParticleEffect();
        snow.load(Gdx.files.internal("effects/snow.party"), Gdx.files.internal("effects"));
        snow.start();
        seasonalEffects.add(snow);
    }

    // Podobne metody dla innych efektów...
}

