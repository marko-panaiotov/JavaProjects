public class Application {
    public static void main(String[]args){

        System.out.println("Мазе бот v1 на вашите услуги");

        String firstName="Марко";
        String secondName="Панайотов";
        int uniqueNum=2101261068;
        int age=19;

        System.out.println("Добре дошъл в мазето на баба " + " " + firstName + " " + secondName);
        System.out.println("Ти се идентифицира с номер " + " " + uniqueNum);
        System.out.println("Ти си на " + " " + age + " " + "години");

        String appleWine="Ябълково вино";
        String smokedMeat="Пушено месо";
        String plumJam="Сливов мармалад";
        String marinatedPeppers="Мариновани чушки";
        String piggyBank="Прасенце касичка";

        int quantityOfAppleWine=10;
        int quantityOfSmokedMeat=5;
        int quantityOfPlumJam=9;
        int quantityOfMarinatedPeppers=4;
        double quantityOfPiggyBank=184.35;

        String lotNumOfAppleWine="C7544_10";
        String lotNumOfSmokedMeat="M7441_5";
        String lotNumOfPlumJam="S6491_9";
        String lotNumOfMarinatedPeppers="P7485_4";
        String lotNumOfPiggyBank="B6584_184.35";

        System.out.println("Отчет за продуктите в мазето");
        System.out.println("=====================================");

        String format="|%-10s |%-10s |%-10s |";

        System.out.format(format,"Продукт","Брой","Нов сериен номер");
        System.out.println();
        System.out.println("=====================================");
        System.out.format(format,appleWine,quantityOfAppleWine,lotNumOfAppleWine);
        System.out.println();
        System.out.format(format,smokedMeat,quantityOfSmokedMeat,lotNumOfSmokedMeat);
        System.out.println();
        System.out.format(format,plumJam,quantityOfPlumJam,lotNumOfPlumJam);
        System.out.println();
        System.out.format(format,marinatedPeppers,quantityOfMarinatedPeppers,lotNumOfMarinatedPeppers);
        System.out.println();
        System.out.format(format,piggyBank,quantityOfPiggyBank,lotNumOfPiggyBank);
        System.out.println();
        System.out.println("=====================================");



    }
}
