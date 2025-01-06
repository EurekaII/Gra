package Labirynth;

public class TownLocation extends GameLocation {
    private List<Shop> shops;
    private Inn inn;
    private TownUI townUI;

    @Override
    public void initialize() {
        loadContent();
        townUI.create();
    }

    @Override
    public void loadContent() {
        // Ładowanie zawartości miasta
    }
}
