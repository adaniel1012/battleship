import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class oceanTest {
    @Test
    public void testOceanGridInitialization() {
        OceanGrid oceanGrid = new OceanGrid();
        oceanGrid.display();

        Cell cell = oceanGrid.getCell(new Coordinate(0, 0));
        assertNotNull(cell, "cell at (0,0) should not be null.");
        assertEquals(Cell.CellState.Empty, cell.getState(), "Cell at (0,0) should be empty.");
    }

    @Test
    public void testReceivedShot() {
        OceanGrid oceanGrid = new OceanGrid();
        
        Ship ship = ShipFactory.createShip("Destroyer");
        oceanGrid.placeShip("Destroyer", new Coordinate(0, 0), true);

        assertTrue(oceanGrid.receivedShot(new Coordinate(0, 0)), "Shot at (0,0) should be a hit.");
        assertFalse(oceanGrid.receivedShot(new Coordinate(5, 5)), "Shot at (5,5) should be a miss.");
        oceanGrid.display();
    }

    @Test
    public void testAllShipsSunk() {
        OceanGrid oceanGrid = new OceanGrid();
        Ship destroyer = ShipFactory.createShip("Destroyer");
        Ship Submarine = ShipFactory.createShip("Submarine");

        oceanGrid.placeShip("Submarine", new Coordinate(5, 5), false);

        oceanGrid.placeShip("Destroyer", new Coordinate(0, 0), true);

        assertFalse(oceanGrid.allShipsSunk(), "No ships should be initially sunk.");

        oceanGrid.receivedShot(new Coordinate(0, 0));
        oceanGrid.receivedShot(new Coordinate(5, 5));
        oceanGrid.receivedShot(new Coordinate(6, 5));
        oceanGrid.receivedShot(new Coordinate(7, 5));

        destroyer.checkSunk();
        assertFalse(oceanGrid.allShipsSunk(), "All ships should be sunk.");
        oceanGrid.display();
    }

    @Test
    public void testCannotPlaceShipOutOfBounds() {
        OceanGrid oceanGrid = new OceanGrid();
        
        Ship Submarine = new Ship("Submarine", 3);
        assertFalse(oceanGrid.placeShip(Submarine, new Coordinate(9, 8), true), "Ship should not be placed out of bounds horizontally.");
        assertFalse(oceanGrid.placeShip(Submarine, new Coordinate(8, 9), false), "Ship should not be placed out of bounds vertically.");
        oceanGrid.display();
    }
}
