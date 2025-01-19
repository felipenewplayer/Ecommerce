package com.example.felipe.Catalogo.controller;

import com.example.felipe.Catalogo.dto.ProdutoDto;
import com.example.felipe.Catalogo.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<ProdutoDto>> buscarProdutos(){
        List<ProdutoDto> produtos = service.buscarProduto();
        return ResponseEntity.ok(produtos);
    }
    @PostMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPeloId(Long id){
        ProdutoDto produtos = service.buscaPorId(id);
        return ResponseEntity.ok(produtos);
    }
    @PostMapping
    public ResponseEntity<ProdutoDto> criarPedido(@RequestBody ProdutoDto ProdutoDto) {
        ProdutoDto novoPedido = service.createProduto(ProdutoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido); // Retorna status 201 (Created)
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        service.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
