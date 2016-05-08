package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "transfer", "priority", "transcription","category"}, name = "word")
@XmlRootElement
public class Word {
    private String name;
    private String transfer;
    private String priority;
    private String transcription;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public static Word createWord(String name, String priority, String transfer, String transcription, String category){
        Word word = new Word();
        word.setName(name);
        word.setTransfer(transfer);
        word.setPriority(priority);
        word.setTranscription(transcription);
        word.setCategory(category);
        return word;
    }
}
