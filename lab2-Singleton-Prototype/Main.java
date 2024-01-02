package sumdu.bookshelf;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bogda
 */
import sumdu.bookshelf.bookstore.Book;


public class Main {
    public static void main(String[] args){
       BookShelf bsf = BookShelf.getInstance();
       for(int i=0; i<5; i++){
           Book b = Generator.createBook();
           bsf.addBook(b);
       }
       bsf.printContent();
    }
}