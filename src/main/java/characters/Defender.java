package characters;

public class Defender extends Warrior {
    private static final int ATTACK = 3, DEFENSE = 2;

    public Defender()
    {
        super(60);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public int getDefense() {
        return DEFENSE;
    }

    @Override
    public void receiveDamage(int damage) {
        super.receiveDamage(Math.max(0,damage-getDefense()));
    }
}
