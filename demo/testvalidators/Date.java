/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Date.java
 *
 * Created on 13 Μαϊ 2010, 6:36:33 μμ
 */

package testvalidators;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.DateValidator;

/**
 *
 * @author lordovol
 */
public class Date extends javax.swing.JPanel {

    /** Creates new form Date */
    public Date() {
        initComponents();
        DateValidator dVal_1 = new DateValidator();
        dVal_1.setAllowEmpty(true);
        tf_date_1.addValidator(dVal_1);

        DateValidator dVal_2 = new DateValidator();
        dVal_2.setAllowEmpty(false);
        dVal_2.setDateFormat(label_2.getText());
        tf_date_2.addValidator(dVal_2);

        DateValidator dVal_3 = new DateValidator();
        dVal_3.setDateFormat(label_3.getText());
        tf_date_3.addValidator(dVal_3);

        DateValidator dVal_4 = new DateValidator();
        dVal_4.setDateFormat(label_4.getText());
        tf_date_4.addValidator(dVal_4);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    sTextField4 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_date_1 = new com.googlecode.svalidators.formcomponents.STextField();
    label_1 = new javax.swing.JLabel();
    tf_date_2 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_date_3 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_date_4 = new com.googlecode.svalidators.formcomponents.STextField();
    label_2 = new javax.swing.JLabel();
    label_3 = new javax.swing.JLabel();
    label_4 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();

    sTextField4.setText("sTextField4");

    tf_date_1.setName("date 1"); // NOI18N

    label_1.setText("dd/MM/yyyy");

    tf_date_2.setName("date 2"); // NOI18N

    tf_date_3.setName("date 3"); // NOI18N
    tf_date_3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tf_date_3ActionPerformed(evt);
      }
    });

    tf_date_4.setName("date 4"); // NOI18N

    label_2.setText("d/M/yy");

    label_3.setText("MM/dd/yyyy");

    label_4.setText("yyyy/MM/dd");

    jButton1.setText("Validate");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(tf_date_4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(tf_date_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(tf_date_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(tf_date_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label_1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(label_2)
              .addComponent(label_3)
              .addComponent(label_4)))
          .addComponent(jButton1))
        .addContainerGap(143, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_1)
          .addComponent(tf_date_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(8, 8, 8)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tf_date_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tf_date_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_3))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tf_date_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(label_4))
        .addGap(18, 18, 18)
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

    private void tf_date_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_date_3ActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_tf_date_3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     ValidationGroup group = new ValidationGroup();
     group.addComponent(tf_date_1);
     group.addComponent(tf_date_2);
     group.addComponent(tf_date_3);
     group.addComponent(tf_date_4);
     if(!group.validate()){
       group.errorMessage(true);
     } else {
       group.successMessage();
     }
    }//GEN-LAST:event_jButton1ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel label_1;
  private javax.swing.JLabel label_2;
  private javax.swing.JLabel label_3;
  private javax.swing.JLabel label_4;
  private com.googlecode.svalidators.formcomponents.STextField sTextField4;
  private com.googlecode.svalidators.formcomponents.STextField tf_date_1;
  private com.googlecode.svalidators.formcomponents.STextField tf_date_2;
  private com.googlecode.svalidators.formcomponents.STextField tf_date_3;
  private com.googlecode.svalidators.formcomponents.STextField tf_date_4;
  // End of variables declaration//GEN-END:variables

}
