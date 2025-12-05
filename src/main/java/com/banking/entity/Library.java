package com.banking.entity;

/*Create a Library class that:
Stores a list of books.
Has methods to:
Add a book.
Display all available books.
Borrow a book by ID.
Return a book by ID.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
    List<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void availableBooks(){
        System.out.println("Available Books");
        for(Book book : books){
            if(book.isAvailable()){
                System.out.println(book);
            }
        }
    }
    public void borrowBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                book.borrowBook();
                return;
            }
            System.out.println("Book Not Available");
        }
    }
    public void returnBook(int id){
        for(Book book : books){
            if(book.getId()== id){
                book.returnBook();
                return;
            }
            System.out.println("Book Not Available");

        }
    }
/*
    In the main method:
    Add at least 3 books to the library.
    Allow the user to borrow and return books using a simple menu-driven program.*/
    public  class LibraryManagement{
        public  static void main(String[] args) {
            Library library = new Library();
            Scanner sc = new Scanner(System.in);
            library.addBook(new Book(1, "Java Programming", "James Gosling"));
            library.addBook(new Book(2, "Effective Java", "Joshua Bloch"));
            library.addBook(new Book(3, "Clean Code", "Robert C. Martin"));
            int choice;
            do {
                System.out.println("\n--- Library Menu ---");
                System.out.println("1. Display Available Books");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> library.availableBooks();
                    case 2 -> {
                        System.out.println("Enter Book ID: ");
                        int borrowId = sc.nextInt();
                        library.borrowBook(borrowId);
                    }
                    case 3 -> {
                        System.out.println("Enter Book ID: ");
                        int returnId = sc.nextInt();
                        library.returnBook(returnId);
                    }
                    case 4 -> System.out.println("Bye!");
                    default -> System.out.println("Wrong Choice!");
                }
            } while (choice!=4);
                sc.close();
            }
        }
        }

