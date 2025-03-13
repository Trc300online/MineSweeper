import java.util.Random;

public class Board {
    public int columnsPrint = Screen.getColumnPrintCords();
    public int rowsPrint = Screen.getRowPrintCords();
    public Tile[][] gameBoard;

    public Board(){
        gameBoard = new Tile[rowsPrint][columnsPrint];
        for (int i = 0; i < rowsPrint; i++) {
            for (int j = 0; j < columnsPrint; j++) {
                gameBoard[i][j] = new Tile();
            }
        }
    }

    public void placeBombs(Tile[][] gameBoard) {
        int bombas = (columnsPrint * rowsPrint)/3;
        int count = 0;

        while (count != bombas) {
            int k = new Random().nextInt(rowsPrint);
            int l = new Random().nextInt(columnsPrint);
            if (!gameBoard[k][l].isBomb) {
                gameBoard[k][l].setBomb();
                count++;
            }
        }
    }
    
    public void countBombAround(){
        for (int i = 0; i < rowsPrint; i++) {
            for (int j = 0; j < columnsPrint; j++) {
                if (gameBoard[i][j].isBomb) {
                    addNeighbours(i, j);
                }
            }
        }
    }

    public void addNeighbours(int columns, int rows){
        if (validPosition(columns + 1, rows, gameBoard)) {
            gameBoard[columns + 1][rows].bombAround += 1;
        }
        if (validPosition(columns + 1, rows + 1, gameBoard)) {
            gameBoard[columns + 1][rows + 1].bombAround += 1;
        }
        if (validPosition(columns, rows + 1, gameBoard)) {
            gameBoard[columns][rows + 1].bombAround += 1;
        }
        if (validPosition(columns - 1, rows + 1, gameBoard)) {
            gameBoard[columns - 1][rows + 1].bombAround += 1;
        }
        if (validPosition(columns - 1, rows, gameBoard)) {
            gameBoard[columns - 1][rows].bombAround += 1;
        }
        if (validPosition(columns - 1, rows - 1, gameBoard)) {
            gameBoard[columns - 1][rows - 1].bombAround += 1;
        }
        if (validPosition(columns, rows - 1, gameBoard)) {
            gameBoard[columns][rows - 1].bombAround += 1;
        }
        if (validPosition(columns + 1, rows - 1, gameBoard)) {
            gameBoard[columns + 1][rows - 1].bombAround += 1;
        }
    }

    public boolean validPosition(int col, int row, Tile[][] gameBoard){
        return col >= 0 && col < gameBoard.length && row >= 0 && row < gameBoard[col].length;
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
    
    public void revealAll() {
        for (int i = 0; i < rowsPrint; i++) {
            for (int j = 0; j < columnsPrint; j++) {
                gameBoard[j][i].isFlagged = false;
                gameBoard[j][i].isRevealed = true;
            }
        }
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