import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class targetTest {
    @Test
    public void testTargetGridInitialization() {
        TargetGrid targetGrid = new TargetGrid(new OceanGrid());

        assertNotNull(targetGrid, "TargetGrid should be initialized.");
        targetGrid.display();
    }

    @Test
    public void testFireShot() {
        OceanGrid oceangrid = new OceanGrid();
        TargetGrid targetGrid = new TargetGrid(oceangrid);

        Ship Destroyer = new Ship("Destroyer", 2);
        oceangrid.placeShip(Destroyer, new Coordinate(2, 2), true);
        

        assertTrue(targetGrid.fireShot(new Coordinate(2, 3)), "Firing at (2,3) should be valid.");
        targetGrid.display();
        oceangrid.display();
    }

    @Test
    public void testFireShotOutOfBoundsException() {
        OceanGrid oceangrid = new OceanGrid();
        TargetGrid targetGrid = new TargetGrid(oceangrid);

        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            targetGrid.fireShot(new Coordinate(10, 10));
        });

        String expectedMessage = "Index 10 out of bounds for length 10";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "Exception message should indicate out of bounds access.");
    }
}
 