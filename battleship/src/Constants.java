import java.util.List;

public class Constants {
    public static final List<ShipSpec> SHIP_SPECS = List.of(
        new ShipSpec("Carrier", 5),
        new ShipSpec("Battleship", 4),
        new ShipSpec("Destroyer", 3),
        new ShipSpec("Submarine", 3),
        new ShipSpec("Patrol Boat", 2)
    );
}
