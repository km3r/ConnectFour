/**
 * Created by Kyle on 10/12/2016.
 */
public class AiAlgo implements AI {
    public int getMove(Board board)
    {
        int[] weight = new int[Game.COLUMNS];

        Piece[][] arr = new Piece[Game.ROWS + 6][Game.COLUMNS + 6];


        int i;

        for (i = 0; i < Game.ROWS; i++)
            for (int j = 0; j< Game.COLUMNS; j++)
                arr[i+3][j+3] = board.pieces[i][j];

        for (i = 0; i < weight.length; i++)
        {
            if (board.pieces[0][i] != Piece.EMPTY)
                return -1;
            int row = 0;
            while (row < Game.ROWS && board.pieces[row + 1][i] != Piece.EMPTY)
            {
                row++;
            }
            //check spot
            weight[i] = weightAll(arr, row+3, i+3);
        }

        int max = 0;
        for (i = 1; i < weight.length; i++)
            if (weight[max] < weight[i]) max = i;
        return max;
    }

    private int weightAll(Piece[][] arr, int row, int col) {
        int weight = 0;
        Piece[] seg = new Piece[7];
        seg[3] = arr[row][col];
        seg[0] = arr[row-3][col];
        seg[0] = arr[row-2][col];
        seg[0] = arr[row-1][col];
        seg[0] = arr[row+1][col];
        seg[0] = arr[row+2][col];
        seg[0] = arr[row+3][col];
        weight += weightSeg(seg);
        seg[0] = arr[row-3][col-3];
        seg[0] = arr[row-2][col-2];
        seg[0] = arr[row-1][col-1];
        seg[0] = arr[row+1][col+1];
        seg[0] = arr[row+2][col+2];
        seg[0] = arr[row+3][col+3];
        weight += weightSeg(seg);
        seg[0] = arr[row][col-3];
        seg[0] = arr[row][col-2];
        seg[0] = arr[row][col-1];
        seg[0] = arr[row][col+1];
        seg[0] = arr[row][col+2];
        seg[0] = arr[row][col+3];
        weight += weightSeg(seg);
        seg[0] = arr[row-3][col+3];
        seg[0] = arr[row-2][col+2];
        seg[0] = arr[row-1][col+1];
        seg[0] = arr[row+1][col-1];
        seg[0] = arr[row+2][col-2];
        seg[0] = arr[row+3][col-3];
        weight += weightSeg(seg);
        return weight;
    }


    private String[]    weightMapA      = {"___X","__X_","_X__","X___","__XX","_X_X","X__X","_XX_","X_X_","XX__","XXX_","XX_X","X_XX","_XXX"};
    private String[]    weightMapB      = {"___O","__O_","_O__","O___","__OO","_O_O","O__O","_OO_","O_O_","OO__","OOO_","OO_O","O_OO","_OOO"};
    private int[]       weightMapInts   = {     1,     2,     2,     1,     6,     5,     4,     6,     5,     6,    12,    11,    11,    12};

    private int weightSeg(Piece[] arr) {
        if (arr.length != 7) return -1;
        String str = "";
        for (Piece p : arr) {
            str += p;
        }
        int weight = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < weightMapA.length; j++) {
                if (str.substring(i, i + 4).equals(weightMapA[j]))
                    weight += weightMapInts[j];
                if (str.substring(i, i + 4).equals(weightMapB[j]))
                    weight += weightMapInts[j];
            }
        return weight;
    }
}
