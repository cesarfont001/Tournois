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
public final class Matches{
    
    private Inscrit Player1;
    private Inscrit Player2;
    private Resultat score;
    
    public Matches(){
        
    }

    public Matches(Inscrit Player1, Inscrit Player2, Resultat score) {
        this.Player1 = Player1;
        this.Player2 = Player2;
        this.score = score;
    }
    
    public Inscrit getPlayer1() {
        return Player1;
    }

    public void setPlayer1(Inscrit Player1) {
        this.Player1 = Player1;
    }

    public Inscrit getPlayer2() {
        return Player2;
    }

    public void setPlayer2(Inscrit Player2) {
        this.Player2 = Player2;
    }

    public Resultat getScore() {
        return score;
    }

    public void setScore(Resultat score) {
        this.score = score;
    }   
    
}