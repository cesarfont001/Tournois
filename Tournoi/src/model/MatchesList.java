/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

/**
 *
 * @author 1212novermeulen
 */
public class MatchesList extends Observable{
    public enum TypeNotif {
        INIT, MATCH_SELECTED, MATCH_UNSELECTED, MATCH_UPDATED, MATCH_ADDED, MATCH_DELETED
    }
    
    private final List<Matches> matchs;
    private int numLineSelected = -1;
    
    public MatchesList() {
        matchs = new ArrayList<>();
    }
    
    public ListIterator listItMatchs(){
        return matchs.listIterator();
    }
            
    public Matches SelectedMatches() {
        return matchs.get(numLineSelected);
    }
    
    public Matches getMatches(int index){
        return matchs.get(index);
    }
    
    public int SelectedIndex() {
        return numLineSelected;
    }
    
    public List getMatchs(){
        return matchs;
    }
    
    public int nbMatch() {
        return matchs.size();
    }
    
    public boolean addMatch(Matches match) {
        matchs.add(match);
        numLineSelected = matchs.size()-1;
        notif(TypeNotif.MATCH_ADDED);
        return true;
    }
    
    public void select(int index) {
        numLineSelected = index;
        notif(TypeNotif.MATCH_SELECTED);
    }
    
    public boolean updateSelectedMatch(Matches match) {
        matchs.set(numLineSelected, match);
        notif(TypeNotif.MATCH_UPDATED);
        return true;
    }
    
    public boolean deleteSelectedMatch() {
        matchs.remove(numLineSelected);
        numLineSelected = matchs.size()-1;
        notif(TypeNotif.MATCH_DELETED);
        return true; 
    }
    
    public void unselect() {
        numLineSelected = -1;
        notif(TypeNotif.MATCH_UNSELECTED);
    }
    
    public void notif(TypeNotif typeNotif) {
        setChanged();
        notifyObservers(typeNotif);
    }

}
