package controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import modelo.Categorias;
import modelo.UsuariosModelo;
import modelo.clientes;
import modelo.productos;
import modelo.proveedor;

public class GenerarReporte {

    public static void generarDocumento() {
        Document document = new Document();

        try {
            // Definir la ruta del archivo PDF
            String rutaArchivo = "ReporteDatos.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));

            // Abrir el documento para escribir
            document.open();

            // Agregar título
            Paragraph titulo = new Paragraph("Reporte de Datos");
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            // Agregar espacio
            document.add(new Paragraph("\n"));

            // Crear tablas para las secciones del reporte
            DaoClientes daoClientes = new DaoClientes();
            DaoProductos daoProductos = new DaoProductos();
            DaoCategorias daoCategorias = new DaoCategorias();
            DaoProveedor daoProveedor = new DaoProveedor();
            DaoUsuario daoUsuario = new DaoUsuario();

            // === LISTA DE CLIENTES ===
            document.add(new Paragraph("=== LISTA DE CLIENTES ==="));
            PdfPTable tablaClientes = new PdfPTable(3);
            tablaClientes.setWidthPercentage(100);
            agregarCeldaEncabezado(tablaClientes, "ID");
            agregarCeldaEncabezado(tablaClientes, "Nombre");
            agregarCeldaEncabezado(tablaClientes, "Documento");

            List<clientes> listaClientes = daoClientes.listar();
            for (clientes c : listaClientes) {
                tablaClientes.addCell(String.valueOf(c.getIdCliente()));
                tablaClientes.addCell(c.getNombre() + " " + c.getApellido());
                tablaClientes.addCell(c.getDocumento());
            }
            document.add(tablaClientes);
            document.add(new Paragraph("\n"));

            // === LISTA DE PRODUCTOS ===
            document.add(new Paragraph("=== LISTA DE PRODUCTOS ==="));
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            agregarCeldaEncabezado(tablaProductos, "ID");
            agregarCeldaEncabezado(tablaProductos, "Nombre");
            agregarCeldaEncabezado(tablaProductos, "Stock");
            agregarCeldaEncabezado(tablaProductos, "Precio");

            List<productos> listaProductos = daoProductos.Listar();
            for (productos p : listaProductos) {
                tablaProductos.addCell(String.valueOf(p.getIdproducto()));
                tablaProductos.addCell(p.getNomProd());
                tablaProductos.addCell(String.valueOf(p.getStock()));
                tablaProductos.addCell(String.valueOf(p.getPrecioV()));
            }
            document.add(tablaProductos);
            document.add(new Paragraph("\n"));

            // === LISTA DE CATEGORÍAS ===
            document.add(new Paragraph("=== LISTA DE CATEGORÍAS ==="));
            PdfPTable tablaCategorias = new PdfPTable(2);
            tablaCategorias.setWidthPercentage(100);
            agregarCeldaEncabezado(tablaCategorias, "ID");
            agregarCeldaEncabezado(tablaCategorias, "Nombre");

            List<Categorias> listaCategorias = daoCategorias.listar();
            for (Categorias cat : listaCategorias) {
                tablaCategorias.addCell(String.valueOf(cat.getIdCategoria()));
                tablaCategorias.addCell(cat.getNomCategoria());
            }
            document.add(tablaCategorias);
            document.add(new Paragraph("\n"));

            // === LISTA DE PROVEEDORES ===
            document.add(new Paragraph("=== LISTA DE PROVEEDORES ==="));
            PdfPTable tablaProveedores = new PdfPTable(4);
            tablaProveedores.setWidthPercentage(100);
            agregarCeldaEncabezado(tablaProveedores, "ID");
            agregarCeldaEncabezado(tablaProveedores, "Nombre");
            agregarCeldaEncabezado(tablaProveedores, "Documento");
            agregarCeldaEncabezado(tablaProveedores, "Teléfono");

            List<proveedor> listaProveedores = daoProveedor.Listar();
            for (proveedor p : listaProveedores) {
                tablaProveedores.addCell(String.valueOf(p.getIdProveedor()));
                tablaProveedores.addCell(p.getNombre() + " " + p.getApellido());
                tablaProveedores.addCell(p.getDocumento());
                tablaProveedores.addCell(p.getTelefono());
            }
            document.add(tablaProveedores);
            document.add(new Paragraph("\n"));

            // === LISTA DE USUARIOS ===
            document.add(new Paragraph("=== LISTA DE USUARIOS ==="));
            PdfPTable tablaUsuarios = new PdfPTable(3);
            tablaUsuarios.setWidthPercentage(100);
            agregarCeldaEncabezado(tablaUsuarios, "ID");
            agregarCeldaEncabezado(tablaUsuarios, "Nombre");
            agregarCeldaEncabezado(tablaUsuarios, "Usuario");

            List<UsuariosModelo> listaUsuarios = daoUsuario.Listar();
            for (UsuariosModelo u : listaUsuarios) {
                tablaUsuarios.addCell(String.valueOf(u.getIdusuario()));
                tablaUsuarios.addCell(u.getNombre() + " " + u.getApellidos());
                tablaUsuarios.addCell(u.getUsuario());
            }
            document.add(tablaUsuarios);

            // Cerrar el documento
            document.close();

            System.out.println("El reporte ha sido generado correctamente en ReporteDatos.pdf");

        } catch (DocumentException | FileNotFoundException e) {
            System.err.println("Error al generar el reporte: " + e.getMessage());
        }
    }

    // Método para agregar las celdas de encabezado a las tablas
    private static void agregarCeldaEncabezado(PdfPTable tabla, String texto) {
        PdfPCell celda = new PdfPCell(new Phrase(texto));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(celda);
    }
}
