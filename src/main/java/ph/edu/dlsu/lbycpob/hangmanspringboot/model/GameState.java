package ph.edu.dlsu.lbycpob.hangmanspringboot.model;
import ph.edu.dlsu.lbycpob.hangmanspringboot.statistics.GameStatistics;
import java.io.Serializable;

/**
 * Mutable snapshot of one player's session: the current game plus the
 * running statistics across all games played so far.
 *
 * <p>Implements {@link Serializable} so the servlet container can persist
 * the session to disk if it needs to (required by the spec even if the
 * container never actually serialises it in development).
 *
 */
public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;

/**
 * The word list file currently in use (e.g. {@code "words.txt"}).
 */

private String filename = "";

/**
 * Upper-cased secret word for the current round.
 */
