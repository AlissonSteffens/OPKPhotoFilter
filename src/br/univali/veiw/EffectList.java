/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import br.univali.model.Effect;
import br.univali.reflection.PackageClassesGetter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Alisson
 */
public class EffectList extends JList<Effect>{

    public EffectList() {
        this.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        this.setVisibleRowCount(1);
        this.setCellRenderer(new EffectListRender());
        DefaultListModel defaultListModel= new DefaultListModel();
        
        try {
            Class<Effect>[] classes = PackageClassesGetter.getClasses("br.univali.effects");
            for (Class<Effect> classe : classes) {
                try {
                    Constructor<Effect> constructor = classe.getConstructor();
                    Effect newInstance = constructor.newInstance();
                    defaultListModel.addElement(newInstance);
                } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                    Logger.getLogger(EffectList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(EffectList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setModel(defaultListModel);
    }
    
    
}
