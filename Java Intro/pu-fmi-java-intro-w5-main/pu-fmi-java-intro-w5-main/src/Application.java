import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Въведете текст за превод");
        String inputText = inputScanner.nextLine();

        String[] specialAlphabetSymbolsArray = {"@(", "!@", "(", "@!", "(-", "!-", "&", "!%", "!", ".!", "!<", "!!", "^^", "%", "()", "!^@", "!.@", "@<", ")(", "/_", "^>", "<!>", "><", "<>", ".=.", "#$"};
        String[] specialPunctuation = {"___", "***", "|...|", "$$$"};

        char digit = 1;
        String translatedCode = "";

        for (int index = 0; index < inputText.length(); index++) {

            char translatedDigit = inputText.charAt(index);
            boolean isUpperCaseLetter = Character.isUpperCase(translatedDigit);
            boolean isSmallerCaseLetter = Character.isLowerCase(translatedDigit);

            if (isSmallerCaseLetter) {
                System.out.print(digitGenerator(translatedDigit, specialAlphabetSymbolsArray));
            }

            if (isUpperCaseLetter) {
                if (isEvenNumber(index)) {
                    System.out.print("[" + digitGenerator(translatedDigit, specialAlphabetSymbolsArray) + "]");
                }
                if (isOddNumber(index)) {
                    System.out.print("{" + digitGenerator(translatedDigit, specialAlphabetSymbolsArray) + "}");
                }
                digit++;

                System.out.print("[(" + (digit - 1) + ")]");
            }

            if (translatedDigit == ' ' && isEvenNumber(index)) {
                System.out.print(specialPunctuation[0]);
                continue;
            }
            if (translatedDigit == ' ' && isOddNumber(index)) {
                System.out.print(specialPunctuation[1]);
                continue;
            }
            if (translatedDigit == '.') {
                System.out.print(specialPunctuation[2]);
                continue;
            }
            if (translatedDigit == '?') {
                System.out.print(specialPunctuation[3]);
                continue;
            }
        }
    }

    public static boolean isOddNumber(int index) {
        return index % 2 != 0;
    }

    public static boolean isEvenNumber(int index) {
        return index % 2 == 0;
    }

    public static String digitGenerator(char digit, String[] specialAlphabet){

        if(digit=='a'||digit=='A'){
            return specialAlphabet[0];
        }
        if(digit=='b'||digit=='B'){
            return specialAlphabet[1];
        }
        if(digit=='c'||digit=='C'){
            return specialAlphabet[2];
        }
        if(digit=='d'||digit=='D'){
            return specialAlphabet[3];
        }
        if(digit=='e'||digit=='E'){
            return specialAlphabet[4];
        }
        if(digit=='f'||digit=='F'){
            return specialAlphabet[5];
        }
        if(digit=='g'||digit=='G'){
            return specialAlphabet[6];
        }
        if(digit=='h'||digit=='H'){
            return specialAlphabet[7];
        }
        if(digit=='i'||digit=='I'){
            return specialAlphabet[8];
        }
        if(digit=='j'||digit=='J'){
            return specialAlphabet[9];
        }
        if(digit=='k'||digit=='K'){
            return specialAlphabet[10];
        }
        if(digit=='l'||digit=='L'){
            return specialAlphabet[11];
        }
        if(digit=='m'||digit=='M'){
            return specialAlphabet[12];
        }
        if(digit=='n'||digit=='N'){
            return specialAlphabet[13];
        }
        if(digit=='o'||digit=='O'){
            return specialAlphabet[14];
        }
        if(digit=='p'||digit=='P'){
            return specialAlphabet[15];
        }
        if(digit=='q'||digit=='Q'){
            return specialAlphabet[16];
        }
        if(digit=='r'||digit=='R'){
            return specialAlphabet[17];
        }
        if(digit=='s'||digit=='S'){
            return specialAlphabet[18];
        }
        if(digit=='t'||digit=='T'){
            return specialAlphabet[19];
        }
        if(digit=='u'||digit=='U'){
            return specialAlphabet[20];
        }
        if(digit=='v'||digit=='V'){
            return specialAlphabet[21];
        }
        if(digit=='w'||digit=='W'){
            return specialAlphabet[22];
        }
        if(digit=='x'||digit=='X'){
            return specialAlphabet[23];
        }
        if(digit=='y'||digit=='Y'){
            return specialAlphabet[24];
        }
        if(digit=='z'||digit=='Z'){
            return specialAlphabet[25];
        }
        return "1";
    }
}
