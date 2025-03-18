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
        /*int bombas = (columnsPrint * rowsPrint)/3;
        int count = 0;

        while (count != bombas) {
            int k = new Random().nextInt(rowsPrint);
            int l = new Random().nextInt(columnsPrint);*/
            if (!gameBoard[2][0].isBomb) {
                gameBoard[2][0].setBomb();
                //count++;
            }
        //}
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

    public void addNeighbours(int rows, int columns){
        if (validPosition(rows + 1, columns, gameBoard)) {
            gameBoard[rows + 1][columns].bombAround += 1;
        }
        if (validPosition(rows + 1, columns + 1, gameBoard)) {
            gameBoard[rows + 1][columns + 1].bombAround += 1;
        }
        if (validPosition(rows, columns + 1, gameBoard)) {
            gameBoard[rows][columns + 1].bombAround += 1;
        }
        if (validPosition(rows - 1, columns + 1, gameBoard)) {
            gameBoard[rows - 1][columns + 1].bombAround += 1;
        }
        if (validPosition(rows - 1, columns, gameBoard)) {
            gameBoard[rows - 1][columns].bombAround += 1;
        }
        if (validPosition(rows - 1, columns - 1, gameBoard)) {
            gameBoard[rows - 1][columns - 1].bombAround += 1;
        }
        if (validPosition(rows, columns - 1, gameBoard)) {
            gameBoard[rows][columns - 1].bombAround += 1;
        }
        if (validPosition(rows + 1, columns - 1, gameBoard)) {
            gameBoard[rows + 1][columns - 1].bombAround += 1;
        }
    }

    public boolean validPosition(int row, int col, Tile[][] gameBoard){
        return col >= 0 && col < gameBoard.length && row >= 0 && row < gameBoard[col].length;
    }

    public boolean gameOver(int rows, int columns){
        return gameBoard[rows][columns].isBomb;
    }

    public boolean quit() {
        return false;
    }

    public boolean revealable(int rows, int columns) {
        if (!gameBoard[columns][rows].isRevealed) {
            return true;
        }
        return false;
    }

    public boolean flaggeable(int rows, int columns) {
        if (!gameBoard[columns][rows].isRevealed) {
            return true;
        }
        return false;
    }
    
    public void revealAll() {
        for (int i = 0; i < rowsPrint; i++) {
            for (int j = 0; j < columnsPrint; j++) {
                gameBoard[i][j].isFlagged = false;
                gameBoard[i][j].isRevealed = true;
            }
        }
    }

    public void revealNeighbours(int rows, int columns){
        if (gameBoard[rows][columns].bombAround == 0) {
            for ( int incFila = -1 ; incFila <= rowsPrint ; incFila++ )
                for ( int incCol = -1 ; incCol <= columnsPrint ; incCol++ ){
                    if (validPosition(rows + incFila, columns + incCol, gameBoard)
                            && !gameBoard[rows + incFila][columns + incCol].isBomb) {
                        gameBoard[rows + incFila][columns + incCol].reveal();

                    }
                }
        }


        /*if (gameBoard[rows][columns].bombAround == 0) {
            if (validPosition(rows + 1, columns, gameBoard)) {
                if (!gameBoard[rows + 1][columns].isBomb) {
                    gameBoard[rows + 1][columns].reveal();
                    if (gameBoard[rows + 1][columns].bombAround == 0) {
                        revealNeighbours(rows + 1, columns);
                    }
                }
            }
            if (validPosition(rows + 1, columns + 1, gameBoard)) {
                if (!gameBoard[rows + 1][columns + 1].isBomb) {
                    gameBoard[rows + 1][columns + 1].reveal();
                    if (gameBoard[rows + 1][columns + 1].bombAround == 0) {
                        revealNeighbours(rows + 1, columns + 1);
                    }
                }
            }
            if (validPosition(rows, columns + 1, gameBoard)) {
                if (!gameBoard[rows][columns + 1].isBomb) {
                    gameBoard[rows][columns + 1].reveal();
                    if (gameBoard[rows][columns + 1].bombAround == 0) {
                        revealNeighbours(rows, columns + 1);
                    }
                }
            }
            if (validPosition(rows - 1, columns + 1, gameBoard)) {
                if (!gameBoard[rows - 1][columns + 1].isBomb) {
                    gameBoard[rows - 1][columns + 1].reveal();
                    if (gameBoard[rows - 1][columns + 1].bombAround == 0) {
                        revealNeighbours(rows - 1, columns + 1);
                    }
                }
            }
            if (validPosition(rows - 1, columns, gameBoard)) {
                if (!gameBoard[rows - 1][columns].isBomb) {
                    gameBoard[rows - 1][columns].reveal();
                    if (gameBoard[rows - 1][columns].bombAround == 0) {
                        revealNeighbours(rows - 1, columns);
                    }
                }
            }
            if (validPosition(rows - 1, columns - 1, gameBoard)) {
                if (!gameBoard[rows - 1][columns - 1].isBomb) {
                    gameBoard[rows - 1][columns - 1].reveal();
                    if (gameBoard[rows - 1][columns - 1].bombAround == 0) {
                        revealNeighbours(rows - 1, columns - 1);
                    }
                }
            }
            if (validPosition(rows, columns - 1, gameBoard)) {
                if (!gameBoard[rows][columns - 1].isBomb) {
                    gameBoard[rows][columns - 1].reveal();
                    if (gameBoard[rows][columns - 1].bombAround == 0) {
                        revealNeighbours(rows, columns - 1);
                    }
                }
            }
            if (validPosition(rows + 1, columns - 1, gameBoard)) {
                if (!gameBoard[rows + 1][columns - 1].isBomb) {
                    gameBoard[rows + 1][columns - 1].reveal();
                    if (gameBoard[rows + 1][columns - 1].bombAround == 0) {
                        revealNeighbours(rows + 1, columns - 1);
                    }
                }
            }
        }*/
    }

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