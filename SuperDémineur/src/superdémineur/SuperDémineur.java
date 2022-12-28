/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package superdémineur;

/**
 *
 * @author Dell
 */
public class SuperDémineur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur J1=new Joueur("greg");
        PartieD Jouons=new PartieD(J1);
        
        Jouons.initialiserPartie();
        
        System.out.println("lancement partie");
        
        Jouons.LancerPartie();
    }
    
    
    
}
