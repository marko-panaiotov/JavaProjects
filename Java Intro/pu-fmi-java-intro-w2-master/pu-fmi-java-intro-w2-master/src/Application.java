import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        final String POSITIVE_ANSWER = "Y";
        final String NEGATIVE_ANSWER = "N";

        final int MEAT_DISH_NUMBER = 1;
        final int VEGETARIAN_DISH_NUMBER = 2;
        final int DESERT_NUMBER = 3;

        final int MINIMUM_AIR_TEMPERATURE = 36;
        final int MAXIMUM_AIR_TEMPERATURE = 48;

        System.out.println("Добре дошли!");

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Колко тигана има в кухнята?");
        int requiredQuestion1 = inputScanner.nextInt();
        System.out.println("Колко тенджери има в кухнята?");
        int requiredQuestion2 = inputScanner.nextInt();
        System.out.println("Колко сантиметра е широка кухнята?");
        int requiredQuestion3 = inputScanner.nextInt();
        System.out.println("Колко сантиметра е дълга кухнята?");
        int requiredQuestion4 = inputScanner.nextInt();
        System.out.println("Колко сантиметра е висока кухнята?");
        int requiredQuestion5 = inputScanner.nextInt();
        System.out.println("Как се казва главния готвач?");
        String requiredQuestion6 = inputScanner.next();
        System.out.println("Колко готвачи работят в кухнята?");
        int requiredQuestion7 = inputScanner.nextInt();
        System.out.println("Колко сервитьори работят в ресторанта?");
        int requiredQuestion8 = inputScanner.nextInt();
        System.out.println("Как се казва отговорника на сосовете?");
        String requiredQuestion9 = inputScanner.next();
        System.out.println("Каква е минималната температура в кухнята?");
        int requiredQuestion10 = inputScanner.nextInt();
        System.out.println("Каква е максималната температура в кухнята?");
        int requiredQuestion11 = inputScanner.nextInt();
        System.out.println("Колко парички имате в банковата си сметка?");
        int requiredQuestion12 = inputScanner.nextInt();
        System.out.println("Колко парички е дневния оборот на ресторанта ви?");
        int requiredQuestion13 = inputScanner.nextInt();
        System.out.println("В колко часа отваряте?");
        int requiredQuestion14 = inputScanner.nextInt();
        System.out.println("В колко часа затваряте?");
        int requiredQuestion15 = inputScanner.nextInt();

        System.out.println("Желаете ли да отговаряте на опционални въпроси?" + "(Y/N)");
        String optionalQuestion = inputScanner.next();
        String optionalQuestion1 = " ";
        String optionalQuestion2 = " ";
        String optionalQuestion3 = " ";
        String optionalQuestion4 = " ";
        String optionalQuestion5 = " ";

        if (optionalQuestion.equals(POSITIVE_ANSWER)) {
            System.out.println("Разполагате ли с хладилник?" + "(Y/N)");
            optionalQuestion1 = inputScanner.next();
            System.out.println("Разполагате ли с газов котлон?" + "(Y/N)");
            optionalQuestion2 = inputScanner.next();
            System.out.println("Разполагате ли с конвектомат?" + "(Y/N)");
            optionalQuestion3 = inputScanner.next();
            System.out.println("Разполагате ли с електрическа скара?" + "(Y/N)");
            optionalQuestion4 = inputScanner.next();
            System.out.println("Разполагате ли с аспиратор?" + "(Y/N)");
            optionalQuestion5 = inputScanner.next();
            System.out.println("Всички въпроси са зададени.");
        } else if (optionalQuestion.equals(NEGATIVE_ANSWER)) {
            System.out.println("Всички въпроси са зададени.");
        }

        System.out.println();
        System.out.println("Какво ще хапвате?");
        System.out.println("(1) Месно ястие");
        System.out.println("(2) Вегетарианско ястие");
        System.out.println("(3) Десерт");

        int dishNumber = inputScanner.nextInt();

        boolean isMeatDish = dishNumber == MEAT_DISH_NUMBER;
        boolean isVegetarianDish = dishNumber == VEGETARIAN_DISH_NUMBER;
        boolean isDesert = dishNumber == DESERT_NUMBER;

        if (isMeatDish) {
            System.out.println("Колко голяма порция предпочитате?");
            System.out.println("(1) малка порция (450 грама)");
            System.out.println("(2) средна порция (750 грама)");
            System.out.println("(3) голяма порция (950 грама)");

            int meatDishPortion = inputScanner.nextInt();

            String meatDishPortionSize = (meatDishPortion == 1) ? "Малка 450 грама" :
                    (meatDishPortion == 2) ? "Средна 750 грама" :
                            (meatDishPortion == 3) ? "Голяма 950 грама" :
                                    " За жалост нямаме такова ястие";

            System.out.println("Каква разновидност на изпичане желаете?");
            System.out.println("(1) RARE");
            System.out.println("(2) MEDIUM");
            System.out.println("(3) WELL DONE");

            int meatDishBaking = inputScanner.nextInt();

            String meatDishBakingWay = (meatDishBaking == 1) ? "RARE" :
                    (meatDishBaking == 2) ? "MEDIUM" :
                            (meatDishBaking == 3) ? "WELL DONE" :
                                    " За жалост нямаме такова ястие";

            final int MEAT_DISH_PORTION_SIZE_SMALL = 1;
            final int MEAT_DISH_PORTION_SIZE_MEDIUM = 2;
            final int MEAT_DISH_PORTION_SIZE_BIG = 3;
            final int MEAT_DISH_BAKING_WAY_RARE = 1;
            final int MEAT_DISH_BAKING_WAY_MEDIUM = 2;
            final int MEAT_DISH_BAKING_WAY_WELL_DONE = 3;

            //For RARE MEAT
            boolean isGasStove = optionalQuestion2.equals(NEGATIVE_ANSWER);
            boolean isElectricBbq = optionalQuestion4.equals(POSITIVE_ANSWER);
            boolean isAspirator = optionalQuestion5.equals(POSITIVE_ANSWER);
            boolean isMeatDish1 = meatDishBaking == MEAT_DISH_BAKING_WAY_RARE;
            boolean isMeatDishPortion1 = meatDishPortion == MEAT_DISH_PORTION_SIZE_SMALL;
            boolean isIntervalOfAir = (MINIMUM_AIR_TEMPERATURE < requiredQuestion10) &&
                    (requiredQuestion11 < MAXIMUM_AIR_TEMPERATURE);
            boolean airAndAspirator = isAspirator && isIntervalOfAir;
            boolean electricBbqAndGasStove = isElectricBbq && isGasStove;

            if (isMeatDish1) {
                if (isMeatDishPortion1) {
                    if (airAndAspirator && electricBbqAndGasStove) {
                        System.out.println("Вашата поръчка е взета, моля изчакайте!");
                        System.out.println("Избраното от вас месно ястие е:" + " " + meatDishPortion + "със степен на изпичане"+ " " + meatDishBaking);
                    } else {
                        System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                    }
                }
            }

            //For MEDIUM MEAT
            final int KITCHEN_STAFF = 5;
            final String CHEF_SPECIAL_NAME = "Иван";

            boolean isMeatDish2 = meatDishBaking == MEAT_DISH_BAKING_WAY_MEDIUM;
            boolean isMeatDishPortion2 = meatDishPortion == MEAT_DISH_PORTION_SIZE_MEDIUM;
            boolean isChefNameIsSpecial = requiredQuestion6.equals(CHEF_SPECIAL_NAME);
            boolean isKitchenStaffIsEnough = requiredQuestion7 == KITCHEN_STAFF;
            boolean isCombiOven = optionalQuestion3.equals(POSITIVE_ANSWER);

            if (isMeatDish2) {
                if (isMeatDishPortion2 || isChefNameIsSpecial || isKitchenStaffIsEnough || isCombiOven) {
                    System.out.println("Вашата поръчка е взета, моля изчакайте!");
                    System.out.println("Избраното от вас месно ястие е:" + " " + meatDishPortion + "със степен на изпичане"+ " " + meatDishBaking);
                } else {
                    System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение. ");
                }
            }

            //For WELL DONE
            final int KITCHEN_AREA = 4500;
            final int WORKING_TIME = 22;
            final String SAUCE_STAFF_1 = "Петър";
            final String SAUCE_STAFF_2 = "Радо";
            final int PAN = 3;
            final int POT = 2;

            boolean isMeatDish3 = meatDishBaking == MEAT_DISH_BAKING_WAY_WELL_DONE;
            boolean isKitchenArea = requiredQuestion3 + requiredQuestion4 + requiredQuestion5 == KITCHEN_AREA;
            boolean isWorkingTime = requiredQuestion15 <= WORKING_TIME;
            boolean isSauceStaff1 = requiredQuestion9.equals(SAUCE_STAFF_1);
            boolean isSauceStaff2 = requiredQuestion9.equals(SAUCE_STAFF_2);
            boolean isPan = requiredQuestion1 == PAN;
            boolean isPot = requiredQuestion2 == POT;
            if (isMeatDish3) {
                if (isWorkingTime || isSauceStaff1 || isSauceStaff2 && isKitchenArea || isPan || isPot) {
                    System.out.println("Вашата поръчка е взета, моля изчакайте!");
                    System.out.println("Избраното от вас месно ястие е:" + " " + meatDishPortion + "със степен на изпичане"+ " " + meatDishBaking);
                } else {
                    System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                }
            }
        }
        if (isVegetarianDish) {
            System.out.println("Какво ястие си избирате?");
            System.out.println("(1) Вегетаринско");
            System.out.println("(2) Веганско");
            System.out.println("(3) Пескатерианско");

            int vegetarianDish = inputScanner.nextInt();

            String vegetarianDishChoice = (vegetarianDish == 1) ? "Вегетариaнско" :
                    (vegetarianDish == 2) ? "Веганско" :
                            (vegetarianDish == 3) ? "Пескатерианско" :
                                    " За жалост нямаме такова ястие";

            boolean vegetarianDishChoice1 = vegetarianDish == 1;
            boolean vegetarianDishChoice2 = vegetarianDish == 2;
            boolean vegetarianDishChoice3 = vegetarianDish == 3;

            boolean isFurnace = optionalQuestion3.equals(NEGATIVE_ANSWER);
            boolean isBbq = optionalQuestion4.equals(NEGATIVE_ANSWER);
            boolean isAspirator = optionalQuestion5.equals(NEGATIVE_ANSWER);

            if (vegetarianDishChoice1) {
                if (isAspirator || isBbq || isFurnace) {
                    System.out.println("Вашата поръчка е взета, моля изчакайте!");
                    System.out.println("Избраното от вас ястие е:" +" "+vegetarianDishChoice);
                } else {
                    System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение. ");
                }
            }

            final String CHEF_OF_KITCHEN_NAME = "Манол";
            final int MIN_CHEFS = 3;
            final int MAX_CHEFS = 11;
            final int WAITER = 7;

            boolean isFridge = optionalQuestion1.equals(POSITIVE_ANSWER);
            boolean isNameOfChef = requiredQuestion6.equals(CHEF_OF_KITCHEN_NAME);
            boolean isNecessaryChefs = (requiredQuestion7 >= MIN_CHEFS)
                    &&
                    (requiredQuestion7 <= MAX_CHEFS);
            boolean isWaiter = (WAITER < requiredQuestion8)
                    ||
                    (WAITER > requiredQuestion8);

            if (vegetarianDishChoice2) {
                if (isFridge && isNameOfChef && isNecessaryChefs && isWaiter) {
                    System.out.println("Вашата поръчка е взета, моля изчакайте!");
                    System.out.println("Избраното от вас ястие е:" +" "+vegetarianDishChoice);
                } else {
                    System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                }
            }

            final int SUM_OF_ALL_MONEY = 158000;
            final double CUBIC_METER = 13;
            boolean bbq = optionalQuestion4.equals(POSITIVE_ANSWER);
            boolean answerAllOptionalQuestions = optionalQuestion.equals(POSITIVE_ANSWER);
            int sumOfMoney = requiredQuestion12 + requiredQuestion13;
            boolean allMoney = SUM_OF_ALL_MONEY > sumOfMoney;
            double cubic = requiredQuestion3 * requiredQuestion4 * requiredQuestion5;
            double cubicSum = cubic / 1000;
            boolean cubicMeter = CUBIC_METER < cubicSum;

            if (vegetarianDishChoice3) {
                if (bbq || answerAllOptionalQuestions && allMoney || cubicMeter) {
                    System.out.println("Вашата поръчка е взета, моля изчакайте!");
                    System.out.println("Избраното от вас ястие е:" +" "+vegetarianDishChoice);
                } else {
                    System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                }
            }
        }
        String sugarManiac = " ";
        if (isDesert) {
            System.out.println("Престрастени ли сте към захар?");
            sugarManiac = inputScanner.next();

            if (sugarManiac.equals(POSITIVE_ANSWER)) {
                System.out.println("Неможем да ви приготвим десерт, щом сте пристрастени към захар!");
            } else if (sugarManiac.equals(NEGATIVE_ANSWER)) {

                System.out.println("Какво ястие си избирате?");
                System.out.println("(1) Торта");
                System.out.println("(2) Сладолед");

                int desert = inputScanner.nextInt();

                String desertChoice = (desert == 1) ? "Торта" :
                        (desert == 2) ? "Сладолед" :
                                " За жалост нямаме такова ястие";

                boolean desertChoice1 = desert == 1;
                boolean desertChoice2 = desert == 2;

                // For Cake
                if (desertChoice1) {

                    final int WORKING_TIME_TO = 19;
                    final int MIN_MONEY_IN_THE_BANK = 15000;
                    final int MAX_MONEY_IN_THE_BANK = 50000;
                    final String NAME_OF_MASTER_CHEF_OF_THE_ICE_CREAM = "Румен";

                    boolean isFridge = optionalQuestion1.equals(POSITIVE_ANSWER);
                    boolean workingTimeTo = requiredQuestion15 == WORKING_TIME_TO;
                    boolean isAspirator = optionalQuestion5.equals(NEGATIVE_ANSWER);
                    boolean moneyInTheBank = (MIN_MONEY_IN_THE_BANK <= requiredQuestion12)
                            &&
                            (requiredQuestion12 <= MAX_MONEY_IN_THE_BANK);
                    boolean nameOfMasterOfTheIceCream = requiredQuestion6.equals(NAME_OF_MASTER_CHEF_OF_THE_ICE_CREAM);

                    if (isFridge && workingTimeTo && isAspirator && moneyInTheBank || nameOfMasterOfTheIceCream) {
                        System.out.println("Вашата поръчка е взета, моля изчакайте!");
                        System.out.println("Избраният от вас десерт е:" +" "+desertChoice);
                    } else {
                        System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                    }
                }

                //For ice-cream
                if (desertChoice2) {
                    System.out.println("Какъв сладолед си избирате?");
                    System.out.println("(1) Ягода");
                    System.out.println("(2) Банан");
                    System.out.println("(3) Ванилия");

                    int iceCreamChoice = inputScanner.nextInt();

                    String iceCreamKindChoice = (iceCreamChoice == 1) ? "Ягода" :
                            (iceCreamChoice == 2) ? "Банан" :
                                    (iceCreamChoice == 3) ? "Ванилия" :
                                            " За жалост нямаме такова ястие";

                    boolean isIceCreamKindChoice1 = iceCreamChoice == 1;
                    boolean isIceCreamKindChoice2 = iceCreamChoice == 2;
                    boolean isIceCreamKindChoice3 = iceCreamChoice == 3;

                    if (isIceCreamKindChoice1) {
                        boolean isNotSugarManiac = sugarManiac.equals(NEGATIVE_ANSWER);
                        boolean isStrawberryChoice = iceCreamChoice == 1;
                        if (isNotSugarManiac || isStrawberryChoice) {
                            System.out.println("Вашата поръчка е взета, моля изчакайте!");
                            System.out.println("Избраният от вас десерт е:" +" "+desertChoice +" "+ iceCreamKindChoice);
                        } else {
                            System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                        }
                    }
                    if (isIceCreamKindChoice2) {
                        boolean isNotSugarManiac = sugarManiac.equals(NEGATIVE_ANSWER);
                        boolean isStrawberryChoice = iceCreamChoice == 1;
                        if (isNotSugarManiac || isStrawberryChoice) {
                            System.out.println("Вашата поръчка е взета, моля изчакайте!");
                            System.out.println("Избраният от вас десерт е:" +" "+desertChoice +" "+ iceCreamKindChoice);
                        } else {
                            System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                        }
                    }
                    if (isIceCreamKindChoice3) {
                        boolean isNotSugarManiac = sugarManiac.equals(NEGATIVE_ANSWER);
                        boolean isStrawberryChoice = iceCreamChoice == 1;
                        if (isNotSugarManiac || isStrawberryChoice) {
                            System.out.println("Вашата поръчка е взета, моля изчакайте!");
                            System.out.println("Избраният от вас десерт е:" +" "+desertChoice +" "+ iceCreamKindChoice);
                        } else {
                            System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
                        }
                    }
                }
            }
        }

        boolean isExitMessage= isMeatDish|| isVegetarianDish||isDesert;
        if(isExitMessage){
            System.out.println("Благодаря Ви, че хапнахте при нас.");
        }else {
            System.out.println("Ресторантът не може да изпълни вашата поръчка, започваме процедура по самоунищожение.");
        }

    }
    }