package ph.edu.dlsu.lbycpob.hangman.statistics;

import java.util.Locale;

/**
 * Holds the running statistics for one program session: games played,
 * games won, and the best (highest) number of guesses remaining at the end
 * of any single game.
 */
public record GameStatistics(int gamesPlayed, int gamesWon, int bestGuessesRemaining) {

/** Runs automatically every time a GameStatistics is created - checks the numbers make sense. */
