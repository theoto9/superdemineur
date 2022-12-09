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
  
  public boolean presenceKit(int x, int y){
    boolean b=grille[x][y].presenceKit();
    return b;
    
    
    
} 
  public String placerBombe(int x, int y){
     grille[x][y].placerBombe();
    String b = "B"; 
        
    return b;
}
  
 public String placerDrapeau(int x, int y){
    grille[x][y].placerDrapeau();
    String d ="D";
    return d;
    
 }  
  public String placerKit(int x, int y){
    grille[x][y].placerKit();
    String k ="K";
    return k;
    
 } 
   public void suppDrapeau(int x, int y){
    grille[x][y].suppDrapeau();   
    
 } 
  public int nbBombesVoisines(int x, int y){
    int c =grille[x][y].nombreBombeVoisines();   
    return c;
 }  
  
}
