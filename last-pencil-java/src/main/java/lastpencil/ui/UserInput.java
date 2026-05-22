package lastpencil.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public final class UserInput implements Supplier<String>, IntSupplier {
    private final UserInterface userInterface;
    private final List<Constraint> constraints;
    private final String prompt;

    public UserInput(UserInterface userInterface, String prompt) {
        this.prompt = prompt;
        this.userInterface = userInterface;
        this.constraints = new ArrayList<>();
    }

    /**
     * Adds a new constraint to the user input.
     *
     * @param predicate the predicate used to validate the user input
     * @param error the error message to display if the user input does not satisfy the predicate
     * @return the UserInput object with the new constraint added
     */
    public UserInput required(Predicate<String> predicate, String error) {
        constraints.add(new Constraint(predicate, error));
        return this;
    }

    @Override
    public int getAsInt() {
        try {
            return Integer.parseInt(get());
        } catch (NumberFormatException e) {
            userInterface.accept("Invalid input. Please enter a number.");
            return getAsInt();
        }
    }

    @Override
    public String get() {
        if (!prompt.isBlank()) {
            userInterface.accept(prompt);
        }
        return Stream.generate(userInterface)
                .filter(this::isValid)
                .findFirst()
                .orElseThrow();
    }

    private boolean isValid(String input) {
        for (var constraint : this.constraints) {
            if (!constraint.predicate().test(input)) {
                userInterface.accept(constraint.error());
                return false;
            }
        }
        return true;
    }

    private record Constraint(Predicate<String> predicate, String error) {
    }
}
