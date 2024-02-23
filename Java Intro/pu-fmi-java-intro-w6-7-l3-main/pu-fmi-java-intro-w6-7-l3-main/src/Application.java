import java.util.Scanner;

public class Application {

    static Scanner inputScanner = new Scanner(System.in);

    private static final int GAME_BOARD_ROW_COUNT = 12;
    private static final int GAME_BOARD_COL_COUNT = 18;


    static String[][] gameBoard = {
            {"$", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "11", "12", "13", "14", "15", "#"},
            {"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33"},
            {"34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51"},
            {"52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69"},
            {"70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87"},
            {"88", "89", "90", "91", "92", "93", "94", "95", "X", "X", "96", "97", "98", "99", "100", "101", "102", "103"},
            {"104", "105", "106", "107", "108", "109", "110", "111", "X", "X", "112", "113", "114", "115", "116", "117", "118", "119"},
            {"120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "134", "135", "136"},
            {"137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154"},
            {"155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172"},
            {"173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190"},
            {"%", "191", "192", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "@"}
    };

    private static final String DIRECTION_FORWARD   = "w";
    private static final String DIRECTION_BACKWARD  = "s";
    private static final String DIRECTION_LEFT      = "a";
    private static final String DIRECTION_RIGHT     = "d";

    private static int playerRow;
    private static int playerCol;

    public static String[][] gameZone(String[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.printf("%5s", gameBoard[i][j]);
            }
            System.out.println();
        }
        return gameBoard;
    }

    public static String[][] movePlayer(String direction, String[][] gameBoard,int avatarChoice) {

        int playerCurrentRow = playerRow;
        int playerCurrentCol = playerCol;

        if(avatarChoice==1){

            if (direction.equals(DIRECTION_FORWARD)) {
                playerCurrentRow = playerCurrentRow - 1;
            }

            if (direction.equals(DIRECTION_BACKWARD)) {
                playerCurrentRow = playerCurrentRow + 1;
            }

            if (direction.equals(DIRECTION_LEFT)) {
                playerCurrentCol = playerCurrentCol - 1;
            }

            if (direction.equals(DIRECTION_RIGHT)) {
                playerCurrentCol = playerCurrentCol + 1;
            }

            playerRow = playerCurrentRow;
            playerCol = playerCurrentCol;

            gameBoard[playerRow][playerCol] = "$";

            return gameBoard;
        }

        if(avatarChoice==2) {


            playerCurrentRow = 1;
            playerCurrentCol = 17;
            playerRow = playerCurrentRow;
            playerCol = playerCurrentCol;
            
            if (direction.equals(DIRECTION_FORWARD)) {
                playerCurrentRow = playerCurrentRow - 1;
            }

            if (direction.equals(DIRECTION_BACKWARD)) {
                playerCurrentRow = playerCurrentRow + 1;
            }

            if (direction.equals(DIRECTION_LEFT)) {
                playerCurrentCol = playerCurrentCol - 1;
            }

            if (direction.equals(DIRECTION_RIGHT)) {
                playerCurrentCol = playerCurrentCol + 1;
            }

            playerRow = playerCurrentRow;
            playerCol = playerCurrentCol;

            gameBoard[playerRow][playerCol] = "#";



                return gameBoard;
        }

        if (avatarChoice==3) {

            playerCurrentRow=12;
            playerCurrentCol=1;

            if (direction.equals(DIRECTION_FORWARD)) {
                playerCurrentRow = playerCurrentRow - 1;
            }

            if (direction.equals(DIRECTION_BACKWARD)) {
                playerCurrentRow = playerCurrentRow + 1;
            }

            if (direction.equals(DIRECTION_LEFT)) {
                playerCurrentCol = playerCurrentCol - 1;
            }

            if (direction.equals(DIRECTION_RIGHT)) {
                playerCurrentCol = playerCurrentCol + 1;
            }

            playerRow = playerCurrentRow;
            playerCol = playerCurrentCol;

            gameBoard[playerRow][playerCol] = "%";

            return gameBoard;
        }

        if (gameBoard[playerRow][playerCol].equals(gameBoard[5][8])) {
            System.out.println("Поздравленя, спечелихте играта");
        }
        return gameBoard;
    }

    public static void main (String[]args){
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Безработните джуджета от прегорялата планина");
        gameZone(gameBoard);

        int endOfTheGame =15;

        while (endOfTheGame!=0){

            System.out.println("Моля изберете герой");
            System.out.println("1. Влюбения Гном Отело");
            System.out.println("2.Синдиката на безработните джуджета");
            System.out.println("3. Лилавния фокусник Шмандалф");

            int avatarChoice= inputScanner.nextInt();

            System.out.println("Choose direction: ");
            String direction = inputScanner.next();

            gameBoard = movePlayer(direction, gameBoard,avatarChoice);
            gameZone(gameBoard);

            endOfTheGame--;

            System.out.println("Оставащи ходове: "+endOfTheGame);
        }
        System.out.println("Край на играта");
    }
}

