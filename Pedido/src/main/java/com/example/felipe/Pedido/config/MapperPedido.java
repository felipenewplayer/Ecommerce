    package com.example.felipe.Pedido.config;

    import com.example.felipe.Pedido.dto.PedidoDto;
    import com.example.felipe.Pedido.model.ItemDoPedido;
    import com.example.felipe.Pedido.model.Pedido;
    import org.springframework.stereotype.Component;

    import java.util.List;
    @Component
    public class MapperPedido {

        public PedidoDto toDto(Pedido pedido){
            return new PedidoDto(pedido.getId(),pedido.getClientName(),pedido.getStatus(),pedido.getItens());
        }

        public Pedido toEntity(PedidoDto dto) {
            Pedido pedido = new Pedido();
            pedido.setId(dto.id());
            pedido.setClientName(dto.clientName());
            pedido.setStatus(dto.status());
            pedido.setItens(dto.itens().stream()
                    .map(itemDto -> new ItemDoPedido(itemDto.id(), itemDto.quantidade(), itemDto.descricao(), pedido))
                    .toList());
            return pedido;
        }

        public List<PedidoDto> toDtoList(List<Pedido> pedidos){
            return pedidos.stream()
                    .map(pedido -> new PedidoDto(pedido.getId(), pedido.getClientName(), pedido.getStatus(),pedido.getItens()))
                    .toList();
        }
    }
