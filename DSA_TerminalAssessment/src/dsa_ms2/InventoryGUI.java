/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dsa_ms2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aira Joie Piopongco
 */
public class InventoryGUI extends javax.swing.JFrame {
    private CSVReader reader = new CSVReader("InventoryData.csv");
    private List<String[]> inventoryData = reader.getInventoryData();
    private BST inventoryBST = new BST();

    public InventoryGUI() {
        initComponents();
        loadInventory("InventoryData.csv");
    }

    public void loadInventory(String csvFile) {
        CSVReader csvReader = new CSVReader(csvFile);
        inventoryData = csvReader.getInventoryData();

        String[] columnNames = {"Date Entered", "Stock Label", "Brand", "Engine Number", "Status"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (String[] row : inventoryData) {
            model.addRow(row);
            Stocks stock = new Stocks(row[0], row[1], row[2], row[3], row[4]);
            inventoryBST.insert(stock);
        }
        jTableInventory.setModel(model);
    }
    
    public void writeToCSV(String csvFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            writer.write("Date Entered,Stock Label,Brand,Engine Number,Status");
            writer.newLine();

            List<Stocks> stocksList = inventoryBST.inOrder();
            for (Stocks stock : stocksList) {
                writer.write(stock.getDateEntered() + "," + stock.getStockLabel() + "," + stock.getBrand() + "," + stock.getEngineNumber() + "," + stock.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to CSV: " + e.getMessage());
        }
    }
    
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInventory = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonSort = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonEditStock = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextDateEnt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextEngineNum = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextLabel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextBrand = new javax.swing.JTextField();
        jTextStatus = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inventory Management System");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 330, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MotorPH");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 120, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 70));

        jTableInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableInventory.setEnabled(false);
        jTableInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInventoryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableInventory);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 560, 420));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExit.setBackground(new java.awt.Color(102, 0, 0));
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("Exit");
        jButtonExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 170, 30));

        jButtonSearch.setBackground(new java.awt.Color(51, 51, 51));
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search Inventory");
        jButtonSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 170, 50));

        jButtonSort.setBackground(new java.awt.Color(51, 51, 51));
        jButtonSort.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSort.setText("Sort Inventory");
        jButtonSort.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 170, 50));

        jButtonDelete.setBackground(new java.awt.Color(51, 51, 51));
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete Stock");
        jButtonDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, 50));

        jButtonAdd.setBackground(new java.awt.Color(51, 51, 51));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add Stock");
        jButtonAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Main Menu");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, -1));

        jButtonEditStock.setBackground(new java.awt.Color(51, 51, 51));
        jButtonEditStock.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditStock.setText("Edit Stock");
        jButtonEditStock.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEditStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditStockActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonEditStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 210, 420));

        jButtonRefresh.setBackground(new java.awt.Color(51, 51, 51));
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 140, 30));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date Entered");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        jTextDateEnt.setEditable(false);
        jTextDateEnt.setBackground(new java.awt.Color(51, 51, 51));
        jTextDateEnt.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jTextDateEnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Engine Number");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        jTextEngineNum.setEditable(false);
        jTextEngineNum.setBackground(new java.awt.Color(51, 51, 51));
        jTextEngineNum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jTextEngineNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Label");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 40, -1));
        jPanel4.add(jTextLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 140, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Brand");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 40, -1));
        jPanel4.add(jTextBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, -1));
        jPanel4.add(jTextStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, -1));

        jButtonEdit.setBackground(new java.awt.Color(51, 51, 51));
        jButtonEdit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEdit.setText("Save Changes");
        jButtonEdit.setToolTipText("");
        jButtonEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonEdit.setEnabled(false);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Status");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        String engineNumberToSearch = JOptionPane.showInputDialog(this, "Enter Engine Number to Search:");

        if (engineNumberToSearch != null) {
            Stocks foundStock = inventoryBST.search(engineNumberToSearch);
            if (foundStock != null) {
                JOptionPane.showMessageDialog(this, "Stock with Engine Number " + "( " + foundStock.getEngineNumber() + " )" + " is found."
                    + "\n\nStock Details:"
                    + "\nDate Entered: " + foundStock.getDateEntered() 
                    + "\nStock Label: " + foundStock.getStockLabel() 
                    + "\nBrand: " + foundStock.getBrand() 
                    + "\nEngine Number: " + foundStock.getEngineNumber()
                    + "\nStatus: " + foundStock.getStatus());
            } else {
                JOptionPane.showMessageDialog(this, "Stock with Engine Number " + "(" + engineNumberToSearch + ")" + " is not found.");
            }
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String engineNumberToDelete = JOptionPane.showInputDialog(this, "Enter Engine Number to Delete:");

        if (engineNumberToDelete != null) {
            Stocks stockToDelete = inventoryBST.search(engineNumberToDelete);
            if (stockToDelete == null) {
                JOptionPane.showMessageDialog(this, "Stock with Engine Number " + "( " + engineNumberToDelete + " )" + " is not found.");
                return;
            }

            if (!stockToDelete.getStockLabel().equals("Old")) {
                JOptionPane.showMessageDialog(this, "Deletion cannot be made. Stock is new.");
                return;
            }

            if (!stockToDelete.getStatus().equals("Sold")) {
                JOptionPane.showMessageDialog(this, "Deletion cannot be made. Stock is currently on-hand.");
                return;
            }

            int confirmation = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete the stock with Engine Number " + engineNumberToDelete + "?"
                    + "\n\nStock Details:"
                    + "\nDate Entered: " + stockToDelete.getDateEntered()
                    + "\nStock Label: " + stockToDelete.getStockLabel()
                    + "\nBrand: " + stockToDelete.getBrand()
                    + "\nStatus: " + stockToDelete.getStatus(),
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                inventoryBST.delete(engineNumberToDelete);
                JOptionPane.showMessageDialog(this, "Stock with Engine Number " + "(" + engineNumberToDelete + ")" + " has been deleted.");

                writeToCSV("InventoryData.csv");
                loadInventory("InventoryData.csv");
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortActionPerformed
        // TODO add your handling code here:
        List<Stocks> stocksList = inventoryBST.inOrder();
        inventoryBST.mergeSort(stocksList);
        updateTable(stocksList);
    }//GEN-LAST:event_jButtonSortActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        String engineNumber = JOptionPane.showInputDialog(this, "Enter Engine Number (10 characters):");

        if (engineNumber != null) {
            if (engineNumber.length() == 10) {
                if (inventoryBST.isEngineNumberUnique(engineNumber)) {
                    String brand = JOptionPane.showInputDialog(this, "Enter Brand:");

                    if (brand == null || brand.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Invalid. Brand cannot be empty.");
                        return;
                    }

                    Stocks addStock = new Stocks(brand, engineNumber);
                    inventoryBST.insert(addStock);

                    JOptionPane.showMessageDialog(this, "New Stock Added Successfully! "
                            + "\n\nDate Entered: " + addStock.getDateEntered()
                            + "\nStock Label: " + addStock.getStockLabel()
                            + "\nBrand: " + brand
                            + "\nEngine Number: " + engineNumber
                            + "\nStatus: " + addStock.getStatus());
                    
                    writeToCSV("InventoryData.csv");
                    List<Stocks> stocksList = inventoryBST.inOrder();
                    updateTable(stocksList);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid. Engine number already exists in the inventory.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid. Engine number must be exactly 10 characters.");
            }
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTableInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInventoryMouseClicked
        // TODO add your handling code here:
        DefaultTableModel invTable = (DefaultTableModel)jTableInventory.getModel();
        
        String tblDateEnt = invTable.getValueAt(jTableInventory.getSelectedRow(), 0).toString();
        String tblEngineNum = invTable.getValueAt(jTableInventory.getSelectedRow(), 3).toString();
        String tblLabel= invTable.getValueAt(jTableInventory.getSelectedRow(), 1).toString();
        String tblBrand = invTable.getValueAt(jTableInventory.getSelectedRow(), 2).toString();
        String tblStatus = invTable.getValueAt(jTableInventory.getSelectedRow(), 4).toString();
        
        jTextDateEnt.setText(tblDateEnt);
        jTextEngineNum.setText(tblEngineNum);
        jTextLabel.setText(tblLabel);
        jTextBrand.setText(tblBrand);
        jTextStatus.setText(tblStatus);
        
        jButtonEdit.setEnabled(true);
    }//GEN-LAST:event_jTableInventoryMouseClicked

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        if (jTableInventory.getSelectedRowCount() == 1) {
            int selectedRow = jTableInventory.getSelectedRow();
            
            String dateEnt = jTableInventory.getValueAt(selectedRow, 0).toString();
            String engineNum = jTableInventory.getValueAt(selectedRow, 3).toString();
            Stocks stockToEdit = inventoryBST.search(engineNum);
            
            if (stockToEdit != null) {
            String label = jTextLabel.getText();
            String brand = jTextBrand.getText();
            String status = jTextStatus.getText();
            
            stockToEdit.setStockLabel(label);
            stockToEdit.setBrand(brand);
            stockToEdit.setStatus(status);
            
            DefaultTableModel invTable = (DefaultTableModel) jTableInventory.getModel();
            invTable.setValueAt(dateEnt, selectedRow, 0);
            invTable.setValueAt(label, selectedRow, 1);
            invTable.setValueAt(brand, selectedRow, 2);
            invTable.setValueAt(engineNum, selectedRow, 3); 
            invTable.setValueAt(status, selectedRow, 4);
            
            JOptionPane.showMessageDialog(this, "Stock details updated successfully!");
            
            writeToCSV("InventoryData.csv");
            
        } else {
            JOptionPane.showMessageDialog(this, "Unable to save changes.");
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        
    }    
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        jTextDateEnt.setText("");
        jTextEngineNum.setText("");
        jTextLabel.setText("");
        jTextBrand.setText("");
        jTextStatus.setText("");
        
        loadInventory("InventoryData.csv");
        jButtonEdit.setEnabled(false);
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonEditStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditStockActionPerformed
        // TODO add your handling code here:
        jTableInventory.setEnabled(true);
        JOptionPane.showMessageDialog(this, "Please select a row to edit.");
    }//GEN-LAST:event_jButtonEditStockActionPerformed
    
    private void updateTable(List<Stocks> stocksList) {
        String[] columnNames = {"Date Entered", "Stock Label", "Brand", "Engine Number", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Stocks stock : stocksList) {
            model.addRow(new Object[]{stock.getDateEntered(), stock.getStockLabel(), stock.getBrand(), stock.getEngineNumber(), stock.getStatus()});
        }

        jTableInventory.setModel(model);
    }
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonEditStock;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableInventory;
    private javax.swing.JTextField jTextBrand;
    private javax.swing.JTextField jTextDateEnt;
    private javax.swing.JTextField jTextEngineNum;
    private javax.swing.JTextField jTextLabel;
    private javax.swing.JTextField jTextStatus;
    // End of variables declaration//GEN-END:variables
}
