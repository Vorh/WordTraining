package Model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "transfer", "priority", "transcription"}, name = "word")
@XmlRootElement
public class Word {
    private String name;
    private String transfer;
    private String priority;
    private String transcription;

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

    public Word (String name, String priority, String transfer, String transcription){
       setName(name);
       setTransfer(transfer);
        setPriority(priority);
        setTranscription(transcription);
    }
}
