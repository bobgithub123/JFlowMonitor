/*
 * This file is written by reyoung, reyoung@126.com.
 */

/*
 * SmallPanel.java
 *
 * Created on 2011-5-7, 13:24:16
 */

package smallpaneltest;

/**
 *
 * @author Reyoung
 */
public class SmallPanel extends javax.swing.JPanel {

    /** Creates new form SmallPanel */
    public SmallPanel() {
        initComponents();
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallpaneltest/arrow-down-double.png"))); // NOI18N

        ui_downloadSpeed.setText("KB/S");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/smallpaneltest/arrow-up-double.png"))); // NOI18N

        ui_uploadSpeed.setText("KB/S");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ui_downloadSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ui_uploadSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(ui_downloadSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(ui_uploadSpeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel ui_downloadSpeed;
    private javax.swing.JLabel ui_uploadSpeed;
    // End of variables declaration//GEN-END:variables

}