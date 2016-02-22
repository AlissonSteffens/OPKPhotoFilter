/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw.listRenders;

import br.univali.model.Effect;
import java.awt.Color;
import javax.swing.JList;

/**
 *
 * @author Alisson
 */
public class AppliedEffectsList extends JList<Effect>{

    public AppliedEffectsList() {
        this.setVisibleRowCount(1);
        this.setCellRenderer(new AppliedEffectsListRender());
        this.setBackground(new Color(50, 50, 50));
        this.setForeground(new Color(255, 255, 255));
    }
    
}
