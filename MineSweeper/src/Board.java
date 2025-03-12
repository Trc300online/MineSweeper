import java.util.Random;

public class Board {
    public int columnsPrint = Screen.getColumnPrintCords();
    public int rowsPrint = Screen.getRowPrintCords();

    //public int columns = Screen.getColumnCords();
    //public int rows = Screen.getRowCords();
    public Tile[][] gameBoard;

    public Board(){
        gameBoard = new Tile[columnsPrint][rowsPrint];
        for (int i = 0; i < columnsPrint; i++) {
            for (int j = 0; j < rowsPrint; j++) {
                gameBoard[i][j] = new Tile();
            }
        }
    }

    public void placeBombs(Tile[][] gameBoard) {
        int bombas = (columnsPrint * rowsPrint)/3;
        int count = 0;

        while (count != bombas) {
            int k = new Random().nextInt(columnsPrint);
            int l = new Random().nextInt(rowsPrint);
            if (!gameBoard[k][l].isBomb) {
                gameBoard[k][l].setBomb();
                count++;
            }
        }
    }
    
    public void countBombAround(){
        for (int i = 0; i < columnsPrint; i++) {
            for (int j = 0; j < rowsPrint; j++) {
                if (gameBoard[i][j].isBomb) {
                    addNeighbours(i, j);
                }
            }
        }
    }

    public void addNeighbours(int columns, int rows){
        
        //primer fer class screen per tenir les cords de les posicions.
    }

    public boolean gameOver(int columns, int rows){
        if (!gameBoard[columns][rows].isRevealed
                && gameBoard[columns][rows].isBomb) {
            return true;

        }
        return false;
    }

    public boolean quit() {
        return false;
    }

    public boolean revealable(int columns, int rows) {
        if (!gameBoard[columns][rows].isRevealed) {
            return true;
        }
        return false;
    }

    public boolean flaggeable(int columns, int rows) {
        if (!gameBoard[columns][rows].isRevealed) {
            return true;
        }
        return false;
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