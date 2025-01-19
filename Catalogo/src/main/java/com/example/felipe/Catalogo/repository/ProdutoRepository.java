package com.example.felipe.Catalogo.repository;

import com.example.felipe.Catalogo.dto.ProdutoDto;
import com.example.felipe.Catalogo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
