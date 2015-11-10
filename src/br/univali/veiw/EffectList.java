/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import br.univali.model.Effect;
import com.jhlabs.image.ColorHalftoneFilter;
import com.jhlabs.image.ContourFilter;
import com.jhlabs.image.CrystallizeFilter;
import com.jhlabs.image.DiffusionFilter;
import com.jhlabs.image.EdgeFilter;
import com.jhlabs.image.FeedbackFilter;
import com.jhlabs.image.FlareFilter;
import com.jhlabs.image.GaussianFilter;
import com.jhlabs.image.HalftoneFilter;
import com.jhlabs.image.InvertFilter;
import com.jhlabs.image.LensBlurFilter;
import com.jhlabs.image.MaskFilter;
import com.jhlabs.image.SolarizeFilter;
import com.jhlabs.image.TritoneFilter;
import java.awt.Dimension;
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
        
        defaultListModel.addElement(new Effect("Difusão", null, new DiffusionFilter()));
        defaultListModel.addElement(new Effect("Edge", null, new EdgeFilter()));
        defaultListModel.addElement(new Effect("Crystalize", null, new CrystallizeFilter()));
        defaultListModel.addElement(new Effect("Contorno", null, new ContourFilter()));
        defaultListModel.addElement(new Effect("Mask", null, new MaskFilter()));
        defaultListModel.addElement(new Effect("Flare", null, new FlareFilter()));
        defaultListModel.addElement(new Effect("Inverter", null, new InvertFilter()));
        defaultListModel.addElement(new Effect("Solarization", null, new SolarizeFilter()));
        defaultListModel.addElement(new Effect("Triton", null, new TritoneFilter()));
        defaultListModel.addElement(new Effect("Gaussian blur", null, new GaussianFilter()));
        defaultListModel.addElement(new Effect("Color halftoning", null, new ColorHalftoneFilter()));
        defaultListModel.addElement(new Effect("Lens blur", null, new LensBlurFilter()));
        
        
        this.setModel(defaultListModel);
    }
    
    
}
