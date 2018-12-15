/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Norman
 */
public final class TournoiList extends Observable{
    
    public enum TypeNotif { INIT, TOURNOI_SELECTED, TOURNOI_UNSELECTED }
    
    private int numTournoiSelected = -1;
    public List<Tournoi> tournoiList = new ArrayList<>();
    ObservableList<Tournoi> olTournoi = FXCollections.observableList(tournoiList);
    
    public TournoiList() {
        initDataTournoi();
    }
    
    public List getTournoiList() {
        return tournoiList;
    }
    
    public void setTournoiList(List tournoiList) {
        this.tournoiList = tournoiList;
    }
    public Tournoi SelectedTournoi(){
        return tournoiList.get(numTournoiSelected);
    }
    public int nbTournois(){
        return tournoiList.size();
    }
    public boolean addTournoi(Tournoi t){
        tournoiList.add(t);
        return true;
    }
    public String nameSelectedTournament() {
        return tournoiList.get(numTournoiSelected).getName();
    }
    
    public List<String> getNameTournois(){
        List<String> nameTournamentTab = new ArrayList<>();
        
        for(Tournoi t : tournoiList){
            nameTournamentTab.add(t.getName());
        }
        return nameTournamentTab;
    }
    public void select(int index) {
        numTournoiSelected = index;
        notif(TypeNotif.TOURNOI_SELECTED);
    }
    public int selectIndex(){
        return numTournoiSelected;
    }
    public void unselect() {
        numTournoiSelected = -1;
        notif(TypeNotif.TOURNOI_UNSELECTED);
    }
    public List<String> getNamePlayersTournoi(){
        return this.SelectedTournoi().getNamePlayers();
    }
    public void notif(TypeNotif typeNotif) {
        setChanged();
        notifyObservers(typeNotif);
    }
     
    public void initDataTournoi(){
       tournoiList.add(new Tournoi("YOYO CHAMPIONSHIP", new InscritsList(), new MatchesList()));
    }
    
}
