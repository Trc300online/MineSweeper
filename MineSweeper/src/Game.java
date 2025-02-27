public class Game {

    public void startGame(){

        new Board().fillMineField();
        new Board().hints();

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
