package kz.bitlab.FoodShop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "userName")
    private String userName;
    @Column (name="foodName")
    private String foodName;
    @Column (name="price")
    private int price;
    @Column (name = "amount")
    private int amount;
    @Column (name = "address")
    private String address;
    @Column (name = "image", length = 10000)
    private String linkToImage;
}
