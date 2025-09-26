package com.example.ss8_ung_dung_muon_sach.controller;

import com.example.ss8_ung_dung_muon_sach.entity.Book;
import com.example.ss8_ung_dung_muon_sach.entity.Borrow;
import com.example.ss8_ung_dung_muon_sach.exception.BookNotFoundException;
import com.example.ss8_ung_dung_muon_sach.exception.OutOfStockException;
import com.example.ss8_ung_dung_muon_sach.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }


    @GetMapping("/{id}")
    public String detailBook(@PathVariable Integer id, Model model) {
        Book book = bookService.findBYId(id);
        model.addAttribute("book", book);
        return "book/detail";
    }


    @PostMapping("/{id}/borrow")
    public String borrowBook(@PathVariable Integer id, RedirectAttributes redirect) {
        try {
            Borrow borrow = bookService.borrowBook(id);
            redirect.addFlashAttribute("message",
                    "Mượn thành công! Mã mượn của bạn là: " + borrow.getBorrowCode());
        } catch (RuntimeException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/books";
    }

    @PostMapping("/books/{id}/borrow")
    public String borrowBook(@PathVariable Integer id, Model model) {
        Book book = bookService.findBYId(id);

        if (book == null) {
            throw new BookNotFoundException("Không tìm thấy sách với ID: " + id);
        }

        if (book.getQuantity() <= 0) {
            throw new OutOfStockException("Sách '" + book.getTitle() + "' đã hết, không thể mượn!");
        }


        Borrow borrow = bookService.borrowBook(id);


        model.addAttribute("borrowCode", borrow.getBorrowCode());

        return "book/borrow_success";
    }



    @GetMapping("/return")
    public String showReturnForm() {
        return "book/return";
    }


    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode, RedirectAttributes redirect) {
        try {
            bookService.returnBook(borrowCode);
            redirect.addFlashAttribute("message", "Trả sách thành công!");
        } catch (RuntimeException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/books";
    }
}
