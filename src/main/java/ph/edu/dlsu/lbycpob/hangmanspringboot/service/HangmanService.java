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


