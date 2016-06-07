package XML;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;

@XmlType (propOrder = {"hours","minutes","second", "countWord", "minPriority", "path", "soundFile"})
@XmlRootElement
public class Settings {
    private int hours;
    private int minutes;
    private int second;
    private int countWord;
    private int minPriority;
    private File path;
    private File soundFile;

    public File getSoundFile() {
        return soundFile;
    }
    public void setSoundFile(File soundFile) {
        this.soundFile = soundFile;
    }



    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }


    public int getCountWord() {
        return countWord;
    }

    public void setCountWord(int countWord) {
        this.countWord = countWord;
    }

    public int getMinPriority() {
        return minPriority;
    }

    public void setMinPriority(int minPriority) {
        this.minPriority = minPriority;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
