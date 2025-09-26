package com.example.ss8_ung_dung_muon_sach.service;

import com.example.ss8_ung_dung_muon_sach.entity.Book;
import com.example.ss8_ung_dung_muon_sach.entity.Borrow;
import com.example.ss8_ung_dung_muon_sach.exception.OutOfStockException;
import com.example.ss8_ung_dung_muon_sach.repository.IBookRepository;
import com.example.ss8_ung_dung_muon_sach.repository.IBorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    private final IBorrowRepository borrowRepository;

    public BookService(IBookRepository bookRepository, IBorrowRepository borrowRepository) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
    }


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBYId(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sách"));
    }

    @Override
    public Borrow borrowBook(Integer bookId) {
        Book book = findBYId(bookId);

        if (book.getQuantity() <= 0){
            throw new OutOfStockException("Sách '" + book.getTitle() + "' đã hết, không thể mượn!");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String code = String.format("%05d", new Random().nextInt(100000));

        Borrow borrow = new Borrow();
        borrow.setBook(book);
        borrow.setBorrowCode(code);
        borrow.setStatus(Borrow.BorrowStatus.BORROWED);

        return borrowRepository.save(borrow);

    }

    @Override
    public void returnBook(String borrowCode) {

        Borrow borrow = borrowRepository.findByBorrowCode(borrowCode)
                .orElseThrow(() -> new RuntimeException("Mã mượn không hợp lệ!"));

        if (borrow.getStatus() == Borrow.BorrowStatus.RETURNED) {
            throw new RuntimeException("Mã này đã được trả sách rồi!");
        }


        borrow.setStatus(Borrow.BorrowStatus.RETURNED);
        borrowRepository.save(borrow);

        Book book = borrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }

}
