package com.example.felipe.Catalogo.service;

import com.example.felipe.Catalogo.config.MapperProduto;
import com.example.felipe.Catalogo.dto.ProdutoDto;
import com.example.felipe.Catalogo.model.Produto;
import com.example.felipe.Catalogo.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;
    private final MapperProduto mapper;

    public ProdutoService(ProdutoRepository repository, MapperProduto mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProdutoDto createProduto(ProdutoDto dto) {
        Produto produto = mapper.toEntity(dto);
        Produto produtoSalvo = repository.save(produto);
        return mapper.toDto(produtoSalvo);
    }

    public ProdutoDto buscaPorId(Long id)  {
        Produto produto = (Produto) repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto com ID " + id + " não encontrado."));
        return mapper.toDto(produto);
    }

    public void deletarProduto(Long id)  {
        Produto produto = (Produto) repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
        repository.delete(produto);
    }

    public List<ProdutoDto> buscarProduto() {
        List<Produto> produtos = repository.findAll();
        return mapper.toDtoList(produtos);
    }
}
