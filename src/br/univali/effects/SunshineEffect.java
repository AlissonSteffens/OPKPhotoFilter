/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.effects;

import br.univali.model.Effect;
import com.jhlabs.image.Colormap;
import com.jhlabs.image.EdgeFilter;
import com.jhlabs.image.LookupFilter;
import java.awt.image.BufferedImage;

/**
 *
 * @author 5663296
 */
public class SunshineEffect implements Effect{

    @Override
    public BufferedImage apply(BufferedImage bufferedImage) {
        BufferedImage image = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getType());
        return new LookupFilter(new Colormap() {

            @Override
            public int getColor(float f) {
                return (int) f*2;
            }
        }).filter(bufferedImage, image);
    }

    @Override
    public String toString() {
        return "Sun Shine";
    }
    
    
}
