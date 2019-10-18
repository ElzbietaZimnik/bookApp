package app;

import java.io.Serializable;
import java.util.Objects;

public class Books implements Serializable {

    private static final long serialVersionUID = 100L;

    private String title;
    private String author;
    private int releaseYear;
    private int numberOfPages;
    private String publisher;
    private String programmingLanguage;
    private String isbn;

    public Books(String title, String author, int releaseYear, int numberOfPages, String publisher, String programmingLanguage, String isbn) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.programmingLanguage = programmingLanguage;
        this.isbn = isbn;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        String stringBuilder = "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Release year: " + releaseYear + "\n" +
                "Number of pages: " + numberOfPages + "\n" +
                "Publisher: " + publisher + "\n" +
                "Programming language: " + programmingLanguage + "\n" +
                "ISBN: " +  isbn + "\n";
        return stringBuilder;
    }

    public String toCSV() {
        return title + ";" + author+ ";" + releaseYear+ ";" + numberOfPages+ ";" + publisher+ ";" + programmingLanguage+ ";" + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return releaseYear == books.releaseYear &&
                numberOfPages == books.numberOfPages &&
                Objects.equals(title, books.title) &&
                Objects.equals(author, books.author) &&
                Objects.equals(publisher, books.publisher) &&
                Objects.equals(programmingLanguage, books.programmingLanguage) &&
                Objects.equals(isbn, books.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, releaseYear, numberOfPages, publisher, programmingLanguage, isbn);
    }
}
