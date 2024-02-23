public class Application{
    
    public static void main(String[] args) {
        int agePerson;
        agePerson = 20;

        String dayMonday="Monday";
        String dayTuesday="Tuesday";
        String dayWednesday="Wednesday";
        String dayThursday="Thursday";
        String dayFriday="Friday";
        String daySaturday="Saturday";
        String daySunday = "Sunday";

        boolean isOpenedMonday=true;
        boolean isOpenedTuesday=true;
        boolean isOpenedWednesday=true;
        boolean isOpenedThursday=true;
        boolean isOpenedFriday=true;
        boolean isClosedSaturday=false;
        boolean isClosedSunday = false;
        
        int visitorsOnMonday = 1000;
        int visitorsOnTuesday = 2000;
        int visitorsOnWednesday = 3000;
        int visitorsOnThursday = 4000;
        int visitorsOnFriday = 5000;
        
        double totalPriceMonday = 1203.5;
        double totalPriceTuesday = 2203.5;
        double totalPriceWednesday = 3203.5;
        double totalPriceThursday = 4203.5;
        double totalPriceFriday = 5203.5;

        String verticalSeparator="|";

        System.out.println(verticalSeparator + dayMonday + verticalSeparator + isOpenedMonday + verticalSeparator
                + visitorsOnMonday + verticalSeparator + totalPriceMonday);

        String format = "|%10s||%10s||%10s||%10s|";

        System.out.format(format, dayMonday, isOpenedMonday, visitorsOnMonday, totalPriceMonday);
        System.out.println();

        System.out.format(format, dayTuesday, isOpenedTuesday, visitorsOnTuesday, totalPriceTuesday);

        System.out.println();

        System.out.format(format, dayWednesday, isOpenedWednesday, visitorsOnWednesday, totalPriceWednesday);

        System.out.println();

        System.out.format(format, dayThursday, isOpenedThursday, visitorsOnThursday, totalPriceThursday);

        System.out.println();

        System.out.format(format, dayFriday, isOpenedFriday, visitorsOnFriday, totalPriceFriday);

        System.out.println();

        System.out.format(format, daySaturday, isClosedSaturday, 0, 0);

        System.out.println();
        
        System.out.format(format, daySunday, isClosedSunday, 0, 0);
    }

    
}