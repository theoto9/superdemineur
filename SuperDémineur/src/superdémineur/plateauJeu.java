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
    public CelluleDeGrille[][] grille = new CelluleDeGrille[30][16];
    
  public plateauJeu(){
    for (int i=0;i<30;i++){
        for(int j=0;j<16;j++){
            grille[i][j]  = new CelluleDeGrille();
            
        }
    }
  }
  
  
  
  public void afficherGrilleSurConsole(){
    for (int i=29;i>=0;i--){
        System.out.print("\n");
        for (int j=15;j>=0;j--){
            
            System.out.print(grille[i][j]);
            
            
        }
    }
  }
  public boolean presenceBombe(int x, int y){
    boolean a=grille[x][y].presenceBombe();
    return a;
 
  }
  
  public boolean presenceDrap(int x, int y){
      boolean a = grille[x][y].presenceDrap();
      return a;
  }
  
  public boolean presenceKit(int x, int y){
    boolean b=grille[x][y].presenceKit();
    return b;
    
    
    
} 
  
  public void cacherCase(int x, int y){
      grille[x][y].cacherCase();
  }
  
  public void décacherCase(int x, int y){
      grille[x][y].décacherCase();
  }
  
  public void placerBombe(int x, int y){
     grille[x][y].placerBombe();
    
}
 
public void supprimerBombe(int x, int y){
     grille[x][y].supprimerBombe();
    
}  
  
 public void placerDrapeau(int x, int y){
    grille[x][y].placerDrapeau();
    
    
 }  
  public void placerKit(int x, int y){
    grille[x][y].placerKit();
    
    
 } 
  public void supprimerKit(int x, int y){
    grille[x][y].supprimerKit();
    
    
 }
   public void suppDrapeau(int x, int y){
    grille[x][y].suppDrapeau();
    
    
 } 
  public int nbBombesVoisines(int x, int y){
    int c =grille[x][y].nombreBombeVoisines();   
    return c;
 }  
 
  
}
