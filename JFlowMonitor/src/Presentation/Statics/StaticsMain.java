/*
 * This file is written by reyoung, reyoung@126.com.
 */

/*
 * StaticsMain.java
 *
 * Created on 2011-5-21, 12:54:43
 */
package Presentation.Statics;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reyoung
 */
public class StaticsMain extends javax.swing.JFrame {

    private static List<IStaticsPage> StaticPages = null;

    public static void RegistePage(Class c) throws InstantiationException, IllegalAccessException {
        IStaticsPage page = (IStaticsPage) c.newInstance();
        assert (page != null);
        StaticPages.add(page);
    }
    private Component m_widget;

    protected static void Init() {
        if (StaticPages == null) {
            StaticPages = new ArrayList<IStaticsPage>();
            try {
//                RegistePage(TestPage.class);
//                RegistePage(TestPage2.class);

                RegistePage(DynamicFlowChartPage.class);
                RegistePage(AnalysisChartPage.class);
                RegistePage(HistoryFlowPage.class);

            } catch (InstantiationException ex) {
                Logger.getLogger(StaticsMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(StaticsMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /** Creates new form StaticsMain */
    public StaticsMain() {
        Init();
        initComponents();
        for (IStaticsPage p : StaticPages) {
            this.ui_comboBox.addItem(p);
        }
        this.ui_comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                IStaticsPage ip = (IStaticsPage) e.getItem();
                changeItem(ip);
            }
        });
        this.changeItem((IStaticsPage) ui_comboBox.getSelectedItem());
    }

    final protected void changeItem(IStaticsPage ip) {
        if (ip != null) {
            if (m_widget != null) {
                StaticsMain.this.remove(m_widget);
            }
            m_widget = ip.getWidget();
            StaticsMain.this.add(m_widget);
            m_widget.setLocation(20, 60);
            m_widget.setSize(480, 400);
            m_widget.setVisible(true);
            this.pack();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        ui_comboBox = new javax.swing.JComboBox();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ui_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_comboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(ui_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ui_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(457, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ui_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ui_comboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new StaticsMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame jFrame1;
    private javax.swing.JComboBox ui_comboBox;
    // End of variables declaration//GEN-END:variables
}
