/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Compare.java
 *
 * Created on 13 ��� 2010, 6:24:24 ��
 */
package testvalidators;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.*;
import com.googlecode.svalidators.validators.CompareValidator.Type;

/**
 *
 * @author lordovol
 */
public class Compare extends javax.swing.JPanel {

  /** Creates new form Compare */
  public Compare() {
    initComponents();
    //EQUALS
    tf_equals_2.addValidator(new NullValidator());
    CompareValidator compareEq = new CompareValidator("", tf_equals_2.getText().trim(), Type.EQUALS, false);
    tf_equals_1.addValidator(compareEq);
    //LESS
    tf_lesser_2.addValidator(new NullValidator());
    CompareValidator compareLe = new CompareValidator("", tf_lesser_2.getText().trim(), Type.LESS, true);
    tf_lesser_1.addValidator(compareLe);
    //GREATER
    tf_greater_2.addValidator(new NullValidator());
    CompareValidator compareGr = new CompareValidator("", tf_greater_2.getText().trim(), Type.GREATER, true);
    tf_greater_1.addValidator(compareGr);
    //LESS EQUALS
    tf_leq_2.addValidator(new NullValidator());
    CompareValidator compareLeq = new CompareValidator("", tf_leq_2.getText().trim(), Type.LESS_OR_EQUALS, true);
    tf_leq_1.addValidator(compareLeq);
    //LESS EQUALS
    tf_geq_2.addValidator(new NullValidator());
    CompareValidator compareGeq = new CompareValidator("", tf_geq_2.getText().trim(), Type.GREATER_OR_EQUALS, true);
    tf_geq_1.addValidator(compareGeq);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    tf_equals_1 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_equals_2 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_lesser_1 = new com.googlecode.svalidators.formcomponents.STextField();
    jLabel2 = new javax.swing.JLabel();
    tf_lesser_2 = new com.googlecode.svalidators.formcomponents.STextField();
    button_compare = new javax.swing.JButton();
    tf_greater_1 = new com.googlecode.svalidators.formcomponents.STextField();
    jLabel4 = new javax.swing.JLabel();
    tf_greater_2 = new com.googlecode.svalidators.formcomponents.STextField();
    jLabel3 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    tf_leq_1 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_leq_2 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_geq_1 = new com.googlecode.svalidators.formcomponents.STextField();
    tf_geq_2 = new com.googlecode.svalidators.formcomponents.STextField();

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Equals");

    tf_equals_1.setMinimumSize(new java.awt.Dimension(2, 20));
    tf_equals_1.setName("equals"); // NOI18N
    tf_equals_1.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_equals_1.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tf_equals_1FocusLost(evt);
      }
    });
    tf_equals_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_equals_1KeyReleased(evt);
      }
    });

    tf_equals_2.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_equals_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_equals_2KeyReleased(evt);
      }
    });

    tf_lesser_1.setName("less than"); // NOI18N
    tf_lesser_1.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_lesser_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_lesser_1KeyReleased(evt);
      }
    });

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("less than");

    tf_lesser_2.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_lesser_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_lesser_2KeyReleased(evt);
      }
    });

    button_compare.setText("Validate");
    button_compare.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_compareActionPerformed(evt);
      }
    });

    tf_greater_1.setName("greater than"); // NOI18N
    tf_greater_1.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_greater_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_greater_1KeyReleased(evt);
      }
    });

    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("greater than");

    tf_greater_2.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_greater_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_greater_2KeyReleased(evt);
      }
    });

    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("less or equals");

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("greater or equals");

    tf_leq_1.setName("less or equal"); // NOI18N
    tf_leq_1.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_leq_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_leq_1KeyReleased(evt);
      }
    });

    tf_leq_2.setPreferredSize(new java.awt.Dimension(2, 20));
    tf_leq_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_leq_2KeyReleased(evt);
      }
    });

    tf_geq_1.setName("greater or equals"); // NOI18N
    tf_geq_1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_geq_1KeyReleased(evt);
      }
    });

    tf_geq_2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        tf_geq_2KeyReleased(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(button_compare)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tf_equals_1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(tf_geq_1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(tf_lesser_1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(tf_greater_1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(tf_leq_1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
              .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(tf_lesser_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tf_equals_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tf_greater_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tf_leq_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tf_geq_2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(24, 24, 24))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGap(112, 112, 112)
              .addComponent(tf_geq_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(26, 26, 26)
                  .addComponent(tf_lesser_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(tf_equals_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(9, 9, 9)
              .addComponent(tf_greater_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(6, 6, 6)
              .addComponent(tf_leq_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(tf_lesser_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tf_equals_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(9, 9, 9)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tf_greater_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(6, 6, 6)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(tf_leq_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
              .addComponent(tf_geq_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel5))))
        .addGap(49, 49, 49)
        .addComponent(button_compare)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(70, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(22, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

    private void tf_equals_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_equals_1FocusLost
      tf_equals_1KeyReleased(null);
}//GEN-LAST:event_tf_equals_1FocusLost

    private void tf_equals_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_equals_1KeyReleased
      CompareValidator compareV = (CompareValidator) tf_equals_1.getValidator(SValidator.COMPARE);
      compareV.setValueToCompareWith(tf_equals_2.getText().trim());
      tf_equals_1.addValidator(compareV);
      tf_equals_1.validateValue();
}//GEN-LAST:event_tf_equals_1KeyReleased

    private void tf_equals_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_equals_2KeyReleased
      tf_equals_1KeyReleased(null);
}//GEN-LAST:event_tf_equals_2KeyReleased

    private void tf_lesser_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_lesser_1KeyReleased
      CompareValidator compareV = (CompareValidator) tf_lesser_1.getValidator(SValidator.COMPARE);
      compareV.setValueToCompareWith(tf_lesser_2.getText().trim());
      tf_lesser_1.addValidator(compareV);
      tf_lesser_1.validateValue();
}//GEN-LAST:event_tf_lesser_1KeyReleased

    private void tf_lesser_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_lesser_2KeyReleased
      tf_lesser_1KeyReleased(null);
}//GEN-LAST:event_tf_lesser_2KeyReleased

    private void button_compareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_compareActionPerformed
      ValidationGroup compareGroup = new ValidationGroup();
      compareGroup.addComponent(tf_equals_1);
      compareGroup.addComponent(tf_equals_2);
      compareGroup.addComponent(tf_lesser_1);
      compareGroup.addComponent(tf_lesser_2);
      compareGroup.addComponent(tf_greater_1);
      compareGroup.addComponent(tf_greater_2);
      compareGroup.addComponent(tf_leq_1);
      compareGroup.addComponent(tf_leq_2);
      compareGroup.addComponent(tf_geq_1);
      compareGroup.addComponent(tf_geq_2);
      if (!compareGroup.validate()) {
        compareGroup.errorMessage(true);
      } else {
        compareGroup.successMessage();
      }
}//GEN-LAST:event_button_compareActionPerformed

    private void tf_greater_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_greater_1KeyReleased
      CompareValidator compareV = (CompareValidator) tf_greater_1.getValidator(SValidator.COMPARE);
      compareV.setValueToCompareWith(tf_greater_2.getText().trim());
      tf_greater_1.addValidator(compareV);
      tf_greater_1.validateValue();
    }//GEN-LAST:event_tf_greater_1KeyReleased

    private void tf_greater_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_greater_2KeyReleased
      tf_greater_1KeyReleased(null);
    }//GEN-LAST:event_tf_greater_2KeyReleased

    private void tf_leq_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_leq_1KeyReleased
      CompareValidator compareV = (CompareValidator) tf_leq_1.getValidator(SValidator.COMPARE);
      compareV.setValueToCompareWith(tf_leq_2.getText().trim());
      tf_leq_1.addValidator(compareV);
      tf_leq_1.validateValue();
    }//GEN-LAST:event_tf_leq_1KeyReleased

    private void tf_leq_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_leq_2KeyReleased
      tf_leq_1KeyReleased(evt);
    }//GEN-LAST:event_tf_leq_2KeyReleased

    private void tf_geq_1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_geq_1KeyReleased
      CompareValidator compareV = (CompareValidator) tf_geq_1.getValidator(SValidator.COMPARE);
      compareV.setValueToCompareWith(tf_geq_2.getText().trim());
      tf_geq_1.addValidator(compareV);
      tf_geq_1.validateValue();
    }//GEN-LAST:event_tf_geq_1KeyReleased

    private void tf_geq_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_geq_2KeyReleased
     tf_geq_1KeyReleased( evt);
    }//GEN-LAST:event_tf_geq_2KeyReleased

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_compare;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel1;
  private com.googlecode.svalidators.formcomponents.STextField tf_equals_1;
  private com.googlecode.svalidators.formcomponents.STextField tf_equals_2;
  private com.googlecode.svalidators.formcomponents.STextField tf_geq_1;
  private com.googlecode.svalidators.formcomponents.STextField tf_geq_2;
  private com.googlecode.svalidators.formcomponents.STextField tf_greater_1;
  private com.googlecode.svalidators.formcomponents.STextField tf_greater_2;
  private com.googlecode.svalidators.formcomponents.STextField tf_leq_1;
  private com.googlecode.svalidators.formcomponents.STextField tf_leq_2;
  private com.googlecode.svalidators.formcomponents.STextField tf_lesser_1;
  private com.googlecode.svalidators.formcomponents.STextField tf_lesser_2;
  // End of variables declaration//GEN-END:variables
}
