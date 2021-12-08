package JAXB.PruebaXML.Ejercicio2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"id_proyect", "price", "lista_productos"})
public class Project {
    private int id_proyect;
    private  double price;
    private List<Product> lista_productos;

    public Project() {
    }

    public Project(int id_proyect, double price) {
        this.id_proyect = id_proyect;
        this.price = price;
        this.lista_productos= new ArrayList<>();
    }

    @XmlElement(name = "id-project")
    public int getId_proyect() {
        return id_proyect;
    }

    public void setId_proyect(int id_proyect) {
        this.id_proyect = id_proyect;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    public List<Product> getLista_productos() {
        return lista_productos;
    }

    public void setLista_productos(List<Product> lista_productos) {
        this.lista_productos = lista_productos;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id_proyect=" + id_proyect +
                ", price=" + price +
                ", lista_productos=" + lista_productos +
                '}';
    }
}
