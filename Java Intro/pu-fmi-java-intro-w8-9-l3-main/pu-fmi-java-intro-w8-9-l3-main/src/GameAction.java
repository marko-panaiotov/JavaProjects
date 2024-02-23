import java.util.Scanner;

public class GameAction {

    static Scanner inputScanner=new Scanner(System.in);
    static int availableMoney = 10000;
    public static int availableTurns=12;
    static int publicApproval=0;
    static int publicDisapproval=0;
    public static void gameAction1() {
        int height = 0;
        int width = 0;

        System.out.println("Моля изберете вид Експанзия:");
        System.out.println("1. <<Пътят към злата монархия>>");
        System.out.println("2. <<Империята на злото>>");

        int expansionChoice = inputScanner.nextInt();

        if (expansionChoice == 1) {

            height = 8;
            availableMoney -= 10000;
            GameZone.formatMatrix(GameZone.resizeHeight(GameZone.gameBoard, height));
            System.out.println("Вашите налични пари са: " + availableMoney);

            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);

        }

        if (expansionChoice == 2 && availableMoney != 50000) {

            width = 13;
            GameZone.formatMatrix(GameZone.resizeWidth(GameZone.gameBoard, width));

            System.out.println("Вашите налични пари са: " + availableMoney);
            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);

        }
    }

    public static void gameAction2(){
        int buldingChoice=inputScanner.nextInt();

        if (buldingChoice == 1) {

            System.out.print("Изберете ред за построяване на база - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на база - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.HQ;

            availableMoney-=1000;

            System.out.println("Вашите налични пари са: " + availableMoney);
            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);

        }
        if (buldingChoice==2){
            System.out.print("Изберете ред за построяване на лаборатория - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на лаборатория - ");
            int toCol = inputScanner.nextInt();

            GameZone.gameBoard[toRow][toCol]     = GameZone.LABORATORY;

            availableMoney-=1000;

            System.out.println("Вашите налични пари са: " + availableMoney);
            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);
            publicApproval+=5;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==3){
            System.out.print("Изберете ред за построяване на пристанище - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на пристанище - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.HARBOUR;
            gameAction3();
            availableTurns--;
            availableTurns-=1000;
            publicApproval+=5;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==4){
            System.out.print("Изберете ред за построяване на казарма - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на казарма - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.BARRACKS;
            gameAction3();

            availableMoney-=1000;

            System.out.println("Вашите налични пари са: " + availableMoney);
            availableTurns--;

            System.out.println("Вашите налични ходове са: "+ availableTurns);
            publicApproval+=1;

            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==5){
            System.out.print("Изберете ред за построяване на университет - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на университет - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.UNIVERSITY;

            availableMoney-=1000;
            System.out.println("Вашите налични пари са: " + availableMoney);

            availableMoney+=500;
            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            publicApproval+=10;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==6){
            System.out.print("Изберете ред за построяване на данъци - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на данъци - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.TAX;

            availableMoney-=1000;
            System.out.println("Вашите налични пари са: " + availableMoney);
            availableMoney+=500;
            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            publicDisapproval+=5;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==7){
            System.out.print("Изберете ред за построяване на театър - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на театър - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.THEATER;

            System.out.println("Вашите налични пари са: " + availableMoney);

            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            publicApproval+=5;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==8){
            System.out.print("Изберете ред за построяване на медия - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на медия - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.MEDIA;

            availableMoney-=500;
            System.out.println("Вашите налични пари са: " + availableMoney);

            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            publicApproval+=5;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }

        if (buldingChoice==9){
            System.out.print("Изберете ред за построяване на църква - ");
            int toRow = inputScanner.nextInt();
            System.out.print("Изберете колона за построяване на църква - ");
            int toCol = inputScanner.nextInt();
            GameZone.gameBoard[toRow][toCol]     = GameZone.CHURCH;

            availableMoney-=100;
            System.out.println("Вашите налични пари са: " + availableMoney);

            availableTurns--;
            System.out.println("Вашите налични ходове са: "+ availableTurns);

            publicApproval+=5;
            System.out.println("Одобрение: " +publicApproval);
            System.out.println("Недоволство: "+publicDisapproval);
        }
    }

    public static void gameAction3(){

        System.out.println("Поздравления отключихте меню Икономика! Може да изберете едно от следните действия");
        System.out.println("1. <<Да се построи търговски коридор>>");
        System.out.println("2. <<Да вземете кредити от чужди банки и финансови институции>>");
        System.out.println("3. <<Да крадете и отвличате>>");

        int economicsChoice=inputScanner.nextInt();

            int toRow=1;
            int toCol=1;

        if(economicsChoice==1){

            while (GameZone.gameBoard[toRow][toCol]     != GameZone.TRADE_ZONE){
                System.out.println("Моля навигирайте корабът като посочвате координатите на желаната дестинация");
                System.out.print("Въведете координатите на корабът за ред - ");
                toRow = inputScanner.nextInt();
                System.out.print("Въведете координатите на корабът за колона - ");
                toCol = inputScanner.nextInt();

                GameZone.gameBoard[toRow][toCol] = GameZone.SHIPS;
                GameZone.gameBoard[0][0]=GameZone.TRADE_ZONE;
                GameZone.gameBoard[6][11]=GameZone.TRADE_ZONE;
                GameZone.render();

                availableTurns--;
                System.out.println("Вашите налични пари са: " + availableMoney);
                System.out.println("Вашите налични ходове са: "+ availableTurns);
            }
        }

        if(economicsChoice==2){

            System.out.println("Какъв кредит изкате да вземете");
            System.out.println("1. <<Кредит зъл стартъп>>");
            System.out.println("2. <<Кредит злодей>>");
            System.out.println("3. <<Кредитна програма доктор Злобил>>");

            int creditChoice=inputScanner.nextInt();

            if(creditChoice==1){
                availableMoney+=10000;
                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

            if(creditChoice==2){
                availableMoney+=50000;

                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

            if(creditChoice==3){
                availableMoney+=100000;

                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);
            }
        }

        if (economicsChoice == 3) {
            System.out.println("1. <<Кражба>>");
            System.out.println("2. <<Отвличане>>");
            int badWorks=inputScanner.nextInt();
            if (badWorks==1){

                System.out.print("Напишете координати за кражба - ");
                toRow = inputScanner.nextInt();
                toCol = inputScanner.nextInt();

                GameZone.gameBoard[toRow][toCol]=GameZone.gameBoard[6][0];
                GameZone.gameBoard[toRow][toCol]=GameZone.gameBoard[0][11];
                availableMoney+=500;
                    GameZone.render();
                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);
            }
            if(badWorks==2){

                System.out.print("Напишете координати за отвличане - ");
                toRow = inputScanner.nextInt();
                toCol = inputScanner.nextInt();

                GameZone.gameBoard[toRow][toCol]=GameZone.gameBoard[6][0];
                GameZone.gameBoard[toRow][toCol]=GameZone.gameBoard[0][11];

                availableMoney+=1500;
                GameZone.render();
                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

        }

    }
    public static void gameAction4(){

        System.out.println("Моля изберете подобрения:");
        System.out.println("1. <<Търговско подобрение>>");
        System.out.println("2. <<Социални подобрения>>");

        int upgradeChoice=inputScanner.nextInt();

        if (upgradeChoice == 1) {

            System.out.println("Моля търговско подобрения:");
            System.out.println("1. <<Двигател тайфун>>");
            System.out.println("2. <<Диагонална струя>>");

            int commercialChoice=inputScanner.nextInt();

            if (commercialChoice == 1) {

                availableMoney-=2000;

                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

            if (commercialChoice == 2) {

                availableMoney-=3000;

                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

        }

        if (upgradeChoice==2){

            System.out.println("Моля социално подобрения:");
            System.out.println("1. <<Умни тоалетни>>");
            System.out.println("2. <<Ефективни данъци>>");

            int socialChoice=inputScanner.nextInt();

            if (socialChoice == 1) {

                availableMoney-=500;

                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

            if (socialChoice == 2) {

                availableMoney-=3000;

                System.out.println("Вашите налични пари са: " + availableMoney);
                availableTurns--;
                System.out.println("Вашите налични ходове са: "+ availableTurns);

            }

        }
    }

    public static void gameAction5(){

        availableMoney-=10000;

        System.out.println("Вашите налични пари са: " + availableMoney);
        availableTurns--;
        System.out.println("Вашите налични ходове са: "+ availableTurns);
    }
}


