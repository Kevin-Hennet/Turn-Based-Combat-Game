import java.util.Random;

public class Skeleton extends CombatEntityEnhanced implements AIControlledEnhanced{
    public Skeleton(String name) {
        super(name, 80, 12);
    }
    @Override
    public String attack(CombatEntityEnhanced target) {
        return target.takeHit(basePower, name);
    }
    @Override
    public String takeTurn(CombatEntityEnhanced target) {
        if (this.getStunned()) {
            this.setStunned(false);
            return name + " is stunned and skips their turn!";

        }
        Random randint = new Random();
        // desperate mode when low health — higher chance of heavy attack
        int max;
        if (curHealth <= 40) {
            max = 15;
        } else {
            max = 21;
        }        
        int choice = randint.nextInt(1, max+1);
        if (choice < 12) {
            return attack(target);
        } else if (choice >= 12 && choice <= 13) {
            target.takeHit(basePower * 2, name);
            return name + " lunges with a bone-crushing strike, dealing " 
                + basePower * 2 + " damage!";
        } else {
            target.takeHit(basePower * 2, name);
            int actualRecovery = Math.min(20, maxHealth - curHealth);
            recover(actualRecovery, name);
            return name + " drains life from " + target.getName() 
                + ", dealing " + basePower * 2 + " damage and recovering " 
                + actualRecovery + " health!";
        }

    }
}
