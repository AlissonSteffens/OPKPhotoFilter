/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5663296
 */
public class EffectComposite implements Effect{
    
    private List<Effect> effects = new ArrayList<>();
    
    @Override
    public BufferedImage apply(BufferedImage bufferedImage) {
        BufferedImage image = bufferedImage;
              
        for (Effect effect : effects) {
            image = effect.apply(image);
        }
        
         return image;
    }
    
    public int numberOfEffects(){
        return effects.size();
    }
    public Effect get(int i){
        return effects.get(i);
    }
    
    public void addEffect(Effect effect){
        effects.add(effect);
    }
    
    public void removeEffect(int position){
        effects.remove(position);
    }
}
