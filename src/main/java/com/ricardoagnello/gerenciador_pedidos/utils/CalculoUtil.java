package com.ricardoagnello.gerenciador_pedidos.utils;

import java.util.List;

import com.ricardoagnello.gerenciador_pedidos.entities.ItemPedido;
import com.ricardoagnello.gerenciador_pedidos.entities.Pedido;

public class CalculoUtil {

    // Método para calcular o valor de um item
    public static double calcularValorItem(ItemPedido itemPedido) {
        if (itemPedido.getQuantidade() == null || itemPedido.getValorUnitario() == null) {
            return 0.0;
        }
        return itemPedido.getQuantidade() * itemPedido.getValorUnitario();
    }

    // Método para calcular o valor total do pedido
    public static double calcularValorTotalPedido(List<ItemPedido> itens) {
        return itens.stream()
                    .mapToDouble(CalculoUtil::calcularValorItem)
                    .sum();
    }

    // Método para calcular o número do item
    public static int calcularNumeroItem(Pedido pedido) {
        if (pedido.getItens() == null || pedido.getItens().isEmpty()) {
            return 1; // Primeiro item do pedido
        }
        return pedido.getItens().size() + 1;
    }

}
