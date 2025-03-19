import java.util.Scanner;

public class Screen {

    public static int getColumnCords(){
        int rowCords;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Column: ");
        rowCords = Integer.parseInt(scanner2.next()) - 1;
        return rowCords;
    }

    public static int getRowPrintCords(){
        int rowCords;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Row: ");
        rowCords = Integer.parseInt(scanner2.next());
        return rowCords;
    }

    public static int getRowCords(){
        int columnCords;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Row: ");
        columnCords = Integer.parseInt(scanner.next()) - 1;
        return columnCords;
    }

    public static int getColumnPrintCords(){
        int columnCords;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Column: ");
        columnCords = Integer.parseInt(scanner.next());
        return columnCords;
    }

    public static void printBoard(Board gameboard){
        for (int i = 0; i < gameboard.rowsPrint; i++){
            for (int j = 0; j < gameboard.columnsPrint; j++){
                System.out.print(gameboard.gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static char askAction() {
        char action;
        Scanner getAction = new Scanner(System.in);
        System.out.println("[R] Reveal | [F] Flag | [Q] QUit");
        action = getAction.next().charAt(0);
        return action;
    }

    public static void gameOverMsg() {
        System.out.println("Heu trepitjat una mina, mala sort!!");
    }

    public static void winMsg() {
        System.out.println("Vicotria!! heu marcat totes les mines!!");
    }
}
