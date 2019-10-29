package app;

public class BibliotekaApp {

    public static void main(String[] args){

        LibraryController libraryController = new LibraryController();
        System.out.println("Welcome in my application.");
        libraryController.loop();

    }
}
