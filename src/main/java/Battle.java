import characters.Healer;
import characters.Lancer;
import characters.Warrior;

import java.util.Iterator;

public class Battle {
    public static boolean fight(Warrior warrior1,Warrior warrior2)
    {
        while (warrior1.isAlive() && warrior2.isAlive()){
            warrior1.hit(warrior2);
            if(warrior2.isAlive())
                warrior2.hit(warrior1);
        }

        return warrior1.isAlive();
    }

    public static boolean fight(Army army1,Army army2)
    {
        Iterator<Warrior> iterator_army1=army1.firstAlive();
        Iterator<Warrior> iterator_army2=army2.firstAlive();

        while (iterator_army1.hasNext() && iterator_army2.hasNext())
            fight(iterator_army1.next(), iterator_army2.next());

        return iterator_army1.hasNext();
    }

    public static boolean straightFight(Army army1,Army army2)
    {
        Iterator<Warrior> iterator_army1=army1.firstAlive();
        Iterator<Warrior> iterator_army2=army2.firstAlive();

        while (iterator_army1.hasNext() && iterator_army2.hasNext()) {
            iterator_army1.forEachRemaining(warrior1 -> {
                Warrior warrior2=null;
                if(iterator_army2.hasNext())
                    warrior2=iterator_army2.next();

                if(warrior1 instanceof Lancer)
                    warrior2.setWarriorBehind(null);
                if(warrior2 instanceof Lancer)
                    warrior1.setWarriorBehind(null);
                if(warrior1.getWarriorBehind() instanceof Healer)
                    warrior1.setWarriorBehind(null);
                if(warrior2.getWarriorBehind() instanceof Healer)
                    warrior2.setWarriorBehind(null);
                fight(warrior1, warrior2);
            });
        }

        return iterator_army1.hasNext();
    }
}
