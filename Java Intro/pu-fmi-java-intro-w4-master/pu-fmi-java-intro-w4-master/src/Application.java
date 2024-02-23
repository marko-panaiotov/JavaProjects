import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        Random randomNumber = new Random();

        System.out.println("Добре дошли в програмата за контрол над озонобъркачки");
        System.out.println();
        System.out.println("Въведете команда status, за да видите наличните си ресурси преди мисията");

        String commandStatus = "";
        commandStatus = inputScanner.next();
        int availableGas = 90;
        int availableOxygen = 168;
        int successMissions = 0;
        int randomNumberCutFind = 0;

        if (commandStatus.equals("status")) {

            System.out.println(availableGas + " " + "литра гориво");
            System.out.println(availableOxygen + " " + "часа кислород");
            System.out.println(successMissions + " " + "изпълнени мисии");
        }

        System.out.println();
        System.out.println("Колко дупки искате да запълните?");

        int numbersOfHole = 0;
        int coordinateOfHole = 0;
        int coordinateOfHoleX = 0;
        int coordinateOfHoleY = 0;

        numbersOfHole = inputScanner.nextInt();

        while (numbersOfHole > coordinateOfHole) {
            coordinateOfHoleX = randomNumber.nextInt(1, 50);
            System.out.println("X-" + " " + coordinateOfHoleX);
            coordinateOfHoleY = randomNumber.nextInt(1, 50);
            System.out.println("Y-" + " " + coordinateOfHoleY);
            coordinateOfHole++;
        }

        System.out.println();
        System.out.println("Напишете команда за включване");

        String turnOnSystem = "";

        do {
            turnOnSystem = inputScanner.next();
            isTurnOnSystem(turnOnSystem);

        } while (isInvalidCommand(turnOnSystem));

        int loop = 0;

        String commandLoad = "";
        String commandUnload = "";
        String robotArm = "";
        String moveX = "";
        String moveY = "";
        String moveXDirection = "";

        while (numbersOfHole > loop) {

            do {
                System.out.println();
                System.out.println("Въведете команда за включване на роботска ръка");

                do {
                    isCommandLoad(commandLoad, commandUnload, inputScanner);
                    break;
                } while (isLoadAndUnloadRobotArm(commandLoad, commandUnload, moveX, moveY));

                System.out.println();
                System.out.println("Въведете команди за предвижването на ръката");

                int coordinateX = 0;
                int coordinateY = 0;

                do {
                    moveX = inputScanner.next();
                    isMoveX(moveX, moveXDirection, moveY, inputScanner, coordinateX);
                    coordinateX = inputScanner.nextInt();
                    System.out.println(coordinateX);
                    moveY = inputScanner.next();
                    isMoveX(moveX, moveXDirection, moveY, inputScanner, coordinateY);
                    coordinateY = inputScanner.nextInt();
                    System.out.println(coordinateY);
                } while (isMoveRobotArm(moveX, moveY));

                System.out.println();
                isIndentifyOfHole(randomNumber);

                System.out.println();
                System.out.println("Въведете команда за работа с роботската ръка");

                String cut = "";
                String fill = "";
                String finish = "";

                do {
                    cut = inputScanner.next();
                    if (cut.equals("cut")) {
                        int randomNumberCut = randomNumber.nextInt(1, 20);
                        System.out.println("Генерирах число от 1 до 20 познай го, за да отрежа дупката");

                        if (randomNumberCut != randomNumberCutFind) {
                            do {
                                randomNumberCutFind = inputScanner.nextInt();
                            }
                            while (randomNumberCutFind != randomNumberCut);

                        }
                        isCommandCut(cut, fill, inputScanner, randomNumber);
                    }

                    fill = inputScanner.next();
                    isCommandFill(fill, cut, inputScanner, randomNumber, randomNumberCutFind);
                    finish = inputScanner.next();
                    isCommandFinish(coordinateY, moveX, moveY, inputScanner, coordinateX, moveXDirection, finish);
                    break;
                } while (isCorrectWay(cut, fill, finish));

                loop++;
            } while (isEndOfMission(availableGas, availableOxygen, successMissions));

        }
            System.out.println();
            System.out.println("Въведете команда status, за да видите наличните си ресурси след мисията");

            commandStatus = inputScanner.next();

            isStartMissionStatus(commandStatus, availableGas, availableOxygen, successMissions, randomNumberCutFind);

            System.out.println("Мисията е изпълнена успешно");
    }

    private static boolean isEndOfMission(int availableGas, int availableOxygen,int successMission){
        return ((availableGas==0)||(availableOxygen==0)||(successMission==1));
    }
    private static void isStartMissionStatus(String commandStatus,int availableGas, int availableOxygen,int successMissions, int randomNumberCutFind){

        if(commandStatus.equals("status")) {
            randomNumberCutFind--;
            int missionStatusInTheEnd = availableGas -randomNumberCutFind;
            System.out.println(missionStatusInTheEnd);
            int missionStatusInTheEnd1 = availableOxygen-9;
            System.out.println(missionStatusInTheEnd1);
            successMissions++;
            int missionStatusInTheEnd2 = successMissions;
            System.out.println(missionStatusInTheEnd2);
        }
    }
