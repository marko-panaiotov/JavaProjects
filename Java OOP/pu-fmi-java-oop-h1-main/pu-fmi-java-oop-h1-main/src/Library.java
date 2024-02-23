import java.util.Scanner;

public class Library {
    Scanner scanner=new Scanner(System.in);

    private String name;
    private String address;
    private int libraryStaffCount;
    private String bookList;

    public String getName() {
        System.out.print("Въведете наименование: ");
        name=scanner.next();
        if (name.length() < 100) {
            return name;
        } else {
            System.out.println("Наименованието не трябва да превишава 100 символа. Моля опитайте отново! ");
        }
        return getName();
    }

    public String getAddress() {
        System.out.print("Въведете адрес: ");
        address=scanner.next();

        if (address.length() < 500) {
            return address;
        } else {
            System.out.println("Адресът не трябва да превишава 500 символа. Моля опитайте отново!");
        }
        return getAddress();
    }

    public int getLibraryStaffCount() {
        System.out.print("Въведете брой служители: ");
        libraryStaffCount=scanner.nextInt();

        System.out.println();

        if(libraryStaffCount<50&&libraryStaffCount>0){
            return libraryStaffCount;

        }else{
            System.out.println("Броят на служителите не трябва да е по-голямо от 0 и по-малко от 50! Моля опитайте отново!");
        }
        return getLibraryStaffCount();
    }

    public String getBookList() {
        return bookList;
    }

}
