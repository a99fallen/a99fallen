package battleships.game;

import battleships.ships.Ship;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class AliveShipsIterator implements Iterator<Ship> {

    private final Board board;
    private Set<Ship> ships;
    private Iterator<Ship> innerIterator;

    public AliveShipsIterator(Board board) {
        this.board = board;
        ships = new LinkedHashSet<>();
        for (Field[] row : board.getFields()) {
            for (Field field : row) {
                if (!field.isEmpty()) {
                    ships.add(field.getShip());
                }
            }
            innerIterator = ships.iterator();
        }
    }

    @Override
    public boolean hasNext() {
        return innerIterator.hasNext();
    }

    @Override
    public Ship next() {
        return innerIterator.next();
    }
}
