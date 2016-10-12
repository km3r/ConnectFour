/**
 * Created by Kyle on 10/10/2016.
 */


public class Game {
    public static int ROWS = 6;
    public static int COLUMNS = 7;
    private Piece turn;
    private Board board;
    private Mode mode;

    enum Mode {PLAYER_V_PLAYER, PLAYER_V_AI}

    /**
     * Starts a new game in the correct mode
     */
    public void playGame()
    {
        board = new Board();
        if (mode == Mode.PLAYER_V_PLAYER)
        {
            playHuman();
        }
        else {
            playAI();
        }
    }

    /**
     * Plays against the computer.
     */
    private void playAI() {

    }

    /**
     * Play against another player.
     */
    private void playHuman() {

    }

    /**
     * Check to see if anyone has won.
     * @return Color of winner or empty if no one has one.
     */
    public Piece checkWinner(){
        return Piece.EMPTY;
    }

    /**
     * Get the next move from the display class.
     * @param color the color to make the next move
     * @return the column of the next move
     */
    public int getNextMove(Piece color) {
        return -1;
    }


    /**
     * Asks the user for the mode and sets
     */
    public void askForMode() {

    }
}
