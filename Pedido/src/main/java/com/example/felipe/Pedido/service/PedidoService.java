package com.example.felipe.Pedido.service;

import com.example.felipe.Pedido.config.MapperPedido;
import com.example.felipe.Pedido.dto.PedidoDto;
import com.example.felipe.Pedido.model.Pedido;
import com.example.felipe.Pedido.model.Status;
import com.example.felipe.Pedido.repository.PedidoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final MapperPedido mapper;

    public PedidoService(PedidoRepository repository, MapperPedido mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<PedidoDto> buscarPedido() {
        List<Pedido> pedidos = repository.findAll();
        return mapper.toDtoList(pedidos);
    }

    public PedidoDto createPedido(PedidoDto dto) {
        Pedido pedido = mapper.toEntity(dto);
        pedido.setStatus(Status.REALIZADO);
        Pedido PedidoSalvo = repository.save(pedido);
        pedido.setStatus(Status.REALIZADO);
        return mapper.toDto(PedidoSalvo);
    }

    public PedidoDto buscaPorId(Long id)  {
        Pedido Pedido = (Pedido) repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido com ID " + id + " não encontrado."));
        return mapper.toDto(Pedido);
    }



    public void deletarPedido(Long id)  {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        pedido.setStatus(Status.CANCELADO);
        repository.delete(pedido);
    }
}
