import java.util.Scanner;

public class Screen {

    public static int getColumnCords(){
        int rowCords = 1;
        try {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Column: ");
            rowCords = Integer.parseInt(scanner2.next()) - 1;
        } catch (NumberFormatException nfe) {
            errorMng(2);
            System.exit(0);
        }
        return rowCords;
    }

    public static int getRowPrintCords(){
        int rowCords = 0;
        try {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Row: ");
            rowCords = Integer.parseInt(scanner2.next());
        } catch (NumberFormatException nfe) {
            errorMng(2);
            System.exit(0);
        }
        return rowCords;
    }

    public static int getRowCords(){
        int columnCords = 1;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Row: ");
            columnCords = Integer.parseInt(scanner.next()) - 1;
        } catch (NumberFormatException nfe) {
            errorMng(2);
            System.exit(0);
        }
        return columnCords;
    }

    public static int getColumnPrintCords(){
        int columnCords = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Column: ");
            columnCords = Integer.parseInt(scanner.next());
        } catch (NumberFormatException nfe) {
            errorMng(2);
            System.exit(0);
        }
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

    public static int bombInfo() {
        int bombs = 0;
        try {
            Scanner getBombs = new Scanner(System.in);
            System.out.println("mines dins el tauler: ");
            bombs = Integer.parseInt(getBombs.next());
        } catch (NumberFormatException nfe) {
            errorMng(2);
            System.exit(0);
        }
        return bombs;
    }

    public static void errorMng(int errorCode) {
        if (errorCode == 1) {
            System.out.println("mida del tauler incorrecte, ha de ser rows = 8...24 i columns = 8...32");
            System.out.println("Detenent execució....");
        }
        if (errorCode == 2) {
            System.out.println("Nomes se accepten numeros...");
            System.out.println("Detenent execució....");
        }
        if (errorCode == 3) {
            System.out.println("Les mines han de ser 1 fins a 1/3 de les caselles");
            System.out.println("Detenent execució....");
        }
        if (errorCode == 4) {
            System.out.println("Una de les caselles introduides esta fora del tauler...");
            System.out.println("Tornau a intentar");
        }
    }
}
