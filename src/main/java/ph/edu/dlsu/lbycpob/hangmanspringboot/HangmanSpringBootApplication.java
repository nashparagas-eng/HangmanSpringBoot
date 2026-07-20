package ph.edu.dlsu.lbycpob.hangmanspringboot;

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

    public static void main(String[] args) {
        SpringApplication.run(HangmanSpringBootApplication.class, args);
    }

}
