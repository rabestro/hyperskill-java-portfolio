package lastpencil.player;

import lastpencil.domain.Board;
import lastpencil.ui.UserInterface;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class HumanPlayer extends AbstractPlayer {
    private static final Predicate<String> INPUT_PREDICATE = Pattern.compile("[1-3]").asMatchPredicate();
    private final UserInterface userInterface;

    public HumanPlayer(UserInterface userInterface) {
        super("John");
        this.userInterface = userInterface;
    }

    @Override
    public void makeMove(Board board) {
        Objects.requireNonNull(board, "Board is not set");

        var pencilsTaken = userInterface.prompt("")
                .required(INPUT_PREDICATE, "Possible values: '1', '2' or '3'")
                .required(input -> Integer.parseInt(input) <= board.pencilsLeft(), "Too many pencils were taken")
                .getAsInt();
        board.takePencils(pencilsTaken);
    }
}
