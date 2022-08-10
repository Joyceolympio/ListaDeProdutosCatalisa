package com.aula42.listaDeProdutos.repository;

import com.aula42.listaDeProdutos.model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
}
