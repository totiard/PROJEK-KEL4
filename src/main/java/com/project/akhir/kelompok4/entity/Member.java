package com.project.akhir.kelompok4.entity;

import jakarta.persistence.*;
import lombok.Data;;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
}
