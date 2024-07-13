package com.project.akhir.kelompok4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.akhir.kelompok4.entity.Book;
import com.project.akhir.kelompok4.entity.BorrowingRecord;
import com.project.akhir.kelompok4.entity.Member;
import com.project.akhir.kelompok4.repository.BookRepository;
import com.project.akhir.kelompok4.repository.BorrowingRecordRepository;
import com.project.akhir.kelompok4.repository.MemberRepository;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    public BorrowingRecord saveBorrowingRecord(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }
    
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Book getBookById(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }
    
}
