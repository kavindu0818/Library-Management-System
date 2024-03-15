package org.example.bo;

import org.example.Entity.Book;
import org.example.bo.Custome.SuperBo;
import org.example.dto.BookDto;

import java.util.ArrayList;
import java.util.List;

public interface BookBo extends SuperBo {
    public boolean saveBook(BookDto book);
    public List<BookDto> getAllBooks();

    public List<BookDto> getSearchBook(String book);

    public boolean deleteBook(String id);

    public boolean updateBook(BookDto book);
}
