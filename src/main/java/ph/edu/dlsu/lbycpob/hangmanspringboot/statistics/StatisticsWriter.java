package ph.edu.dlsu.lbycpob.hangmanspringboot.statistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Writes Hangman session statistics to a flat file.
 */
@Component
public class StatisticsWriter {

    private static final Logger log = LoggerFactory.getLogger(StatisticsWriter.class);

    private static final String FILENAME  = "hangman_statistics.txt";
    private static final String SEPARATOR = "=".repeat(60);

    public void writeStats(int gamesPlayed, int gamesWon, int gamesLost,
                           double winPercentage, int bestScore) {
        try {
            ensureFileExists();
            appendStatsToFile(gamesPlayed, gamesWon, gamesLost, winPercentage, bestScore);
            log.info("Session statistics saved to {}", FILENAME);
        } catch (IOException e) {
            log.error("Error writing statistics to file: {}", e.getMessage(), e);
        }
    }
