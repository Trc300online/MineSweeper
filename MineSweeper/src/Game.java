public class Game {

    public void startGame() {

        Board board = new Board();
        board.placeBombs(board.gameBoard);
        Screen.printBoard(board);


        boolean gameContinues;
        while (gameContinues) {
            int col = Screen.getColumnCords();
            int row = Screen.getRowCords();
            if (Board.gameOver()){
                gameContinues = false;
            }
            if (!Board.gameBoard[col][row].isRevealed && Board.gameBoard[col][row].isBomb) {
                gameContinues = Board.gameOver();
            }
            if (!Board.gameBoard[col][row].isRevealed && !Board.gameBoard[col][row].isBomb) {
                reveal();
                (gameContinues == true)
            }
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
