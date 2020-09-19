package battleships.players;

import battleships.game.*;
import battleships.ships.Ship;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PlayerOptionLogic implements PlayerLogic{

    private Board playerBoard;

    private ShootingField salvoField = new ShootingField('A', 1);
    private Set<Field> salvoHistory = new HashSet<>();


    @Override
    public Field salvo() {  //zapisuje punkty trafień dla obu graczy, a nie tylko Playera 1
        Field target = null;
        Scanner scanner = new Scanner(System.in);
        do {

            int maxVal = playerBoard.getFields().length;
            System.out.println("Podaj wiersz i kolumnę: (wiersze A-J, kolumna 1-10");
            char row = scanner.next().charAt(0);
            int col = scanner.nextInt();
            salvoField.setRow(row);
            salvoField.setCol(col);
            target = new Field(row, col);

        } while(salvoHistory.contains(target));
        salvoHistory.add(target);
        return target;
    }

    @Override
    public ShootResult callOut(Field field) {
        int rowIndex = field.getRow() - 'A';
        int colIndex = field.getCol() - 1;
        Field onBoardField = playerBoard.getFields()[rowIndex][colIndex];
        if (onBoardField.isEmpty()) {
            return ShootResult.MISS;
        } else {
            Ship ship = onBoardField.getShip();
            if (ship.isDestroyed()) {
                return ShootResult.MISS;
            }
            ship.hit();
            onBoardField.setShip(null);
            if (ship.isDestroyed()) {
                return ShootResult.HIT_AND_SINK;
            } else {
                return ShootResult.HIT;
            }
        }
    }

    @Override
    public Board prepareBoard() {
        playerBoard = new BoardBuilder()
                .carrier('D', 3, true)
                .warship('A', 1, false)
                .cruiser('G', 8, true)
                .destroyer('I', 4, false)
                .destroyer('F', 1, false)
                .submarine('A', 10, false)
                .submarine('J', 10, false)
                .build();

        return playerBoard;
    }
}
