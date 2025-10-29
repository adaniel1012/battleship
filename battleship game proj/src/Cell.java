public class Cell {
    private Coordinate coordinate;
    protected CellState state;


    enum CellState {
        Empty,
        Ship,
        Hit,
        Miss;
    }

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.state = CellState.Empty;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "(" + coordinate.getRow() + ", " + coordinate.getCol() + "): " + state;
    }
}
