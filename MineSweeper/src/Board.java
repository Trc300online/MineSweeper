public class Board {
    public static Tile[][] gameBoard;



}



/*import java.util.Arrays;
import java.util.Random;

public class Board {
    public static final int columns = 8;
    public static final int rows = 8;
    private static int[][] boardPlayed;
    private static int[][] boardBomb;
    private static int[][] boardBAround;

    public Board() {
        boardPlayed = new int[columns][rows];
        boardBomb = new int[columns][rows];
        boardBAround = new int[columns][rows];
    }

    public int[][] getBoardPlayed() {
        return boardPlayed;
    }

    public int[][] getBoardBomb() {
        return boardBomb;
    }

    public int[][] getBoardBAround() {
        return boardBAround;
    }

    public void fillMineField(){
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                boardBomb[i][j] = randomFill();
            }
        }
        for (int i = 0; i < columns; i++){
            System.out.println();
            for (int j = 0; j < rows; j++){
                System.out.print(boardBomb[i][j] + " ");
            }
        }
        System.out.println();
    }

    public int randomFill(){
        return new Random().nextInt(3);
    }

    public void hints(){
        int count = 0;
        for (int i = 0; i < columns; i++){
            for (int j = 0; j < rows; j++){
                boardBAround[i][j] = getAround();
            }
        }

        for (int i = 0; i < columns; i++){
            System.out.println();
            for (int j = 0; j < rows; j++){
                System.out.print(boardBAround[i][j] + " ");
            }
        }
        System.out.println();
    }

    public int getAround(){
        int count = 0;
        for (int i = 1; i -1 < columns; i++){
            for (int j = 1; j -1 < rows; j++){
                if (boardBomb[i + 1][j] == 2) {
                    count += 1;
                }
                if (boardBomb[i + 1][j + 1] == 2) {
                    count += 1;
                }
                if (boardBomb[i][j + 1] == 2) {
                    count += 1;
                }
                if (boardBomb[i - 1][j + 1] == 2) {
                    count += 1;
                }
                if (boardBomb[i - 1][j] == 2) {
                    count += 1;
                }
                if (boardBomb[i - 1][j - 1] == 2) {
                    count += 1;
                }
                if (boardBomb[i][j - 1] == 2) {
                    count += 1;
                }
                if (boardBomb[i + 1][j - 1] == 2) {
                    count += 1;
                }
            }
        }
        return count;
    }

}
*/