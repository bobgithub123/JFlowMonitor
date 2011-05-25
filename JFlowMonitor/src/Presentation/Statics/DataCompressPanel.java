/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataCompressPanel.java
 *
 * Created on 2011-5-25, 20:57:36
 */

package Presentation.Statics;

import Logic.History.HistoryCompressThread;
import java.util.Date;

/**
 *
 * @author Kuziki
 */
public class DataCompressPanel extends javax.swing.JPanel {

    /** Creates new form DataCompressPanel */
    public DataCompressPanel() {
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
        YearLbl = new javax.swing.JTextField();
        MonthLbl = new javax.swing.JTextField();
        DayLbl = new javax.swing.JTextField();
        CompressBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ResultLbl = new javax.swing.JLabel();

        jLabel1.setText("Please input the date:");

        YearLbl.setText("2011");

        MonthLbl.setText("5");

        DayLbl.setText("24");

        CompressBtn.setText("Compress");
        CompressBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompressBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Warning: the detail data the specified date will be compress ");

        jLabel3.setText("to simple data!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ResultLbl)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(YearLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(DayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CompressBtn)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(YearLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MonthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompressBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(ResultLbl)
                .addContainerGap(159, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CompressBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompressBtnActionPerformed
        String y,m,d;
        int iy,im,id;
        y = YearLbl.getText();
        m = MonthLbl.getText();
        d = DayLbl.getText();
        if(y.isEmpty() || m.isEmpty() || d.isEmpty())
        {
            ResultLbl.setText("Error : Date has empty");
            return;
        }
        else
        {
            try{
                iy = Integer.parseInt(y);
                im = Integer.parseInt(m);
                id = Integer.parseInt(d);
            }
            catch (NumberFormatException e) {
            ResultLbl.setText("input error:date has wrong");
            return;
            }
        }
        Date deadDay = new Date(iy-1900,im-1,id);
        HistoryCompressThread hct = new HistoryCompressThread(deadDay);
        hct.start();
        ResultLbl.setText("Compress OK");
    }//GEN-LAST:event_CompressBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompressBtn;
    private javax.swing.JTextField DayLbl;
    private javax.swing.JTextField MonthLbl;
    private javax.swing.JLabel ResultLbl;
    private javax.swing.JTextField YearLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

}
