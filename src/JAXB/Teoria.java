package JAXB;

public class Teoria {
        /*
        - La capacidad de serializar las referencias de objetos Java a XML, se llamara
            Marshall o marshalling
        - La capacidad de deserializar XML en objetos Java, lo llamaremos unmarshall o
            unmarshalling.

            Anotaciones:

            - @XmlRootElement(namespace = "namespace") --> Define la raiz del documento
            - @XmlTYpe(propOrder={“field2”,”field1”…}) --> Define el orden en el que se escriben los elementos
            - @XmlElement(name = "name") --> Define le el elemento

            A cualquiera de estos podemos especificar el nombre de la etiqueta con "name"

            Si el atributo es una coleccion, debe llevar dos anotaciones
            - @XmlElementWrapper
            - @XmlElement --> Esta puede llevar "name" si se desea
         */
}
