package it.uniroma1.dis.wsngroup.gexf4j.core.impl;


import it.uniroma1.dis.wsngroup.gexf4j.core.Gexf;
import it.uniroma1.dis.wsngroup.gexf4j.core.GexfWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.impl.writer.GexfEntityWriter;
import it.uniroma1.dis.wsngroup.gexf4j.core.utils.PrettyPrintHandler;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Proxy;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.commons.io.output.WriterOutputStream;

/**
 * StaxGraphWriter class is an implementation of the GexfWriter interface.
 *
 */
public class StaxGraphWriter implements GexfWriter {

    @Override
    public void writeToStream(Gexf gexf, Writer out, String fileName, String encoding) throws IOException {
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter streamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            
            PrettyPrintHandler handler = new PrettyPrintHandler(streamWriter);
            streamWriter = (XMLStreamWriter) Proxy.newProxyInstance(
            		XMLStreamWriter.class.getClassLoader(),
            		new Class[]{XMLStreamWriter.class},
            		handler );
            
            streamWriter.writeStartDocument(encoding, "1.0");

            new GexfEntityWriter(streamWriter, gexf);

            streamWriter.writeEndDocument();

            streamWriter.flush();
            streamWriter.close();

        } catch (XMLStreamException e) {
            throw new IOException("XML Exception: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void writeToStream(Gexf gexf, OutputStream out, String fileName,String encoding) throws IOException {
        writeToStream(gexf, new OutputStreamWriter(out, encoding), fileName, encoding);
    }
}