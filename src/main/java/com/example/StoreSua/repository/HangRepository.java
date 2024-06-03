package com.example.StoreSua.repository;

import com.example.StoreSua.model.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangRepository extends JpaRepository<Hang, Long> {
}
