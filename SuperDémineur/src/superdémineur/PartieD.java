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
            int x = 1000;
            int y = 1000;
            
            while(x<=30){
                x = generateurAleat.nextInt();
            }
            
            while(y<=16){
                y = generateurAleat.nextInt();
            }
            
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
            
            if(choix==1){//si l'utilisateur décide de déminer 
                System.out.println("Quels sont les coordonnées x de la case à déminer ?");
                int x=saisieUtilisateur.nextInt();
                
                System.out.println("Quels sont les coordonnées y de la case à déminer ?");
                int y=saisieUtilisateur.nextInt();
                
                boolean vlr= plateau.presenceBombe(x, y); //on vérifie si il a une bombe
                boolean kit=plateau.presenceKit(x, y);//on vérifie s'il y a un kit
                
                if(vlr==true){//si presence de bombe
                    int vie=joueurCourant.nbVie();//on recup le nb de vie du joueur
                    
                    if(vie>0){//s'il lui reste des vies on lui en enlève une
                        joueurCourant.mort();
                        System.out.println("vous perdez une vie");
                        plateau.supprimerBombe(x, y);//on supprime la bombe pour continuer à jouer
                        
                    }
                    else{//sinon fin du jeu
                        System.out.println("vous avez perdu");
                        fin=true;
                    }
                }
                
                if(kit==true){//si présence de kit on recupère le kit et on le supprime
                    System.out.println("vous avez récupéré un kit de déminage");
                    plateau.supprimerKit(x, y);
                    joueurCourant.obtenirKit();
                }
                if(vlr==false){
                    
                }
                
            }
            
            if (choix==2){//si le joueur veut placer un drapeau
                
            }
            if (choix==3){//si l'utilisateur décide d'utiliser un kit
                
            }
            
            
        }
    }
}
