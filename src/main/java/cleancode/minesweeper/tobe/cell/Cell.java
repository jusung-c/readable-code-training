package cleancode.minesweeper.tobe.cell;

public interface Cell {

    boolean isLandMine();

    boolean hasLandMineCount();

    CellSnapshot getSnapshot();

    void open();

    void flag();

    boolean isChecked();

    boolean isOpened();

}
