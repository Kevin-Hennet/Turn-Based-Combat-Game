public class StrengthPotion extends Item {
    private int turnsRemaining;
    private int originalPower;

    public StrengthPotion() {
        super("Strength Potion");
    }

    @Override
    public Item use(CombatEntityEnhanced target) {
        if (turnsRemaining <= 0) {
            originalPower = target.getPower();
        }
          
        target.setPower(target.getPower() * 3);
        turnsRemaining = 3;
        System.out.println(target.getName() + " used a Strength Potion! Power tripled for 3 turns!");
        return this;
    }

    public void tickTurn(CombatEntityEnhanced target) {
        turnsRemaining--;
        if (turnsRemaining <= 0) {
            target.setPower(originalPower);  // restore after turns expire
            System.out.println("Strength Potion wore off!");
        }
    
    }
    public boolean isExpired() {
        return turnsRemaining <= 0;
    }
}
