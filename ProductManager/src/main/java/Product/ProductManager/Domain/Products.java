package Product.ProductManager.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String name;
    private int price;
    private int stock;

}
