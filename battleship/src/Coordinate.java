public class Coordinate {
    private final int row;
    private final int col;
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int row() { return row; }
    public int col() { return col; } 
    public static Coordinate fromString(String text) {
        String t = text.trim().toUpperCase();
        if (t.length() < 2 || t.length() > 3) return new Coordinate(-1, -1);
        char letter = t.charAt(0);
        if (letter < 'A' || letter > 'J') return new Coordinate(-1, -1);
        String numPart = t.substring(1);
        int colNum = -1;
        if (numPart.equals("10")) colNum = 10;
        else if (numPart.length() == 1) {
            char d = numPart.charAt(0);
            if (d >= '1' && d <= '9') colNum = d - '0';
        }
        if (colNum < 1 || colNum > 10) return new Coordinate(-1, -1);
        int rowIndex = letter - 'A';
        int colIndex = colNum - 1;
        return new Coordinate(rowIndex, colIndex);
    }
}

