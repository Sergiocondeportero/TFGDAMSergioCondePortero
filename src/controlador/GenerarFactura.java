package controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import modelo.productos;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GenerarFactura {
public void generarFactura() {
    // Crear la conexión con el DAO de productos
    DaoProductos daoProductos = new DaoProductos();

    // Obtener todos los productos
    List<productos> productos = daoProductos.Listar();

    // Calcular el total de la factura
    double total = 0;
    for (productos p : productos) {
        double subTotal = p.getPrecioV() * p.getStock(); // Multiplicar precio por stock para obtener el total de cada producto
        total += subTotal; // Acumular el subtotal de cada producto al total de la factura
    }

    // Crear el documento PDF
    Document document = new Document();
    try {
        String rutaArchivo = "FacturaProductos.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
        document.open();

        // Título de la factura
        Paragraph titulo = new Paragraph("Factura de Productos");
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);
        document.add(new Paragraph("\n"));

        // Tabla de productos
        PdfPTable tabla = new PdfPTable(4);  // Cuatro columnas: Nombre, Cantidad, Precio, Subtotal
        tabla.setWidthPercentage(100);

        // Encabezado de la tabla
        agregarCeldaEncabezado(tabla, "Producto");
        agregarCeldaEncabezado(tabla, "Cantidad");
        agregarCeldaEncabezado(tabla, "Precio");
        agregarCeldaEncabezado(tabla, "Subtotal");

        // Añadir los productos a la tabla
        for (productos p : productos) {
            tabla.addCell(p.getNomProd());  // Nombre del producto
            tabla.addCell(String.valueOf(p.getStock()));  // Cantidad (en este caso el stock)
            tabla.addCell("$" + p.getPrecioV());  // Precio del producto
            double subTotal = p.getPrecioV() * p.getStock();
            tabla.addCell("$" + subTotal);  // Subtotal (precio * cantidad)
        }

        // Añadir la tabla al documento
        document.add(tabla);
        document.add(new Paragraph("\n"));

        // Mostrar el total
        document.add(new Paragraph("Total a pagar: $" + total));

        // Cerrar el documento
        document.close();

        System.out.println("Factura generada correctamente en la ruta: " + rutaArchivo);
    } catch (DocumentException | FileNotFoundException e) {
        e.printStackTrace();
        System.err.println("Error al generar la factura: " + e.getMessage());
    }
}

// Método auxiliar para agregar celdas
private void agregarCeldaEncabezado(PdfPTable tabla, String texto) {
    PdfPCell celda = new PdfPCell(new Phrase(texto));
    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
    tabla.addCell(celda);
}

}
