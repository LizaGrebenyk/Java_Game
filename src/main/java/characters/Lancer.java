package characters;

public class Lancer extends Warrior {
    private static int ATTACK = 6, PIERCING_POWER=50;

    public Lancer() {
        super(50);
    }

    public static int getPiercingPower() {
        return PIERCING_POWER;
    }

    @Override
    public int getAttack() {
        return ATTACK;
    }

    @Override
    public void hit(Warrior opponent) {
        int last_opponent_health=opponent.getHealth();
        super.hit(opponent);

        if(opponent.getWarriorBehind()!=null)
        {
            int dealt_damage=last_opponent_health-opponent.getHealth();
            Warrior next= opponent.getWarriorBehind();
            next.receiveDamage(dealt_damage*getPiercingPower()/100);
        }
    }
}
