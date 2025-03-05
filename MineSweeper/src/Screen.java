import java.util.Scanner;

public class Screen {

    public static int getRowCords(){
        int rowCords;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Row: ");
        rowCords = Integer.parseInt(scanner2.next());
        return rowCords;
    }

    public static int getColumnCords(){
        int columnCords;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Column: ");
        columnCords = Integer.parseInt(scanner.next());
        return columnCords;
    }

    public static void printBoard(){
        for (int i = 0; i < Board.columns; i++){
            for (int j = 0; j < Board.rows; j++){
                System.out.println(Board.gameBoard[i][j]);
            }
        }
    }

}
