package bookservice;

import bookservice.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AuthorServiceImplTest{
    private BookService bookService;
    private BookValidatorService bookValidatorService;

    @Before
    public void setUp(){
        bookService=mock(BookService.class);
        bookValidatorService=mock(BookValidatorServiceImpl.class);

    }
    @Test
    public void testGetTotalBooks(){
        String bookName="bot";

        //Assignment
        ArrayList<Book> listOfBooks=new ArrayList<>();
       Book book1= new Book("bot");
        listOfBooks.add(book1);
       Book book2= new Book("book1")
        listOfBooks.add(book2);

        AuthorServiceImpl authorService=new AuthorServiceImpl();

        when(bookService.findBookByAuthor(bookName)).thenReturn(listOfBooks);
        when(bookValidatorService.isValid(book1)).thenReturn(true);
        when(bookValidatorService.isValid(book2)).thenReturn(false);

        //acting
        int count =authorService.getTotalBooks(bookName);

        //assertion

        Assert.assertEquals(1,count );

    }

}