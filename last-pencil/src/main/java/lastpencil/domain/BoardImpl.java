package lastpencil.domain;

import java.util.Formatter;

public final class BoardImpl implements Board {
    private int pencilsLeft;

    public BoardImpl(int pencils) {
        this.pencilsLeft = pencils;
    }

    public int pencilsLeft() {
        return pencilsLeft;
    }

    public void takePencils(int pencilsTaken) {
        pencilsLeft -= pencilsTaken;
    }

    @Override
    public boolean hasPencilsLeft() {
        return pencilsLeft > 0;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("|".repeat(pencilsLeft));
    }
}
