import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShipFactory {

    // fresh ships built from static SHIP_SPECS each time (no shared instances)
    private List<Ship> freshFleet() {
        ArrayList<Ship> fleet = new ArrayList<>();
        for (ShipSpec spec : Constants.SHIP_SPECS) {
            fleet.add(new Ship(spec.name(), spec.length()));
        }
        return fleet;
    }

    public List<Ship> getShipsSortedByName(Order order) {
        List<Ship> fleet = freshFleet();
        Comparator<Ship> byName = new Comparator<Ship>() {
            public int compare(Ship a, Ship b) {
                int nameCmp = a.getName().compareTo(b.getName());
                if (nameCmp != 0) return nameCmp;
                return Integer.compare(a.getLength(), b.getLength());
            }
        };
        Collections.sort(fleet, byName);
        if (order == Order.DESC) Collections.reverse(fleet);
        return fleet;
    }

    public List<Ship> getShipsSortedByLength(Order order) {
        List<Ship> fleet = freshFleet();
        Comparator<Ship> byLength = new Comparator<Ship>() {
            public int compare(Ship a, Ship b) {
                int lenCmp = Integer.compare(a.getLength(), b.getLength());
                if (lenCmp != 0) return lenCmp;
                return a.getName().compareTo(b.getName());
            }
        };
        Collections.sort(fleet, byLength);
        if (order == Order.DESC) Collections.reverse(fleet);
        return fleet;
    }
}
