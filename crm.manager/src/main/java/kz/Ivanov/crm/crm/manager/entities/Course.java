package kz.Ivanov.crm.crm.manager.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;

}
