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

    public Book getBookById(String id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public String addBookupdateBook(Book book) {
        if (book.getId() == null || book.getId().trim().isEmpty()) {
            int maxId = 0;
            if (!books.isEmpty()) {
                maxId = books.stream()
                        .mapToInt(b -> Integer.parseInt(b.getId())) 
                        .max() 
                        .orElse(0);
            }

            // Gán ID mới = Max + 1
            book.setId(String.valueOf(maxId + 1));
            books.add(book);
            return "Book added successfully";
        } else {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getId().equals(book.getId())) {
                    books.set(i, book);
                    return "Book updated successfully";
                }
            }
            books.add(book);
        }
        return "cap nhat thanh ccong";
    }

    public boolean deleteBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
        return true;
    }
}
