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
    ImageIcon img_1 = new javax.swing.ImageIcon(getClass().getResource("/images/1.png"));
    ImageIcon img_2 = new javax.swing.ImageIcon(getClass().getResource("/images/2.png"));
    ImageIcon img_3 = new javax.swing.ImageIcon(getClass().getResource("/images/3.png"));
    ImageIcon img_4 = new javax.swing.ImageIcon(getClass().getResource("/images/4.png"));
    ImageIcon img_5 = new javax.swing.ImageIcon(getClass().getResource("/images/5.png"));
    ImageIcon img_6 = new javax.swing.ImageIcon(getClass().getResource("/images/6.png"));
    ImageIcon img_7 = new javax.swing.ImageIcon(getClass().getResource("/images/7.png"));
    ImageIcon img_8 = new javax.swing.ImageIcon(getClass().getResource("/images/8.png"));
    
    
    
    
    
    
    
    public CelluleGraphique (CelluleDeGrille uneCellule){
        celluleAssociees = uneCellule;
    }
    
    
  @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
       int i=0;
        //setIcon(img_gris);
       while(i!=0){ 
        if(celluleAssociees.presenceBombe()==true){
           setIcon(img_bombe); 
        }
        if(celluleAssociees.presenceBombe()==false){
           setIcon(img_blanc); 
        }
        if(celluleAssociees.presenceDrap()==true){
            setIcon(img_drapeau);
        }
        if(celluleAssociees.nombreBombeVoisines()==1){
            setIcon(img_1);
        }
        if(celluleAssociees.nombreBombeVoisines()==2){
            setIcon(img_2);
        }
        if(celluleAssociees.nombreBombeVoisines()==3){
            setIcon(img_3);
        }
        if(celluleAssociees.nombreBombeVoisines()==4){
            setIcon(img_4);
        }
        if(celluleAssociees.nombreBombeVoisines()==5){
            setIcon(img_5);
        }
        if(celluleAssociees.nombreBombeVoisines()==6){
            setIcon(img_6);
        }
        if(celluleAssociees.nombreBombeVoisines()==7){
            setIcon(img_7);
        }
        if(celluleAssociees.nombreBombeVoisines()==8){
            setIcon(img_8);
        }
   }
    
}
}
