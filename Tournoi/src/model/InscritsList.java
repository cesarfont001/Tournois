/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Norman
 */
public final class InscritsList extends Observable{
    
    private final Set<Inscrit> inscrits;
    private final List<String> inscritList = new ArrayList<>();
    
    public InscritsList (){
        inscrits = new TreeSet<>();
        initedata();
    }
    
    public List<String> getNamePlayerList() {
        inscrits.forEach((p) -> {
            inscritList.add(p.getInscrits());
        });
        return inscritList;
    }

    public Set<Inscrit> getInscrits() {
        return inscrits;
    }
    
    public int nbInscrits() {
        return inscrits.size();
    }
    
    public void addInscrit(Inscrit inscrit){
        inscrits.add(inscrit);
    }
    
    /*public <Inscrit> inscritsList(){
        return inscrits;
    }*/
    
    public void initedata(){
        inscrits.add(new Inscrit("Norman"));
        inscrits.add(new Inscrit("jean"));
        inscrits.add(new Inscrit("sam"));
    } 
}
