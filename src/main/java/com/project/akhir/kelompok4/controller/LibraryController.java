package com.project.akhir.kelompok4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.project.akhir.kelompok4.entity.Book;
import com.project.akhir.kelompok4.entity.BorrowingRecord;
import com.project.akhir.kelompok4.entity.Member;
import com.project.akhir.kelompok4.service.LibraryService;

import java.util.Date;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        model.addAttribute("members", libraryService.getAllMembers());
        model.addAttribute("borrowingRecords", libraryService.getAllBorrowingRecords());
        return "index";
    }

    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book) {
        libraryService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/addMember")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add_member";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute("member") Member member) {
        libraryService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/borrowBook")
    public String showBorrowBookForm(Model model) {
        model.addAttribute("borrowingRecord", new BorrowingRecord());
        model.addAttribute("books", libraryService.getAllBooks());
        model.addAttribute("members", libraryService.getAllMembers());
        return "borrow_book";
    }

    @PostMapping("/borrowBook")
    public String borrowBook(
        @RequestParam("memberId") Long memberId,
        @RequestParam("bookId") String bookId,
        @RequestParam("dueDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDate) {
    Member member = libraryService.getMemberById(memberId);
    Book book = libraryService.getBookById(bookId);
    BorrowingRecord borrowingRecord = new BorrowingRecord();
    borrowingRecord.setMember(member);
    borrowingRecord.setBook(book);
    borrowingRecord.setBorrowDate(new Date());
    borrowingRecord.setDueDate(dueDate);
    libraryService.saveBorrowingRecord(borrowingRecord);
    return "redirect:/";
    }


    // @PostMapping("/borrowBook")
    // public String borrowBook(
    //         @RequestParam("memberId") Long memberId,
    //         @RequestParam("bookId") String bookId,
    //         @RequestParam("dueDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDate) {
    //     Member member = libraryService.getMemberById(memberId);
    //     Book book = libraryService.getBookById(bookId);
    //     BorrowingRecord borrowingRecord = new BorrowingRecord();
    //     borrowingRecord.setMember(member);
    //     borrowingRecord.setBook(book);
    //     borrowingRecord.setBorrowDate(new Date());
    //     borrowingRecord.setDueDate(dueDate);
    //     libraryService.saveBorrowingRecord(borrowingRecord);
    //     return "redirect:/";
    // }
}