/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui;

import com.codename1.capture.Capture;
import com.mycompany.entities.User;
import com.mycompany.services.serviceUtilisateur;
import com.mycompany.utils.Statics;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;


public class UFrontProfilUpdate extends BaseForm{
    
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));

    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.Label mailLabel = new com.codename1.ui.Label();
    private com.codename1.ui.Label nomLabel = new com.codename1.ui.Label();
    private com.codename1.ui.Label lastnomLabel = new com.codename1.ui.Label();
    private com.codename1.ui.Label passwordLabel = new com.codename1.ui.Label();
    private com.codename1.ui.Label passwordreLabel = new com.codename1.ui.Label();

    private com.codename1.ui.TextField mailText = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField nomText = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField lastnomText = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField passwordText = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField passwordreText = new com.codename1.ui.TextField();
    
    protected com.codename1.ui.Button btnCapture = new com.codename1.ui.Button("upload");
     protected Label lblimage=new Label();
     
   Container c5 = new Container(new FlowLayout(CENTER, CENTER));
     String path="";

    
    private com.codename1.ui.Button btnInscri = new com.codename1.ui.Button();
    
    
    public UFrontProfilUpdate(String mail) {
        this(com.codename1.ui.util.Resources.getGlobalResources(), mail);
    } 
    
     public UFrontProfilUpdate(com.codename1.ui.util.Resources resourceObjectInstance,String mail) {
        initGuiBuilderComponents(resourceObjectInstance);
        installSidemenu(resourceObjectInstance);
        remplirUser(mail,resourceObjectInstance);
     
    }
     private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {

        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Modification profil");
        setName("InscriForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        //gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);

        Container c1 = new Container(new FlowLayout(CENTER, CENTER));
        Container c2 = new Container(new FlowLayout(CENTER, CENTER));
        Container c3 = new Container(new FlowLayout(CENTER, CENTER));
        Container c4 = new Container(new FlowLayout(CENTER, CENTER));
        
        Container c6 = new Container(new FlowLayout(CENTER, CENTER));
        

        nomLabel.setText("nom d'utilisateur");
        lastnomLabel.setText("prenom d'utilisateur");
        
        mailLabel.setText("adresse mail");
        passwordLabel.setText("mot de passe");
        passwordreLabel.setText("confirmer votre mot de passe");
        c1.addComponent(nomLabel);
        c1.addComponent(nomText);
        
        c2.addComponent(mailLabel);
        c2.addComponent(mailText);
        c3.addComponent(passwordLabel);
        c3.addComponent(passwordText);
        c4.addComponent(passwordreLabel);
        c4.addComponent(passwordreText);
        
        c5.addComponent(lblimage);
        c5.addComponent(btnCapture);
        
        c6.addComponent(lastnomLabel);
        c6.addComponent(lastnomText);
        
        mailText.setEnabled(false);

        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(c1);
        gui_Component_Group_1.addComponent(c6);
        gui_Component_Group_1.addComponent(c2);
        gui_Component_Group_1.addComponent(c3);
        gui_Component_Group_1.addComponent(c4);
        gui_Component_Group_1.addComponent(c5);

        
        btnInscri.setText("Confirmer");
        btnInscri.setName("btnInscri");
        gui_Container_1.addComponent(btnInscri);
        
        gui_Component_Group_1.setName("Component_Group_1");

     
       

        btnInscri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!mailText.getText().isEmpty() && !nomText.getText().isEmpty() && !lastnomText.getText().isEmpty() && !passwordreText.getText().isEmpty() && !passwordreText.getText().isEmpty() && !path.equals("") ) {
                    
                        if(passwordText.getText().equals(passwordreText.getText())){
                        User user = new User();
                        user.setEmail(mailText.getText());
                        user.setName(nomText.getText());
                        user.setLastName(lastnomText.getText());
                        user.setPassword(passwordText.getText());
                        user.setPicture(path);
                        

                        serviceUtilisateur su = serviceUtilisateur.getInstance();

                        if (su.Update(user)) {
                            Dialog.show("Profil", "Modification effectu??e", new Command("OK"));
                            Statics.userconnecter.setLastName(lastnomText.getText());
                            Statics.userconnecter.setPassword(passwordText.getText());
                            Statics.userconnecter.setName(nomText.getText());
                        } else {
                            Dialog.show("Profil", "Erreur de modification", new Command("OK"));
                        }
                        new Accueil().show();
                    }else{
                         Dialog.show("V??rification", "Les 2 mots de passe sont diff??rents ", new Command("OK"));   
                        } 
                    

                } else {
                    Dialog.show("Inscription", "Les champs ne doivent pas ??tre vide", new Command("OK"));
                }
            }
        });
        
        btnCapture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String _path=new String(path);
                path= Capture.capturePhoto(c5.getWidth(),btnCapture.getHeight()*5);
            if (path!=null){
                   try {
                       Image img=Image.createImage(path);
                       lblimage.setIcon(img);
                       c5.revalidate();
                      
                   } catch (IOException ex) {
                     
                   }
            }else{
              path=new String(_path);  
            }
            }
        });
    }


    @Override
     protected boolean isCurrentProfils() {
        return true;
    }
     
    public void remplirUser(String mail,com.codename1.ui.util.Resources resourceObjectInstance) {
        serviceUtilisateur suser=serviceUtilisateur.getInstance();
      User u=  suser.GetUserByEmail(mail);
      nomText.setText(u.getFirstName());
      lastnomText.setText(u.getLastName());
      mailText.setText(u.getEmail());

      
      Image img;
        try {
            path=u.getPicture();
            img = Image.createImage(path);
              lblimage.setIcon(img);
                       c5.revalidate();
        } catch (IOException ex) {
            
        }
                     
      
    }

     
}


