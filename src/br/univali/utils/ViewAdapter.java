/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.utils;

import br.univali.model.Effect;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author 5663296
 */
public class ViewAdapter {
    public static List<Effect> modelToList(DefaultListModel listModel){
        List<Effect> effects= new ArrayList<>();
        for(int i=0; i<listModel.size(); i++)
        {
            Effect effect = (Effect) listModel.get(i);
            effects.add(effect);
        }
        return effects;
    }
}
