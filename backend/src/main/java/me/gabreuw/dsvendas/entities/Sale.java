package me.gabreuw.dsvendas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_sales")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Integer visited;

    private Integer deals;

    private Double amount;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

}
