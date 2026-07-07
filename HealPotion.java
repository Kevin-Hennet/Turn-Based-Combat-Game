public class HealPotion extends Item{
    
    public HealPotion() {
        super("Heal Potion");
    }
    // healing method 
    @Override
    public Item use(CombatEntityEnhanced target) {
        target.recover(30, "Heal Potion");
        System.out.println(target.getName() +" used a potion and restored 30 HP!");
        return null;
        
    }
    
}


