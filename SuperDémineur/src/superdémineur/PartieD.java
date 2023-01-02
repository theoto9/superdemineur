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
    
    public plateauJeu plateau;
    public Joueur joueurCourant;
    
    
    public PartieD(Joueur j) {
        
        joueurCourant = j;
        plateau = new plateauJeu();
    }
    
    private void placerBombe(int i) {
        Random generateurAleat = new Random();
        
        for (int j = 0; j <= i; j++) {
            
            int x = generateurAleat.nextInt(30);
            
            int y = generateurAleat.nextInt(16);
            
            if (plateau.presenceBombe(x, y) == false) {
                plateau.placerBombe(x, y);
            } else {
                j -= 1;
            }            
        }
    }
    
    private void placerKit() {
        Random generateurAleat = new Random();
        
        for (int j = 0; j <= 5; j++) {
            
            int x = generateurAleat.nextInt(30);
            
            int y = generateurAleat.nextInt(16);
            
            if (plateau.presenceKit(x, y) == false) {
                plateau.placerKit(x, y);
            } else {
                j -= 1;
            }            
        }
    }
    
    
    
    public void cacherGrille() {
        for (int i = 29; i >= 0; i--) {
            System.out.print("\n");
            for (int j = 15; j >= 0; j--) {
                
                plateau.cacherCase(i, j);
                
            }
        }
    }
    
    public void initialiserPartie() {
        Scanner saisieUtilisateur = new Scanner(System.in);
        
        System.out.println("Quel est le nom du joueur 1");//On demande le nom du j1
        String n_j1 = saisieUtilisateur.nextLine();
        Joueur J1 = new Joueur(n_j1);
        
        System.out.println("Combien de bombes voulez vous placer ?");
        int nb_b = saisieUtilisateur.nextInt();
        nb_b -= 1;
        placerBombe(nb_b);
        placerKit();
        cacherGrille();
        
    }
    
    public void LancerPartie() {
        
        Scanner saisieUtilisateur = new Scanner(System.in);
        boolean fin = false;
        
        while (fin == false) {
            plateau.afficherGrilleSurConsole();
            
            
            
            System.out.println("\n1: Déminer \n2: drapeau\n3: retirer drapeau\n4: utiliser kit\n5: donner la solution");
            int choix = saisieUtilisateur.nextInt();
            
            if (choix == 1) {//si l'utilisateur décide de déminer 
                System.out.println("Quelle est la ligne de la case à déminer ?");
                int x = saisieUtilisateur.nextInt() - 1;
                
                System.out.println("Quelle est la colonne de la case à déminer ?");
                int y = saisieUtilisateur.nextInt() - 1;
                
                boolean vlr = plateau.presenceBombe(x, y); //on vérifie si il a une bombe
                boolean kit = plateau.presenceKit(x, y);//on vérifie s'il y a un kit
                
                if (vlr == true) {//si presence de bombe
                    System.out.println("vous avez touché une bombe");
                    int vie = joueurCourant.nbVie();//on recup le nb de vie du joueur
                    
                    if (vie > 1) {//s'il lui reste des vies on lui en enlève une
                        joueurCourant.mort();
                        System.out.println("vous perdez une vie\nnb de vie restante : ");
                        joueurCourant.nbVie();
                        plateau.supprimerBombe(x, y);//on supprime la bombe pour continuer à jouer
                        
                    } else {//sinon fin du jeu
                        System.out.println("vous avez perdu");
                        fin = true;
                    }
                }
                
                if (kit == true) {//si présence de kit on recupère le kit et on le supprime
                    System.out.println("vous avez récupéré un kit de déminage");
                    plateau.supprimerKit(x, y);
                    joueurCourant.obtenirKit();
                }
                if (vlr == false) {
//                    plateau.décacherCase(x, y);
//                    int a = plateau.nbBombesVoisines(x, y);
//                    System.out.println("il y a "+a+" bombes a proximité");
                    plateau.decouverteGalerie(x, y);
                    
                    joueurCourant.affecter_nbkit(plateau.envoyer_kit());
                }
                
            }
            
            if (choix == 2) {//si le joueur veut placer un drapeau
                System.out.println("Sur quelle ligne voulez vous le placer ?");
                int x = saisieUtilisateur.nextInt() - 1;
                
                System.out.println("Sur quelle colonne voulez vous le placer ?");
                int y = saisieUtilisateur.nextInt() - 1;
                
                plateau.placerDrapeau(x, y);
            }
            
            if (choix == 3) {
                System.out.println("Sur quelle ligne est le drapeau ?");
                int x = saisieUtilisateur.nextInt() - 1;
                
                System.out.println("Sur quelle colonne est le drapeau ?");
                int y = saisieUtilisateur.nextInt() - 1;
                
                plateau.suppDrapeau(x, y);
            }
            
            if (choix == 4) {//si l'utilisateur décide d'utiliser un kit
                int nb_kit = joueurCourant.nbKit();
                if (nb_kit > 0) {
                    plateau.ut_kit();
                    joueurCourant.utiliserKit();
                    System.out.println("Sur quelle ligne voulez vous inspecter ?");
                    int x = saisieUtilisateur.nextInt() - 1;
                    
                    System.out.println("Sur quelle colonne voulez vous inspecter ?");
                    int y = saisieUtilisateur.nextInt() - 1;
                    
                    boolean bombe = plateau.presenceBombe(x, y);
                    if (bombe == true) {
                        System.out.println("il y a une bombe sur cette case");
                    } else {
                        System.out.println("il n'y a pas de bombe sur cette case");
                    }
                } else {
                    System.out.println("vous n'avez pas de kit");
                }
            }
            if (choix==5){
                
                plateau.Donnersolution();
                plateau.afficherGrilleSurConsole();
                fin = true;
                
            } 
        }
    }
}
