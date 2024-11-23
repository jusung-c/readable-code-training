package cleancode.minesweeper.tobe.minesweeper.board.cell;

public interface Cell {

    boolean isLandMine();

    boolean hasLandMineCount();

    CellSnapshot getSnapshot();

    void open();

    void flag();

    boolean isChecked();

    boolean isOpened();

}
