/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw.listRenders;

import br.univali.model.Effect;
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
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alisson
 */
public class EffectListRender extends DefaultListCellRenderer{
    
    BufferedImage image;
    
    public EffectListRender() {
        try {
            image = ImageIO.read(new File("./src/br/univali/resources/flor.jpg"));
            
        } catch (IOException ex) {
            Logger.getLogger(EffectListRender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel component = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        component.setHorizontalTextPosition(JLabel.CENTER);
        component.setVerticalTextPosition(JLabel.BOTTOM);
        component.setHorizontalAlignment(JLabel.CENTER);
        component.setVerticalAlignment(JLabel.CENTER);
        Effect effect = (Effect) value;
        component.setIcon(new ImageIcon(effect.apply(image)));
        component.setBorder(new EmptyBorder(4,4,4,4));
        
        return component;
    }
    
    
    
}
