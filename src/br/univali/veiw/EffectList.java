/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import br.univali.effects.EdgeEffect;
import br.univali.effects.InvertEffect;
import br.univali.effects.SunshineEffect;
import br.univali.model.Effect;
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
        
        defaultListModel.addElement(new InvertEffect());
        defaultListModel.addElement(new EdgeEffect());
        defaultListModel.addElement(new SunshineEffect());
        
        
        this.setModel(defaultListModel);
    }
    
    
}
