/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysprestamos.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.upeu.sysprestamos.modelo.EAP;
import pe.edu.upeu.sysprestamos.DAO.EAPDAO;
import pe.edu.upeu.sysprestamos.modelo.Facultad;
import pe.edu.upeu.sysprestamos.DAO.FacultadDAO;


/**
 *
 * @author alum.fial8
 */
public class EapForm extends javax.swing.JInternalFrame {
    int op;
    
    ArrayList<Facultad> lista = new ArrayList();
    ArrayList<EAP> lista1 = new ArrayList();
    FacultadDAO ad = new FacultadDAO();
    EAPDAO ad1 = new EAPDAO();
    DefaultTableModel model;
    DefaultComboBoxModel<Object> modelocombo = new DefaultComboBoxModel<>();
    /**
     * Creates new form EapForm
     */
    public EapForm() {
        initComponents();
        cargarFacu();
        desabilitar();              
        ListarEap();
        bloquear();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtEscuela = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboFacultad = new javax.swing.JComboBox();
        txtIdFacultad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbListarEscuela = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos EAP"));

        jLabel1.setText("idEap");

        jLabel4.setText("Escuela");

        jLabel3.setText("Facultad");

        cboFacultad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar" }));
        cboFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFacultadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEscuela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar Datos de Escuela"));

        jtbListarEscuela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Escuela", "IdFacultad"
            }
        ));
        jtbListarEscuela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbListarEscuelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbListarEscuela);
        if (jtbListarEscuela.getColumnModel().getColumnCount() > 0) {
            jtbListarEscuela.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        btnNuevo.setText("Nuevo");

        btnAgregar.setText("Registrar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFacultadActionPerformed
        // TODO add your handling code here:
        String c = cboFacultad.getSelectedItem().toString();
        int id;
        int x = cboFacultad.getSelectedIndex();
        if(x>0){
            
            id = ad.devolverIdFacultad(c);
            txtIdFacultad.setText(""+id);
        }
    }//GEN-LAST:event_cboFacultadActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
      if(cboFacultad.getSelectedIndex()!=0){
        int idp = Integer.parseInt(txtIdFacultad.getText());
        String escu = txtEscuela.getText();
        int o = ad1.registrarEap(idp, escu);
        limpiar();
        if(o>0){
            JOptionPane.showMessageDialog(null, "Usuario Registrado");
            updateComponets();            
            btnAgregar.setEnabled(false);
        }
        }else{
        
            JOptionPane.showMessageDialog(null, "Selecionar Usuario");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         int fil = jtbListarEscuela.getSelectedRow();
        if(fil<0){
            JOptionPane.showMessageDialog(null, "Seleccionar La EAP a MODIFICAR!");
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea MODIFICAR LA EAP? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                    int id = Integer.parseInt(txtId.getText());
                    String esc = txtEscuela.getText();
             
                    int x = ad1.modificarEap(id, esc);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "EAP MODIFICADO!");
                        updateComponets();
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "EAP no se ha MODIFICADO!");      
                    }                   
            }        
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = jtbListarEscuela.getSelectedRow();
        if(fila<0){
            JOptionPane.showMessageDialog(null, "Seleccionar LA Escuela a ELIMINAR");            
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea ELIMINAR La Escuela? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                    int celda = (int) jtbListarEscuela.getValueAt(fila, 0);
                    int x = ad1.eliminarEap(celda);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Escuela ELIMINADO!");
                        updateComponets();
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Escuela no ELIMINADO!");      
                    }                   
            } 
            
        }        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jtbListarEscuelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbListarEscuelaMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==1){
            int fila = jtbListarEscuela.getSelectedRow();
            int celda = (int) jtbListarEscuela.getValueAt(fila, 0);
            lista1 = ad1.listarEap(celda);
            for(int i=0;i<lista1.size();i++){
                txtId.setText(""+lista1.get(i).getIdEap());
                txtEscuela.setText(lista1.get(i).getEscuela());
                txtIdFacultad.setText(""+lista1.get(i).getIdFacultad());
                
                
            }
        }  
    }//GEN-LAST:event_jtbListarEscuelaMouseClicked
    void limpiar(){
    txtIdFacultad.setText(null);
    txtId.setText(null);
    txtEscuela.setText(null);
    }
    void updateComponets(){
            LimpiarTabla(model);
            ListarEap();
    }
    void LimpiarTabla(DefaultTableModel modelo){
        int a =modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){  
            modelo.removeRow(i);
        }
    }
    void ListarEap(){
    lista1 = ad1.listarEap();
    model = (DefaultTableModel) jtbListarEscuela.getModel();
        Object[] eap1 = new Object[3];
        for(int i=0;i<lista1.size();i++){
            eap1[0]=lista1.get(i).getIdEap();
            eap1[1]=lista1.get(i).getEscuela();
            eap1[2]=lista1.get(i).getIdFacultad();
            model.addRow(eap1);
        }        
        jtbListarEscuela.setModel(model);
    }
    final void cargarFacu(){
    lista = ad.listarFacultad();
    modelocombo.addElement("Seleccionar Facultad");
    cboFacultad.setModel(modelocombo);
    for (int i=0;i<lista.size();i++){
    modelocombo.addElement(lista.get(i).getFacultad());
    }
    cboFacultad.setModel(modelocombo);
    }
    void desabilitar(){
        txtEscuela.setEditable(true);
        btnAgregar.setEnabled(false);
    }
    final void bloquear(){
    txtEscuela.setEditable(true);
    btnAgregar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cboFacultad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbListarEscuela;
    private javax.swing.JTextField txtEscuela;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdFacultad;
    // End of variables declaration//GEN-END:variables
}
