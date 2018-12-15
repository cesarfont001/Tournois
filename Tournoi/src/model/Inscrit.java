/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Fontaine César
 */
public class Inscrit{
    
    private String Inscrit;
    
    public Inscrit(String player){
        this.Inscrit = player;
    }

    public String getInscrits() {
        return Inscrit;
    }

    public void setInscrits(String Inscrits) {
        this.Inscrit = Inscrits;
    }

}
