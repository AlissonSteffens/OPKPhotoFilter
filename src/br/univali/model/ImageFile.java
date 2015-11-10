/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model;

import java.io.File;

/**
 *
 * @author 5663296
 */
public class ImageFile extends File{

    public ImageFile(String pathname) {
        super(pathname);
    }

    @Override
    public String toString() {
            return this.getName();
    }
    
    
}
