/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw.listRenders;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Alisson
 */
public class AppliedEffectsListRender extends DefaultListCellRenderer{
    
    BufferedImage image;
    
    public AppliedEffectsListRender() {
        try {
            image = ImageIO.read(new File("./src/br/univali/resources/icons/close.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(AppliedEffectsListRender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel component = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        
//        component.setHorizontalTextPosition(JLabel.CENTER);
//        component.setVerticalTextPosition(JLabel.BOTTOM);
//        component.setHorizontalAlignment(JLabel.CENTER);
//        component.setVerticalAlignment(JLabel.CENTER);

        
        component.setIcon(new ImageIcon(image));
        
        return component;
    }
    
}
