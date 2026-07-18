package ph.edu.dlsu.lbycpob.hangman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ph.edu.dlsu.lbycpob.hangman.render.AsciiArtRenderer;
import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.ClasspathWordRepository;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;