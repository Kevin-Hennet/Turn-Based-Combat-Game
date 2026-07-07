public abstract class CombatEntityEnhanced {
    protected String name; // name of combat entity 
    protected int curHealth; // current health of entity 
    protected int maxHealth; // max health of entity 
    protected int basePower; // standard damage the entity can do
    protected boolean isStunned;
    protected boolean isBlocking;
    protected Item item;
    protected Item lastUsedItem;


    public CombatEntityEnhanced(String n, int h, int p){
        this.name = n; 
        this.maxHealth = h; 
        this.basePower = p;
        this.curHealth = maxHealth;
        this.isStunned = false;
        this.isBlocking = false;
        this.item = null;
    }
    public boolean hasLost() {
        return curHealth <= 0;
    }
    
    public String takeHit(int damage, String source) {
        if (isBlocking) {
            damage /= 2;
            isBlocking = false;
            curHealth -= damage;
            return name + " blocked! Takes only " + damage + " damage from " + source;
        } else {
            curHealth -= damage;
            return name + " takes a hit for " + damage + " damage from " + source;
        }
        
    }
    public String recover(int amount, String source) {
        if (curHealth + amount <= this.maxHealth) {
            curHealth += amount;
            return name + " recovers " + amount + " health from " + source;
        }
        else {
            int amountR = maxHealth - curHealth; 
            curHealth = maxHealth;
            return name + " recovers " + amountR + " health from " + source;
        }
    }
    public String getName() {
        return this.name;
    }
    public void setHealth(int health) {
        curHealth = health; 
    }
    public int getHealth(){
        return curHealth;
    
    }
    public int getMaxHealth(){
        return maxHealth;

    }
    public int getPower(){
        return basePower;
    }
    public void setPower(int power) {
        basePower = power;
    }
    public boolean getStunned() {
        return isStunned;
    }
    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }
    public boolean getBlocking() {
        return isBlocking;

    }
    public void setBlocking(boolean blocking) {
        isBlocking = blocking;
    }
    public void resetStatus() {
        isStunned = false;
        isBlocking = false;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public Item getItem() {
        return item;
    }
    public boolean hasItem() {
        return item != null;
    }
    public Item useItem(CombatEntityEnhanced target) {
        if (item == null) return null;

        Item used = item;
        lastUsedItem = used;
        
        if (item instanceof WeaknessPotion) {
            item.use(target);
        } else {
            item.use(this);
        }

        item = null;
        return used;
    }
    public Item getLastUsedItem() {
        return lastUsedItem;
    }

    public abstract String attack(CombatEntityEnhanced target);
}
