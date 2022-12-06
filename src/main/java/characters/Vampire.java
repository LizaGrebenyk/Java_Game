package characters;

public class Vampire extends Warrior{
    private static int ATTACK = 4, VAMPIRISM=50;

    public Vampire()
    {
        super(40);
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    public float getVampirism() {
        return (float) VAMPIRISM/100;
    }

    @Override
    public void hit(Warrior opponent) {
        int last_opponent_health=opponent.getHealth();
        super.hit(opponent);
        if(getHealth()<40 && isAlive())
        {
            int add_health= (int) ((last_opponent_health - opponent.getHealth())*getVampirism());
            super.healHealth(Math.min(add_health,40-getHealth()));
        }
    }
}
