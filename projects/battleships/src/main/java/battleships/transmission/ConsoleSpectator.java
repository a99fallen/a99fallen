package battleships.transmission;

import battleships.BattleshipsApp;
import battleships.game.Board;
import battleships.game.Field;
import battleships.players.Player;

import static battleships.ConsoleColors.BLUE_BACKGROUND;
import static battleships.ConsoleColors.RESET;

public class ConsoleSpectator implements Spectator {
    @Override
    public void spectate(GameEvent event) {
        GameEvent.EventType type = event.getType();
        Player sourcePlayer = event.getSourcePlayer();
        Player targetPlayer = event.getTargetPlayer();
        switch(type) {
            case GAME_STARTED:
                System.out.println("Gra się rozpoczyna! Trzymaj się krzesła!!!");
                System.out.println("Grają " + sourcePlayer.getName() + " z " + targetPlayer.getName());
                break;
            case PLAYER_HIT_A_SHIP:
                System.out.println("Gracz " + sourcePlayer.getName() + " trafił!");
                System.out.println("Jak wygląda plansza gracza " + targetPlayer.getName() + "?");
                BattleshipsApp.printBoard(targetPlayer.getBoard());
                break;
            case PLAYER_WIN:
                System.out.println("Koniec!");
                System.out.println("Wygrał " + sourcePlayer.getName());
                break;
        }
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
