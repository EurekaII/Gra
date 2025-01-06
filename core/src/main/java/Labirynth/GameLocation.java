package Labirynth;

import stage.BaseStage;

public abstract class GameLocation extends BaseStage {
    protected List<Character> characters;
    protected Map<String, InteractiveObject> objects;

    public abstract void loadContent();
    public abstract void handleInteractions();
}
