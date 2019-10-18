package app;

import java.util.NoSuchElementException;

    enum OPTIONS {

        SEARCH_BY_AUTHOR(0, "Search by author"),
        SEARCH_BY_ISBN(1, "Search by isbn"),
        SEARCH_BY_TYPE(2, "Search by type"),
        LARGEST_NUMBER_OF_PAGES(3, "Book with the largest number of pages"),
        SORT_BY_RELEASE_YEAR_REVERSED(4,"Sort books by release year (reversed)"),
        SAVE_TO_FILE_SORTED_BY_TITLE(5,"Save to file"),
        CLOSE(6, "EXIT");

        private final int shortcut;
        private final String description;

        OPTIONS(int shortcut, String description) {
            this.shortcut = shortcut;
            this.description = description;
        }


        static OPTIONS convertToOption(int option) {
            if(option >= values().length || option < 0)
                throw new NoSuchElementException();
            return values()[option];
        }

        @Override
        public String toString() {
            return shortcut + " - " + description;
        }
    }