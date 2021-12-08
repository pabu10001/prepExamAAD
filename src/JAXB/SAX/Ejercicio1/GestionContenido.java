package JAXB.PruebaXML.Ejercicio1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {
    static double total = 0;
    static boolean imprimir = false;
    static boolean sumar = false;

    public GestionContenido() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("id-project")){ System.out.print("Identificador del proyecto: "); imprimir = true;}
        if (qName.equals("price")) {System.out.print("Precio: "); imprimir = true; sumar = true;}
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        str = str.trim();
        try{
            if (sumar)
                total += Double.parseDouble(str);
        }catch (NumberFormatException ignored){}
        System.out.print(str.length() >= 1 && imprimir? str + "\n": "");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        imprimir = false;
        sumar = false;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("TOTAL: " + total);
    }
}
