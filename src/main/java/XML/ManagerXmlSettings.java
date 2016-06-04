package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ManagerXmlSettings {
    private static File file;
    private static Settings settings;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    static {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
            Marshaller m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            marshaller = m;
            unmarshaller = un;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshal(Settings settings){
        try {
            marshaller.marshal(settings,file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
