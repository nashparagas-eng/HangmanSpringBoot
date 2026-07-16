package ph.edu.dlsu.lbycpob.hangmanspringboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Pure, stateless game-logic service.
 */
@Service
public class HangmanService {

    private static final Logger log = LoggerFactory.getLogger(HangmanService.class);

    /** Maximum incorrect guesses before the player loses. */
    public static final int MAX_GUESSES = 8;

    private static final String[] FALLBACK_WORDS = {
            "JAVA", "HANGMAN", "COMPUTER", "KEYBOARD", "PROGRAM", "ALGORITHM"
    };

    private final WordRepository wordRepository;
    private final HangmanRenderer renderer;
    private final Random random;

    public HangmanService(WordRepository wordRepository,
                          HangmanRenderer renderer,
                          Random random) {
        this.wordRepository = Objects.requireNonNull(wordRepository);
        this.renderer       = Objects.requireNonNull(renderer);
        this.random         = Objects.requireNonNull(random);
    }

    // ------------------------------------------------------------------ //
    //  Word selection                                                       //
    // ------------------------------------------------------------------ //

    /**
     * Returns a random upper-cased word from {@code filename}, falling back
     * to a built-in word list if the file cannot be read.
     *
     * <p>Mirrors {@code Hangman.getRandomWord} but logs the error instead
     * of printing to stdout.
     */
    public String getRandomWord(String filename) {
        Objects.requireNonNull(filename, "filename must not be null");
        try {
            return wordRepository.getRandomWord(filename);
        } catch (IOException e) {
            log.warn("Could not load words from \"{}\": {}. Using built-in fallback.",
                    filename, e.getMessage());
            return FALLBACK_WORDS[random.nextInt(FALLBACK_WORDS.length)];
        }
    }

    // ------------------------------------------------------------------ //
    //  Hint building                                                        //
    // ------------------------------------------------------------------ //

    /**
     * Builds the player-visible hint string: revealed letters in their
     * correct positions, {@code '-'} everywhere else.
     *
     * <p>Algorithm is identical to the original {@code Hangman.createHint}.
     */
    public String createHint(String secretWord, String guessedLetters) {
        Objects.requireNonNull(secretWord,      "secretWord must not be null");
        Objects.requireNonNull(guessedLetters,  "guessedLetters must not be null");

        String upperWord    = secretWord.toUpperCase();
        String upperGuessed = guessedLetters.toUpperCase();

        StringBuilder hint = new StringBuilder(upperWord.length());
        for (int i = 0; i < upperWord.length(); i++) {
            char c = upperWord.charAt(i);
            hint.append(upperGuessed.indexOf(c) >= 0 ? c : '-');
        }
        return hint.toString();
    }




