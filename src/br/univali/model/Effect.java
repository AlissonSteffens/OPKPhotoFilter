/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import com.jhlabs.image.AbstractBufferedImageOp;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alisson
 */
public class Effect {
    private String name;
    private Image preview;
    private AbstractBufferedImageOp imageOp;

    public Effect(String name, Image preview, AbstractBufferedImageOp imageOp) {
        this.name = name;
        this.preview = preview;
        this.imageOp = imageOp;
    }
   
    public BufferedImage apply(BufferedImage image){
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        imageOp.filter(image, bufferedImage);
        return bufferedImage;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
