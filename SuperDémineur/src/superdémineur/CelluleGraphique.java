/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superdémineur;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Dell
 */
public class CelluleGraphique extends JButton {
    CelluleDeGrille celluleAssociees;
    ImageIcon img_gris = new javax.swing.ImageIcon(getClass().getResource("/images/gris.png"));
    ImageIcon img_blanc = new javax.swing.ImageIcon(getClass().getResource("/images/Blanc.png"));
    ImageIcon img_bombe = new javax.swing.ImageIcon(getClass().getResource("/images/bombe.png"));
    ImageIcon img_drapeau = new javax.swing.ImageIcon(getClass().getResource("/images/drapeau.png"));
    
    public CelluleGraphique (CelluleDeGrille uneCellule){
        celluleAssociees = uneCellule;
    }
    
    
  @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
       
        setIcon(img_gris);
        
        if(celluleAssociees.presenceBombe()==true){
           setIcon(img_bombe); 
        }
        if(celluleAssociees.presenceBombe()==false){
           setIcon(img_blanc); 
        }
        if(celluleAssociees.presenceDrap()==true){
            setIcon(img_drapeau);
        }
   } 
}
