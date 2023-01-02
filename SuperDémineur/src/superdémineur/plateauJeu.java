/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superdémineur;

/**
 *
 * @author Dell
 */
public class plateauJeu {
    
    int nb_kit;
    boolean solution;
    public CelluleDeGrille[][] grille = new CelluleDeGrille[30][16];

    public plateauJeu() {
        solution=false;
        nb_kit=0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 16; j++) {
                grille[i][j] = new CelluleDeGrille();

            }
        }
    }
    
    
    
    public void Donnersolution(){
        for (int i = 29; i >= 0; i--) {
            for (int j = 15; j >= 0; j--) {

                grille[i][j].solution();

            }
        }
    }
    
    public void afficherGrilleSurConsole() {
        for (int i = 29; i >= 0; i--) {
            System.out.print("\n");
            for (int j = 15; j >= 0; j--) {

                System.out.print(grille[i][j]);

            }
        }
    }

    public boolean presenceBombe(int x, int y) {
        boolean a = grille[x][y].presenceBombe();
        return a;

    }

    public boolean presenceDrap(int x, int y) {
        boolean a = grille[x][y].presenceDrap();
        return a;
    }

    public boolean presenceKit(int x, int y) {
        boolean b = grille[x][y].presenceKit();
        return b;

    }
    public int envoyer_kit(){
        return nb_kit;
    }
    public int aj_kit(){
        nb_kit+=1;
        return nb_kit;
    }
    
    public int ut_kit(){
        nb_kit-=1;
        return nb_kit;
    }
    
    public void cacherCase(int x, int y) {
        grille[x][y].cacherCase();
    }

    public void décacherCase(int x, int y) {
        grille[x][y].décacherCase();
    }

    public void placerBombe(int x, int y) {
        grille[x][y].placerBombe();

    }

    public void supprimerBombe(int x, int y) {
        grille[x][y].supprimerBombe();

    }

    public void placerDrapeau(int x, int y) {
        grille[x][y].placerDrapeau();

    }

    public void placerKit(int x, int y) {
        grille[x][y].placerKit();

    }

    public void supprimerKit(int x, int y) {
        grille[x][y].supprimerKit();

    }

    public void suppDrapeau(int x, int y) {
        grille[x][y].suppDrapeau();

    }

    public void decouverteGalerie(int lgn, int col) {

        int lgn2 = -1;
        int col2 = -1;

        //System.out.println("decouverte galerie : " + lgn + ", " + col);

        if (!grille[lgn][col].statutCase()) {//on regarde si la case à déja été découverte
            //System.out.println("deja decouverte");
            return;//si elle ai déjà découverte on quitte
        }
        
        if (this.presenceKit(lgn, col)){
            this.aj_kit();
            System.out.println("vous avez recupéré un kit");
        }
        
        grille[lgn][col].décacherCase();//si on est ici c'est que la case n'ai pas découverte et qu'elle ne contient pas de bombe

        int nb = nbBombesVoisines(lgn, col);//on chercher combien il y a de bombes aux alentours

        if (nb != 0) {//s'il y a des bombes aux alentours on lui attribue le nb de bombes voisines et on quitte

            //System.out.println("sortie rec voici le nb de bombe" + nb);
            grille[lgn][col].attribuerNbBombe(nb);

            return;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //si on est ici c'est que la case étudiée n'a aucune bombes aux alentours
        if (lgn != 29) {//si la case étudiée n'est pas sur la ligne la plus haute alors elle a une ligne au dessus d'elle
            if (col != 0) {//si la case n'est pas sur la colonne la plus a droite alors elle a une case à droite
                lgn2 = lgn + 1;
                col2 = col - 1;
                decouverteGalerie(lgn2, col2);//on explore alors cette case à droite
            }
            if (col != 15) {//si la case n'est pas sur la colonne la plus à gauche alors elle a une case a sa gauche
                lgn2 = lgn + 1;
                col2 = col + 1;
                decouverteGalerie(lgn2, col2);//on explore cette case a gauche
            }

            lgn2 = lgn + 1;
            col2 = col;
            decouverteGalerie(lgn2, col2);//on explore la case au dessus
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (lgn != 0) {//idem qu'en haut  
            if (col != 0) {
                lgn2 = lgn - 1;
                col2 = col - 1;
                decouverteGalerie(lgn2, col2);
            }
            if (col != 15) {
                lgn2 = lgn - 1;
                col2 = col + 1;
                decouverteGalerie(lgn2, col2);
            }
            lgn2 = lgn - 1;
            col2 = col;
            decouverteGalerie(lgn2, col2);
        }
        if (col != 0) {
            lgn2 = lgn;
            col2 = col - 1;
            decouverteGalerie(lgn2, col2);
        }
        if (col != 15) {
            lgn2 = lgn;
            col2 = col + 1;
            decouverteGalerie(lgn2, col2);
        }      
    }

    public int nbBombesVoisines(int x, int y) {
        int nb_voisine = 0;
        boolean N = false;
        boolean NO = false;
        boolean O = false;
        boolean SO = false;
        boolean S = false;
        boolean SE = false;
        boolean E = false;
        boolean NE = false;

        if (x == 0 && y != 0 && y != 15) {
            O = grille[x][y + 1].presenceBombe();
            NO = grille[x + 1][y + 1].presenceBombe();
            N = grille[x + 1][y].presenceBombe();
            NE = grille[x + 1][y - 1].presenceBombe();
            E = grille[x][y - 1].presenceBombe();
        }

        if (x == 29 && y != 0 && y != 15) {
            O = grille[x][y + 1].presenceBombe();
            SO = grille[x - 1][y + 1].presenceBombe();
            S = grille[x - 1][y].presenceBombe();
            SE = grille[x - 1][y - 1].presenceBombe();
            E = grille[x][y - 1].presenceBombe();
        }

        if (y == 0 && x != 0 && x != 29) {
            S = grille[x - 1][y].presenceBombe();
            SO = grille[x - 1][y + 1].presenceBombe();
            O = grille[x][y + 1].presenceBombe();
            NO = grille[x + 1][y + 1].presenceBombe();
            N = grille[x + 1][y].presenceBombe();
        }

        if (y == 15 && x != 0 && x != 29) {
            N = grille[x + 1][y].presenceBombe();
            NE = grille[x + 1][y - 1].presenceBombe();
            E = grille[x][y - 1].presenceBombe();
            SE = grille[x - 1][y - 1].presenceBombe();
            S = grille[x - 1][y].presenceBombe();
        }

        if (y == 15 && x == 29) {

            E = grille[x][y - 1].presenceBombe();
            SE = grille[x - 1][y - 1].presenceBombe();
            S = grille[x - 1][y].presenceBombe();
        }

        if (y == 0 && x == 29) {
            S = grille[x - 1][y].presenceBombe();
            SO = grille[x - 1][y + 1].presenceBombe();
            O = grille[x][y + 1].presenceBombe();
        }

        if (x == 0 && y == 0) {
            O = grille[x][y + 1].presenceBombe();
            NO = grille[x + 1][y + 1].presenceBombe();
            N = grille[x + 1][y].presenceBombe();

        }

        if (x == 0 && y == 15) {

            N = grille[x + 1][y].presenceBombe();
            NE = grille[x + 1][y - 1].presenceBombe();
            E = grille[x][y - 1].presenceBombe();
        }

        if (x != 0 && x != 29 && y != 0 && y != 15) {
            N = grille[x + 1][y].presenceBombe();
            NE = grille[x + 1][y - 1].presenceBombe();
            E = grille[x][y - 1].presenceBombe();
            SE = grille[x - 1][y - 1].presenceBombe();
            S = grille[x - 1][y].presenceBombe();
            SO = grille[x - 1][y + 1].presenceBombe();
            O = grille[x][y + 1].presenceBombe();
            NO = grille[x + 1][y + 1].presenceBombe();
        }

        if (N == true) {
            nb_voisine += 1;
        }
        if (NO == true) {
            nb_voisine += 1;
        }
        if (O == true) {
            nb_voisine += 1;
        }
        if (SO == true) {
            nb_voisine += 1;
        }
        if (S == true) {
            nb_voisine += 1;
        }
        if (SE == true) {
            nb_voisine += 1;
        }
        if (E == true) {
            nb_voisine += 1;
        }
        if (NE == true) {
            nb_voisine += 1;
        }

        return nb_voisine;
    }
    
    public void Solution(){
        
        
    }
        
    

}
