package ph.edu.dlsu.lbycpob.hangman.utils;

import ph.edu.dlsu.lbycpob.hangman.render.AsciiArtRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.ClasspathWordRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * One small, focused job: read every line of a text file that is bundled
 * inside the application as a classpath resource - i.e. packaged inside the
 * jar and found with {@code getResourceAsStream}, as opposed to a real file
 * sitting on the user's filesystem.
 */
public final class ClasspathResources {