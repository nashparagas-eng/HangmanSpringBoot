package ph.edu.dlsu.lbycpob.hangmanspringboot.render;

import java.io.IOException;
import java.util.List;

/**
 * Produces the hangman drawing for a given number of guesses remaining.
 */
public interface HangmanRenderer {

    /**
     * Returns the lines of hangman art for {@code guessesRemaining} (0–8).
     *
     * @throws IOException if the art resource cannot be located or read
     */
    List<String> render(int guessesRemaining) throws IOException;
}
