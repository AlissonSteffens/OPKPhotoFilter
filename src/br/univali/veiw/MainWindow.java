/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.veiw;

import br.univali.utils.ViewAdapter;
import br.univali.utils.DirectoryFileFilter;
import br.univali.model.Effect;
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
import br.univali.model.ImageFile;
import br.univali.model.ImageEffectProcessor;
import br.univali.model.ImageEffectProcessorListener;
import br.univali.veiw.listRenders.AppliedEffectsList;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;

/**
 *
 * @author 5663296
 */
public class MainWindow extends javax.swing.JFrame {

    Loading loading = new Loading();
    EffectComposite composit = new EffectComposite();
    JList<Effect> appliedEffectsList = new AppliedEffectsList();
    
    /**
     * Creates new form UI
     */
    public MainWindow() {
        initComponents();
        setBackground(new Color(38, 38, 38));
        setGlassPane(loading);
        DefaultListModel listModel = new DefaultListModel();
        jPanel1.add(appliedEffectsList);
        appliedEffectsList.setModel(listModel);
        BufferedImage imageOld;
        BufferedImage imageNew;
//        splitePane2.getSpliteImage().setDividerLocation(splitePane2.getSpliteImage().getWidth() / 2);
        try {
            imageOld = ImageIO.read(new File("./src/br/univali/resources/img1.jpg"));
            imageNew = ImageIO.read(new File("./src/br/univali/resources/img2.png"));
            splitePane.getSpliteImage().setImages(imageOld, imageNew);

        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        appliedEffectsList.addListSelectionListener((ListSelectionEvent e) -> {
            if (appliedEffectsList.getSelectedValue() != null) {
                composit.removeEffect(appliedEffectsList.getSelectedIndex());
                atualizarAppliedList();
                appliedEffectsList.clearSelection();
                atualizarFiltros();
            }
        });

        effectList1.addListSelectionListener((ListSelectionEvent e) -> {
            if (effectList1.getSelectedValue() != null) {
                composit.addEffect(effectList1.getSelectedValue());
                atualizarAppliedList();
                atualizarFiltros();
                effectList1.clearSelection();
            }
        });

        imagesList.addListSelectionListener((ListSelectionEvent e) -> {
            try {
                BufferedImage imageOld1;
                BufferedImage imageNew1;
                File file = (File) imagesList.getSelectedValue();
                imageOld1 = ImageIO.read(file);
                imageNew1 = imageOld1;
                splitePane.getSpliteImage().setImages(imageOld1, imageNew1);
                setTitle("Omega Power & Knuckles Photo Filter | " + file.getAbsolutePath());
                atualizarFiltros();
            }catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        openFolderButton.doClick();
        splitePane.getSpliteImage().invalidate();
        
        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e); //To change body of generated methods, choose Tools | Templates.
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        splitePane.updateState();
                    }
                });
            }
            
        });
    }

    private void atualizarFiltros() {
        
        BufferedImage imageOld = splitePane.getSpliteImage().getImageOld();
        imageOld = splitePane.getSpliteImage().getImageOld();
        ImageEffectProcessorListener listener = new ImageEffectProcessorListener() {

            @Override
            public void processamentoIniciado() {
                SwingUtilities.invokeLater(() -> {
                    effectList1.setEnabled(false);
                    appliedEffectsList.setEnabled(false);
                    imagesList.setEnabled(false);
                    loading.setVisible(true);
                });
            }

            @Override
            public void processamentoFinalizado(BufferedImage imageOld, BufferedImage imageNew) {
                SwingUtilities.invokeLater(() -> {
                    effectList1.setEnabled(true);
                    appliedEffectsList.setEnabled(true);
                    imagesList.setEnabled(true);
                    splitePane.getSpliteImage().setImages(imageOld, imageNew);
                    loading.setVisible(false);
                    splitePane.updateState();
                });
            }

        };
        
        DefaultListModel listModel = (DefaultListModel) appliedEffectsList.getModel();
                
        ImageEffectProcessor processador = new ImageEffectProcessor(imageOld, ViewAdapter.modelToList(listModel), listener);
        processador.run();
    }
    
    private void atualizarAppliedList(){
        DefaultListModel listModel = new DefaultListModel();
        for(int i=0; i<composit.numberOfEffects();i++){
            Effect effect = composit.get(i);
            listModel.addElement(effect);
        }
        appliedEffectsList.setModel(listModel);
        
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
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        imagesList = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        effectList1 = new br.univali.veiw.listRenders.EffectList();
        splitePane = new br.univali.veiw.splite.SplitePane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openFolderButton = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        saveImageButton = new javax.swing.JMenuItem();
        saveImagesButton = new javax.swing.JMenuItem();
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

        imagesList.setBackground(new java.awt.Color(50, 50, 50));
        imagesList.setForeground(new java.awt.Color(255, 255, 255));
        imagesList.setFixedCellWidth(150);
        jScrollPane2.setViewportView(imagesList);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel4);

        jSplitPane2.setLeftComponent(jSplitPane1);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout(0, 10));

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
        jPanel3.add(splitePane, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel3);

        jPanel2.add(jSplitPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);

        fileMenu.setText("Arquivo");

        openFolderButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/menus/abrir.png"))); // NOI18N
        openFolderButton.setText("Abrir Pasta");
        openFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFolderButtonActionPerformed(evt);
            }
        });
        fileMenu.add(openFolderButton);
        fileMenu.add(jSeparator1);

        saveImageButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/menus/salvar.png"))); // NOI18N
        saveImageButton.setText("Salvar Imagem");
        saveImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageButtonActionPerformed(evt);
            }
        });
        fileMenu.add(saveImageButton);

        saveImagesButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveImagesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/resources/menus/salvar_lote.png"))); // NOI18N
        saveImagesButton.setText("Salvar Lote");
        saveImagesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImagesButtonActionPerformed(evt);
            }
        });
        fileMenu.add(saveImagesButton);

        jMenuBar1.add(fileMenu);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFolderButtonActionPerformed
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
                imagesList.setModel(model);
            }
        }
    }//GEN-LAST:event_openFolderButtonActionPerformed

    private void saveImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this);
        File file = chooser.getSelectedFile();
        BufferedImage bi = splitePane.getSpliteImage().getImageNew();
        /***Magica muito loka (não mexer nesta parte do código)
        /*It's Magic, I ain't explain shit
         */
        String ext = imagesList.getSelectedValue().toString();
        ext = ext.substring(ext.length() - 3);
        String f = file.toString()+"."+ext;
        file = new File(f);
        try {
            ImageIO.write(bi, ext, file);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveImageButtonActionPerformed

    private void saveImagesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImagesButtonActionPerformed
        DefaultListModel<File> listModel = (DefaultListModel<File>) imagesList.getModel();
        DefaultListModel model = (DefaultListModel) appliedEffectsList.getModel();
        for(int i=0; i< listModel.size();i++){
            
            File file = listModel.getElementAt(i);
            ImageEffectProcessorListener listener = new ImageEffectProcessorListener() {
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
                            String ext = file.getAbsolutePath();
                            ext = ext.substring(ext.length() - 3);
                            try {
                                ImageIO.write(imageNew, ext, file);
                            } catch (IOException ex) {
                                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            loading.setVisible(false);
                        }
                    });
                }

            };
            
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(file);
                ImageEffectProcessor processador = new ImageEffectProcessor(bufferedImage, ViewAdapter.modelToList(model), listener);
                processador.run();
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_saveImagesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new WebLookAndFeel());
            //</editor-fold>
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.univali.veiw.listRenders.EffectList effectList1;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JList imagesList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JMenuItem openFolderButton;
    private javax.swing.JMenuItem saveImageButton;
    private javax.swing.JMenuItem saveImagesButton;
    private br.univali.veiw.splite.SplitePane splitePane;
    // End of variables declaration//GEN-END:variables
}
