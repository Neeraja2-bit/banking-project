package com.banking.entity;
/*
Create a Book class with:
Attributes: id, title, author, isAvailable
Methods: borrowBook(), returnBook()*/

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public  void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book has been borrowed");
        } else {
            isAvailable = true;
            System.out.println("Book has been borrowed");
        }
    }
        public void returnBook(){
            if(!isAvailable){
                isAvailable = true;
                System.out.println("Book has been returned");
            }
            else {
                isAvailable = false;
                System.out.println("Book has been returned");
        }
    }
}
