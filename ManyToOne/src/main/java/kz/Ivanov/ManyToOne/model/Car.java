package kz.Ivanov.ManyToOne.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_cars")
@Getter
@Setter

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxSpeed;
    private int year;
    private double price;

    @ManyToOne
    private Country country;
}
