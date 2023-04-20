package madeby.common.util;

import madeby.common.data.data_class.Vehicles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XmlUtils {
    private final JAXBContext context;

    public XmlUtils() throws JAXBException {
        context = JAXBContext.newInstance(Vehicles.class);
    }

    public void serialize(Vehicles vehicles, String pathToXml) throws JAXBException {
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(vehicles, new File(pathToXml));
    }

    public Vehicles deserialize(String pathToXml) throws JAXBException, FileNotFoundException {

        return (Vehicles) context.createUnmarshaller()
                .unmarshal(new FileReader(pathToXml));
    }
}
