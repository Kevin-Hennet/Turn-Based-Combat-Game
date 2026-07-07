public abstract class Item {
    // houses all the item behavior 
    protected String name;
    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    // use method for the potions 
    }
    abstract Item use(CombatEntityEnhanced target);
}
