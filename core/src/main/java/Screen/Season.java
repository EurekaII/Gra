package Screen;

public enum Season {
    SPRING("spring_background.png", new Color(0.7f, 0.9f, 0.7f, 1f)),
    SUMMER("summer_background.png", new Color(1f, 0.95f, 0.7f, 1f)),
    AUTUMN("autumn_background.png", new Color(0.9f, 0.7f, 0.5f, 1f)),
    WINTER("winter_background.png", new Color(0.8f, 0.8f, 0.9f, 1f));

    private final String backgroundPath;
    private final Color ambientColor;

    Season(String backgroundPath, Color ambientColor) {
        this.backgroundPath = backgroundPath;
        this.ambientColor = ambientColor;
    }

    public String getBackgroundPath() { return backgroundPath; }
    public Color getAmbientColor() { return ambientColor; }
}
