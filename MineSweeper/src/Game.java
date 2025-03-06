public class Game {

    public void startGame(){

        Board gameBoard = new Board();
        Screen.printBoard(gameBoard);
        /*
        while(gameContinues) {
            screen ask move;
            if (gameBoard[move][move].isRevealed == false && gameBoard[move][move].isBomb == true){
                gameOver();(gameContinue == false)
            }
            if (gameBoard[move][move].isRevealed == false && gameBoard[move][move].isBomb == false){
                reveal();(gameContinue == true)
            }
            (winCond)-->
            for (int i = 0; i < columns; i++){
                for (int j = 0; j < rows; j++){
                    if  (gameBoard[move][move].isRevealed
                    || gameBoard[move][move].isBomb){
                        int count += 1;
                        if  (count == columns * rows) {
                            winMsg();
                        }
                    }
                    break;
                }
            }
        }
        */

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
