package stage;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.MyGame.MyGame;

public abstract class BaseStage extends Stage {
    protected final MyGame game;

    public BaseStage(MyGame game) {
        super(new ScreenViewport());
        this.game = game;
    }

    public abstract void initialize();
    public abstract void update(float delta);
}
