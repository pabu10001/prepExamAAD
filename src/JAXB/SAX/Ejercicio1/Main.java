package JAXB.PruebaXML.Ejercicio1;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class Main {

    /*
    EJERCICIO-1
Acceso a ficheros con SAX, usando el fichero (Company.xml), muestra por pantalla el identificador del proyecto y el precio y al final un PRECIO TOTAL
SALIDA
Identificador del proyecto: 111
Precio: 1100.00
Identificador del proyecto: 112
Precio: 1200.00
Identificador del proyecto: 113
Precio: 800.00
TOTAL: 3100

     */
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        GestionContenido gestionContenido = new GestionContenido();
        xmlReader.setContentHandler(gestionContenido);
        InputSource xml_file = new InputSource("src/PruebaXML/proyecto.xml");
        xmlReader.parse(xml_file);
    }
}
