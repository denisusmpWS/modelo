package com.usmp.pe.com.usmp.pe.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;

public class Prueba {


    public static void main(String []args) throws JAXBException {

        Persona  e=new Persona();
        e.setId(1);
        e.setEstado(0);
        e.setNombre("DENIS");

            /*

            File fileXML = new File("test.xml");
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            JAXBContext context=JAXBContext.newInstance(Persona.class);
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(e, fileXML);
            marshaller.marshal(e, baos);
            String formatXML=new String(baos.toByteArray()).toString();
            System.out.println(formatXML);
*/
        JAXBContext context = JAXBContext.newInstance(Persona.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        m.marshal(e, sw);
        String result = sw.toString();
        System.out.println(result);
    }
}
