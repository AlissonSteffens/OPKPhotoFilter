/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import br.univali.model.Effect;
import java.awt.Color;
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
import javax.swing.border.LineBorder;

/**
 *
 * @author Alisson
 */
public class EffectListRender extends DefaultListCellRenderer{

    
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel component = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        Effect effect = (Effect) value;
        try {
            BufferedImage image = ImageIO.read(new File("./src/br/univali/resources/flor.jpg"));
            component.setIcon(new ImageIcon(effect.apply(image)));
        } catch (IOException ex) {
            Logger.getLogger(EffectListRender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(isSelected){
            component.setBorder(new LineBorder(Color.DARK_GRAY));
        }
        
        return component;
    }
    
    
    
}
