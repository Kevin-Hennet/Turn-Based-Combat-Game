import java.util.ArrayList;

public class GameStackEnhanced {
    private ArrayList<GameStateEnhanced> history;
    public GameStackEnhanced(){
        this.history = new ArrayList<GameStateEnhanced>();
    }
    public void push(GameStateEnhanced t){
        history.add(t);
    }
    public GameStateEnhanced pop() {
        if (history.size() == 0) {
            return null;
        } else { 
            return history.remove(history.size() - 1);
        }
    }
    public GameStateEnhanced peek() {
        return history.get(history.size() -1);
    }
    public boolean isEmpty() {
        if (history.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
