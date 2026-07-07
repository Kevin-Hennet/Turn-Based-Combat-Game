import java.util.Scanner;

public class WizardEnhanced extends CombatEntityEnhanced implements PlayerControlledEnhanced{  
    public WizardEnhanced(String name){
        super(name, 120, 15);
    }
    @Override
    public String attack(CombatEntityEnhanced target) {
        return target.takeHit(basePower, name);
    
    }
    @Override
    public String chooseAction(Scanner input, CombatEntityEnhanced target) {
        System.out.println("0. Retreat    1. Simple Attack   2. Heal (Spell)    3. Undo (Spell)    4. Special Attack (lose 10 hp but deal 2X damage)   5. Use Item" );
        int choice = -1;
        boolean valid = false;
        while (!valid) {
            if (!input.hasNextInt()) {
                input.next();
                System.out.println("Invalid input, please enter a number 0-5");
            } else {
                choice = input.nextInt();
                if (choice >= 0 && choice <= 5) {
                    valid = true;
                } else { 
                    System.out.println("Invalid input, please enter a number 0-5");
                }
            }
        }
        if (choice == 0) {
            return "RETREAT";
        } else if (choice == 1) {
            return attack(target);

        } else if (choice == 2) {
            return recover(20, name);
        } else  if (choice == 3) {
            return "UNDO";
        } else if (choice == 4) {
            String selfDamage = takeHit(10, "Mana Burst");
            String attack = target.takeHit(basePower * 2, name + "'s Mana Burst");
            return selfDamage + "\n" + attack;
        } else {
            if (hasItem()) {
                Item used = useItem(target);
                return name + " uses " + used.getName() + "!";
            } else {
                return name + " has no item to use!";
            }
        }
    }    
}


