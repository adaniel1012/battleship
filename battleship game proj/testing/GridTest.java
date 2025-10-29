import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GridTest {
    @Test
    public void testGridInitialization() {
        Grid grid = new Grid();

        grid.display();

        Cell cell = grid.getCell(new Coordinate(0, 0));
        assertNotNull(cell, "Cell at (0,0) should not be null.");
        assertEquals(0, cell.getCoordinate().getCol(), "Cell X coordinate (col) should be 0.");
        assertEquals(0, cell.getCoordinate().getRow(), "Cell Y (row) coordinate should be 0.");

        cell = grid.getCell(new Coordinate(9, 9));
        assertNotNull(cell, "Cell at (9,9) should not be null.");
        assertEquals(9, cell.getCoordinate().getCol(), "Cell X coodinate (col) should be 9.");
        assertEquals(9, cell.getCoordinate().getRow(), "Cell Y coordinate (row) should be 9.");
        
    }
}
