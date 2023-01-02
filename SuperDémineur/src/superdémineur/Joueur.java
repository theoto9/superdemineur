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
    private int pt_vie;
    private int kit_deminage;
    
    public Joueur(String nom1) {
        nom = nom1;
        pt_vie=3;
        kit_deminage=0;
    }
    
    public void affecter_nbkit(int i){
        kit_deminage=i;
    }
    
    public int nbVie(){
        System.out.print(pt_vie);
        return(pt_vie);
    }
    
    public int mort(){
        pt_vie-=1;
        return pt_vie;
    }
    
    public void obtenirKit() {
        kit_deminage += 1;
    }  
    public int nbKit(){
        return kit_deminage;
    }
    public void utiliserKit() {
        kit_deminage -= 1;
    }      
}
