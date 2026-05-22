package lastpencil.player;

import lastpencil.domain.Board;
import lastpencil.strategy.GameStrategy;
import lastpencil.ui.UserInterface;

import java.util.Objects;

public final class RobotPlayer extends AbstractPlayer {
    private final UserInterface userInterface;
    private final GameStrategy gameStrategy;

    public RobotPlayer(UserInterface userInterface, GameStrategy gameStrategy) {
        super("Jack");
        this.userInterface = userInterface;
        this.gameStrategy = gameStrategy;
    }

    @Override
    public void makeMove(Board board) {
        Objects.requireNonNull(board, "Board is not set");

        var pencils = gameStrategy.pencilsToTake(board.pencilsLeft());

        board.takePencils(pencils);
        userInterface.accept(String.valueOf(pencils));
    }

}
