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
    public int nbBombes;
    
    public  CelluleDeGrille(){
       presenceBombe=false;
       presenceKit=false;
       drapeau=false;
       nbBombes=0;
    }
    

    
    public boolean presenceBombe (){
        
        if (presenceBombe == false){
            return(false);
        }
        else{
            return(true);
        }
        
    }
    
    public boolean presenceDrap (){
        
        if (drapeau == false){
            return(false);
        }
        else{
            return(true);
        }
        
    }
    
    public boolean presenceKit (){
        
        if (presenceKit == false){
            return(false);
        }
        else{
            return(true);
        }
        
    }
    
    
    public void placerBombe(){
        presenceBombe=true;
    }
    
    public void supprimerBombe(){
        presenceBombe=false;
    }
    
    
    public void placerKit(){
        presenceKit=true;
    }
    
    public void supprimerKit(){
        presenceKit=false;
    }
    
    public int nombreBombeVoisines(){
        return nbBombes;
    }
    
    public void placerDrapeau(){
        drapeau=true;
    }
    public void suppDrapeau(){
        drapeau=false;
    }
}
