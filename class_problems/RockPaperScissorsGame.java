import java.util.Random;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    // Determines the result of one round from the player's point of view
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static String randomComputerMove(Random rng) {
        return MOVES[rng.nextInt(MOVES.length)];
    }

    public static void main(String[] args) {
        int n = 5;
        // Predefined player moves for a repeatable live demo
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        String[] computerMoves = new String[n];
        String[] results = new String[n];

        Random rng = new Random();

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            computerMoves[i] = randomComputerMove(rng);
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            switch (results[i]) {
                case "Player Wins" -> wins++;
                case "Computer Wins" -> losses++;
                default -> draws++;
            }
        }

        System.out.printf("%-8s%-15s%-15s%-15s%n", "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d%-15s%-15s%-15s%n", i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercent = (wins * 100.0) / n;
        System.out.println();
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercent);
    }
}
