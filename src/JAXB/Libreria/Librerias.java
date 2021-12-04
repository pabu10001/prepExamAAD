package JAXB.Libreria;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "MisLibrerias")
public class Librerias {
    ArrayList<Libreria> librerias = new ArrayList<Libreria>();

    public Librerias() {
        Libreria libreria = new Libreria("Libreria_1", "Lugar_1");
        String libro;
        for (int i = 1; i <= 2; i++) {
            libro = "Libro" + i + "_1";
            libreria.getListaLibro().add(new Libro(libro, libro, libro, libro));
        }

        Libreria libreria1 = new Libreria("Libreria_2", "Lugar_2");
        for (int i = 1; i <= 3; i++) {
            libro = "Libro" + i + "_2";
            libreria1.getListaLibro().add(new Libro(libro,  libro, libro, libro));
        }
        librerias.add(libreria);
        librerias.add(libreria1);
    }

    @XmlElement(name = "Libreria")
    public ArrayList<Libreria> getLibrerias() {
        return librerias;
    }

    @Override
    public String toString() {
        return "Librerias{" +
                "librerias=" + librerias +
                '}';
    }
}
