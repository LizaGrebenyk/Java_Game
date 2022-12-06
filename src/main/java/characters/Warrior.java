package characters;

public class Warrior implements WarriorDefine,HasWarriorBehind{
        private static final int ATTACK = 5;
        private int health = 50;
        private final int initHealth;
        private Warrior nextBehind=null;

        public Warrior() {
                this(50);
        }

        protected Warrior(int health) {
                initHealth = this.health = health;
        }

        public int getAttack() {
                return ATTACK;
        }

        public int getHealth() {
                return health;
        }

        private void setHealth(int health) {
                this.health = Math.min(health,getInitHealth());
        }

        private int getInitHealth()
        {
                return initHealth;
        }

        public boolean isAlive() {
                return getHealth() > 0;
        }

        public void hit(Warrior opponent) {
                opponent.receiveDamage(getAttack());
                processCommand(WarriorHasHit.INSTANCE, null);
        }

        public void receiveDamage(int damage) {
                setHealth(getHealth() - damage);
        }

        public void healHealth(int heal) {
                setHealth(getHealth() + heal);
        }

        @Override
        public String toString() {
                return "%s {health = %d, attack = %d}".formatted(getClass().getSimpleName(), getHealth(),getAttack());
        }

        protected void processCommand(Command command, Warrior sender)
        {
                var next=getWarriorBehind();
                if(next!= null)
                        next.processCommand(command,this);
        }


        @Override
        public Warrior getWarriorBehind() {
                return nextBehind;
        }

        @Override
        public void setWarriorBehind(Warrior nextBehind) {
                this.nextBehind=nextBehind;
        }
}
