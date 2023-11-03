package com.zpx.almoxarifado.repository;

import com.zpx.almoxarifado.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlmoxRepository extends JpaRepository <Produto, Long>{
}
