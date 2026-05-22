package lastpencil.strategy;

import java.util.function.IntUnaryOperator;

/**
 * Represents a game strategy for robot players.
 */
@FunctionalInterface
public interface GameStrategy extends IntUnaryOperator {
    default int pencilsToTake(int pencilsLeft) {
        return applyAsInt(pencilsLeft);
    }

    int applyAsInt(int pencilsLeft);
}
