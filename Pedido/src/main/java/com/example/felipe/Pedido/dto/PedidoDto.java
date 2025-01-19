package com.example.felipe.Pedido.dto;

import com.example.felipe.Pedido.model.Status;

import java.util.List;

public record PedidoDto(
        Long id,
        String clientName,
        Status status,
        List<ItemPedidoDto> itens
) {
}
