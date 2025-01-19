package com.example.felipe.Catalogo.config;

import com.example.felipe.Catalogo.dto.ProdutoDto;
import com.example.felipe.Catalogo.model.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MapperProduto {

    public ProdutoDto toDto(Produto Produto){
        return new ProdutoDto(Produto.getId(),Produto.getName(),Produto.getPrice());
    }

    public Produto toEntity(ProdutoDto dto) {
        return new Produto(dto.id(), dto.name(), dto.price());
    }
    public List<ProdutoDto> toDtoList(List<Produto> Produtos){
        return Produtos.stream()
                .map(Produto -> new ProdutoDto(Produto.getId(), Produto.getName(),Produto.getPrice()))
                .toList();
    }
}
