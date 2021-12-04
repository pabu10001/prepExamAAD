package JAXB.Libreria;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType(propOrder = {"nombre", "lugar", "listaLibro"})
public class Libreria {
    private ArrayList<Libro> listaLibro;
    private String nombre;
    private String lugar;

    public Libreria(String nombre, String lugar) {
        this.listaLibro = new ArrayList<Libro>();
        this.nombre = nombre;
        this.lugar = lugar;
    }

    public Libreria() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlElementWrapper(name = "MiListaLibros")
    @XmlElement(name = "Libro")
    public ArrayList<Libro> getListaLibro() {
        return listaLibro;
    }

    public void setListaLibro(ArrayList<Libro> listaLibro) {
        this.listaLibro = listaLibro;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "listaLibro=" + listaLibro +
                ", nombre='" + nombre + '\'' +
                ", lugar='" + lugar + '\'' +
                '}';
    }
}
