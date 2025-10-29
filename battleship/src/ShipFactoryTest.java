// alex - "I am getting 1 million errors on this page related to the imports not working yet the test methods are functioning exactly as expected when I run them. I think this is an IDE issue but I am not sure how to fix it."
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

public class ShipFactoryTest {

    private ShipFactory factory;

    @BeforeEach
    void init() {
        factory = new ShipFactory();
    }

    @Test
    void providesShipsOrderedByName() {
        List<Ship> ships = factory.getShipsSortedByName(Order.ASC);

        assertEquals(5, ships.size());

        // Expected alphabetical order
        assertEquals("Battleship",  ships.get(0).getName());
        assertEquals("Carrier",     ships.get(1).getName());
        assertEquals("Destroyer",   ships.get(2).getName());
        assertEquals("Patrol Boat", ships.get(3).getName());
        assertEquals("Submarine",   ships.get(4).getName());

        // Quick length check
        assertEquals(4, ships.get(0).getLength());
        assertEquals(5, ships.get(1).getLength());
        assertEquals(3, ships.get(2).getLength());
        assertEquals(2, ships.get(3).getLength());
        assertEquals(3, ships.get(4).getLength());
    }

    @Test
    void providesShipsOrderedByNameDesc() {
        List<Ship> ships = factory.getShipsSortedByName(Order.DESC);

        assertEquals(5, ships.size());

        // Reverse alphabetical
        assertEquals("Submarine",   ships.get(0).getName());
        assertEquals("Patrol Boat", ships.get(1).getName());
        assertEquals("Destroyer",   ships.get(2).getName());
        assertEquals("Carrier",     ships.get(3).getName());
        assertEquals("Battleship",  ships.get(4).getName());

        // Quick length check
        assertEquals(3, ships.get(0).getLength());
        assertEquals(2, ships.get(1).getLength());
        assertEquals(3, ships.get(2).getLength());
        assertEquals(5, ships.get(3).getLength());
        assertEquals(4, ships.get(4).getLength());
    }

    @Test
    void providesShipsOrderedByLength() {
        List<Ship> ships = factory.getShipsSortedByLength(Order.ASC);

        assertEquals(5, ships.size());

        // Ascending by length: 2,3,3,4,5
        assertEquals(2, ships.get(0).getLength());
        assertEquals(3, ships.get(1).getLength());
        assertEquals(3, ships.get(2).getLength());
        assertEquals(4, ships.get(3).getLength());
        assertEquals(5, ships.get(4).getLength());

        // Verify expected names
        assertEquals("Patrol Boat", ships.get(0).getName());
        // The 3-length ships can appear in either order (Destroyer/Submarine)
        Set<String> midPairAsc = Set.of(ships.get(1).getName(), ships.get(2).getName());
        assertEquals(Set.of("Destroyer", "Submarine"), midPairAsc);
        assertEquals("Battleship", ships.get(3).getName());
        assertEquals("Carrier",    ships.get(4).getName());
    }

    @Test
    void providesShipsOrderedByLengthDesc() {
        List<Ship> ships = factory.getShipsSortedByLength(Order.DESC);

        assertEquals(5, ships.size());

        // Descending by length: 5,4,3,3,2
        assertEquals(5, ships.get(0).getLength());
        assertEquals(4, ships.get(1).getLength());
        assertEquals(3, ships.get(2).getLength());
        assertEquals(3, ships.get(3).getLength());
        assertEquals(2, ships.get(4).getLength());

        // Expected names at the ends
        assertEquals("Carrier",     ships.get(0).getName());
        assertEquals("Battleship",  ships.get(1).getName());
        assertEquals("Patrol Boat", ships.get(4).getName());

        // Two 3-length ships can appear in either order
        Set<String> midPairDesc = Set.of(ships.get(2).getName(), ships.get(3).getName());
        assertEquals(Set.of("Destroyer", "Submarine"), midPairDesc);
    }
}
