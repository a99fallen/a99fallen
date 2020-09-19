package battleships.game;

public class ShootingField extends Field {
    private char xRow;
    private int yColumn;


    public ShootingField(char row, int col) {
        super(row, col);
        xRow = row;
        yColumn = col;
    }

    @Override
    public char getRow() {
        return super.getRow();
    }

    public void setRow(char xRow) {
        this.xRow = xRow;
    }

    @Override
    public int getCol() {
        return super.getCol();
    }

    public void setCol(int yColumn) {
        this.yColumn = yColumn;
    }
}
