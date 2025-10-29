public class Grid {
    protected Cell [][] cells = new Cell[10][10];

    public Grid() {
        for(int row = 0; row < 10; row++) {
            for(int col = 0; col < 10; col++) {
                Coordinate coordinate = new Coordinate(row, col);
                cells[row][col] = new Cell(coordinate);
            }
        }
    }

    protected Cell getCell(Coordinate coordinate) {
        return cells[coordinate.getRow()][coordinate.getCol()];
    }

    protected void setCellState(Coordinate coordinate, Cell.CellState state) {
        if (coordinate.getRow() < 0 || coordinate.getRow() >= 10 ||
            coordinate.getCol() < 0 || coordinate.getCol() >= 10) {
                throw new IllegalArgumentException("Coordinate out of bounds: " + coordinate);
            }
        cells[coordinate.getRow()][coordinate.getCol()].setState(state);
    }

    public char getDisplaySymbol(Cell.CellState state) {
        switch(state) {
            case Empty:
                return '~';
            case Ship:
                return 'S';
            case Hit:
                return 'X';
            case Miss:
                return 'O';
            default:
                return '?';
        }
    }
    

    private void printColumnHeaders() {
        System.out.print("  ");
        for (int col = 1; col <= 10; col++) {
            System.out.print(" " + col + " ");
        }
        System.out.println();
    }

    private void printGridBorders() {
        System.out.print(" +");
        for (int col = 0; col < 10 * 3; col++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    private void printRow(int row) {
        Coordinate rowCoordinate = new Coordinate(row, 0);
        System.out.print(rowCoordinate.getRowLabel() + "|");
        for (int col = 0; col < 10; col++) {
            Coordinate coordinate = new Coordinate(row, col);
            System.out.print(String.format("%2s ", getDisplaySymbol(getCell(coordinate).getState())));
        }
        System.out.println("|");
    }

    public void display() {
        printColumnHeaders();
        printGridBorders();
        for (int row = 0; row < 10; row++) {
            printRow(row);
        }
        printGridBorders();
    }
}
