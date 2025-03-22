import java.util.Random;

public class Board {
    public int columnsPrint = Screen.getColumnPrintCords();
    public int rowsPrint = Screen.getRowPrintCords();
    public Tile[][] gameBoard;


    public Board() {
        gameBoard = new Tile[rowsPrint][columnsPrint];
        int errorCode;
        if ((rowsPrint > 24 || columnsPrint > 32) || (rowsPrint < 8 || columnsPrint < 8)) {
            Screen.errorMng(1);
            System.exit(0);
        } else {
            for (int i = 0; i < rowsPrint; i++) {
                for (int j = 0; j < columnsPrint; j++) {
                    gameBoard[i][j] = new Tile();
                }
            }
        }
    }

    public void placeBombs(Tile[][] gameBoard) {
        int bombas = Screen.bombInfo();
        if (bombas < 1 || bombas > ((rowsPrint * columnsPrint)/3)) {
            Screen.errorMng(3);
            System.exit(0);
        } else {
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
    }

    public void countBombAround() {
        for (int i = 0; i < rowsPrint; i++) {
            for (int j = 0; j < columnsPrint; j++) {
                if (gameBoard[i][j].isBomb) {
                    addNeighbours(i, j);
                }
            }
        }
    }

    public void addNeighbours(int rows, int columns) {
        for (int incFila = -1; incFila <= 1; incFila++) {
            for (int incCol = -1; incCol <= 1; incCol++) {
                int newRow = rows + incFila;
                int newCol = columns + incCol;

                if (validPosition(newRow, newCol, gameBoard)) {

                    gameBoard[newRow][newCol].bombAround += 1;

                }
            }
        }
    }

    public boolean validPosition(int row, int col, Tile[][] gameBoard) {
        return row >= 0 && row < gameBoard.length && col >= 0 && col < gameBoard[0].length;
    }

    public boolean gameOver(int rows, int columns) {
        return gameBoard[rows][columns].isBomb;
    }

    public boolean quit() {
        return false;
    }

    public boolean revealable(int rows, int columns) {
        if (!gameBoard[rows][columns].isRevealed) {
            return true;
        }
        return false;
    }

    public boolean flaggeable(int rows, int columns) {
        if (!gameBoard[rows][columns].isRevealed) {
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

    public void revealNeighbours(int rows, int columns) {
        if (gameBoard[rows][columns].bombAround == 0) {
            for (int incFila = -1; incFila <= 1; incFila++) {
                for (int incCol = -1; incCol <= 1; incCol++) {
                    int newRow = rows + incFila;
                    int newCol = columns + incCol;

                    if (validPosition(newRow, newCol, gameBoard)
                            && !gameBoard[newRow][newCol].isBomb
                            && !gameBoard[newRow][newCol].isRevealed
                            && !gameBoard[newRow][newCol].isFlagged) {

                        gameBoard[newRow][newCol].reveal();


                        if (gameBoard[newRow][newCol].bombAround == 0) {
                            revealNeighbours(newRow, newCol);

                        }
                    }
                }
            }
        }
    }

    public boolean winCond() {
        int count = 0;
        for (int i = 0; i < rowsPrint; i++) {
            for (int j = 0; j < columnsPrint; j++) {
                if (gameBoard[i][j].isRevealed
                        || gameBoard[i][j].isBomb) {
                    count +=1;

                }
            }
        }
        if (count == columnsPrint * rowsPrint) {
            return true;
        }
        return false;
    }
}