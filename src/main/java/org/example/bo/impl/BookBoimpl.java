package org.example.bo.impl;

import org.example.Entity.Book;
import org.example.bo.BookBo;
import org.example.dao.impl.BookDaoimpl;
import org.example.dto.BookDto;

import java.util.ArrayList;
import java.util.List;


public class BookBoimpl implements BookBo {
    BookDaoimpl bookDaoimpl = new BookDaoimpl();
    public boolean saveBook(BookDto book) {
        Book book1 = new Book(book.getId(),book.getTitle(),book.getAuthor(),book.getCatougery(),book.getStatus());
        boolean isSave = bookDaoimpl.save(book1);
        return isSave;
    }


    public List<BookDto> getAllBooks() {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> bookList = bookDaoimpl.getAll();

        for (Book book : bookList) {
            bookDtos.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getCatougery(), book.getStatus()));
        }

        return bookDtos;
    }

    public List<BookDto> getSearchBook(String book) {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> bookList = bookDaoimpl.getAllSearchBookDetails(book);


        for (Book books : bookList) {
            bookDtos.add(new BookDto(books.getId(), books.getTitle(), books.getAuthor(), books.getCatougery(), books.getStatus()));
        }

        if (bookList != null) {
            for (BookDto bookDto : bookDtos) {
                System.out.println(bookDto);
            }
        } else {
            System.out.println("The list of books is null.");
        }

        return bookDtos;
    }

    public boolean deleteBook(String id){
        boolean isDelete = bookDaoimpl.DeleteBook(id);
        return isDelete;
    }

    public boolean updateBook(BookDto book) {
        Book book1 = new Book(book.getId(),book.getTitle(),book.getAuthor(),book.getCatougery(),book.getStatus());
        boolean isUpdate = bookDaoimpl.update(book1);

        return isUpdate;
    }
}
