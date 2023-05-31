package kz.Ivanov.crm.crm.manager.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "t_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phone;
    private String commentary;
    private boolean handled;
    @ManyToOne (fetch = FetchType.EAGER)
    private Course course;
    @ManyToMany (fetch = FetchType.EAGER)
    List <Operators> operators;
}
