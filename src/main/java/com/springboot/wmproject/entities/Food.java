package com.springboot.wmproject.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "food_name", nullable = true, length = 45)
    private String foodName;
    @Basic
    @Column(name = "food_type", nullable = true, length = 45)
    private String foodType;
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    private String description;
    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    private Double price;

    @OneToMany(mappedBy = "foodByFoodId",cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<FoodDetails> foodDetailsById;

}
