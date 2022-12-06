package characters;

public interface WarriorDefine {
    int getAttack();

    int getHealth();

    private void setHealth(int health) {}

    boolean isAlive();

    void hit(Warrior opponent);

    void receiveDamage(int damage);

    void healHealth(int heal);
}
