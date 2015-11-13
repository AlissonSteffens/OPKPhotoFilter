/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.awt.image.BufferedImage;

/**
 *
 * @author 5663296
 */
public interface ImageEffectProcessorListener {
    
    void processamentoIniciado();
    void processamentoFinalizado(BufferedImage imageOld, BufferedImage imageNew);
}
