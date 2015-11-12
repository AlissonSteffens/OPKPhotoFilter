/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import br.univali.model.EffectComposite;
import com.alee.laf.WebLookAndFeel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import br.univali.model.ImageFile;
import br.univali.model.Processador;
import br.univali.model.ProcessadorListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author 5663296
 */
public class UI extends javax.swing.JFrame {

    Loading loading = new Loading();
    EffectComposite composit = new EffectComposite();
    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        setBackground(new Color(38, 38, 38));
        setGlassPane(loading);
        DefaultListModel listModel = new DefaultListModel();
        applyedEffectsList.setModel(listModel);
        BufferedImage imageOld;
        BufferedImage imageNew;
        spliteImage1.setDividerLocation(spliteImage1.getWidth() / 2);
        try {
            imageOld = ImageIO.read(new File("./src/br/univali/resources/img1.jpg"));
            imageNew = ImageIO.read(new File("./src/br/univali/resources/img2.png"));
            spliteImage1.setImages(imageOld, imageNew);

        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }

        applyedEffectsList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (applyedEffectsList.getSelectedValue() != null) {
                    composit.removeEffect(applyedEffectsList.getSelectedIndex());
                    atualizarApplyedList();
                    applyedEffectsList.clearSelection();
                    atualizarFiltros();
                }
            }
        });

        effectList1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (effectList1.getSelectedValue() != null) {
                    composit.addEffect(effectList1.getSelectedValue()); 
                    atualizarApplyedList();
                    atualizarFiltros();
                    effectList1.clearSelection();
                }

            }
        });

        listaImagens.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    BufferedImage imageOld;
                    BufferedImage imageNew;
                    File file = (File) listaImagens.getSelectedValue();
                    imageOld = ImageIO.read(file);
                    imageNew = ImageIO.read(file);
                    spliteImage1.setImages(imageOld, imageNew);
                    setTitle("Omega Power & Knuckles Photo Filter | " + file.getAbsolutePath());
                    atualizarFiltros();
                } catch (IOException ex) {
                    Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jMenuItem1.doClick();
        spliteImage1.setDividerLocation(0.5);
        spliteImage1.invalidate();
    }

    private void atualizarFiltros() {
        
        BufferedImage imageOld = spliteImage1.getImageOld();
        imageOld = spliteImage1.getImageOld();
        ProcessadorListener listener = new ProcessadorListener() {

            @Override
            public void processamentoIniciado() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        loading.setVisible(true);
                    }
                });
            }

            @Override
            public void processamentoFinalizado(BufferedImage imageOld, BufferedImage imageNew) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        spliteImage1.setImages(imageOld, imageNew);
                        loading.setVisible(false);
                    }
                });
            }

        };
        
        DefaultListModel listModel = (DefaultListModel) applyedEffectsList.getModel();
                
        Processador processador = new Processador(imageOld, ViewAdapter.modelToList(listModel), listener);
        processador.processa();
    }
    
    private void atualizarApplyedList(){
        DefaultListModel listModel = new DefaultListModel();
        for(int i=0; i<composit.numberOfEffects();i++){
            listModel.addElement(composit.get(i));
        }
        applyedEffectsList.setModel(listModel);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        applyedEffectsList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaImagens = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        spliteImage1 = new br.univali.veiw.SpliteImage();
        jScrollPane4 = new javax.swing.JScrollPane();
        effectList1 = new br.univali.veiw.EffectList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Omega Power & Knuckles Photo Filter");
        setBackground(new java.awt.Color(38, 38, 38));
        getContentPane().setLayout(new java.awt.GridLayout(1, 1));

        jPanel2.setBackground(new java.awt.Color(38, 38, 38));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel2.setLayout(new java.awt.BorderLayout(10, 0));

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 75, 75), 2, true), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);

        applyedEffectsList.setBackground(new java.awt.Color(50, 50, 50));
        applyedEffectsList.setForeground(new java.awt.Color(255, 255, 255));
        applyedEffectsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        applyedEffectsList.setFixedCellWidth(100);
        jScrollPane1.setViewportView(applyedEffectsList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(38, 38, 38));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Filtros Aplicados");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(77, 30));
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jSplitPane1.setRightComponent(jPanel1);

        jPanel4.setBackground(new java.awt.Color(50, 50, 50));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 75, 75), 2, true), javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        jPanel4.setAutoscrolls(true);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(38, 38, 38));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Imagens");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(41, 30));
        jPanel4.add(jLabel2, java.awt.BorderLayout.NORTH);

        jScrollPane2.setBorder(null);

        listaImagens.setBackground(new java.awt.Color(50, 50, 50));
        listaImagens.setForeground(new java.awt.Color(255, 255, 255));
        listaImagens.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listaImagens.setFixedCellWidth(150);
        jScrollPane2.setViewportView(listaImagens);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel4);

        jPanel2.add(jSplitPane1, java.awt.BorderLayout.WEST);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout(0, 10));

        spliteImage1.setBackground(new java.awt.Color(50, 50, 50));
        spliteImage1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 75, 75), 2, true));
        spliteImage1.setResizeWeight(0.5);
        spliteImage1.setOpaque(false);
        jPanel3.add(spliteImage1, java.awt.BorderLayout.CENTER);

        jScrollPane4.setBackground(new java.awt.Color(50, 50, 50));
        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(75, 75, 75), 2, true));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(12, 120));

        effectList1.setBackground(new java.awt.Color(50, 50, 50));
        effectList1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)));
        effectList1.setForeground(new java.awt.Color(255, 255, 255));
        effectList1.setFixedCellHeight(90);
        effectList1.setFixedCellWidth(90);
        jScrollPane4.setViewportView(effectList1);

        jPanel3.add(jScrollPane4, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/menus/abrir.png"))); // NOI18N
        jMenuItem1.setText("Abrir Pasta");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/menus/salvar.png"))); // NOI18N
        jMenuItem2.setText("Salvar Imagem");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/menus/salvar_lote.png"))); // NOI18N
        jMenuItem3.setText("Salvar Lote");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new DirectoryFileFilter());
        int retorno = chooser.showOpenDialog(this);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file.isDirectory()) {
                File[] files = file.listFiles(new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        String extenssion;
                        if(name.length()>=4)
                        {
                            extenssion = name.substring(name.length() - 3);
                            return extenssion.equals("jpg") || extenssion.equals("png") || extenssion.equals("gif");
                        }
                        return false;
                    }
                });
                DefaultListModel<File> model = new DefaultListModel<>();
                for (File file1 : files) {
                    model.addElement(new ImageFile(file1.getAbsolutePath()));
                }
                listaImagens.setModel(model);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();
        BufferedImage bi = spliteImage1.getImageNew();
        /***Magica muito loka (não mexer nesta parte do código)
        /*It's Magic, I ain't explain shit
         */
        String ext = listaImagens.getSelectedValue().toString();
        ext = ext.substring(ext.length() - 3);
        String f = file.toString()+"."+ext;
        file = new File(f);
        try {
            ImageIO.write(bi, ext, file);
        } catch (IOException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new WebLookAndFeel());
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList applyedEffectsList;
    private br.univali.veiw.EffectList effectList1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList listaImagens;
    private br.univali.veiw.SpliteImage spliteImage1;
    // End of variables declaration//GEN-END:variables
}
