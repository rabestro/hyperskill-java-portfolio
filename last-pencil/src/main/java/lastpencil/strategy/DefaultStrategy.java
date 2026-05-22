package lastpencil.strategy;

import java.util.concurrent.ThreadLocalRandom;

public class DefaultStrategy implements GameStrategy {
    private static final int TAKE_LIMIT = 3;

    private static int randomPencilsToTake() {
        return ThreadLocalRandom.current().nextInt(1, TAKE_LIMIT + 1);
    }

    @Override
    public int applyAsInt(int pencilsLeft) {
        var remainder = pencilsLeft % (TAKE_LIMIT + 1);
        return switch (remainder) {
            case 0 -> TAKE_LIMIT;
            case 1 -> pencilsLeft == 1 ? 1 : randomPencilsToTake();
            default -> remainder - 1;
        };
    }
}
