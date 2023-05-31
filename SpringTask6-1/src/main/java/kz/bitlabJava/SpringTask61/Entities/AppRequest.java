package kz.bitlabJava.SpringTask61.Entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_requests")
@Getter
@Setter
public class AppRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;

    private String commentary;

    private String phone;

    private boolean handled;
    @ManyToOne
    Courses courses;
}
