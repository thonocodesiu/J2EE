package com.example.baitap_tuan2.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.baitap_tuan2.models.Book;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    public BookService() {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "1", 10.99));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "2", 8.99));
        books.add(new Book("1984", "George Orwell", "3", 9.99));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "4", 7.99));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "5", 6.99));
    }
    public List<Book> getAllBooks() {
        return books;
    }
    public List<Book> getBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                List<Book> result = new ArrayList<>();
                result.add(book);
                return result;
            }
        }
        return books;
    }
    public void addBookupdateBook(Book book) {
        if(book.getId() == null) {
            books.add(book);
        } else {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId().equals(book.getId())) {
                    books.set(i, book);
                    return;
                }
            }
            books.add(book);
        }
    }
    public boolean  deleteBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
        return true;
    }
}
