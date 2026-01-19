/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.yourcompany.Book.Book.Book;

/**
 *
 * @author thong
 */
public class Btvn1 {
    private static List<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU QUAN LY SACH ---");
            System.out.println("1. Them sach moi");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Cap nhat sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Tim kiem sach");
            System.out.println("6. Tim sach theo gia (Top K, gia <= P)");
            System.out.println("7. Tim sach theo danh sach tac gia");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: updateBook(); break;
                case 4: deleteBook(); break;
                case 5: searchBook(); break;
                case 6: searchBooksByPriceAndLimit(); break;
                case 7: searchBooksByAuthors(); break;
                case 0: 
                    System.out.println("Ket thuc chuong trinh.");
                    return;
                default: System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Nhap ma sach: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        String title = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String author = scanner.nextLine();
        System.out.print("Nhap don gia: ");
        double price = scanner.nextDouble();
        
        books.add(new Book(id, title, author, price));
        System.out.println("Da them sach thanh cong!");
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sach trong.");
        } else {
            System.out.println("\n--- DANH SACH SACH ---");
            books.forEach(System.out::println);
        }
    }

    private static void updateBook() {
        System.out.print("Nhap ma sach can sua: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Book bookToUpdate = books.stream()
                .filter(b -> b.getBookId() == id)
                .findFirst()
                .orElse(null);

        if (bookToUpdate != null) {
            System.out.print("Ten moi (Enter de giu nguyen): ");
            String title = scanner.nextLine();
            if (!title.isEmpty()) bookToUpdate.setTitle(title);
            
            System.out.print("Tac gia moi (Enter de giu nguyen): ");
            String author = scanner.nextLine();
            if (!author.isEmpty()) bookToUpdate.setAuthor(author);
            
            System.out.print("Gia moi (Enter de giu nguyen): ");
            String priceStr = scanner.nextLine();
            if (!priceStr.isEmpty()) bookToUpdate.setPrice(Double.parseDouble(priceStr));
            
            System.out.println("Da cap nhat thong tin sach.");
        } else {
            System.out.println("Khong tim thay sach co ma: " + id);
        }
    }

    private static void deleteBook() {
        System.out.print("Nhap ma sach can xoa: ");
        int id = scanner.nextInt();
        if (books.removeIf(b -> b.getBookId() == id)) {
            System.out.println("Da xoa sach thanh cong.");
        } else {
            System.out.println("Khong tim thay sach co ma: " + id);
        }
    }

    private static void searchBook() {
        System.out.print("Nhap tu khoa tim kiem: ");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("--- KET QUA TIM KIEM ---");
        books.stream()
             .filter(b -> b.getTitle().toLowerCase().contains(keyword) || b.getAuthor().toLowerCase().contains(keyword))
             .forEach(System.out::println);
    }

    private static void searchBooksByPriceAndLimit() {
        System.out.print("Nhap so luong sach toi da (K): ");
        int k = scanner.nextInt();
        System.out.print("Nhap muc gia toi da (P): ");
        double p = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("--- KET QUA ---");
        books.stream()
             .filter(b -> b.getPrice() <= p)
             .limit(k)
             .forEach(System.out::println);
    }

    private static void searchBooksByAuthors() {
        System.out.print("Nhap danh sach tac gia (cach nhau boi dau phay): ");
        String input = scanner.nextLine();
        List<String> authors = Arrays.stream(input.split(","))
                                     .map(String::trim)
                                     .map(String::toLowerCase)
                                     .collect(Collectors.toList());

        System.out.println("--- KET QUA ---");
        books.stream()
             .filter(b -> authors.contains(b.getAuthor().toLowerCase()))
             .forEach(System.out::println);
    }
}
