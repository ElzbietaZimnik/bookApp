package app;

import java.util.*;
import java.util.stream.Collectors;


public class Library implements Iterable<Books> {

    private Map<String, Books> books = new TreeMap<>();

    public Library(Map<String, Books> books) {
        this.books = books;
    }

    public Library() {
    }


    public List<Books> findByAuthor(String author) {
        return books.values()
                .stream()
                .filter(x->x.getAuthor().contains(author))
                .collect(Collectors.toList());
    }


    public List<Books> findByIsbn(String isbn) {
        return books.values()
                .stream()
                .filter(b -> b.getIsbn().contains(isbn))
                .collect(Collectors.toList());
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
        Optional<Books> optionalBooks = books.values()
                .stream()
                .max(Comparator.comparing(Books::getNumberOfPages));
        optionalBooks.stream()
                .forEach(System.out::println);
    }


    public Collection<Books> getSortedBooks(Comparator<Books> comparator) {
        ArrayList<Books> list = new ArrayList<>(this.books.values());
        list.sort(comparator);
        return list;
    }


    @Override
    public Iterator<Books> iterator() {
        return books.values().iterator();
    }
}






