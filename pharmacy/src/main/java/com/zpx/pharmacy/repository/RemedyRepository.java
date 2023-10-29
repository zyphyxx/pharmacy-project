package com.zpx.pharmacy.repository;

import com.zpx.pharmacy.dto.DadosListagemRemedio;
import com.zpx.pharmacy.model.Remedio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public interface RemedyRepository extends JpaRepository <Remedio,Long> {

    List<Remedio> findAllByAtivoTrue();
}
