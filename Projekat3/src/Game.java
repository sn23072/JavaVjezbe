import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;

    public Game() {
        
        player = new Player(10, 10, 50, 50, "Petar Peric", 100);

        
        enemies = new ArrayList<>();
        eventLog = new ArrayList<>();

        
        enemies.add(new Enemy(40, 20, 30, 30, "Goblin", 20));
        enemies.add(new Enemy(90, 60, 40, 40, "Ork", 35));
        enemies.add(new BossEnemy(150, 100, 80, 100, "Dragon", 80, "Fire Storm"));

       
        eventLog.add("Igra započeta! Igrač: " + player.getName());
    }

 
    public void playRound() {
        System.out.println("Novi krug igre");

        for (Enemy e : enemies) {
            System.out.println(e);

            // Provjera sudara
            if (player.intersect(e)) {
                String event = "Igrač " + player.getName() + " se sudario sa neprijateljem tipa " + e.getType();
                eventLog.add(event);
                System.out.println(event);
            } else {
                String event = "Nema sudara sa " + e.getType();
                eventLog.add(event);
                System.out.println(event);
            }

            // Ako je BossEnemy, koristi specijalni napad
            if (e instanceof BossEnemy) {
                ((BossEnemy) e).performSpecialAttack();
                eventLog.add("Boss koristi specijalni napad: " + ((BossEnemy) e).getSpecialAttack());
            }
        }
    }

    
    public void printEventLog() {
        System.out.println("\n ");
        for (String log : eventLog) {
            System.out.println(log);
        }
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.playRound();
        game.printEventLog();
    }
}

