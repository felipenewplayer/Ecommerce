package com.example.felipe.Pedido.controller;

import com.example.felipe.Pedido.dto.PedidoDto;
import com.example.felipe.Pedido.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<PedidoDto>> buscarProdutos(){
        List<PedidoDto> produtos = service.buscarPedido();
        return ResponseEntity.ok(produtos);
    }
    @PostMapping("/{id}")
    public ResponseEntity<PedidoDto> buscarPeloId(Long id){
        PedidoDto produtos = service.buscaPorId(id);
        return ResponseEntity.ok(produtos);
    }
    @PostMapping
    public ResponseEntity<PedidoDto> criarPedido(@RequestBody PedidoDto PedidoDto) {
        PedidoDto novoPedido = service.createPedido(PedidoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido); // Retorna status 201 (Created)
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        service.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
