package lastpencil.domain;

import java.util.Formattable;

/**
 * The Board interface represents a board with pencils.
 * <p>
 * The Board provides methods to get the number of pencils left and take pencils from the board.
 *
 * @see Formattable
 */
public interface Board extends Formattable {
    /**
     * Gets the number of pencils left.
     *
     * @return The number of pencils left as an integer.
     */
    int pencilsLeft();

    /**
     * Takes a specified number of pencils from the board.
     *
     * @param pencilsTaken the number of pencils to be taken from the inventory
     */
    void takePencils(int pencilsTaken);

    /**
     * Checks if there are any pencils left in the inventory.
     *
     * @return true if there are pencils left, false otherwise
     */
    boolean hasPencilsLeft();
}
