// autor : Norman & César 2018-2019// autor : Norman & César 2018-2019
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Text extends Observable {

    public enum TypeNotif {
        INIT, LINE_SELECTED, LINE_UNSELECTED, LINE_UPDATED, LINE_ADDED
    }

    private static final int MAX_WORD_LENGTH = 15;
    private final List<String> lines = new ArrayList<>();
    private int numLineSelected = -1;

    public Text() {
        initData();
    }

    public String SelectedLine() {
        return lines.get(numLineSelected);
    }

    public int SelectedIndex() {
        return numLineSelected;
    }

    public List<String> getLines() {
        return lines;
    }

    public int nbLines() {
        return lines.size();
    }

    public boolean addLine(String line) {
        if (line.length() <= MAX_WORD_LENGTH) {
            lines.add(line);
            numLineSelected = lines.size() - 1;
            notif(TypeNotif.LINE_ADDED);
            return true;
        }
        return false;
    }

    public void select(int index) {
        numLineSelected = index;
        notif(TypeNotif.LINE_SELECTED);
    }

    public boolean updateSelectedLine(String txt) {
        if (txt.length() <= MAX_WORD_LENGTH) {
            lines.set(numLineSelected, txt);
            notif(TypeNotif.LINE_UPDATED);
            return true;
        }
        return false;
    }

    public void unselect() {
        numLineSelected = -1;
        notif(TypeNotif.LINE_UNSELECTED);
    }

    public void notif(TypeNotif typeNotif) {
        setChanged();
        notifyObservers(typeNotif);
    }

    private void initData() {
        addLine("One");
        addLine("Two");
        addLine("Three");
    }

}

