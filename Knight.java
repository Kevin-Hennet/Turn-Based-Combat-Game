
import java.util.Scanner;

public class Knight extends CombatEntityEnhanced implements PlayerControlledEnhanced{
    private boolean isCharged;
    public Knight(String name) {
        super(name, 130, 10);
        this.isCharged = false;
    }
    @Override
    public String attack(CombatEntityEnhanced target) {
        if (isCharged) {
            isCharged = false;
            int damage = basePower * 2;
            return target.takeHit(damage, name + "'s Charged Attack");
        }
        return target.takeHit(basePower, name);
    }
    @Override
    public String chooseAction(Scanner input, CombatEntityEnhanced target) {
        System.out.println("0. Retreat    1. Simple Attack   2. Block   3. Shield Bash   4. Charge Attack    5. Use Item");
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
            this.setBlocking(true);
            return name + " Takes a defensive stance and will block the next hit!";
            
        } else if (choice == 3){
            String result = target.takeHit(5, "Shield Bash");
            target.setStunned(true);
            return result + "\n" + target.getName() + " is stunned and will skip their next turn";

        }else if (choice == 4) {
            isCharged = true;
            return name + " is charging up for a powerful strike next turn!";
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
