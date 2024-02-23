import java.util.Random;
import java.util.Scanner;

    public class Application {
        public static void main(String[] args) {

            final int CLIENT_BIRTH_YEAR = 1965;
            final int CURRENT_YEAR = 2022;

            Random randomGenerator = new Random();
            Scanner inputScanner = new Scanner(System.in);

            System.out.println("През коя година сте родени?");
            int birthYear = inputScanner.nextInt();

            //first number
            boolean isClientBirthYearBefore = birthYear < CLIENT_BIRTH_YEAR;
            boolean isClientBirthYearAfter = birthYear > CLIENT_BIRTH_YEAR;
            int clientYears = CURRENT_YEAR - birthYear;
            int firstNonSpecialRandomNumber = (randomGenerator.nextInt(1, 7));
            int firstNonSpecialNumber = clientYears / firstNonSpecialRandomNumber;
            int firstOddNumber = firstNonSpecialNumber / 10;

            //Odd and before client birth year
            if (isClientBirthYearBefore) {

                if (firstOddNumber % 2 != 0) {
                    System.out.println(firstOddNumber);
                } else {
                    firstOddNumber++;
                    System.out.println(firstOddNumber);
                }
            }

            //Even and after client birth year
            int firstEvenNumber = firstNonSpecialNumber / 10;

            if (isClientBirthYearAfter) {

                if (firstEvenNumber % 2 == 0) {
                    System.out.println(firstEvenNumber);
                } else {
                    firstEvenNumber++;
                    System.out.println(firstEvenNumber);
                }
            }
            //Special client birth year
            int firstSpecialNumber = 0;
            boolean isSpecial = birthYear == CLIENT_BIRTH_YEAR;
            if (isSpecial) {
                System.out.println(firstSpecialNumber);
            }
            int firstNumber = firstEvenNumber + firstOddNumber + firstSpecialNumber;

            //Second number

            boolean isFirstSpecial = firstNumber == 0;

            int clientGenderNumber = 0;
            int firstSpecial = 9;
            int secondRandomNumber = 0;
            boolean isSecondNum;

            if (isFirstSpecial) {
                System.out.println(firstSpecial);
            } else {
                System.out.println("Какъв е вашият пол?");
                System.out.println("1 Мъжки");
                System.out.println("3 Женски");
                System.out.println("Предпочитам да не казвам");
                int clientGender = inputScanner.nextInt();

                clientGenderNumber = (clientGender == 1) ? 1 :
                        (clientGender == 3) ? 3 :
                                0;

                if (clientGender != 1 && clientGender != 3) {
                    secondRandomNumber = (randomGenerator.nextInt(1, 9));
                    isSecondNum = secondRandomNumber != 1 && secondRandomNumber != 3;

                    if (isSecondNum) {
                        System.out.println(secondRandomNumber);
                    }
                }
            }
            int secondNumber = secondRandomNumber + clientGenderNumber;

            //Third Number
            System.out.println("Пълнолетни ли сте? Y/N");
            String adult = inputScanner.next();

            int lastDigit1 = 0;
            int lastDigit2 = 0;
            int secondLastDigit = 0;
            int zero = 0;
            if (adult.equals("Y")) {
                System.out.println(zero);
            } else {
                System.out.println("Въведете годината на раждане на майка ви:");
                int momBirthYear = inputScanner.nextInt();
                System.out.println("Въведете годината на раждане на баща ви:");
                int dadBirthYear = inputScanner.nextInt();

                lastDigit1 = momBirthYear % 10;
                lastDigit2 = dadBirthYear % 10;

                if (lastDigit1 == lastDigit2) {
                    int lastDigit = momBirthYear / 10;
                    secondLastDigit = lastDigit % 10;
                    System.out.println(secondLastDigit);
                }
                if (lastDigit1 != lastDigit2) {
                    System.out.println(lastDigit2);
                }
            }
            int thirdNumber = lastDigit1 + lastDigit2 + secondLastDigit;

            //Forth Number
            System.out.println("Въведете вашата височина в сантиметри:");
            int clientHeight = inputScanner.nextInt();
            System.out.println("Въведете вашето тегло:");
            int clientWeight = inputScanner.nextInt();

            int clientHeightAndWeight = (clientHeight * clientHeight) / clientWeight;

            final double UNDER_NORM = 16;
            final double NORMAL = 16.99;
            final double NORMAL_ATHLETIC = 17;
            final double NORMAL_ATHLETIC1 = 18.49;
            final double NORMAL_1 = 18.5;
            final double NORMAL_2 = 24.99;
            final double POST_OVER_NORM = 25;
            final double POST_OVER_NORM_1 = 29.99;
            final double OVER_NORM_THICK = 30;
            final double OVER_NORM_THICK_1 = 34.99;
            final double OVER_NORM_FAT = 35;
            final double OVER_NORM_FAT_1 = 39.99;
            final double OVER_NORM_MEGA_FAT = 40;

            boolean isUnderNorm = clientHeightAndWeight < UNDER_NORM;
            boolean isNormal = UNDER_NORM < clientHeightAndWeight && NORMAL > clientHeightAndWeight;
            boolean isNormalAthletic = NORMAL_ATHLETIC < clientHeightAndWeight && NORMAL_ATHLETIC1 > clientHeightAndWeight;
            boolean isNormal1 = NORMAL_1 < clientHeightAndWeight && NORMAL_2 > clientHeightAndWeight;
            boolean isPostOverNorm = POST_OVER_NORM < clientHeightAndWeight & POST_OVER_NORM_1 > clientHeightAndWeight;
            boolean isOverNormThick = OVER_NORM_THICK < clientHeightAndWeight && OVER_NORM_THICK_1 > clientHeightAndWeight;
            boolean isOverNormFat = OVER_NORM_FAT < clientHeightAndWeight && OVER_NORM_FAT_1 > clientHeightAndWeight;
            boolean isOverNormMegaFat = clientHeightAndWeight > OVER_NORM_MEGA_FAT;

            int clientInfo = (isUnderNorm) ? 1 :
                    (isNormal) ? 2 :
                            (isNormalAthletic) ? 3 :
                                    (isNormal1) ? 4 :
                                            (isPostOverNorm) ? 5 :
                                                    (isOverNormThick) ? 6 :
                                                            (isOverNormFat) ? 7 :
                                                                    (isOverNormMegaFat) ? 8 :
                                                                            0;
            System.out.println(clientInfo);

            //Fifth Number
            System.out.println("Моля изберете един от видовете стоки:");
            System.out.println("1.Плодове и зеленчуци");
            System.out.println("2.Месо и месни продукти");
            System.out.println("3.Цигари и алкохол");
            System.out.println("4.Млечни продукти");
            System.out.println("5.Захарни изделия");
            int stockChoiceNumber = inputScanner.nextInt();

            int stockChoice = (stockChoiceNumber == 1) ? 1 :
                    (stockChoiceNumber == 2) ? 2 :
                            (stockChoiceNumber == 3) ? 3 :
                                    (stockChoiceNumber == 4) ? 4 :
                                            (stockChoiceNumber == 5) ? 5 :
                                                    0;

            System.out.println("Моля изберете колко често купувате избраният от Вас продукт!");
            System.out.println("1-рядко");
            System.out.println("2-понякога");
            System.out.println("3-често");
            int frequencyOfStock = inputScanner.nextInt();

            int frequencyOfStockChoice = (frequencyOfStock == 1) ? 1 :
                    (frequencyOfStock == 2) ? 2 :
                            (frequencyOfStock == 3) ? 3 :
                                    0;

            int sumOfStockAndFrequency = stockChoice + frequencyOfStockChoice;
            System.out.println(sumOfStockAndFrequency);

            //Sixth Number
            int sixthNumber = firstNumber + secondNumber + thirdNumber + clientInfo + sumOfStockAndFrequency;
            boolean isSixthNumber = sixthNumber < 10;
            boolean isSixthNumber1 = 10 < sixthNumber;

            if (isSixthNumber) {
                System.out.println(sixthNumber - 1);
            }
            if (isSixthNumber1) {
                int firstNumberOfSixth = sixthNumber % 10;
                int firstCombineNumber = sixthNumber / 10;
                sixthNumber = firstNumberOfSixth + firstCombineNumber;
                System.out.println(sixthNumber);
            }

            //Seventh number
            int seventhNumber = 0;

            if (firstNumber % 2 == 0 && secondNumber % 2 == 0 && sumOfStockAndFrequency % 2 == 0) {
                System.out.println(seventhNumber);
            }
            if (firstNumber < secondNumber && thirdNumber < clientInfo && sumOfStockAndFrequency < sixthNumber) {
                seventhNumber = 5;
                System.out.println(seventhNumber);
            } else if (firstNumber % 2 != 0 && secondNumber % 2 != 0 && sumOfStockAndFrequency % 2 != 0) {
                seventhNumber = 1;
                System.out.println(seventhNumber);
            }
            if (firstNumber % 2 == 0 || secondNumber % 2 == 0 || sumOfStockAndFrequency % 2 == 0) {
                seventhNumber = 2;
                System.out.println(seventhNumber);
            }
            if (firstNumber % 2 == 0 && secondNumber % 2 == 0 || thirdNumber % 2 != 0 && clientInfo % 2 != 0 && sumOfStockAndFrequency % 2 != 0) {
                seventhNumber = 3;
                System.out.println(seventhNumber);
            }
            if (firstNumber == secondNumber && thirdNumber == clientInfo && sumOfStockAndFrequency == sixthNumber) {
                seventhNumber = 4;
                System.out.println(seventhNumber);
            }

            if (firstNumber + secondNumber + thirdNumber + clientInfo + sumOfStockAndFrequency + sixthNumber < 10) {
                seventhNumber = 6;
                System.out.println(seventhNumber);
            }
            if (firstNumber + secondNumber + thirdNumber + clientInfo + sumOfStockAndFrequency + sixthNumber > 10) {
                seventhNumber = 7;
                System.out.println(seventhNumber);
            }
            if (seventhNumber != 0 && seventhNumber != 1 && seventhNumber != 2 && seventhNumber != 3 && seventhNumber != 4 && seventhNumber != 5 && seventhNumber != 6 && seventhNumber != 7) {
                seventhNumber = 9;
                System.out.println(seventhNumber);
            }

            //Eight Number
            int eightNumber = 0;

            if (adult.equals("Y") && isOverNormFat && isOverNormThick && isOverNormMegaFat && stockChoiceNumber == 5 && frequencyOfStock == 3) {
                int eightRandomNumber = (randomGenerator.nextInt(1, 9));
                if (eightRandomNumber % 2 != 0) {
                    eightNumber = eightRandomNumber;
                    System.out.println(eightNumber);
                } else {
                    eightNumber = eightRandomNumber;
                    eightNumber++;
                    System.out.println(eightNumber);
                }

            } else {
                System.out.println(eightNumber);
            }
            if (adult.equals("N") && isNormalAthletic && stockChoiceNumber == 1 && frequencyOfStock == 1) {
                int eightRandomNumber = (randomGenerator.nextInt(1, 9));
                if (eightRandomNumber % 2 == 0) {
                    eightNumber = eightRandomNumber;
                    System.out.println(eightNumber);
                } else {
                    eightNumber = eightRandomNumber;
                    eightNumber++;
                    System.out.println(eightNumber);
                }
            } else {
                System.out.println(eightNumber);
            }

            //Ninth Number
            int a = Math.max(firstNumber, secondNumber);
            a = Math.max(thirdNumber, clientInfo);
            a = Math.max(sumOfStockAndFrequency, sixthNumber);
            a = Math.max(seventhNumber, eightNumber);
            //System.out.println(a);

            int b = Math.min(firstNumber, clientInfo);
            b = Math.min(thirdNumber, clientInfo);
            b = Math.min(sumOfStockAndFrequency, sixthNumber);
            b = Math.min(seventhNumber, eightNumber);
            // System.out.println(b);

            if (a > b) {
                a++;
                System.out.println(a);
                if (a == 0 || a == 9) {
                    if (a == 0) {
                        System.out.println(1);
                    }
                    if (a == 9) {
                        System.out.println(0);
                    }
                }
            }
            if (a < b) {
                a--;
                System.out.println(a);
                if (a == 0 || a == 9) {
                    if (a == 0) {
                        System.out.println(1);
                    }
                    if (a == 9) {
                        System.out.println(0);
                    }
                }
            }
            boolean isEquals = a == b;
            if (isEquals) {
                if (a == 0 || a == 9 && b == 0 || b == 9) {
                    if (a == 0) {
                        System.out.println(1);
                    }
                    if (a == 9) {
                        System.out.println(0);
                    }
                    if (b == 0) {
                        System.out.println(1);
                    }
                    if (b == 9) {
                        System.out.println(0);
                    }
                }
                System.out.println(0);
            }

            //barcode
            boolean isFirstSymbol = firstNumber == 0 || secondNumber == 0 || thirdNumber == 0 || clientInfo == 0 || sumOfStockAndFrequency == 0 || sixthNumber == 0 || seventhNumber == 0 || eightNumber == 0 || a == 0 || b == 0;
            boolean isSecondSymbol = firstNumber == 1 || secondNumber == 1 || thirdNumber == 1 || clientInfo == 1 || sumOfStockAndFrequency == 1 || sixthNumber == 1 || seventhNumber == 1 || eightNumber == 1 || a == 1 || b == 1;
            boolean isThirdSymbol = firstNumber == 2 || secondNumber == 2 || thirdNumber == 2 || clientInfo == 2 || sumOfStockAndFrequency == 2 || sixthNumber == 2 || seventhNumber == 2 || eightNumber == 2 || a == 2 || b == 2;
            boolean isForthSymbol = firstNumber == 3 || secondNumber == 3 || thirdNumber == 3 || clientInfo == 3 || sumOfStockAndFrequency == 3 || sixthNumber == 3 || seventhNumber == 3 || eightNumber == 3 || a == 3 || b == 3;
            boolean isFifthSymbol = firstNumber == 4 || secondNumber == 4 || thirdNumber == 4 || clientInfo == 4 || sumOfStockAndFrequency == 4 || sixthNumber == 4 || seventhNumber == 4 || eightNumber == 4 || a == 4 || b == 4;
            boolean isSixthSymbol = firstNumber == 5 || secondNumber == 5 || thirdNumber == 5 || clientInfo == 5 || sumOfStockAndFrequency == 5 || sixthNumber == 5 || seventhNumber == 5 || eightNumber == 5 || a == 5 || b == 5;
            boolean isSeventhSymbol = firstNumber == 6 || secondNumber == 6 || thirdNumber == 6 || clientInfo == 6 || sumOfStockAndFrequency == 6 || sixthNumber == 6 || seventhNumber == 6 || eightNumber == 6 || a == 6 || b == 6;
            boolean isEightSymbol = firstNumber == 7 || secondNumber == 7 || thirdNumber == 7 || clientInfo == 7 || sumOfStockAndFrequency == 7 || sixthNumber == 7 || seventhNumber == 7 || eightNumber == 7 || a == 7 || b == 7;
            boolean isNinthSymbol = firstNumber == 8 || secondNumber == 8 || thirdNumber == 8 || clientInfo == 8 || sumOfStockAndFrequency == 8 || sixthNumber == 8 || seventhNumber == 8 || eightNumber == 8 || a == 8 || b == 8;
            boolean isTenthSymbol = firstNumber == 9 || secondNumber == 9 || thirdNumber == 9 || clientInfo == 9 || sumOfStockAndFrequency == 9 || sixthNumber == 9 || seventhNumber == 9 || eightNumber == 9 || a == 9 || b == 9;


            if (isFirstSymbol) {
                System.out.print("*");
            }
            if (isSecondSymbol) {
                System.out.print("!");
            }
            if (isThirdSymbol) {
                System.out.print("@");
            }
            if (isForthSymbol) {
                System.out.print("#");
            }
            if (isFifthSymbol) {
                System.out.print("$");
            }
            if (isSixthSymbol) {
                System.out.print("%");
            }
            if (isSeventhSymbol) {
                System.out.print("^");
            }
            if (isEightSymbol) {
                System.out.print("&");
            }
            if (isNinthSymbol) {
                System.out.print("/");
            }
            if (isTenthSymbol) {
                System.out.print("+");
            }
        }
    }
