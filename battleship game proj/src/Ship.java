import java.util.List;
import java.util.ArrayList;

public class Ship {
    private final String shipType;
    private final int shipSize;
    private boolean isSunk;
    private final List<Cell> cells;

    public Ship(String shipType, int shipSize) {
        this.shipType = shipType;
        this.shipSize = shipSize;
        this.isSunk = false;
        this.cells = new ArrayList<>();
    }

    public String getShipType() {
        return shipType;
    }

    public int getShipSize() {
        return shipSize;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public List<Cell> getCells() {
        return cells;
    }

    protected void checkSunk() {
        for (Cell cell : cells) {
            if (cell.getState() != Cell.CellState.Hit) {
                return;
            }
        }
        isSunk = true;
        System.out.println("Ship " + shipType + " is sunk!");
    }
}
