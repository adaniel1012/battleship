public class TargetGrid extends Grid {

    private OceanGrid oceanGrid;
    
    public TargetGrid(OceanGrid oceanGrid) {
        super();
        this.oceanGrid = oceanGrid;
        System.out.println("Target Grid");
    }

    public boolean fireShot(Coordinate coordinate) {
        Cell cell = getCell(coordinate);

        if (cell.getState() == Cell.CellState.Hit || cell.getState() == Cell.CellState.Miss) {
            System.out.println("Already fired at " + coordinate);
            return false;
        }

        Cell oceanCell = oceanGrid.getCell(coordinate);

        if (oceanCell.getState() == Cell.CellState.Ship) {
            cell.setState(Cell.CellState.Hit);
            oceanCell.setState(Cell.CellState.Hit);
            
            Ship hitShip = oceanGrid.getShipByCell(oceanCell);
            if (hitShip != null) {
                hitShip.checkSunk();
                if (hitShip.isSunk()) {
                    System.out.println("You sunk " + hitShip.getShipType() + "!");
                }
            }
            System.out.println("Hit at " + coordinate);
            return true;
        }
        
        else {
            cell.setState(Cell.CellState.Miss);
            oceanCell.setState(Cell.CellState.Miss);
            System.out.println("Miss at " + coordinate);
            return false;
        }
    }

   @Override
    public char getDisplaySymbol(Cell.CellState state) {
        switch(state) {
            case Empty:
                return '~';
            case Ship:
                return '~'; 
            case Hit:
                return 'X';
            case Miss:
                return 'O';
            default:
                return '?';
        }
        
    }
}
