package JAXB.Libreria;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        Librerias librerias = new Librerias();

        //Creamos el contexto indicando la clase raiz
        JAXBContext context = JAXBContext.newInstance(Librerias.class);

        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller marshaller = context.createMarshaller();

        //Formateamos el xml para que quede bien
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //Lo visualizamos con system. out
        marshaller.marshal(librerias, System.out);

        //Escribimos en el archivo
        marshaller.marshal(librerias, new File("src/JAXB/Libreria/librerias.xml"));

        //Creamos el unmarshaller
        Unmarshaller unmarshaller = context.createUnmarshaller();

        //Leemos el flujo de entrada
        InputStream inputStream = new FileInputStream(new File("src/JAXB/Libreria/librerias.xml"));
        Librerias librerias_lectura = (Librerias) unmarshaller.unmarshal(inputStream);

        //Vemos que contiene
        System.out.println(librerias_lectura);

    }
}
