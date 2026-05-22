package lastpencil;

import lastpencil.domain.Board;
import lastpencil.player.Player;
import lastpencil.ui.UserInterface;

import java.util.Collections;
import java.util.List;

public final class Game implements Runnable {
    private final UserInterface userInterface;
    private final List<Player> players;
    private final Board board;
    private int currentPlayer;

    public Game(UserInterface userInterface, List<Player> players, Board board) {
        this.board = board;
        this.userInterface = userInterface;
        this.players = Collections.unmodifiableList(players);
    }

    @Override
    public void run() {
        while (board.hasPencilsLeft()) {
            printBoard();
            currentPlayer().makeMove(board);
            nextPlayer();
        }
        printWinner();
    }

    private void printBoard() {
        printf("%s%n%s's turn!", board, currentPlayer());
    }

    private void printWinner() {
        printf("%s won!", currentPlayer());
    }

    @SuppressWarnings("java:S923")
    private void printf(String template, Object... args) {
        userInterface.accept(template.formatted(args));
    }

    private Player currentPlayer() {
        return players.get(currentPlayer);
    }

    private void nextPlayer() {
        this.currentPlayer = 1 - this.currentPlayer;
    }
}
