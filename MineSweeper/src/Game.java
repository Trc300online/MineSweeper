public class Game {

    public void startGame() {

        Board board = new Board();
        board.placeBombs(board.gameBoard);
        Screen.printBoard(board);

        boolean gameContinues = true;
        while (gameContinues) {
            char action = Screen.askAction();
            if (action == 'Q' || action == 'q') {
                gameContinues = board.quit();
            }
            if (action == 'R' || action == 'r'){
                int columns = Screen.getColumnCords();
                int rows = Screen.getRowCords();
                if (board.gameOver(columns, rows)){
                    gameContinues = false;
                } if (board.revealable(columns, rows)) {
                    board.gameBoard[columns][rows].reveal();
                    Screen.printBoard(board);
                }/*
                (Board.gameWin() / winCond)-- >
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        if (board[move][move].isRevealed
                                || board[move][move].isBomb) {
                            int count +=1;
                            if (count == columns * rows) {
                                Screen.winMsg();
                            }
                        }
                        break;
                    }
                }*/
            } else if (action == 'F' || action == 'f') {
                int columns = Screen.getColumnCords();
                int rows = Screen.getRowCords();
                if (board.flaggeable(columns, rows)) {
                    board.gameBoard[columns][rows].toggleFlag();
                }
            }
        }
    }
    /*
    * class screen (print boardPlayed, print win & error msg, print boardHidden when win)
    * class Board (update move/clicks, check and give/get num mines around, check win, place flags)
    *
    * idea funcionament print board (get move sobre boardPlayed --> comprovar a boardHidden
    * si bomba o no --> if bomba - lose msg, else - show Nº bombas around)
    *
    * idea funcionament win condition (if get move = bombaTile --> lose,
    * else if all bombaTile flag = true && !unRevealed == win)
    *
    * possible modif a board (board sempre sap si flaged, reveled, bomba o no, Nº bomba around)
    * */

}
