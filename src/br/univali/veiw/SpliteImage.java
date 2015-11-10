/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import java.awt.Dimension;
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
    private BufferedImage imageOld;
    private BufferedImage imageNew;
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

    public BufferedImage getImageOld() {
        return imageOld;
    }

    public BufferedImage getImageNew() {
        return imageNew;
    }
    
    
    private class CustomPanel extends JPanel{
        BufferedImage image;
        String lado;

        public BufferedImage getImage() {
            return image;
        }
        
        public CustomPanel(String lado) {
            super();
            this.setMinimumSize(new Dimension(5, 0));
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

