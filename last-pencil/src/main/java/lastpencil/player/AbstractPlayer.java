package lastpencil.player;

abstract sealed class AbstractPlayer implements Player permits HumanPlayer, RobotPlayer {
    private final String name;

    AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
