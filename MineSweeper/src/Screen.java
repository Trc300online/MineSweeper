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

    public static void printBoard(Board gameboard){
        for (int i = 0; i < gameboard.columns; i++){
            for (int j = 0; j < gameboard.rows; j++){
                System.out.print(gameboard.gameBoard[i][j]);
            }
            System.out.println();
        }
    }

}
