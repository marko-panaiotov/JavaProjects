import java.util.ArrayList;
import java.util.Scanner;

public class LibrarianChoice {

    final int addBook=1;
    final int removeBook=2;
    final int searchBook=3;
    final int updateBook=4;
    final int listOfBooks=5;
    final int exit=6;

    final int availability=1;
    final int dateOfGet=2;
    final int dateOfReturn=3;
    final int takingPeriod=4;
    final int howTimesBookWasGet=5;


    Scanner scanner = new Scanner(System.in);
    int librarianChoice;

    public void options(){
        System.out.println("Моля изберете опция: ");
        System.out.println("1. Добавяне на книга");
        System.out.println("2. Премахване на книга");
        System.out.println("3. Търсене на книга");
        System.out.println("4. Обновяване на книга");
        System.out.println("5. Пълен списък с книги");
        System.out.println("6. Изход");
    }

    public void updateMenu(){

        System.out.println("Моля изберете какво искате да обновите: ");
        System.out.println("1. Наличност");
        System.out.println("2. Дата, на която е взета книгата");
        System.out.println("3. Дата, на която трябва да се върне книгата");
        System.out.println("4. Период на вземане");
        System.out.println("5. Колко пъти книгата е взимана от библиотеката");

    }

    static ArrayList<Books>bookList= new ArrayList<>();

    public void menuChoice() {

        do {

            options();
            librarianChoice = scanner.nextInt();
            System.out.println();

            if (librarianChoice == addBook) {

                Books books=new Books();
                books.getTitle();
                books.getGenre();
                books.getAuthor();
                books.getPublisher();
                books.getYearOfPublisher();
                books.getISBN();
                books.getNumberOfPages();
                books.getLanguage();
                books.getAvailability();
                books.getHowTimesBookWasTaken();
                bookList.add(books);

                System.out.println("Книгата е добавена успешно!");

            }

            if (librarianChoice==removeBook){
                System.out.println("Изберете заглавие книга за премахване от списъка:");
                String title="";
                    String bookId = scanner.next();
                    boolean checkBookId = checkBookId(bookId,title);
                    if (checkBookId) {
                        System.out.println("Книгата съществува!");
                        bookList.removeIf(book7->checkBookId);

                    }else {
                        System.out.println("Книгата не съществува!");
                    }
                }

            if (librarianChoice==searchBook){

                System.out.println("Въведете заглавието на книгат акоято търсите: ");
                String searchBookId = scanner.next();
                searchBook(searchBookId);

                }

            if (librarianChoice==updateBook){

                Books books=new Books();

                updateMenu();
                int updateMenuChoice=scanner.nextInt();

                if (updateMenuChoice==availability){

                    books.getAvailability();
                }

                if(updateMenuChoice==dateOfGet){
                    books.getDateOfGet();
                }

                if (updateMenuChoice==dateOfReturn){
                    books.getDateOfReturn();
                }

                if (updateMenuChoice==takingPeriod){
                    books.getCollectionPeriod();
                }

                if(updateMenuChoice==howTimesBookWasGet){
                    books.getHowTimesBookWasTaken();
                }

            }

            if (librarianChoice==listOfBooks){

                for ( Books b:bookList) {

                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println(b);

                }

            }

        } while (librarianChoice < exit );
        System.out.println("Довиждане!");
    }

    public static boolean checkBookId(String bookId ,String title) {
        for (Books book : bookList) {
            if (book.getISBN().equals( bookId)&&book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public static void searchBook(String searchBookId) {
        boolean search = true;
        for (Books book : bookList) {
            if (book.getTitle().equals(searchBookId)) {

                search = false;
            }
        }
        if (search) {
            System.out.println(searchBookId + "Несъществува");
        }
    }

}
