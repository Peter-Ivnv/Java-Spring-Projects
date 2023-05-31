package kz.CIS.CIScountries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "language")
    private String language;
    @Column(name = "size")
    private int size;
    @Column(name = "allies")
    private String allies;
    @Column(name = "enemies")
    private String enemies;
    @Column(name = "commentary")
    private String commentary;
    @Column (name = "picture")
    private String picture;

}
