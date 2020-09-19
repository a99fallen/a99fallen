package battleships;

import battleships.game.Board;
import battleships.game.Field;
import battleships.game.GameEngine;
import battleships.game.GameResult;
import battleships.players.Player;
import battleships.players.PlayerOptionLogic;
import battleships.players.SimpleLogic;
import battleships.transmission.Announcer;
import battleships.transmission.ConsoleSpectator;

import static battleships.ConsoleColors.BLUE_BACKGROUND;
import static battleships.ConsoleColors.RESET;

public class BattleshipsApp {

    public static void main(String[] args) {

        // Tworzenie graczy
        Player playerOne = new Player(new SimpleLogic());
        playerOne.setName("Leszek");

        Player playerTwo = new Player(new SimpleLogic());
        playerTwo.setName("Wojtek");

        // Uruchomienie gry
        GameEngine engine = new GameEngine();
        Announcer announcer = new Announcer();
        announcer.addSpectator(new ConsoleSpectator());
        engine.setAnnouncer(announcer);
        engine.prepareGame(playerOne, playerTwo);
        engine.prepareBoards();

        System.out.println("Plansza pierwszego gracza:");
        printBoard(playerOne.getBoard());

        System.out.println("\nPlansza drugiego gracza:");
        printBoard(playerTwo.getBoard());

        engine.startGame();

        // Prezentacja wyników
        GameResult result = engine.getGameResult();
        System.out.println("\nWynik gry: " + result);

        System.out.println("Plansza pierwszego gracza:");
        printBoard(playerOne.getBoard());

        System.out.println("\nPlansza drugiego gracza:");
        printBoard(playerTwo.getBoard());
    }

    public static void printBoard(Board board) {
        Field[][] fields = board.getFields();
        System.out.print("\n    ");
        for (int i = 1; i < 1 + fields.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        char r = 'A';
        for (Field[] row : fields) {
            System.out.print(r + "  ");
            r++;
            for (Field f : row) {
                if (f.isEmpty()) {
                    System.out.print(BLUE_BACKGROUND + "  " + RESET);
                }
                else {
                    System.out.print(f.getShip().getColor() + "  " + RESET);
                }
            }
            System.out.print("\n");
        }
    }
}
