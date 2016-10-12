/**
 * Created by Kyle on 10/10/2016.
 */
public class Board {

    public Piece[][] pieces = new Piece[Game.ROWS][Game.COLUMNS];

    /**
     * Clear the board to start.
     */
    public Board() {
        clearBoard();
    }

    /**
     * Clears the board to an empty state
     * @return true if the board was already cleared
     */
    public boolean clearBoard() {
        boolean alreadyClear = true;
        for (int i = 0; i < pieces.length; i++)
        {
            for (int j = 0; j < pieces[0].length; j++){
                if (pieces[i][j] != Piece.EMPTY)
                {
                    alreadyClear = false;
                    pieces[i][j] = Piece.EMPTY;
                }
            }
        }
        return alreadyClear;
    }

    /**
     * Drops a piece in the specified column, with the specified color.
     * @param column the row to drop the piece into
     * @param color the color of the piece
     * @return return the row the piece ended up in or -1 if the column was full
     */
    public int drop(int column, Piece color) {
        if (pieces[0][column] != Piece.EMPTY)
            return -1;
        int row = 0;
        while (row < Game.ROWS && pieces[row + 1][column] != Piece.EMPTY)
        {
            row++;
        }
        pieces[row][column] = color;
        return row;
    }
}
