package com.nash.bookworm.services;

import com.nash.bookworm.dto.BookDto;
import com.nash.bookworm.dto.BookPage;
import com.nash.bookworm.dto.ReviewDto;
import com.nash.bookworm.entities.Discount;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface
BookService {

    @Transactional
    void saveBook(BookDto book);
    BookDto getBookById(Long id);

    BookPage getBookPage(int page, int show, long filter, int type, int sort);
}
