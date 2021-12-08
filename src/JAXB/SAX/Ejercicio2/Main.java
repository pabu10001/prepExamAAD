package JAXB.SAX.Ejercicio2;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    /*
    EJERCICIO -2
        Trabaja con JAXB, para ello partimos de un fichero XML (Company.xml)
        -	Crear las clases objetos para poder trabajar con dicho fichero.
        -	Una vez creadas las clases objeto, traspasa a ellas el XML.
        -	Realiza las operaciones oportunas, para eliminar el ratón de id=322
        -	Añade al proyect id=112, un nuevo product, con id=222 y name=Keyboard

     */
    static Projects projects;
    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Projects.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        projects = (Projects) unmarshaller.unmarshal(new File("src/PruebaXML/proyecto.xml"));

        //Elimino el raton con id = 322.
        delProduct(322);

        //Añado un producto con id 222 llamado Keyboard al proyecto 112.
        addProductToProyect(112, 222, "Keyboard");

        //Salida para comprobar el resultado.
        marshaller.marshal(projects, System.out);
    }


    //Metodo para eliminar un producto que tenga la id del parametro
    public static void delProduct(int id) {
        for (Project proyect: projects.getLista_proyectos() ) {
            proyect.getLista_productos().removeIf(product -> product.getId_product() == id);
        }
    }

    //Metodo para añadir un producto a un proyecto
    public static void addProductToProyect(int num_project, int id_product, String name){
        for (Project project:
             projects.getLista_proyectos()) {
            if (project.getId_proyect() == num_project)
                project.getLista_productos().add(new Product(id_product, name));
        }
    }
}
