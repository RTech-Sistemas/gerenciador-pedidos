package com.ricardoagnello.gerenciador_pedidos.entities;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class ItemPedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    private Integer numeroItem;

    @NotEmpty(message = "Descrição obrigatória")
    private String descricao;

    @Min(value = 1, message = "Quantidade de ser pelo menos 1")
    private Integer quantidade;

    @DecimalMin(value = "0.01", message = "O valor unitário deve ser pelo menos 0.01")
    private Double valorUnitario;

    private Double valorTotalItem;

    public ItemPedido(Pedido pedido, String descricao, Integer quantidade, Double valorUnitario) {
        this.pedido = pedido;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    

}
