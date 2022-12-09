/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superdémineur;

import java.util.ArrayList;

/**
 *
 * @author proto
 */
public class Joueur {
    private String nom;
    private int pt_de_vie;
    private int kit_deminage;
    
    public Joueur(String nom1) {
        this.nom = nom1;
        this.pt_de_vie=3;
        this.kit_deminage=0;
    }
    
    public int nbVie(){
        return(pt_de_vie);
    }
    
    public void obtenirKit() {
        kit_deminage += 1;
    }
    
    
    public void utiliserKit() {
        kit_deminage -= 1;
    }    
    
    
    
}
