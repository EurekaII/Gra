package Labirynth;

public class DungeonLocation extends GameLocation {
    private List<Monster> monsters;
    private List<Treasure> treasures;
    private CombatSystem combatSystem;
    private DungeonUI dungeonUI;

    @Override
    public void initialize() {
        loadContent();
        dungeonUI.create();
        combatSystem = new CombatSystem();
    }
}
