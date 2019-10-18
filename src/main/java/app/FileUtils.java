package app;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class FileUtils {
    private static final String FILE_NAME = "dane.txt";

    public static Library read() {
        Library book = null;
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(FILE_NAME));
            Map<String, Books> b = buffReader.lines()
                    .map(line -> line.split(";"))
                    .map(split -> new Books(split[0], split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3]),split[4],split[5],split[6]))
                    .collect(Collectors.toMap(Books::getAuthor, Function.identity()));
            book = new Library(new TreeMap<>(b));
        } catch (FileNotFoundException e) {

        }
        return book != null ? book : new Library();
    }


    public static void save(List<Books> biblioteka) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        for (Books b : biblioteka) {
            writer.write(b.toCSV());
            writer.newLine();
        }
        writer.close();
    }

}