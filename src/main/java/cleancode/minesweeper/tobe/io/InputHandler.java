package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.Position.CellPosition;

public interface InputHandler {

    String getUserInput();

    CellPosition getCellPositionFromUser();
}
