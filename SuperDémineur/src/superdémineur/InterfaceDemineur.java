/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package superdémineur;

import java.util.Random;
import java.util.Scanner;




/**
 *
 * @author Dell
 */
public class InterfaceDemineur extends javax.swing.JPanel {
    public plateauJeu plateau;
    public Joueur joueurCourant;
    
    
    
    public static void main(String args[]) {
        
        System.out.println("OK");
        /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceDemineur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceDemineur().setVisible(true);
            }
        });
    }
    
     
    /**
     * Creates new form InterfaceDemineur
     */
    public InterfaceDemineur() {
        initComponents();
        
        plateau = new plateauJeu();
        panneau_bombe.setVisible(false);
        panneau_kit.setVisible(false);
        panneau_ptv.setVisible(false);
        useKit.setVisible(false);
        
        for(int i=27; i>=0;i--){
            for(int j=14;j>=0;j--){
             CelluleGraphique CellGraph = new CelluleGraphique(plateau.grille[i][j]); 
             panneau_grille.add(CellGraph);
            }
        }
    }
    
    
    
    public void placerBombe(int i){
        Random generateurAleat = new Random();
        
        for(int j=1 ; j<=i ; j++){
            
            
            
            
               int x = generateurAleat.nextInt(28);
            
            
            
                int y = generateurAleat.nextInt(15);
            
            
            if(plateau.presenceBombe(x, y)==false){
                plateau.placerBombe(x, y);
            }
            else{
                j-=1;
            }           
        }
    }
    
    public void cacherGrille(){
    for (int i=27;i>=0;i--){
        System.out.print("\n");
        for (int j=14;j>=0;j--){
            
            plateau.cacherCase(i, j);
            
            
        }
    }
  }
    
    public void initialiserPartie(){
     
        int nb_b= Integer.valueOf(choixBombe.getText());
        placerBombe(nb_b);
        
        cacherGrille();
        
    }
    public void LancerPartie(){
        
        
        
        Scanner saisieUtilisateur = new Scanner(System.in);
        boolean fin = false;
        while (fin==false){
            plateau.afficherGrilleSurConsole();
            System.out.println("\n1: Déminer \n2: drapeau\n3: retirer drapeau\n4: utiliser kit");
            int choix=saisieUtilisateur.nextInt();
            
            if(choix==1){//si l'utilisateur décide de déminer 
                System.out.println("Quelle est la ligne de la case à déminer ?");
                int x=saisieUtilisateur.nextInt()-1;
                
                System.out.println("Quelle est la colonne de la case à déminer ?");
                int y=saisieUtilisateur.nextInt()-1;
                
                boolean vlr= plateau.presenceBombe(x, y); //on vérifie si il a une bombe
                boolean kit=plateau.presenceKit(x, y);//on vérifie s'il y a un kit
                
                if(vlr==true){//si presence de bombe
                    System.out.println("vous avez touché une bombe");
                    int vie=joueurCourant.nbVie();//on recup le nb de vie du joueur
                    
                    if(vie>1){//s'il lui reste des vies on lui en enlève une
                        joueurCourant.mort();
                        System.out.println("vous perdez une vie\nnb de vie restante : ");
                        joueurCourant.nbVie();
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
//                    plateau.décacherCase(x, y);
//                    int a = plateau.nbBombesVoisines(x, y);
//                    System.out.println("il y a "+a+" bombes a proximité");
                    plateau.decouverteGalerie(x, y);
                }
                
            }
            
            if (choix==2){//si le joueur veut placer un drapeau
                System.out.println("Sur quelle ligne voulez vous le placer ?");
                int x=saisieUtilisateur.nextInt()-1;
                
                System.out.println("Sur quelle colonne voulez vous le placer ?");
                int y=saisieUtilisateur.nextInt()-1;
                
                plateau.placerDrapeau(x, y);
            }
            
            if(choix==3){
                System.out.println("Sur quelle ligne est le drapeau ?");
                int x=saisieUtilisateur.nextInt()-1;
                
                System.out.println("Sur quelle colonne est le drapeau ?");
                int y=saisieUtilisateur.nextInt()-1;
                
                plateau.suppDrapeau(x, y);
            }
            
            if (choix==4){//si l'utilisateur décide d'utiliser un kit
                int nb_kit=joueurCourant.nbKit();
                if(nb_kit>0){
                    joueurCourant.utiliserKit();
                    System.out.println("Sur quelle ligne voulez vous inspecter ?");
                    int x=saisieUtilisateur.nextInt()-1;
                
                    System.out.println("Sur quelle colonne voulez vous inspecter ?");
                    int y=saisieUtilisateur.nextInt()-1;
                    
                    boolean bombe=plateau.presenceBombe(x, y);
                    if(bombe==true){
                        System.out.println("il y a une bombe sur cette case");
                    }
                    else{
                        System.out.println("il n'y a pas de bombe sur cette case");
                    }
                }
                else{
                    System.out.println("vous n'avez pas de kit");
                }
            }
            
            
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneau_grille = new javax.swing.JPanel();
        panneau_bombe = new javax.swing.JPanel();
        nbBombes = new javax.swing.JLabel();
        nbB = new javax.swing.JLabel();
        panneau_kit = new javax.swing.JPanel();
        nombre_kit = new javax.swing.JLabel();
        nbKit = new javax.swing.JLabel();
        useKit = new javax.swing.JButton();
        lancerPartie = new javax.swing.JButton();
        panneau_ptv = new javax.swing.JPanel();
        PointVie = new javax.swing.JLabel();
        ptV = new javax.swing.JLabel();
        choix_bombe = new javax.swing.JPanel();
        choixDeBombe = new javax.swing.JLabel();
        choixBombe = new javax.swing.JTextField();

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(204, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panneau_grille.setBackground(new java.awt.Color(204, 204, 204));
        panneau_grille.setLayout(new java.awt.GridLayout(15, 28));
        add(panneau_grille, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 672, 360));

        panneau_bombe.setBackground(new java.awt.Color(102, 204, 255));
        panneau_bombe.setPreferredSize(new java.awt.Dimension(100, 50));
        panneau_bombe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nbBombes.setText("nombre bombe :");
        panneau_bombe.add(nbBombes, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        nbB.setText("nbBombes");
        panneau_bombe.add(nbB, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 28, -1, -1));

        add(panneau_bombe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panneau_kit.setBackground(new java.awt.Color(102, 204, 255));
        panneau_kit.setForeground(new java.awt.Color(51, 153, 255));
        panneau_kit.setPreferredSize(new java.awt.Dimension(100, 50));
        panneau_kit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre_kit.setText("Nombres Kit :");
        panneau_kit.add(nombre_kit, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, -1, -1));

        nbKit.setText("nbKit");
        panneau_kit.add(nbKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 28, -1, -1));

        add(panneau_kit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, 50));

        useKit.setBackground(new java.awt.Color(255, 0, 0));
        useKit.setText("utiliser Kit");
        add(useKit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        lancerPartie.setBackground(new java.awt.Color(255, 0, 0));
        lancerPartie.setText("Play");
        lancerPartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancerPartieActionPerformed(evt);
            }
        });
        add(lancerPartie, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 90, 30));

        panneau_ptv.setBackground(new java.awt.Color(102, 204, 255));
        panneau_ptv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PointVie.setText("Point de vie :");
        panneau_ptv.add(PointVie, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        ptV.setText("ptVie");
        panneau_ptv.add(ptV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        add(panneau_ptv, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 90, 50));

        choix_bombe.setBackground(new java.awt.Color(0, 204, 255));
        choix_bombe.setForeground(new java.awt.Color(0, 204, 255));
        choix_bombe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        choixDeBombe.setText("Combien de bombes");
        choix_bombe.add(choixDeBombe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 20));

        choixBombe.setText("Bombes?");
        choix_bombe.add(choixBombe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        add(choix_bombe, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 120, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void lancerPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancerPartieActionPerformed
        panneau_bombe.setVisible(true);
        panneau_kit.setVisible(true);
        panneau_ptv.setVisible(true);
        useKit.setVisible(true);
        initialiserPartie();
        panneau_grille.repaint();
        lancerPartie.setEnabled(true);
        choix_bombe.setVisible(false);
    }//GEN-LAST:event_lancerPartieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PointVie;
    private javax.swing.JTextField choixBombe;
    private javax.swing.JLabel choixDeBombe;
    private javax.swing.JPanel choix_bombe;
    private javax.swing.JButton lancerPartie;
    private javax.swing.JLabel nbB;
    private javax.swing.JLabel nbBombes;
    private javax.swing.JLabel nbKit;
    private javax.swing.JLabel nombre_kit;
    private javax.swing.JPanel panneau_bombe;
    private javax.swing.JPanel panneau_grille;
    private javax.swing.JPanel panneau_kit;
    private javax.swing.JPanel panneau_ptv;
    private javax.swing.JLabel ptV;
    private javax.swing.JButton useKit;
    // End of variables declaration//GEN-END:variables
}
