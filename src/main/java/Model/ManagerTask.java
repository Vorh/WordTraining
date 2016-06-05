package Model;

import View.StatisticsTable;
import View.TaskPane;
import View.TaskPaneWord;
import XML.ManagerXmlCategory;
import XML.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerTask {

    public static int score;
    public static int amountWord;
    public static List<Word> listWord;
    public static int countWord;

    public static void extraditionSetWord(int s){
        List<Word> temp = ManagerXmlCategory.unmarshaller().getList();
        amountWord = s;
        countWord = s;
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
        TaskPaneWord.wordCount.setText("Количество слов: " + ManagerTask.countWord);
        if(score < amountWord) {
            TaskPaneWord.needWordName.setText("Нужное слово: " + listWord.get(score).getName());
            TaskPaneWord.needWordTransfer.setText(listWord.get(score).getTransfer());
        }else {
            ManagerXmlCategory.marshalSave(listWord);
            TaskPane.startTimer.setDisable(false);
            StatisticsTable.addWordInTable(ManagerXmlCategory.unmarshaller().getList());
        }
    }

    public static void result(boolean result){
        int a = Integer.parseInt(listWord.get(score).getPriority());
        if(result == true){
            listWord.get(score).setPriority(String.valueOf(++a));
        }else {
            listWord.get(score).setPriority(String.valueOf(a));
        }
        score++;
        countWord--;
    }

}
