public class GameStateEnhanced {
    protected CombatEntityEnhanced[] Beings;
    protected int[] BeingsHealth;
    public GameStateEnhanced(CombatEntityEnhanced[] b, int[] bHealth) {
        this.Beings = b;
        this.BeingsHealth = bHealth;
    }
    public CombatEntityEnhanced getCE(int index) {
        return Beings[index];   
    }
    public int getCEHealth(int index) {
        return BeingsHealth[index];
    }
    public int getBeingsSize(){
        return Beings.length;
    }
    public int getBeingsHealthSize(){
        return BeingsHealth.length;
    }
}
