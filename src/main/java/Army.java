import characters.Warrior;

import java.util.*;
import java.util.function.Supplier;

public class Army {
    List<UnitInArmy> troops= new LinkedList<>();

    static class UnitInArmy extends Warrior
    {
        public Warrior warrior;

        public UnitInArmy(Warrior warrior) {
            this.warrior = warrior;
        }

        @Override
        public Warrior getWarriorBehind() {
            return  warrior.getWarriorBehind();
        }

        @Override
        public void setWarriorBehind(Warrior next) {
            warrior.setWarriorBehind(next);
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public boolean isAlive() {
            return warrior.isAlive();
        }

        @Override
        public void hit(Warrior opponent) {
            warrior.hit(opponent);
        }

        @Override
        public void receiveDamage(int damage) {
            warrior.receiveDamage(damage);
        }

        @Override
        public void healHealth(int heal) {
            warrior.healHealth(heal);
        }
    }

    public Iterator<Warrior> firstAlive()
    {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Warrior>
    {
        @Override
        public boolean hasNext() {
            while (peekFirst()!=null && !peekFirst().isAlive())
                removeFirst();

            return peekFirst()!=null;
        }

        @Override
        public Warrior next() {
            if(!hasNext())
                throw new NoSuchElementException();

            return peekFirst();
        }
    }

    public Army addUnits(UnitInArmy nextUnit)
    {
        if(!troops.isEmpty())
            troops.get(troops.size()-1).setWarriorBehind(nextUnit.warrior);
        troops.add(nextUnit);
        return this;
    }

    public Army addUnits(Supplier<Warrior> factory, int quantity)
    {
        for(int i=0;i<quantity;i++) {
            Warrior nextWarrior=factory.get();
            UnitInArmy nextUnit=new UnitInArmy(nextWarrior);
            addUnits(nextUnit);
        }

        return this;
    }

    public Warrior peekFirst()
    {
        if(!troops.isEmpty())
            return troops.get(0).warrior;
        else
            return null;
    }

    public void removeFirst()
    {
        if(!troops.isEmpty())
            troops.remove(0);
    }

    public boolean isEmpty()
    {
        return troops.isEmpty();
    }
}
