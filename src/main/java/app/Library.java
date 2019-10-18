package app;

import java.util.*;


public class Library implements Iterable<Books> {

    private Map<String, Books> books = new TreeMap<>();

    public Library(Map<String, Books> books) {
        this.books = books;
    }

    public Library() {
    }


    public Optional<Books> findByAuthor(String author) {
        if (author.isEmpty()) {
            System.out.println("No book found with the given author");
        } else
            return Optional.ofNullable(books.get(author));
        //tworzy Optional z podaną wartością, ale w przypadku przekazania null nie zostanie zgłoszony wyjątek.

        return null;
    }


    public List<Books> findByIsbn(String isbn) {
        List<Books> result = new ArrayList<>();
        for (Books b : books.values()) {
            if (b.getIsbn().contains(isbn))
                result.add(b);
        }
        return result;
    }


    public List<Books> findByType(String programmingLanguage) {
        List<Books> result = new ArrayList<>();
        for (Books b : books.values()) {
            if (b.getProgrammingLanguage().contains(programmingLanguage))
                result.add(b);
        }
        return result;
    }


    public void maxNunberOfPages() {
        Optional<Books> a = books.values().stream()
                .max(Comparator.comparing(Books::getNumberOfPages));
        System.out.println(a.toString());
    }


    public List<Books> getSortedBooks(Comparator<Books> comparator) {
        List<Books> list = new ArrayList<>(this.books.values());
        list.sort(comparator);
        return list;
    }


    @Override
    public Iterator<Books> iterator() {
        return books.values().iterator();
    }
}






