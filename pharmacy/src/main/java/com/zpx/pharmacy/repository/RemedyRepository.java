package com.zpx.pharmacy.repository;

import com.zpx.pharmacy.model.Remedio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RemedyRepository extends JpaRepository <Remedio,Long> {
}
