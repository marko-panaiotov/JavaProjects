public class GameZone {

    public static final int EMPTY_AREA=0;
    public static final int BAY=1;
    public static final int PROPERTY=2;
    public static final int HQ=3;
    public static final int TRADE_ZONE=4;
    public static final int TOURIST_ATTRACTION=5;
    public static final int LABORATORY=6;
    public static final int HARBOUR=7;
    public static final int BARRACKS=8;
    public static final int UNIVERSITY=9;
    public static final int TAX=10;
    public static final int THEATER=11;
    public static final int MEDIA=12;
    public static final int CHURCH=13;
    public static final int SHIPS=14;

   public static int[][] gameBoard=new int[][]{
           {TRADE_ZONE,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,TOURIST_ATTRACTION},
           {EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA},
           {EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,BAY,PROPERTY,PROPERTY,BAY,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA},
           {EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,PROPERTY,PROPERTY,HQ,PROPERTY,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA},
           {EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,BAY,PROPERTY,PROPERTY,PROPERTY,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA},
           {EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA},
           {TOURIST_ATTRACTION,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,EMPTY_AREA,TRADE_ZONE}
   };

    public static void render(){
        for (int[] processableRow:gameBoard){
            for (int element:processableRow){
                String renderElement=renderGameBoard(element);
                System.out.printf("%5s",renderElement);
            }
            System.out.println();
        }

    }

    public static String renderGameBoard(int element)   {

        if (element==BAY)                return "@";
        if (element==PROPERTY)           return "X";
        if (element==HQ)                 return "HQ";
        if (element==TRADE_ZONE)         return "$";
        if (element==TOURIST_ATTRACTION) return "&";
        if (element == LABORATORY)       return "LB";
        if (element==HARBOUR)            return "P";
        if (element==BARRACKS)           return "B";
        if (element==UNIVERSITY)         return "U";
        if (element==TAX)                return "RA";
        if (element==THEATER)            return "TH";
        if (element==MEDIA)              return "M";
        if(element==CHURCH)              return "C";
        if (element == SHIPS)            return "#";


        return "0" ;
    }

    public static int getWidth( int[][] gameBoard) {
        int max = 0;
        if (gameBoard.length > 0) {
            max = gameBoard[0].length;
            if (gameBoard.length > 1) {
                for (int i = 1; i < gameBoard.length; i++) {
                    if (gameBoard[i].length > max) {
                        max = gameBoard[i].length;
                    }
                }
            }
        }
        return max;
    }

    public static int getHeight( int[][] gameBoard) {
        return gameBoard.length;
    }

    public static int[][] resizeWidth( int[][] gameBoard, final int w) {
        int width = getWidth(gameBoard);
        return addCols(gameBoard, w - width);
    }

    public static int[][] resizeHeight(int[][] gameBoard, final int h) {
        int height = getHeight(gameBoard);
        return addRows(gameBoard, h - height);
    }

    public static int[][] addRows( int[][] gameBoard, final int n) {
        if (n == 0) {
            return gameBoard;
        }
        int oldHeight = gameBoard.length;
        int newHeight = oldHeight + n;
        int width = getWidth(gameBoard);
        int[][] copy = new int[newHeight][];
        System.arraycopy(gameBoard, 0, copy, 0, n > 0 ? oldHeight : newHeight);
        for (int i = oldHeight; i < newHeight; i++) {
            copy[i] = new int[width];

            System.out.println();

        }
        return copy;
    }

    public static int[][] addCols( int[][] gameBoard, final int n) {
        if (n == 0) {
            return gameBoard;
        }
        int oldWidth = getWidth(gameBoard);
        int newWidth = oldWidth + n;
        int height = gameBoard.length;
        int[][] copy = new int[height][newWidth];
        for (int i = 0; i < height; i++) {
            copy[i] = new int[newWidth];

            System.arraycopy(gameBoard[i], 0, copy[i], 0, n > 0 ? oldWidth : newWidth);
        }
        return copy;
    }

    public static String formatMatrix(int[][] gameBoard) {
        for (int[] processableRow:gameBoard){
            for (int element:processableRow){
                String renderElement=renderGameBoard(element);

                System.out.printf("%5s",renderElement);
            }
            System.out.println();
        }

        return formatMatrix(gameBoard,"\n", " ");
    }

    public static String formatMatrix(int[][] gameBoard, String vSep, String hSep) {

        return join(new StringBuffer(), gameBoard, vSep, hSep).toString();
    }

    public static StringBuffer join(StringBuffer buff, int[][] gameBoard, String vSep, String hSep) {
        if (gameBoard.length > 0) {

            for (int i = 1; i < gameBoard.length; i++) {

            }
        }

        return buff;
    }

}
