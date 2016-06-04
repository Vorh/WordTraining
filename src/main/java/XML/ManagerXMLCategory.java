package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class ManagerXmlCategory {

    private static File file;
    private static Category category;
    private static Marshaller marshaller;
    private static Unmarshaller unmarshaller;

    static {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
            Marshaller m = jaxbContext.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller =  m;
            Unmarshaller un = jaxbContext.createUnmarshaller();
            unmarshaller = un;

            isWordFile();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshal(Word word){
        try {
            Category category = unmarshaller();
            category.getList().add(word);
            marshaller.marshal(category,file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static Category unmarshaller(){
        try {
            category = (Category) unmarshaller.unmarshal(file);
            return category;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Category createCategory(String name){
        try {
            Category category = new Category();
            category.setName(name);
            category.setPath(file);
            marshaller.marshal(category, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return category;
    }

    public static void isWordFile(){
        String path = Category.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String dirPath = new File(path).getParent();
        String name = "SaveWord";
        file = new File(dirPath+"\\" + name + ".xml");
        if(!file.exists()){
            createCategory(name);
        }
    }

    public static void marshalSave (List<Word> list){
        category.getList().clear();
        for (Word record : list) {
            category.getList().add(record);
        }
        try {
            marshaller.marshal(category, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
