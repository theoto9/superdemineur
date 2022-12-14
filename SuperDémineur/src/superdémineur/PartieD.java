/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superdémineur;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author proto
 */
public class PartieD {
    
    private plateauJeu plateau;
    private Joueur joueurCourant;
    
    
    public PartieD(Joueur j){
        joueurCourant=j;
    }
    
    private void placerBombe(int i){
        Random generateurAleat = new Random();
        
        for(int j=0 ; j<=i ; j++){
            
            int x = generateurAleat.nextInt();
            int y = generateurAleat.nextInt();
            
            if(plateau.presenceBombe(x, y)==false){
                plateau.placerBombe(x, y);
            }
            else{
                j-=1;
            }           
        }
    }
    
    private void initialiserPartie(){
        Scanner saisieUtilisateur = new Scanner(System.in);
        
        System.out.println("Quel est le nom du joueur 1");//On demande le nom du j1
        String n_j1=saisieUtilisateur.nextLine();
        Joueur J1=new Joueur(n_j1);
        
        System.out.println("Combien de bombes voulez vous placer ?");
        int nb_b=saisieUtilisateur.nextInt();
        
        placerBombe(nb_b);
        
    }
    
    private void LancerPartie(){      
        Scanner saisieUtilisateur = new Scanner(System.in);
        boolean fin = false;
        while (fin==false){
            System.out.println("1: Déminer \n2:drapeau\n3: utiliser kit");
            int choix=saisieUtilisateur.nextInt();
            
            if(choix==1){
                
            }
            
            
            
            
            
        }
    }
}
