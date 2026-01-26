package com.example.baitap_tuan2.Controller;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.baitap_tuan2.Service.BookService;
import com.example.baitap_tuan2.models.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public String getAllBookString() {
        return bookService.getAllBooks().toString();
    }
    @GetMapping("/{id}")
    public String getBookByIdString(@PathVariable ("id") String id) {
        return bookService.getBookById(id).toString();
    }
    @PutMapping("/addupdate")
    public String addOrUpdateBook(@RequestBody Book book) {
        String a = bookService.addBookupdateBook(book);
        return a;
    }
     @DeleteMapping("/delete/{id}")
     public String deleteBook(@PathVariable ("id") String id) {
        boolean isDeleted = bookService.deleteBook(id);
        if (isDeleted) {
           return "Book deleted successfully";
        } else {
            return "Book not found";
        }
    }
}
