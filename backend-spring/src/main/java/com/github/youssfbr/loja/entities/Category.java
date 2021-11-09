package com.github.youssfbr.loja.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_category")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
