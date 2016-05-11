package Model;

import View.TaskPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerTask {

    private static int score;
    public static int amountWord = 3;
    public static List<Word> listWord;

    public static void extraditionSetWord(){
        List<Word> temp = ManagerXML.unmarshaller().getList();
        listWord = new ArrayList<>();
        for (int i = 0; i < amountWord; i++) {
            listWord.add(temp.get(i));
        }

        Collections.sort(listWord, (o1, o2) -> {
            Word a = o1;
            Word b = o2;
            return a.getPriority().compareTo(b.getPriority());
        });
        installationWord();
        score = 0;

    }

    public static void installationWord(){
        if(score < amountWord) {
            TaskPane.needWordName.setText(listWord.get(score).getName());
            TaskPane.needWordTransfer.setText(listWord.get(score).getTransfer());
        }else {
            System.out.println("Молодец");
            ManagerXML.marshalSave(listWord);
        }
    }

    public static void result(boolean result){
        int a = Integer.parseInt(listWord.get(score).getPriority());
        if(result == true){
            listWord.get(score).setPriority(String.valueOf(++a));
        }else {
            listWord.get(score).setPriority(String.valueOf(--a));
        }
        score++;
    }

}
