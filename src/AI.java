/**
 * Created by Kyle on 10/10/2016.
 */
public class AI {
    public int getMove(Board board)
    {
        int[] weight = new int[Game.COLUMNS];



        int i;
        Piece temp;
        for (i = 0; i < weight.length; i++)
        {
            if (board.pieces[0][i] != Piece.EMPTY)
                continue;
            int row = 0;
            while (row < Game.ROWS && pieces[row + 1][column] != Piece.EMPTY)
            {
                row++;
            }
            if (row != 0) {
                //north-west
                if (i != 0) {
                    if (board.pieces[row - 1][i - 1] != Piece.EMPTY) {
                        weight[i] += 1;
                        temp = board.pieces[row - 1][i - 1];
                        if (board.pieces[row - 2][i - 2] == temp) {
                            weight[i] += 6;
                            if (board.pieces[row - 3][i - 3] == temp) {
                                weight[i] += 50;

                            }
                        }
                    }
                }
                //north-east
                if (i < Game.COLUMNS - 1) {
                    if (board.pieces[row - 1][i + 1] != Piece.EMPTY) {
                        weight[i] += 1;
                        temp = board.pieces[row - 1][i + 1];
                        if (board.pieces[row - 2][i + 2] == temp) {
                            weight[i] += 6;
                            if (board.pieces[row - 3][i + 3] == temp) {
                                weight[i] += 50;

                            }
                        }
                    }
                }
            }
            //west
            if (i != 0) {
                if (board.pieces[row][i - 1] != Piece.EMPTY) {
                    weight[i] += 1;
                    temp = board.pieces[row][i - 1];
                    if (board.pieces[row][i - 2] == temp) {
                        weight[i] += 6;
                        if (board.pieces[row][i - 3] == temp) {
                            weight[i] += 50;

                        }
                    }
                }
            }
            if (row != Game.ROWS - 1) {
                //south-west
                if (i != 0) {
                    if (board.pieces[row + 1][i - 1] != Piece.EMPTY) {
                        weight[i] += 1;
                        temp = board.pieces[row + 1][i - 1];
                        if (board.pieces[row + 2][i - 2] == temp) {
                            weight[i] += 6;
                            if (board.pieces[row + 3][i - 3] == temp) {
                                weight[i] += 50;

                            }
                        }
                    }
                }
                //south
                if (board.pieces[row + 1][i] != Piece.EMPTY) {
                    weight[i] += 1;
                    temp = board.pieces[row + 1][i];
                    if (board.pieces[row + 2][i] == temp) {
                        weight[i] += 6;
                        if (board.pieces[row + 3][i] == temp) {
                            weight[i] += 50;

                        }
                    }
                }
                //south-east
                if (i != Game.COLUMNS - 1) {
                    if (board.pieces[row + 1][i + 1] != Piece.EMPTY) {
                        weight[i] += 1;
                        temp = board.pieces[row + 1][i + 1];
                        if (board.pieces[row + 2][i + 2] == temp) {
                            weight[i] += 6;
                            if (board.pieces[row + 3][i + 3] == temp) {
                                weight[i] += 50;

                            }
                        }
                    }
                }
            }
             //east
            if (i != Game.COLUMNS - 1) {
                if (board.pieces[row][i]) {

                }
            }




        }

        int max = 0;
        for (i = 1; i < weight.length; i++)
            if (weight[max] < weight[i]) max = i;
        return max;
    }
}
