import java.util.HashMap;
import java.util.Map;

public class ShipFactory {
    private static Map<String, Integer> shipTypes = new HashMap<>();

    static {
        shipTypes.put("Carrier", 5);
        shipTypes.put("Battleship", 4);
        shipTypes.put("Cruiser", 3);
        shipTypes.put("Submarine", 3);
        shipTypes.put("Destroyer", 2);
    }

    public static Ship createShip(String shipType) {
        Integer size = shipTypes.get(shipType);
        if (size == null) {
            throw new IllegalArgumentException("Invalid ship type: " + shipType);
        }
        return new Ship(shipType, size);
    }
}