private static boolean isCorrectWay(String cut,String fill,String finish){
    return (!(cut.equals("cut")) && !(fill.equals("fill"))&&!(finish.equals("finish")));
}
    private static String isCommandCut (String cut,String fill,Scanner inputScanner,Random randomNumber){

        if(cut.equals("cut")){
                System.out.println("Операцията cut е изпълнена успешно");
        }

        if(!cut.equals("cut")){
            System.out.println("Грешка - некоректна последователност на използваната команда");
            return (isCommandCut ( cut, fill,inputScanner,randomNumber));
        }
        return cut;
    }
    private static String isCommandFill(String fill,String cut, Scanner inputScanner,Random randomNumber,int randomNumberCutFind){

        if(fill.equals("fill")){
            int randomNumberFill= randomNumber.nextInt(1,20);
            System.out.println("Генерирах число от 1 до 20 и го събрах с"+" "+randomNumberCutFind+" "+" познай го, за да отрежа дупката");

            int resultOfRandomAndCutNumber=randomNumberFill+randomNumberCutFind;
            int randomNumberFillFind=0;
            if(randomNumberFill!=resultOfRandomAndCutNumber) {

                do {
                    randomNumberFillFind = inputScanner.nextInt();
                }
                while (randomNumberFillFind != resultOfRandomAndCutNumber);
            }
            System.out.println("Операцията fill е изпълнена успешно");
        }
        if(!fill.equals("fill")){
            System.out.println("Грешка - некоректна последователност на използваната команда");
           return (isCommandCut (cut, fill,inputScanner,randomNumber));
        }
        return fill;
    }

    private static String isCommandFinish(int coordinateY,String moveX, String moveY, Scanner inputScanner,int coordinateX,String moveXDirection,String finish){
        if(finish.equals("finish")) {
            System.out.println("Дупката на координати" + " " +  coordinateX + " " + "и" + " " +  coordinateY + " " + "е запълнена успешно");
        }
        return finish;
    }

    private static boolean isLoadAndUnloadRobotArm(String moveX ,String moveY, String commandLoad,String commandUnload ) {

        return (!(commandLoad.equals("load")) && !(commandUnload.equals("unload")));
    }


    private static boolean isMoveRobotArm(String moveX, String moveY) {
        return !((moveX.equals("moveX")) || (moveY.equals("moveY")));
    }

    private static void isIndentifyOfHole(Random randomNumber) {
        int randomNumbers = randomNumber.nextInt(1, 5);
        System.out.println("Дупката е идентифицирана");
    }

    private static int isMoveX(String moveX, String moveXDirection, String moveY, Scanner inputScanner,int coordinateX) {



        if (moveX.equals("moveX")) {
            moveXDirection = inputScanner.next();

            if ((moveXDirection.equals("right")) || (moveXDirection.equals("left")) || (moveXDirection.equals("up")) || (moveXDirection.equals("down"))) {
            }
        }
        return coordinateX;
    }
        private static int isMoveY(String moveX, String moveXDirection, String moveY, Scanner inputScanner,int coordinateY){
        moveY = inputScanner.next();
        if (moveY.equals("moveY")) {
            moveY = inputScanner.next();

            if ((moveY.equals("right")) || (moveY.equals("left")) || (moveY.equals("up")) || (moveY.equals("down"))) {
            }
        }
        return coordinateY;
    }

    private static String isCommandLoad(String commandLoad, String commandUnload, Scanner inputScanner) {
        commandLoad = inputScanner.next();
        String robotArm = "";
        robotArm = inputScanner.next();
        if (commandLoad.equals("load")) {

            if (robotArm.equals("A") || robotArm.equals("B") || robotArm.equals("C")) {

                if (robotArm.equals("A")) {
                    System.out.println("Ръка А е включена успешно, въведете команда 'unload' за изключване на текущата ръка или команда 'next', за да продължите с предвижването и");
                }
                if (robotArm.equals("B")) {
                    System.out.println("Ръка В е включена успешно, въведете команда 'unload' за изключване на текущата ръка или команда 'next', за да продължите с предвижването и");
                }
                if (robotArm.equals("C")) {
                    System.out.println("Ръка С е включена успешно, въведете команда 'unload' за изключване на текущата ръка или команда 'next', за да продължите с предвижването и");
                }
            } else {
                System.out.println("Не разполагате с подобно устройство");
                return isCommandLoad(commandLoad, commandUnload, inputScanner);
            }
        }
            commandUnload=inputScanner.next();
            if (commandUnload.equals("unload")) {
                if (robotArm.equals("A")) {
                    System.out.println("Ръка А е изключена успешно");
                    return isCommandLoad(commandLoad, commandUnload, inputScanner);
                }
                if (robotArm.equals("B")) {
                    System.out.println("Ръка B е изключена успешно");
                    return isCommandLoad(commandLoad, commandUnload, inputScanner);
                }
                if (robotArm.equals("C")) {
                    System.out.println("Ръка C е изключена успешно");
                    return isCommandLoad(commandLoad, commandUnload, inputScanner);
                }
            }
        return robotArm;
    }

        private static boolean isInvalidCommand (String turnOnSystem){
            return !(turnOnSystem.equals("turnon"));
        }

        private static void isTurnOnSystem (String turnOnSystem){

            if (turnOnSystem.equals("turnon")) {
                System.out.println("Системата е включена!");
            } else {
                System.out.println("Озонобъркачката не е включена - включете я преди да правите каквото и да е било");
            }


        }
    }

