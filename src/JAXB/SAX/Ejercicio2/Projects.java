package JAXB.SAX.Ejercicio2;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "projects")
public class Projects {
    private List<Project> lista_proyectos;

    public Projects() {
        lista_proyectos = new ArrayList<>();
    }

    @XmlElement(name = "project")
    public List<Project> getLista_proyectos() {
        return lista_proyectos;
    }

    public void setLista_proyectos(List<Project> lista_proyectos) {
        this.lista_proyectos = lista_proyectos;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "lista_proyectos=" + lista_proyectos +
                '}';
    }
}
