/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Alisson
 */
public class Loading extends JDialog{

    public Loading(Window owner) throws IOException {
        try {
            BufferedImage image= ImageIO.read(new File("./src/br/univali/resources/loading.gif"));
            Icon icon = new ImageIcon((Image) image);
            JLabel label = new JLabel(icon);

            JFrame f = new JFrame("Animation");
            f.getContentPane().add(label);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Loading.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
