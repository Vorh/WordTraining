package Model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ManagerXML {

    public static void marshal(Word word, File file){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            Category category = unmarshaller(file);

            category.getList().add(word);
            marshaller.marshal(category,file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static Category unmarshaller(File fIle){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Category category = (Category) unmarshaller.unmarshal(fIle);
            return category;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Category createCategory(String name){
        String path = Category.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String dirPath = new File(path).getParent();
        File file = new File(dirPath+"\\" + name + ".xml");

        Category category = new Category();
        category.setName(name);
        category.setPath(file);


        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(category, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return category;
    }
}
