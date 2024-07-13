package com.project.akhir.kelompok4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.akhir.kelompok4.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
