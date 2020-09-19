package battleships.players;

import battleships.game.*;
import battleships.ships.Ship;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SimpleLogic implements PlayerLogic {

    private Board playerBoard;
    private Random random = new Random();

    private ShootingField salvoField = new ShootingField('A', 1);
    private Set<Field> simpleSalvoHistory = new HashSet<>();

    @Override
    public Field salvo() {
        Field target = null;
        do {
            int maxVal = playerBoard.getFields().length;
            char row = (char) ('A' + random.nextInt(maxVal));
            int col = 1 + random.nextInt(maxVal);
            salvoField.setRow(row);
            salvoField.setCol(col);
            target = new Field(row, col);
        } while (simpleSalvoHistory.contains(target));
        simpleSalvoHistory.add(target);
        return target;
//        możne zrobić inaczej
//            int maxVal = playerBoard.getFields().length;
//            char row = (char) ('A' + random.nextInt(maxVal));
//            int col = 1 + random.nextInt(maxVal);
//            salvoField.setRow(row);
//            salvoField.setCol(col);
//
//        return salvoField;
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
