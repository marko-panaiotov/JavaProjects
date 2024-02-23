import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books{

    Scanner scanner=new Scanner(System.in);
    List<String> bookList= new ArrayList<>();
    ArrayList<String>bookList1= new ArrayList<>();

    private String title;
    private String genre;
    private String author;
    private String publisher;
    private int yearOfPublisher;
    private String ISBN;
    private int numberOfPages;
    private String language;
    private String availability;
    private int dateOfGet;
    private int dateOfReturn;
    private int collectionPeriod;
    private int howTimesBookWasTaken;

    public Books(){

    }

    public String getTitle() {
        System.out.println("Въведете заглавие: ");
        this.title= scanner.next();
        if (this.title.length()<100){
            return this.title;
        }else{
            System.out.println("Некоректни данни!");
            return getTitle();
        }
    }

    public String getGenre() {
        System.out.println("Въведете жанр: ");
        genre=scanner.next();
        return genre;
    }

    public String getAuthor() {
        System.out.println("Въведете автор: ");
        author=scanner.next();
        if (author.length()<50){
            return author;
        }else{
            System.out.println("Некоректни данни!");
        }
        return getAuthor();
    }

    public String getPublisher() {
        System.out.println("Въведете издателство: ");
        publisher=scanner.next();
        return publisher;
    }

    public int getYearOfPublisher() {
        System.out.println("Въведете година на издаване: ");
        yearOfPublisher=scanner.nextInt();

        if (yearOfPublisher>0&&yearOfPublisher<2022){
            return yearOfPublisher;
        }
        return getYearOfPublisher();
    }

    public String getISBN() {
        System.out.println("Въведете ISBN номер: ");
        ISBN=scanner.next();

        if (ISBN.length()<10){
            return ISBN;
        }
        return getISBN();
    }

    public int getNumberOfPages() {
        System.out.println("Въведете брой страници: ");
        numberOfPages=scanner.nextInt();

        if (numberOfPages>-1&&numberOfPages>0){
            return numberOfPages;
        }else {
            System.out.println("Некоректни данни! ");
        }
        return getNumberOfPages();
    }

    public String getLanguage() {
        System.out.println("Въведете език на книгата: ");
        language=scanner.next();
        return language;
    }

    public String getAvailability() {
        System.out.println("Налична ли е книгата (Да/Не): ");
        availability=scanner.next();

        if (availability.equals("Да")){
            return "Книгата е налична";
        }
        else if (availability.equals("Не")){
            return "Книгата не е налична";
        }
        return getAvailability();
    }

    public int getDateOfGet() {
        System.out.println("На коя дата е взета книгата ");
        dateOfGet=scanner.nextInt();
        return dateOfGet;
    }

    public int getDateOfReturn() {
        System.out.println("На коя дата трябва да се върне книгата ");
        dateOfReturn=scanner.nextInt();
        return dateOfReturn;
    }

    public int getCollectionPeriod() {
        System.out.println("Колко време е била взета книгата ");
        collectionPeriod=scanner.nextInt();
        return collectionPeriod;
    }

    public int getHowTimesBookWasTaken() {
        System.out.println("Колко пъти книгата е била взимана от библиотеката? ");
        howTimesBookWasTaken=scanner.nextInt();
        return howTimesBookWasTaken;
    }


    public String toString() {

        String str="ЗАГЛАВИЕ:" + "'" + this.title + "'" + " ЖАНР:" + "'" + this.genre + "'" + " АВТОР:" + "'" + this.author + "'" + " ИЗДАТЕЛ:" + "'" + this.publisher + "'" + " ISBN НОМЕР:" + "'" + this.ISBN + "'" + " СТРАНИЦИ:" + "'" + this.numberOfPages + "'" + " ЕЗИК:" + "'" + this.language + "'" + " НАЛИЧНОСТ:" + "'" + this.availability + "'" + " ВЗИМАНЕ ОТ БИБЛИОТЕКАТА:" + "'" + this.howTimesBookWasTaken + "'" ;

        return str;
    }



}
