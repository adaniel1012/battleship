import java.util.List;
import java.util.ArrayList;

public class OceanGrid extends Grid {
    private List<Ship> ships = new ArrayList<>();

    public OceanGrid() {
        super();
        System.out.println("Ocean Grid");
    }

    public boolean placeShip(String shipType, Coordinate start, boolean horizontal) {
        Ship ship = ShipFactory.createShip(shipType);
        int length = ship.getShipSize();
        if (!canPlaceShip(start, length, horizontal)) {
            System.out.println("Cannot place ship " + ship.getShipSize() + "at " + start);
            return false;
        }

        for (int i = 0; i < length; i++) {
            Coordinate coordinate = horizontal
                ? new Coordinate(start.getRow(), start.getCol() + i)
                : new Coordinate(start.getRow() + i, start.getCol());
            
            Cell cell = getCell(coordinate);
            cell.setState(Cell.CellState.Ship);
            ship.addCell(cell);
        }

        ships.add(ship);
        System.out.println("Placed " + ship.getShipType());
        return true;
    }

    private boolean canPlaceShip(Coordinate start, int length, boolean horizontal) {
        if (horizontal) {
            if (start.getCol() + length > 10) return false;
            for (int col = start.getCol(); col < start.getCol() + length; col++) {
                if (cells[start.getRow()][col].getState() != Cell.CellState.Empty) {
                    return false;
                }
            }
        } 
        else {
            if (start.getRow() + length > 10) return false;
            for (int row = start.getRow(); row < start.getRow() + length; row++) {
                if (cells[row][start.getCol()].getState() != Cell.CellState.Empty) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean receivedShot(Coordinate coordinate) {
        Cell cell = getCell(coordinate);
        System.out.println("Shot fired at " + coordinate);
        if (cell.getState() == Cell.CellState.Ship) {
            cell.setState(Cell.CellState.Hit);
            Ship hitShip = getShipByCell(cell);

            if (hitShip != null) {
                hitShip.checkSunk();
            }
            return true;
        }
        else if (cell.getState() == Cell.CellState.Empty) {
            cell.setState(Cell.CellState.Miss);
        }

        return false;
    }
    
    protected Ship getShipByCell(Cell cell) {
        for (Ship ship : ships) {
            if (ship.getCells().contains(cell)) {
                return ship;
            }
        }
        return null;
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()){
                System.out.println(ship.getShipType() + " is still afloat.");
                return false;
            }
        }
        System.out.println("All ships are sunk!");
        return true;
    }
}
