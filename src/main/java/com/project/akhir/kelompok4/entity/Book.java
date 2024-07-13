package com.project.akhir.kelompok4.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;
}
