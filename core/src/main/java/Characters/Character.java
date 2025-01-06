package Characters;



public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected Position position;

    public abstract void update(float delta);
    public abstract void interact(Character other);
}
