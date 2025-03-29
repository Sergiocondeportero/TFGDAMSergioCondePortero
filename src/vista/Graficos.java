/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.awt.Color;
import java.util.List;
import modelo.productos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author sergi
 */
public class Graficos extends javax.swing.JPanel {

 // Constructor que acepta la lista de productos
    public Graficos(List<productos> listaProductos) {
        initComponents();  // Inicializa los componentes de la interfaz gráfica
        mostrarGrafico(listaProductos);  // Llama al método para mostrar el gráfico
    }

    private void mostrarGrafico(List<productos> listaProductos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Recorre la lista de productos y agrega los datos al dataset
        for (productos prod : listaProductos) {
            dataset.setValue(prod.getStock(), "Stock", prod.getNomProd());
        }

        // Crea el gráfico de barras con los datos
        JFreeChart grafico = ChartFactory.createBarChart(
            "Gráficos de Stock",  // Título del gráfico
            "Producto",  // Eje X
            "Cantidad",  // Eje Y
            dataset,
            PlotOrientation.VERTICAL,
            true,  // Leyenda
            true,  // Tooltips
            false  // URLs
        );

        // Personaliza el gráfico, como cambiar el color de la cuadrícula
        CategoryPlot plot = grafico.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        // Crea un panel que contendrá el gráfico
        ChartPanel panelGrafico = new ChartPanel(grafico);
        panelGrafico.setPreferredSize(new java.awt.Dimension(800, 400));  // Define el tamaño del gráfico

        // Limpia el panel antes de agregar el nuevo gráfico
        pnlGrafico2.removeAll();

        // Agrega el panel gráfico al panel `pnlGrafico2`
        pnlGrafico2.add(panelGrafico, java.awt.BorderLayout.CENTER);

        // Revalida y repinta para actualizar la interfaz
        this.revalidate();
        this.repaint();
    }
  

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnicono1 = new RSMaterialComponent.RSButtonMaterialIconDos();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlGrafico2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1057, 651));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        btnicono1.setBackground(new java.awt.Color(51, 51, 51));
        btnicono1.setForeground(new java.awt.Color(204, 204, 255));
        btnicono1.setToolTipText("");
        btnicono1.setBackgroundHover(new java.awt.Color(51, 51, 51));
        btnicono1.setForegroundHover(new java.awt.Color(204, 204, 255));
        btnicono1.setForegroundIcon(new java.awt.Color(204, 204, 255));
        btnicono1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.GRAPHIC_EQ);
        btnicono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnicono1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Script MT Bold", 1, 36)); // NOI18N
        jLabel1.setText("Gráficos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnicono1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnicono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Script MT Bold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("Gráficos de Stock de productos");

        pnlGrafico2.setBackground(new java.awt.Color(204, 204, 255));
        pnlGrafico2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(pnlGrafico2, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 547, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(pnlGrafico2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(118, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnicono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnicono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnicono1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnicono;
    private RSMaterialComponent.RSButtonMaterialIconDos btnicono1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlGrafico2;
    // End of variables declaration//GEN-END:variables
}
