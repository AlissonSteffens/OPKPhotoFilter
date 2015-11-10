/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author 5663296
 */
public class Processador {

    BufferedImage imgOriginal;
    BufferedImage imgDestino;
    List<Effect> filtros;

    private ProcessadorListener listener;

    public Processador(BufferedImage imgOriginal, List<Effect> filtros, ProcessadorListener listener) {
        this.imgOriginal = imgOriginal;
        this.imgDestino = imgOriginal;
        this.filtros = filtros;
        this.listener = listener;
    }

    public void processa() {
        Runnable tarefaDeProcessamento = new Runnable() {

            @Override
            public void run() {
                listener.processamentoIniciado();

                for (int i = 0; i < filtros.size(); i++) {
                    Effect effect = filtros.get(i);
                    imgDestino = effect.apply(imgDestino);
                }

                listener.processamentoFinalizado(imgOriginal, imgDestino);
            }
        };

        Thread thread = new Thread(tarefaDeProcessamento);
        thread.start();
    
    }

}
