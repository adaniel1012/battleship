public class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getRowLabel() {
        return (char) ('A' + row);
    }
    

    @Override
    public String toString() {
        return "(" + getRowLabel() + ", " + col + ")";
    }
}
