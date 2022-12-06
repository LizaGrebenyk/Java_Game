package characters;

public class Healer extends Warrior{
    private static final int HEAL_POWER=2;

    public Healer() {
        super(60);
    }

    @Override
    public int getAttack() {
        return 0;
    }

    @Override
    public void hit(Warrior opponent) {
    }

    @Override
    protected void processCommand(Command command, Warrior sender) {
        if(command instanceof WarriorHasHit)
            heal(sender);
        super.processCommand(command, sender);
    }

    public static int getHealingPower() {
        return HEAL_POWER;
    }

    public void heal(Warrior warrior)
    {
        warrior.healHealth(getHealingPower());
    }
}
