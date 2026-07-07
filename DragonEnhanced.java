import java.util.Random;

public class DragonEnhanced extends CombatEntityEnhanced implements AIControlledEnhanced{
    public DragonEnhanced(String name) {
        super(name, 150, 20);
        
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
        int choice = randint.nextInt(1, 21);
        if (curHealth <= 30) {
            if (choice <= 6) {
                return attack(target);
            } else if (choice >= 7 && choice <= 14) {
               target.takeHit(basePower * 3, name);
                return name + " scorched " + target.getName() + 
                " with searing fire, dealing " + basePower * 3 + " damage";  
            } else {
                target.takeHit(basePower * 3, name);
                int actualRecovery = Math.min(20, maxHealth - curHealth);
                recover(actualRecovery, name);
                return name + " took a bit out of " + target.getName() + 
                " dealing " + basePower * 3 + " damage and recovering " 
                + actualRecovery + " health!"; 
            }
        } else if (curHealth <= 75) {
            if (choice <= 10){
                return attack(target);
            } else if (choice >= 11 && choice <= 17) {
               target.takeHit(basePower * 3, name);
                return name + " scorched " + target.getName() + 
                " with searing fire, dealing " + basePower * 3 + " damage"; 
            } else {
               target.takeHit(basePower * 3, name);
                int actualRecovery = Math.min(20, maxHealth - curHealth);
                recover(actualRecovery, name);
                return name + " took a bit out of " + target.getName() + 
                " dealing " + basePower * 3 + " damage and recovering " 
                + actualRecovery + " health!"; 
            }
        } else {
            if (choice <= 16) {
            return attack(target);
            } else if (choice >= 17 && choice <= 19){
                target.takeHit(basePower * 3, name);
                return name + " scorched " + target.getName() + 
                " with searing fire, dealing " + basePower * 3 + " damage";

            } else { 
                target.takeHit(basePower * 3, name);
                int actualRecovery = Math.min(20, maxHealth - curHealth);
                recover(actualRecovery, name);
                return name + " took a bit out of " + target.getName() + 
                " dealing " + basePower * 3 + " damage and recovering " 
                + actualRecovery + " health!";
            }
        }

    }
    
}
