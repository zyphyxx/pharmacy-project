package com.zpx.almoxarifado.repository;

import com.zpx.almoxarifado.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produto,Long> {
}
