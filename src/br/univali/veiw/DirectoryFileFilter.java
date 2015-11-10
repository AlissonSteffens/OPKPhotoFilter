/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Alisson
 */
public class DirectoryFileFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
        return f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Pastas";
    }
    
}
