package lastpencil.ui;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Represents a user interface that can receive input from the user and display output.
 */
public interface UserInterface extends Supplier<String>, Consumer<String> {

    @SuppressWarnings({"java:S106", "java:S1943"})
    static UserInterface terminal() {
        return new UserInterface() {
            private final Scanner scanner = new Scanner(System.in);

            @Override
            public String get() {
                return scanner.nextLine();
            }

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
    }

    /**
     * Creates a new UserInput object with the provided prompt.
     *
     * @param prompt the prompt to be displayed when requesting user input
     * @return a UserInput object with the specified prompt
     */
    default UserInput prompt(String prompt) {
        return new UserInput(this, prompt);
    }
}
