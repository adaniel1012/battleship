public class OceanGridTest {
    public static void main(String[] args) {

        System.out.println("=== Battleship OceanGrid Prototype (for Alex) ===");

        // make an empty 10x10 ocean grid
        OceanGrid grid = new OceanGrid();

        // create the standard ships
        Ship carrier    = new Ship("Carrier", 5);
        Ship battleship = new Ship("Battleship", 4);
        Ship submarine  = new Ship("Submarine", 3);
        Ship cruiser    = new Ship("Patrol Boat", 3);
        Ship destroyer  = new Ship("Destroyer", 2);

        // try placing ships on the grid
        boolean p1 = grid.placeShip(carrier,    Coordinate.fromString("A1"),  OceanGrid.Orientation.HORIZONTAL);
        boolean p2 = grid.placeShip(battleship, Coordinate.fromString("C3"),  OceanGrid.Orientation.VERTICAL);
        boolean p3 = grid.placeShip(submarine,  Coordinate.fromString("J1"),  OceanGrid.Orientation.HORIZONTAL);
        boolean p4 = grid.placeShip(cruiser,    Coordinate.fromString("F7"),  OceanGrid.Orientation.VERTICAL);
        boolean p5 = grid.placeShip(destroyer,  Coordinate.fromString("I9"),  OceanGrid.Orientation.HORIZONTAL);

        // test bad placements (should return false)
        boolean bad1 = grid.placeShip(new Ship("TestBadOverlap", 3), Coordinate.fromString("C3"), OceanGrid.Orientation.HORIZONTAL);
        boolean bad2 = grid.placeShip(new Ship("TestBadBounds", 4),  Coordinate.fromString("J8"), OceanGrid.Orientation.HORIZONTAL);

        // print results
        System.out.println("Placed Carrier at A1 horiz:      " + p1);
        System.out.println("Placed Battleship at C3 vert:    " + p2);
        System.out.println("Placed Submarine at J1 horiz:    " + p3);
        System.out.println("Placed Cruiser at F7 vert:       " + p4);
        System.out.println("Placed Destroyer at I9 horiz:    " + p5);
        System.out.println("Bad overlap at C3 horiz (expect false): " + bad1);
        System.out.println("Bad out-of-bounds at J8 horiz (expect false): " + bad2);

        System.out.println();
        grid.printForAlex();  // print the grid
    }
}

    

