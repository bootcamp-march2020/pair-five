package bookservice;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    List<Book> findBookByAuthor(String author);
}

interface BookDao {
    List<Book> findBookByAuthor(String author);
}

interface AuthorService {
    int getTotalBooks(String author);
}

class BookDaoImpl implements BookDao {

    @Override
    public List<Book> findBookByAuthor(String name) {
        return new ArrayList<>();
    }
}

