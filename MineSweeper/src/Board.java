import java.util.Random;

public class Board {
    public int columns = Screen.getColumnCords();
    public int rows = Screen.getRowCords();
    public Tile[][] gameBoard;

    public Board(){
        gameBoard = new Tile[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                gameBoard[i][j] = new Tile();
            }
        }
    }

    public void placeBombs(Tile[][] gameBoard) {
        int bombas = (columns * rows)/3;
        int count = 0;

        while (count != bombas) {
            int k = new Random().nextInt(columns);
            int l = new Random().nextInt(rows);
            if (!gameBoard[k][l].isBomb) {
                gameBoard[k][l].setBomb();
                count++;
            }
        }
    }
    
    public void countBombAround(){
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (gameBoard[i][j].isBomb) {
                    count();
                }
            }
        }
    }

    public void count(){
        //primer fer class screen per tenir les cords de les posicions.
    }

    public boolean gameOver(){
        if (!gameBoard[Screen.getColumnCords()][Screen.getRowCords()].isRevealed
                && gameBoard[Screen.getColumnCords()][Screen.getRowCords()].isBomb) {

        }
        return true;
    }

    /*public static boolean gameOver(){
        return false;
    }*/

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