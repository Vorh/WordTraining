package Model;

import View.TaskPane;

import java.util.Collections;
import java.util.List;

public class ManagerTask {

    private static int score;
    public static int amountWord = 3;
    public static List<Word> listWord;

    public static void extraditionSetWord(){
        listWord = ManagerXML.unmarshaller().getList();

        Collections.sort(listWord, (o1, o2) -> {
            Word a = (Word) o1;
            Word b = (Word) o2;
            return a.getPriority().compareTo(b.getPriority());
        });
        installationWord();
        score = 0;

    }

    public static void installationWord(){
        if(score > amountWord) {
            TaskPane.needWordName.setText(listWord.get(amountWord).getName());
            TaskPane.needWordTransfer.setText(listWord.get(amountWord).getName());
        }else {

        }
    }

    public static void result(boolean result){
        int a = Integer.parseInt(listWord.get(amountWord).getPriority());
        if(result == true){
            listWord.get(amountWord).setPriority(String.valueOf(a++));
        }else {
            listWord.get(amountWord).setPriority(String.valueOf(a--));
        }
        score++;
    }

}
