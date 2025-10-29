public class OceanGrid {
    public enum Orientation { HORIZONTAL, VERTICAL }
    private final int size = 10;
    private final char[][] cells;
    public OceanGrid() {
        cells = new char[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                cells[r][c] = '.';
            }
        }
        }
        
        public int size() { return size; }
        
        public boolean inBounds(Coordinate start) {
            return start.row() >= 0 && start.row() < size && start.col() >= 0 && start.col() < size;
        }
        private boolean fits(Ship ship, Coordinate start, Orientation o) {
            if (!inBounds(start)) return false;
            int endRow = start.row();
            int endCol = start.col();
            if (o == Orientation.HORIZONTAL) endCol = start.col() + ship.getLength() - 1;
            else endRow = start.row() + ship.getLength() - 1;
            return !(endRow < 0 || endRow >= size || endCol < 0 || endCol >= size);
        }
        private boolean pathClear(Ship ship, Coordinate start, Orientation o) {
            int r = start.row();
            int c = start.col();
            for (int i = 0; i < ship.getLength(); i++) {
                if (cells[r][c] != '.') return false;
                if (o == Orientation.HORIZONTAL) c++;
                else r++;
            }
            return true;
        }
        public boolean placeShip(Ship ship, Coordinate start, Orientation o) {
            if (!fits(ship, start, o)) return false;
            if (!pathClear(ship, start, o)) return false;   
            int r = start.row();
            int c = start.col();
            for (int i = 0; i < ship.getLength(); i++) {
                cells[r][c] = '0';
                if (o == Orientation.HORIZONTAL) c++;
                else r++;
            }
            return true;
        }
        public void printForAlex() {
            System.out.println("   1  2  3  4  5  6  7  8  9  10  ");
            for (int r = 0; r < size; r++) {
                char rowLetter = (char)('A' + r);
                if (r < 9) System.out.print(rowLetter + " ");
                else System.out.print(rowLetter + " ");
                for (int c = 0; c < size; c++) {
                    System.out.print(" " + cells[r][c]);
                    if (c < size - 1) System.out.print(" ");
                }
                System.out.println();
                }


            }
        }
    
 