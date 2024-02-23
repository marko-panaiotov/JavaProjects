public class InvisibleLibrary {

    public static void main(String[] args) {

        Library takeInput=new Library();
        takeInput.getName();
        takeInput.getAddress();
        takeInput.getLibraryStaffCount();
        takeInput.getBookList();



        LibrarianChoice librarianChoice=new LibrarianChoice();
        librarianChoice.menuChoice();



    }
}
