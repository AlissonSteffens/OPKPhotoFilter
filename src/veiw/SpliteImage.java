/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author 5663296
 */
public class SpliteImage extends JSplitPane{
    BufferedImage imageOld;
    BufferedImage imageNew;
    int dividerLocation;
    
    public SpliteImage() {
        
    }

    public void setImages(BufferedImage imageOld, BufferedImage imageNew) {
        this.imageOld = imageOld;
        this.imageNew = imageNew;
        JPanel leftPanel = new CustomPanel("esquerda");
        JPanel rightPanel = new CustomPanel("direita");
        dividerLocation = this.getDividerLocation();
        this.setLeftComponent(leftPanel);
        this.setRightComponent(rightPanel);
    }
     
    private class CustomPanel extends JPanel{
        BufferedImage image;
        String lado;
        public CustomPanel(String lado) {
            super();
            this.lado=lado;
            if(lado.equals("esquerda"))
            {
                image =imageOld;
            }
            else{
                image = imageNew;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D gd2 = (Graphics2D) g;
            gd2.setColor(Color.red);

            if(lado.equals("esquerda"))
            {
                gd2.drawImage(image, 0, 0, this.getParent().getWidth(), this.getHeight(), null);
            }
            else
            {
                gd2.drawImage(image, getWidth()-this.getParent().getWidth(), 0, this.getParent().getWidth(), this.getHeight(), null);
            }
        }
        
        
        
    }
}

