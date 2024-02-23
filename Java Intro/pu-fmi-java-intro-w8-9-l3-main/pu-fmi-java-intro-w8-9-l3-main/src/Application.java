import java.util.Scanner;

public class Application {
    static Scanner inputScanner=new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Злите планове за превземане на Света, на малкото колибри Джибри и неговата банда");
        GameZone.render();
        int availableMoney=10000;

        System.out.println("Вашите налични пари са: "+ availableMoney);

        while (GameAction.availableTurns!=0||GameAction.availableMoney<=1000000) {

            System.out.println("Моля изберете действие: ");
            System.out.println("1. <<Експанзия>>");
            System.out.println("2. <<Строителство на сгради>>");
            System.out.println("3. <<Икономика>>");
            System.out.println("4. <<Научно технически прогрес>>");
            System.out.println("5. <<Зъл план>>");

            int gameAction=inputScanner.nextInt();

            if(gameAction==1) {

                GameAction.gameAction1();

            }

            if (gameAction==2){

                GameZone.render();

                System.out.println("Какъв вид сгради искате да построите");
                System.out.println("1. <<Зла база>>");
                System.out.println("2. <<Лаборатория>>");
                System.out.println("3. <<Пристанище>>");
                System.out.println("4. <<Казарма>>");
                System.out.println("5. <<Университет>>");
                System.out.println("6. <<Данъчни>>");
                System.out.println("7. <<Театър>>");
                System.out.println("8. <<Медии>>");
                System.out.println("9. <<Храм>>");

                GameAction.gameAction2();

            }

            if (gameAction==3){

                GameZone.render();
                GameAction.gameAction3();

            }

            if (gameAction == 4) {

                GameZone.render();
                GameAction.gameAction4();

            }

            if (gameAction==5){
                GameAction.gameAction5();
            }

        }
    }
}
