package lastpencil.player;

import lastpencil.domain.Board;

import java.util.Formattable;
import java.util.Formatter;

/**
 * The {@code Player} interface represents a player in a game.
 */
public sealed interface Player extends Formattable permits AbstractPlayer  {
    /**
     * Retrieves the name of a player.
     *
     * @return The name of the object.
     */
    String name();

    /**
     * Makes a move on the given Board.
     *
     * @param board the Board object on which the move needs to be made
     */
    void makeMove(Board board);

    @Override
    default void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%s", name());
    }
}
