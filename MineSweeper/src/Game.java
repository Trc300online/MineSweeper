public class Game {

    public void startGame() {

        Board board = new Board();
        board.placeBombs(board.gameBoard);
        board.countBombAround();
        boolean gameContinues = true;

        while (gameContinues) {

            Screen.printBoard(board);
            char action = Screen.askAction();

            switch (action) {
                case 'Q':
                case 'q':
                    gameContinues = board.quit();
                    break;


                case 'R':
                case 'r':
                    int columns = Screen.getColumnCords();
                    int rows = Screen.getRowCords();

                    if (board.gameOver(rows, columns)){

                        board.revealAll();
                        Screen.printBoard(board);
                        Screen.gameOverMsg();
                        gameContinues = false;
                        break;
                    }
                    if (board.revealable(rows, columns) && !board.gameBoard[rows][columns].isFlagged) {

                        board.gameBoard[rows][columns].reveal();
                        board.revealNeighbours(rows, columns);

                        if (board.winCond()) {
                            Screen.printBoard(board);
                            Screen.winMsg();
                            gameContinues = false;
                        }
                    }
                    break;


                case 'F':
                case 'f':
                    int columnsF = Screen.getColumnCords();
                    int rowsF = Screen.getRowCords();

                    if (board.flaggeable(rowsF, columnsF)) {

                        board.gameBoard[rowsF][columnsF].toggleFlag();
                    }
                    break;
            }
        }
    }
}
