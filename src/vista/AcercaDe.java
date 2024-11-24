
package vista;

public class AcercaDe extends javax.swing.JPanel {

    public AcercaDe() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(
                "La gestión de inventario es un proceso integral que involucra la administración eficiente de categorías, clientes, proveedores, usuarios \ny productos, con el objetivo de optimizar el flujo de bienes y servicios en una organización. Las categorías permiten \nclasificar los productos según su naturaleza o uso, facilitando su localización y control. Los clientes son el eje central, \nya que su demanda determina los niveles óptimos de inventario, mientras que los proveedores son socios clave para garantizar la disponibilidad oportuna de los productos. \nPor otro lado, los usuarios, que incluyen empleados o sistemas internos, interactúan con el inventario para registrar, \nactualizar y controlar las existencias. Un enfoque adecuado en la gestión de inventario garantiza que los productos\n estén disponibles en cantidad suficiente, evitando excesos o desabastecimientos, y mejora la eficiencia operativa \nde toda la cadena de suministro.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(210, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(269, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
