/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.bookshelf;

/**
 *
 * @author bogda
 */
import sumdu.bookshelf.bookstore.Book;
import sumdu.bookshelf.bookstore.BookCash;
import java.util.Random;


public class Generator {
    static Book createBook(){
        BookCash.loadCache();
        Random rand = new Random();
        int max=9999,min=1111;
        int id= rand.nextInt(3 - 1 + 1) + 1;
        Book b = BookCash.getBook(id);
        b.setISBN(rand.nextInt(max - min + 1) + min);
        b.setPages(rand.nextInt(max/90 - min/300 + 1) + min/300);
        return b;
    }
}