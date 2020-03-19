package bookservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class AuthorServiceImplTest{
    private BookService bookService;
    private BookValidatorService bookValidatorService;
    private AuthorServiceImpl authorService;


    @Before
    public void setUp(){
        bookService=mock(BookService.class);
        bookValidatorService=mock(BookValidatorServiceImpl.class);
        authorService=new AuthorServiceImpl();
        authorService.setBookService(bookService);
        authorService.setBookValidatorService(bookValidatorService);

    }


    @Test
    public void validateTestGetTotalBooks(){
        String bookName="bot";
        //Assignment
        ArrayList<Book> listOfBooks=new ArrayList<>();
        Book book1= new Book("bot");
        listOfBooks.add(book1);
        Book book2= new Book("book1");
        listOfBooks.add(book2);



        when(bookService.findBookByAuthor(bookName)).thenReturn(listOfBooks);
        when(bookValidatorService.isValid(book1)).thenReturn(true);
        when(bookValidatorService.isValid(book2)).thenReturn(false);

        //acting
        int count =authorService.getTotalBooks(bookName);

        //assertion

        Assert.assertEquals(1,count );

    }

    @Test
    public void validateCountOfTestGetTotalBooksToBe5(){
        String bookName="bot";

        //Assignment
        ArrayList<Book> listOfBooks=new ArrayList<>();
        Book book1= new Book("bot");
        listOfBooks.add(book1);
        Book book2= new Book("bot");
        listOfBooks.add(book2);
        Book book3= new Book("bot");
        listOfBooks.add(book3);
        Book book4= new Book("bot");
        listOfBooks.add(book4);
        Book book5= new Book("bot");
        listOfBooks.add(book5);

        when(bookService.findBookByAuthor(bookName)).thenReturn(listOfBooks);
        when(bookValidatorService.isValid(book1)).thenReturn(true);
        when(bookValidatorService.isValid(book2)).thenReturn(true);
        when(bookValidatorService.isValid(book3)).thenReturn(true);
        when(bookValidatorService.isValid(book4)).thenReturn(true);
        when(bookValidatorService.isValid(book5)).thenReturn(true);

        //acting
        int count =authorService.getTotalBooks(bookName);

        //assertion

        Assert.assertEquals(5,count );

    }

    @Test
    public void validateOrderOfMethodExecutionOfCountOfTestGetTotalBooks(){

        ///acting

        InOrder inOrder = inOrder(bookService);
        InOrder inOrder1 = inOrder(bookValidatorService);

        when(bookService.findBookByAuthor("test")).thenReturn(new ArrayList<Book>());

        //acting
        int count =authorService.getTotalBooks("test");

        inOrder.verify(bookService, times(1)).findBookByAuthor("test");


    }

}
