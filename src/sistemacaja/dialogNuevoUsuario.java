package sistemacaja;

import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.*;


public class dialogNuevoUsuario extends javax.swing.JDialog {
    String tipdoc, nom, apePat, apeMat, depart, prov, distr, direc, dni;
    int sol;
    conexion con= new conexion();
    public dialogNuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    public dialogNuevoUsuario(java.awt.Frame parent, boolean modal, String dni, int combo){
        super(parent, modal);
        initComponents();
        if(combo == 1){
            this.Ocultar();
        }else{
            this.Mostrar();
        }
        this.txtNumDoc.setText(dni);
        this.cboxTipoDocum.setSelectedIndex(combo);
        this.txtApePat.requestFocus();
    }
    public void dbcbox(String sql,JComboBox a){
            try {
                con.conectar();
                ResultSet rs = con.consulta(sql);
                while(rs.next()){
                    a.addItem (rs.getObject(1));
                }
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(rootPane, "Error" +e);
            }
        }
   public void Ocultar(){
       this.lblpaterno.setVisible(false);
       this.lblmaterno.setVisible(false);
       this.lblnombre.setText("Institucion");
       this.txtApeMat.setText(".");
       this.txtApePat.setText(".");
       this.txtApeMat.setVisible(false);
       this.txtApePat.setVisible(false);
       this.txtNom.requestFocus();
   }
   public void Mostrar(){
       this.lblpaterno.setVisible(true);
       this.lblmaterno.setVisible(true);
       this.lblnombre.setText("Nombre");
       this.txtApeMat.setVisible(true);
       this.txtApePat.setVisible(true);
       this.txtApePat.requestFocus();
   }
    public void nuevoRegistro(){
        int solic=0;
        try{
                con.conectar();
                ResultSet res=con.consulta("SELECT COUNT(codUsu) AS num FROM usuarios");
                res.next();
                solic=Integer.parseInt(res.getString("num"));
            }catch(SQLException e){
                System.out.println(e);
            }
        lblUsu.setText(String.valueOf(solic+1));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtNumDoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblmaterno = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        lblnombre = new javax.swing.JLabel();
        txtApeMat = new javax.swing.JTextField();
        txtApePat = new javax.swing.JTextField();
        lblpaterno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxTipoDocum = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cboxDepart = new javax.swing.JComboBox();
        cboxProv = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboxDist = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtDirec = new javax.swing.JTextField();
        lblUsu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRAR NUEVO USUARIO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Datos del Solicitante:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel1.setToolTipText("Datos del Solicitante");
        jPanel1.setName("datos"); // NOI18N

        txtNumDoc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNumDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumDocKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumDocKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumDocKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("N° Documento:");

        lblmaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblmaterno.setText("Apellido Materno:");

        txtNom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomKeyPressed(evt);
            }
        });

        lblnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblnombre.setText("Nombres:");

        txtApeMat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApeMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApeMatKeyPressed(evt);
            }
        });

        txtApePat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtApePat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApePatKeyPressed(evt);
            }
        });

        lblpaterno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblpaterno.setText("Apellido Paterno:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Tipo de Documento:");

        cboxTipoDocum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboxTipoDocum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "D.N.I.", "RUC.", "L.M.", "PASAPORTE", "" }));
        cboxTipoDocum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboxTipoDocumKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumDoc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxTipoDocum, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblpaterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApePat))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblmaterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApeMat))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblnombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxTipoDocum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtNumDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblpaterno)
                    .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmaterno)
                    .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnombre)
                    .addComponent(txtNom))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Departamento:");

        cboxDepart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboxDepart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "AMAZONAS", "ANCASH", "APURIMAC", "AREQUIPA", "AYACUCHO", "CAJAMARCA", "CALLAO", "CUSCO", "HUANCAVELICA", "HUANUCO", "ICA", "JUNIN", "LA LIBERTAD", "LAMBAYEQUE", "LIMA", "LORETO", "MADRE DE DIOS", "MOQUEGUA", "PASCO", "PIURA", "PUNO", "SAN MARTIN", "TACNA", "TUMBES", "UCAYALI" }));
        cboxDepart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxDepartItemStateChanged(evt);
            }
        });
        cboxDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxDepartActionPerformed(evt);
            }
        });
        cboxDepart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboxDepartKeyPressed(evt);
            }
        });

        cboxProv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboxProv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxProvItemStateChanged(evt);
            }
        });
        cboxProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxProvActionPerformed(evt);
            }
        });
        cboxProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboxProvKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Provincia:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Distrito:");

        cboxDist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cboxDist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboxDistKeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Dirección");

        txtDirec.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDirec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDirecActionPerformed(evt);
            }
        });
        txtDirec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDirecKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxDepart, 0, 172, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxProv, 0, 204, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxDist, 0, 213, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirec, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboxDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboxDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblUsu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65)
                        .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(706, 311));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
}//GEN-LAST:event_btnCancelarActionPerformed
    private void txtNumDocKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtApePat.requestFocus();
        }
}//GEN-LAST:event_txtNumDocKeyPressed
    private void txtNumDocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyReleased
        if(txtNumDoc.getText().length()>20){
            txtApePat.requestFocus();
        }
}//GEN-LAST:event_txtNumDocKeyReleased
    private void txtNumDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumDocKeyTyped
        
}//GEN-LAST:event_txtNumDocKeyTyped
    private void txtNomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            cboxDepart.requestFocus();
        }
}//GEN-LAST:event_txtNomKeyPressed
    private void txtApeMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApeMatKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtNom.requestFocus();
        }
}//GEN-LAST:event_txtApeMatKeyPressed
    private void txtApePatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApePatKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtApeMat.requestFocus();
        }
}//GEN-LAST:event_txtApePatKeyPressed
    private void cboxTipoDocumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboxTipoDocumKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtNumDoc.requestFocus();
        }
}//GEN-LAST:event_cboxTipoDocumKeyPressed
    private void cboxDepartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxDepartItemStateChanged
        int valor = this.cboxDepart.getSelectedIndex();
        cboxProv.removeAllItems();
        try{
            dbcbox("SELECT Des_pvi opcion FROM provincias WHERE Cod_dpt="+valor+"0000",cboxProv);
        }catch(Exception e){
            System.out.println(e);
        }
}//GEN-LAST:event_cboxDepartItemStateChanged
    private void cboxDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxDepartActionPerformed
}//GEN-LAST:event_cboxDepartActionPerformed
    private void cboxDepartKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboxDepartKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            cboxProv.requestFocus();
        }
}//GEN-LAST:event_cboxDepartKeyPressed
    private void cboxProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxProvActionPerformed
}//GEN-LAST:event_cboxProvActionPerformed
    private void cboxProvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboxProvKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            cboxDist.requestFocus();
        }
}//GEN-LAST:event_cboxProvKeyPressed
    private void cboxDistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboxDistKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            txtDirec.requestFocus();
        }
}//GEN-LAST:event_cboxDistKeyPressed
    private void txtDirecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            btnGuardar.doClick();
        }
}//GEN-LAST:event_txtDirecKeyPressed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        tipdoc=String.valueOf(cboxTipoDocum.getSelectedItem());
        sol = Integer.parseInt(lblUsu.getText());
        dni=this.txtNumDoc.getText();
        nom=txtNom.getText().toUpperCase();
        apePat=txtApePat.getText().toUpperCase();
        apeMat=txtApeMat.getText().toUpperCase();
        depart=String.valueOf(cboxDepart.getSelectedItem());
        prov=String.valueOf(cboxProv.getSelectedItem());
        distr=String.valueOf(cboxDist.getSelectedItem());
        direc=txtDirec.getText().toUpperCase();
        if(direc == null ? "" == null : direc.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Tiene que escribir su direccion Actual");
        }else{
            try{
                con.conectar();
                con.insertar("INSERT INTO usuarios ( nombre, apePat, apeMat, tipDoc, numDoc, direccion, codDep, codPro, codDis) "
                +" VALUES('"+nom+"','"+apePat+"','"+apeMat+"','"+tipdoc+"','"+dni+"','"+direc+"','"+depart+"','"+prov+"','"+distr+"');");
                //con.cierraConexion();
                dispose();
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void cboxProvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxProvItemStateChanged
        String provi = String.valueOf(cboxProv.getSelectedItem());
        String valor="";
        cboxDist.removeAllItems();
        try{
            con.conectar();
            ResultSet rs = con.consulta("SELECT Cod_pvi FROM provincias WHERE Des_pvi='"+provi+"';");
            rs.next();
            valor=String.valueOf(rs.getObject("Cod_pvi"));
            //con.cierraConexion();
            dbcbox("SELECT Des_dst FROM distritos WHERE Cod_pvi='"+valor+"';",cboxDist);
        }catch(SQLException e){
            System.out.println(e);
        }        
    }//GEN-LAST:event_cboxProvItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.txtApePat.requestFocus();
        nuevoRegistro();
    }//GEN-LAST:event_formWindowOpened

    private void txtDirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDirecActionPerformed
        // TODO add your handling code here:ç

    }//GEN-LAST:event_txtDirecActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogNuevoUsuario dialog = new dialogNuevoUsuario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboxDepart;
    private javax.swing.JComboBox cboxDist;
    private javax.swing.JComboBox cboxProv;
    private javax.swing.JComboBox cboxTipoDocum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblUsu;
    private javax.swing.JLabel lblmaterno;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblpaterno;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNumDoc;
    // End of variables declaration//GEN-END:variables
}
