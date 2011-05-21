/*
 * This file is written by reyoung, reyoung@126.com.
 */

/*
 * SmallWindow.java
 *
 * Created on 2011-5-7, 14:23:10
 */
package Presentation;

import Logic.PacketPool.IPacketPoolEvent;
import Logic.PacketPool.IPacketPoolEventListener;
import Logic.PacketPool.PacketPool;
import Presentation.Statics.StaticsMain;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import javax.swing.JFrame;

/**
 *
 * @author Reyoung
 */
public class SmallWindow extends javax.swing.JFrame implements IPacketPoolEventListener {

    /** Creates new form SmallWindow */
    public SmallWindow() {
        initComponents();
        m_keyPressed = false;
        PacketPool.Instance().addPacketPoolListener(this);
        this.setAlwaysOnTop(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ui_downloadSpeed = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        ui_uploadSpeed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(160, 20));
        setResizable(false);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/arrow-down-double.png"))); // NOI18N

        ui_downloadSpeed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ui_downloadSpeed.setText("KB/S");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/arrow-up-double.png"))); // NOI18N

        ui_uploadSpeed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ui_uploadSpeed.setText("KB/S");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(ui_downloadSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(ui_uploadSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
            .addComponent(ui_downloadSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
            .addComponent(ui_uploadSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            PopupMenu menu = new PopupMenu();
            this.add(menu);
            {   /// 添加Show Static
                MenuItem mit = new MenuItem("Show Statics");
                mit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onStaticsShow();
                    }
                });
                menu.add(mit);
            }
            {   /// 添加分隔符
                menu.addSeparator();
            }
            {   /// 添加Exit操作
                MenuItem mit = new MenuItem("Exit");
                mit.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                menu.add(mit);
            }
            menu.show(this, evt.getX(), evt.getY());
        } else if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            onStaticsShow();
        }
    }//GEN-LAST:event_formMouseClicked

    static public void onStaticsShow() {
        if (m_mainWindow == null) {
            StaticsMain wd = new StaticsMain();
            wd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            m_mainWindow = wd;
        }
        m_mainWindow.setVisible(true);
    }
    static private JFrame m_mainWindow = null;

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (!m_keyPressed) {
            return;
        }
//        System.out.printf("In\n");
        Point pos2 = evt.getLocationOnScreen();
        this.setLocation(pos2.x - m_inPos.x, pos2.y - m_inPos.y);
    }//GEN-LAST:event_formMouseMoved

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        m_keyPressed = true;
        m_inPos = evt.getPoint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        m_keyPressed = false;
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.formMouseMoved(evt);
    }//GEN-LAST:event_formMouseDragged
    private boolean m_keyPressed;
    private Point m_inPos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel ui_downloadSpeed;
    private javax.swing.JLabel ui_uploadSpeed;
    // End of variables declaration//GEN-END:variables

    public void onPoolRefresh(IPacketPoolEvent e) {
        double us = e.getUploadSpeed() / 1024;
        double ds = e.getDownloadSpeed() / 1024;
        this.ui_downloadSpeed.setText(String.format("%.1f KB/S", ds));
        this.ui_uploadSpeed.setText(String.format("%.1f KB/S", us));
    }

    public boolean isEnable() {
        return true;
    }

    public boolean isConcern() {
        return true;
    }
}
