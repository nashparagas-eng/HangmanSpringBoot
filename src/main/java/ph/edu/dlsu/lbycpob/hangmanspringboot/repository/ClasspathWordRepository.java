package ph.edu.dlsu.lbycpob.hangman.repository;

import ph.edu.dlsu.lbycpob.hangman.render.AsciiArtRenderer;
import ph.edu.dlsu.lbycpob.hangman.utils.ClasspathResources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * {@link WordRepository} that reads one of the word lists bundled inside
 * the application itself - packaged as a classpath resource, the same way
 * {@link AsciiArtRenderer} reads its art - rather than a file on the
 * user's real, separate filesystem.
 */

