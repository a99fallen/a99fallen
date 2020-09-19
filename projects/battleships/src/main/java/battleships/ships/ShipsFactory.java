package battleships.ships;


import battleships.ConsoleColors;

public class ShipsFactory {

    private int shipSize;
    private String shipName;

    public ShipsFactory(String shipName) {
        this.shipName = shipName;
    }

    public int getShipSize() {
        return shipSize;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public static Ship carrier() {
        return new Ship(5, "Lotniskowiec", ConsoleColors.RED_BACKGROUND);
    }
    public static Ship warship() {
        return new Ship(4, "Statek wojenny", ConsoleColors.GREEN_BACKGROUND);
    }
    public static Ship cruiser() {
        return new Ship(3, "Krążownik", ConsoleColors.YELLOW_BACKGROUND);
    }
    public static Ship destroyer() {
        return new Ship(2, "Niszczyciel", ConsoleColors.PURPLE_BACKGROUND);
    }
    public static Ship submarine() { return new Ship(1, "łódź podwodna", ConsoleColors.CYAN_BACKGROUND); }
    public static Ship missedShoot() {return new Ship(1, "Pudło", ConsoleColors.BLUE_BACKGROUND_BRIGHT); }

}
