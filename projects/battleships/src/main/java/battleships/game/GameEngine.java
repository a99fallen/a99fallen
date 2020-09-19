package battleships.game;

import battleships.players.Player;
import battleships.transmission.Announcer;
import battleships.transmission.GameEvent;

public class GameEngine {

    private Player playerOne;
    private Player playerTwo;
    private GameResult gameResult = GameResult.NOT_FINISHED_YET;
    private Announcer announcer;

    public void prepareGame(Player p1, Player p2) {
        gameResult = GameResult.NOT_FINISHED_YET;
        this.playerOne = p1;
        this.playerTwo = p2;
    }

    public void prepareBoards() {
        playerOne.prepareBoard();
        playerTwo.prepareBoard();
    }

    public void startGame() {
        announcer.announce(GameEvent.EventType.GAME_STARTED.event(playerOne, playerTwo));
        while (true) {
            Field field = playerOne.salvo();
            announcer.announce(GameEvent.EventType.PLAYER_SHOOT.event(playerOne, playerTwo));
            ShootResult shootResult = playerTwo.callOut(field);
            announceShootResult(shootResult, playerOne, playerTwo);
            playerOne.use(shootResult, field);

            field = playerTwo.salvo();
            announcer.announce(GameEvent.EventType.PLAYER_SHOOT.event(playerTwo, playerOne));
            shootResult = playerOne.callOut(field);
            announceShootResult(shootResult, playerTwo, playerOne);
            playerTwo.use(shootResult, field);



            if (checkIfFirstPlayerWon()) {
                gameResult = GameResult.FIRST_PLAYER_WON;
                return;
            } else if (checkIfSecondPlayerWon()) {
                gameResult = GameResult.SECOND_PLAYER_WON;
                return;
            } else if (checkIfItsDraw()) {
                gameResult = GameResult.DRAW;
                return;
            }
        }
    }

    private void announceShootResult(ShootResult result, Player sourcePlayer, Player targetPlayer) {
        switch (result) {
            case MISS:
                announcer.announce(GameEvent.EventType.PLAYER_MISS.event(sourcePlayer, targetPlayer));
                break;
            case HIT:
                announcer.announce(GameEvent.EventType.PLAYER_HIT_A_SHIP.event(sourcePlayer, targetPlayer));
                break;
            case HIT_AND_SINK:
                announcer.announce(GameEvent.EventType.PLAYER_SANK_A_SHIP.event(sourcePlayer, targetPlayer));
                break;
        }
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    private boolean checkIfItsDraw() {
        return !playerOne.hasMoreShips() && !playerTwo.hasMoreShips();
    }

    private boolean checkIfSecondPlayerWon() {
        return !playerOne.hasMoreShips() && playerTwo.hasMoreShips();
    }

    private boolean checkIfFirstPlayerWon() {
        return playerOne.hasMoreShips() && !playerTwo.hasMoreShips();
    }

    public void setAnnouncer(Announcer announcer) {
        this.announcer = announcer;
    }

    public Announcer getAnnouncer() {
        return announcer;
    }
}