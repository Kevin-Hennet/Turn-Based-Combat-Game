public class WeaknessPotion extends Item{
    private int turnsRemaining;
    private int originalPower;

    public WeaknessPotion() {
        super("Weakness Potion");
    }

    @Override
    public Item use(CombatEntityEnhanced target) {
        originalPower = target.getPower();  // save it as a field
        target.setPower(target.getPower() / 2);
        turnsRemaining = 3;
        System.out.println(target.getName() + " used a Weakness Potion! Power halved for 3 turns!");
        return this;
    }

    public void tickTurn(CombatEntityEnhanced target) {
        turnsRemaining--;
        if (turnsRemaining <= 0) {
            target.setPower(originalPower);  // restore after turns expire
            System.out.println("Weakness Potion wore off!");
            }
    }
    public boolean isExpired() {
        return turnsRemaining <= 0;
    }

}