
package vista;

import controlador.DaoCategorias;
import controlador.DaoProveedor;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Categorias;
import modelo.proveedor;

public class BuscarDato extends javax.swing.JFrame {

    Categoria ct = new Categoria();
    DaoCategorias daoCt = new DaoCategorias();
    DaoProveedor daoP = new DaoProveedor();
    DefaultTableModel modelo = new DefaultTableModel();
    public static boolean tipo;
    public static boolean entrada;

    public BuscarDato() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0, 0, 0, 0));
        cabezeras();
        if (tipo == true) {
            listarCategorias();
        } else {
            listarProveedor();
        }
    }

    private void cabezeras() {
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        tabla.setModel(modelo);
    }

    private void listarCategorias() {
        List<Categorias> lista = daoCt.listar();
        modelo = (DefaultTableModel) tabla.getModel();
        Object[] ob = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdCategoria();
            ob[1] = lista.get(i).getNomCategoria();
            modelo.addRow(ob);
        }
        tabla.setModel(modelo);
    }

    private void listarProveedor() {
        List<proveedor> lista = daoP.Listar();
        modelo = (DefaultTableModel) tabla.getModel();
        Object[] ob = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getIdProveedor();
            ob[1] = lista.get(i).getRsocial();
            modelo.addRow(ob);
        }
        tabla.setModel(modelo);
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jpanelRound1 = new modelo.JpanelRound();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        btnCerrar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconDos();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jpanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jpanelRound1.setRoundBottomLeft(25);
        jpanelRound1.setRoundBottomRight(25);
        jpanelRound1.setRoundTopLeft(25);
        jpanelRound1.setRoundTopRight(52);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setText("LISTADO");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnCerrar.setBackground(new java.awt.Color(204, 0, 0));
        btnCerrar.setText("Cerrar");
        btnCerrar.setBackgroundHover(new java.awt.Color(255, 130, 130));
        btnCerrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrar.setRound(25);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setText("Enviar");
        btnBuscar.setBackgroundHover(new java.awt.Color(153, 153, 153));
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEND);
        btnBuscar.setRound(25);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelRound1Layout = new javax.swing.GroupLayout(jpanelRound1);
        jpanelRound1.setLayout(jpanelRound1Layout);
        jpanelRound1Layout.setHorizontalGroup(
                jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanelRound1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jpanelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpanelRound1Layout.createSequentialGroup()
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 156,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jpanelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelRound1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jpanelRound1Layout.setVerticalGroup(
                jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpanelRound1Layout.createSequentialGroup()
                                .addGroup(jpanelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpanelRound1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                jpanelRound1Layout.createSequentialGroup()
                                                        .addContainerGap(68, Short.MAX_VALUE)
                                                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jpanelRound1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jpanelRound1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//
        dispose();
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//
        if (tipo == true) {
            if (entrada == true) {

            } else {
                Productos.txtNomCategoria.setText(txtnombre.getText());
                Productos.txtidCategoria.setText(txtID.getText());
            }
        }
        dispose();
    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tabla.getSelectedRow();
        txtID.setText(tabla.getValueAt(fila, 0).toString());
        txtnombre.setText(tabla.getValueAt(fila, 1).toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarDato.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarDato.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarDato.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarDato.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarDato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private modelo.JpanelRound jpanelRound1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
