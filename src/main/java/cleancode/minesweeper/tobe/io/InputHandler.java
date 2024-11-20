package cleancode.minesweeper.tobe.io;

import cleancode.minesweeper.tobe.Position.CellPosition;
import cleancode.minesweeper.tobe.user.UserAction;

public interface InputHandler {

    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
