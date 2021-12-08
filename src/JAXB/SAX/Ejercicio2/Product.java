package JAXB.SAX.Ejercicio2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id_product", "name"})
public class Product {

    private int id_product;
    private String name;

    public Product() {
    }

    public Product(int id_producto, String name) {
        this.id_product = id_producto;
        this.name = name;
    }

    @XmlElement(name = "id-product")
    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_producto=" + id_product +
                ", name='" + name + '\'' +
                '}';
    }
}
