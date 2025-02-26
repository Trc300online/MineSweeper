public class Board {
    public static final int columns = 7;
    public static final int rows = 6;
    private static int[][] boardPlayed;
    private static int[][] boardHidden;

    public Board() {
        boardPlayed = new int[columns][rows];
    }

    public int[][] getBoard() {
        return boardPlayed;
    }

}
