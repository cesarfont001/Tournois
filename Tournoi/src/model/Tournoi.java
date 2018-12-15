/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Norman
 */
public class Tournoi {
    
    private final String name;
    private final InscritsList inscritsList;
    private final MatchesList matchesList;
    
    public Tournoi(String name, InscritsList inscritsList, MatchesList matchs){
        this.name = name;
        this.inscritsList = inscritsList;
        this.matchesList = matchs;
        
    }
    public String getName() {
        return name;
    }
    
    
    public InscritsList getInscrits(){
        return inscritsList;
    }
    
    public MatchesList getMatchs(){
        return matchesList;
    }
    
    public ListIterator<Matches> ListItMatch(){
        return matchesList.listItMatchs();
    }
    
    public Resultat getResultat(){
        return matchesList.SelectedMatches().getScore();
    }
    
    public List<String> getNamePlayers(){
        return this.getInscrits().getNamePlayerList();
    }
    
    public Inscrit getNamePlayer1(){
        return matchesList.SelectedMatches().getPlayer1();
    }
    
    public Inscrit getNamePlayer2(){
        return matchesList.SelectedMatches().getPlayer2();
    }
}
