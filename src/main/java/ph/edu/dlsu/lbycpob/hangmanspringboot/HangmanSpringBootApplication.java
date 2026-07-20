package ph.edu.dlsu.lbycpob.hangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ph.edu.dlsu.lbycpob.hangmanspringboot.render.ASCIIArtRenderer;
import ph.edu.dlsu.lbycpob.hangmanspringboot.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangmanspringboot.repository.ClasspathWordRepository;
import ph.edu.dlsu.lbycpob.hangmanspringboot.repository.WordRepository;

import java.util.Random;

@SpringBootApplication
public class HangmanSpringBootApplication {
    /** Shared classpath root – mirrors the original {@code GAME_ASSETS_BASE_PATH}. */
    private static final String GAME_ASSETS_BASE_PATH = "/game-assets";

    static void main(String[] args) {
        SpringApplication.run(HangmanSpringBootApplication.class, args);
    }
    @Bean
    public Random random() {
        return new Random();
    }
    @Bean
    public WordRepository wordRepository(Random random) {
        return new ClasspathWordRepository(GAME_ASSETS_BASE_PATH + "/words", random);
    }
    @Bean
    public HangmanRenderer hangmanRenderer() {
        return new AsciiArtRenderer(GAME_ASSETS_BASE_PATH + "/hangman-art");
    }

}

/*
For small- to medium-sized Spring Boot applications, placing @Bean definitions in the main application class is a simple and practical approach because it keeps the application's startup configuration in one place. This makes it easy to see which shared objects (beans) the application needs without searching through multiple configuration classes. It is especially useful when objects require custom constructor parameters, such as file paths or other initialization values, that Spring cannot automatically determine.
*/
