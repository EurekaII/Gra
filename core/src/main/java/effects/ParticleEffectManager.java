package effects;

import Screen.Season;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class ParticleEffectManager {
    private Map<Season, Array<ParticleEffect>> seasonalEffects;

    public ParticleEffectManager() {
        seasonalEffects = new HashMap<>();
        for (Season season : Season.values()) {
            seasonalEffects.put(season, new Array<>());
        }
    }

    public void loadEffects() {
        // Ładowanie efektów dla każdej pory roku
        loadSpringEffects();
        loadSummerEffects();
        loadAutumnEffects();
        loadWinterEffects();
    }

    private void loadSpringEffects() {
        ParticleEffect rain = new ParticleEffect();
        rain.load(Gdx.files.internal("effects/rain.party"), Gdx.files.internal("effects"));
        ParticleEffect petals = new ParticleEffect();
        petals.load(Gdx.files.internal("effects/petals.party"), Gdx.files.internal("effects"));

        seasonalEffects.get(Season.SPRING).add(rain);
        seasonalEffects.get(Season.SPRING).add(petals);
    }

    // Podobne metody dla pozostałych pór roku...

    public void update(Season currentSeason, float delta) {
        Array<ParticleEffect> effects = seasonalEffects.get(currentSeason);
        for (ParticleEffect effect : effects) {
            effect.update(delta);
        }
    }

    public void draw(SpriteBatch batch, Season currentSeason) {
        Array<ParticleEffect> effects = seasonalEffects.get(currentSeason);
        for (ParticleEffect effect : effects) {
            effect.draw(batch);
        }
    }

    public void dispose() {
        for (Array<ParticleEffect> effects : seasonalEffects.values()) {
            for (ParticleEffect effect : effects) {
                effect.dispose();
            }
        }
    }
}
