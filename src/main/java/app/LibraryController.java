package app;

import java.io.IOException;
import java.util.*;


public class LibraryController {

    private Library library;
    private Scanner input = new Scanner(System.in);

    public LibraryController() {
        library = FileUtils.read();
    }


    public void loop() {
        OPTIONS option = null;
        do {
            showOptions();
            try {
                option = chooseOption();
                executeOption(option);
            } catch (NoSuchElementException e) {
                System.out.println("Incorrect option");
            }
        } while (option != OPTIONS.CLOSE);
    }

    private void showOptions() {
        System.out.println("Options:");
        for (OPTIONS option : OPTIONS.values()) {
            System.out.println(option);
        }
    }

    private OPTIONS chooseOption() {
        int option = input.nextInt();
        input.nextLine();
        return OPTIONS.convertToOption(option);
    }

    private void executeOption(OPTIONS options) {
        switch (options) {
            case SEARCH_BY_TYPE:
                searchByType();
                break;
            case SEARCH_BY_AUTHOR:
                searchByAuthor();
                break;
            case SEARCH_BY_ISBN:
                searchByIsbn();
                break;
            case LARGEST_NUMBER_OF_PAGES:
                largestNumberOfPages();
                break;
            case SORT_BY_RELEASE_YEAR_REVERSED:
                sortBookByReleaseYear();
                break;
            case SAVE_TO_FILE_SORTED_BY_TITLE:
                saveToFileSortedByTitle();
                break;
            case CLOSE:
                close();
                break;
        }
    }

    private void saveToFileSortedByTitle() {
        try {
            FileUtils.save(library);
            System.out.println("Changes saved successfully");
        } catch (IOException e) {
            System.err.println("Failed to save changes");
        }
    }


    private void searchByAuthor() {
        System.out.println("Enter author:");
        String author = input.nextLine();
        List<Books> byAuthor = library.findByAuthor(author);
        if (byAuthor.isEmpty()) {
            System.out.println("No results");
        } else {
            System.out.println("Results found:");
            byAuthor.stream()
                    .map(Books::toString)
                    .forEach(System.out::println);
        }
    }


    private void searchByIsbn() {
        System.out.println("Enter isbn:");
        String isbn = input.nextLine();
        List<Books> byIsbn = library.findByIsbn(isbn);
        if (byIsbn.isEmpty()) {
            System.out.println("No results");
        } else {
            System.out.println("Results found:");
            byIsbn.stream()
                    .map(Books::toString)
                    .forEach(System.out::println);
        }
    }


    private void searchByType() {
        System.out.println("Enter type:");
        String programmingLanguage = input.nextLine();
        List<Books> byType = library.findByType(programmingLanguage);
        if (byType.isEmpty()) {
            System.out.println("No results");
        } else {
            System.out.println("Results found:");
            byType.stream()
                    .map(Books::toString)
                    .forEach(System.out::println);
        }
    }


    public void largestNumberOfPages() {
        System.out.println("Book with the largest number of pages:");
        library.maxNunberOfPages();
    }


    private void sortBookByReleaseYear() {
        System.out.println("Sorted books:");
        Collection<Books> sorted = library.getSortedBooks((Comparator.comparingInt(Books::getReleaseYear).reversed()));
        sorted.forEach(System.out::println);
    }


    private void close() {
        input.close();
        System.out.println("Thank you, goodbye");
    }
}


