package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "best_before_date")
    private LocalDate bestBeforeDate;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private FoodType foodType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
