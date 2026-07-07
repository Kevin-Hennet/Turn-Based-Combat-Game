import java.util.Scanner;
import  java.util.Random;
public class Game {
public static void main(String[] args) {
    int score = 0;

    Scanner player = new Scanner(System.in);
    WizardEnhanced wizard = new WizardEnhanced("Wizard one");
    Knight knight = new Knight("Knight one");
    Skeleton skeleton = new Skeleton("Skeleton one");
    DragonEnhanced dragon = new DragonEnhanced("Dragon one");
    GameStackEnhanced control = new GameStackEnhanced();
    System.out.println("Game Starting!!! ");
    int choice = -1;
    boolean valid = false;
    CombatEntityEnhanced hero = null;
    CombatEntityEnhanced villain = null;
    CombatEntityEnhanced secondVillain = null;
    Random randint = new Random();
    int randomChoice = randint.nextInt(1, 3);
    
    if (randomChoice == 1) {
        villain = skeleton;
        secondVillain = dragon;
    } else {
        villain = dragon;
        secondVillain = skeleton;
    }
    while (!valid) {
        System.out.println("Choose your hero: ");
        System.out.println("1) Wizard");
        System.out.println("2) Knight");
        if (!player.hasNextInt()) {
            player.next();
            System.out.println("Invalid input, please enter a number 1-2");
        } else {
            choice = player.nextInt();
            if (choice >= 1 && choice <= 2) {
                valid = true;
            } else { 
                System.out.println("Invalid input, please enter a number 1-2");
            }
        }
    }
    if (choice == 1) {
        hero = wizard;
    }
    else {
        hero = knight;
    }
    giveReward(hero, randint);
    String result = runBattle(hero, villain, control, player);

    if (result.equals("WIN")) {
        score += 100;
        score += Math.max(0, 50 - lastTurnCount); // faster = more points
        System.out.println("Victory!");
        System.out.println("--- SECOND WAVE ---");
        if (hero.hasItem()) {
            System.out.println("Your unused potion faded after the battle...");
        }
        hero.setItem(null);
        giveReward(hero, randint);
        control = new GameStackEnhanced();
        hero.recover(100, "Defeating the first villian");

        String result2 = runBattle(hero, secondVillain, control, player);

        if (result2.equals("WIN")) {
            System.out.println("You defeated both enemies!");
            score += 150;
            System.out.println("Final Score: " + score);
            if (score >= 250) {
                System.out.println("S Rank Victory!");
            } else if (score >= 150) {
                System.out.println("A Rank Victory!");
            } else {
                System.out.println("Victory... barely.");
            }
        } else if (result2.equals("LOSS")) {
            System.out.println("You fell in the second battle...");
        } else {
            System.out.println("You escaped the second fight.");
        }
    } else if (result.equals("LOSS")) {
        System.out.println("Defeat");
    } else {
        System.out.println("Escape");
    }
    
}
private static GameStateEnhanced currentState;
static int lastTurnCount;
public static GameStateEnhanced getCurrentGameState() {
    return currentState;
}
public static String runBattle(
    CombatEntityEnhanced hero,
    CombatEntityEnhanced villain,
    GameStackEnhanced control,
    Scanner player
) {
    int turnCount = 0;
    StrengthPotion activeStrength = null;
    WeaknessPotion activeWeakness = null;

    CombatEntityEnhanced[] players = {hero, villain};

    while (!hero.hasLost() && !villain.hasLost()) {
        

        for (CombatEntityEnhanced entity : players) {
            System.out.println(entity.getName() + " HP: " + entity.getHealth());
        }

        GameStateEnhanced state = new GameStateEnhanced(players,
                new int[]{hero.getHealth(), villain.getHealth()});
        control.push(state);

        String result = ((PlayerControlledEnhanced) hero).chooseAction(player, villain);

        // track potion use
        Item used = hero.getLastUsedItem();
        if (used instanceof StrengthPotion) activeStrength = (StrengthPotion) used;
        if (used instanceof WeaknessPotion) activeWeakness = (WeaknessPotion) used;

        if (result.equals("UNDO")) {
            control.pop();
            GameStateEnhanced past = control.peek();
            if (past != null) {
                for (int i = 0; i < past.getBeingsSize(); i++) {
                    past.getCE(i).setHealth(past.getCEHealth(i));
                }
                System.out.println("Time reversed!");
            }
            continue;
        }

        if (result.equals("RETREAT")) return "ESCAPE";

        System.out.println(result);

        if (!villain.hasLost()) {
            System.out.println(((AIControlledEnhanced) villain).takeTurn(hero));
        }

        // tick effects AFTER turn
        if (activeStrength != null) {
            activeStrength.tickTurn(hero);
            if (activeStrength.isExpired()) activeStrength = null;
        }

        if (activeWeakness != null) {
            activeWeakness.tickTurn(villain);
            if (activeWeakness.isExpired()) activeWeakness = null;
        }
        turnCount++;
        lastTurnCount = turnCount;
    }

    if (hero.hasLost()) return "LOSS";
    if (villain.hasLost()) return "WIN";
    return "ESCAPE";
}
public static void giveReward(CombatEntityEnhanced hero, Random rand) {
    int drop = rand.nextInt(3);
    Item reward;
    if (drop == 0) reward = new HealPotion();
    else if (drop == 1) reward = new StrengthPotion();
    else reward = new WeaknessPotion();
    System.out.println("You received: " + reward.getName());
    hero.setItem(reward);
}
}
