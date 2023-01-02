/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superdémineur;

/**
 *
 * @author Dell
 */
public class CelluleDeGrille {

    private boolean presenceBombe;
    private boolean presenceKit;
    private boolean drapeau;
    private boolean statut;
    private boolean solution;
    public int nbBombes;

    public CelluleDeGrille() {
        presenceBombe = false;
        presenceKit = false;
        drapeau = false;
        solution = false;
        nbBombes = 0;
    }

    public void solution() {
        solution = true;
    }

    public void cacherCase() {
        statut = true;//statut en true <=> case cachée
    }

    public void décacherCase() {
        statut = false;
    }

    public boolean statutCase() {
        return statut;
    }

    public boolean presenceBombe() {

        if (presenceBombe == false) {
            return (false);
        } else {
            return (true);
        }

    }

    public boolean presenceDrap() {

        if (drapeau == false) {
            return (false);
        } else {
            return (true);
        }

    }

    public boolean presenceKit() {

        if (presenceKit == false) {
            return (false);
        } else {
            return (true);
        }

    }

    public void placerBombe() {
        presenceBombe = true;
    }

    public void supprimerBombe() {
        presenceBombe = false;
    }

    public void placerKit() {
        presenceKit = true;
    }

    public void supprimerKit() {
        presenceKit = false;
    }

    public void attribuerNbBombe(int a) {
        nbBombes = a;
    }

    public int nombreBombeVoisines() {
        return nbBombes;
    }

    public void placerDrapeau() {
        drapeau = true;
    }

    public void suppDrapeau() {
        drapeau = false;
    }

    @Override
    public String toString() {

        if (solution == true) {
            if (presenceBombe() == true) {
                return "B";

            } else {
                return ".";
            }
        }

        int a = nombreBombeVoisines();

        if (presenceDrap() == true) {
            return "D";
        }

        if (a == 1) {
            return "1";
        }

        if (a == 2) {
            return "2";
        }
        if (a == 3) {
            return "3";
        }
        if (a == 4) {
            return "4";
        }
        if (a == 5) {
            return "5";
        }
        if (a == 6) {
            return "6";
        }
        if (a == 7) {
            return "7";
        }
        if (a == 8) {
            return "8";
        }
        if (presenceDrap() == true) {
            return "D";
        }
        if (statutCase() == true && presenceDrap() == false) {
            return "/";//case cachée
        } else {
            return ".";//case déminée
        }

//if(presenceBombe()==true){
//    return"B";
//    
//}
//else{
//    return ".";
//}
    }

}
