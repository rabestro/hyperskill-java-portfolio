package lastpencil;

import lastpencil.domain.BoardImpl;
import lastpencil.player.HumanPlayer;
import lastpencil.player.Player;
import lastpencil.player.RobotPlayer;
import lastpencil.strategy.DefaultStrategy;
import lastpencil.ui.UserInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public final class GameSupplier implements Supplier<Game> {
    private static final Predicate<String> NUMBER_PREDICATE = Pattern.compile("\\d+").asMatchPredicate();

    private final UserInterface userInterface;

    public GameSupplier() {
        this(UserInterface.terminal());
    }

    public GameSupplier(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public Game get() {
        var pencils = userInterface.prompt("How many pencils would you like to use:")
                .required(NUMBER_PREDICATE, "The number of pencils should be numeric")
                .required(input -> Integer.parseInt(input) > 0, "The number of pencils should be positive")
                .getAsInt();

        var players = Arrays.<Player>asList(
                new HumanPlayer(userInterface),
                new RobotPlayer(userInterface, new DefaultStrategy())
        );
        var names = players.stream().map(Player::name).toList();

        var first = userInterface.prompt("Who will be the first (" + String.join(", ", names) + "):")
                .required(names::contains, "Choose between  " + String.join(" and ", names))
                .get();

        Collections.rotate(players, names.indexOf(first));

        var board = new BoardImpl(pencils);
        return new Game(userInterface, players, board);
    }
}
