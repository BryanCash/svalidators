/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * testValidators.java
 *
 * Created on 13 Μαϊ 2010, 10:36:40 πμ
 */
package testvalidators;

/**
 *
 * @author ssoldatos
 */
public class testValidators extends javax.swing.JFrame {

  /** Creates new form testValidators */
  public testValidators() {
    initComponents();
    setLocationRelativeTo(null);
    tabbedPane.add("Compare",new Compare());
    tabbedPane.add("Date",new Date());
    tabbedPane.add("Regex",new Regex());

  }

 

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    tabbedPane = new javax.swing.JTabbedPane();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getStyle() | java.awt.Font.BOLD, jLabel3.getFont().getSize()+3));
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("SValidator Test");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel3)
        .addGap(34, 34, 34)
        .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        new testValidators().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTabbedPane tabbedPane;
  // End of variables declaration//GEN-END:variables
}
