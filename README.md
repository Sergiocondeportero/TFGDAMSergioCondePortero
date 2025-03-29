📦 Proyecto de Gestión de Inventarios

## Descripción del Proyecto

La **gestión de inventarios** es uno de los aspectos más críticos para las pequeñas y medianas empresas (PYMES), ya que impacta directamente en su eficiencia operativa y rentabilidad. Este proyecto se presenta como una solución para los problemas comunes que enfrentan las PYMES al gestionar sus inventarios. La aplicación de escritorio está diseñada para optimizar el flujo de trabajo empresarial de manera eficiente y rápida.

### Tecnologías Usadas:

- **Lenguaje**: Java
- **Base de Datos**: MySQL
- **Interfaz Gráfica**: Swing
- **Patrón de Diseño**: Modelo-Vista-Controlador (MVC)

La aplicación permite gestionar el inventario de productos, clientes, proveedores, usuarios y categorías mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

---

## 🗃️ Estructura de la Base de Datos

El sistema utiliza una base de datos relacional con el modelo **Entidad-Relación**. La base de datos se llama **Inventario** y contiene las siguientes tablas:

### **Categoría**

- `idCategoria` (PK): Identificador único de la categoría.
- `categoria`: Nombre de la categoría.

### **Cliente**

- `idCliente` (PK): Identificador único del cliente.
- `nombre`, `apellido`, `documento`, `direccion`, `telefono`, `correo`: Información del cliente.

### **Producto**

- `idProducto` (PK): Identificador único del producto.
- `nombre`, `stock`, `precio`: Detalles del producto.
- `idCategoria` (FK): Relación con la categoría del producto.

### **Proveedor**

- `idProveedor` (PK): Identificador único del proveedor.
- `nombre`, `apellido`, `documento`, `Rsocial`, `direccion`, `telefono`, `correo`: Información del proveedor.

### **Usuario**

- `idUsuario` (PK): Identificador único del usuario.
- `nombre`, `apellido`, `documento`, `direccion`, `telefono`, `correo`: Información del usuario.
- `tipoUsuario`: Tipo de usuario (Administrador, Almacenero, Vendedor).
- `usuario`, `password`: Credenciales de acceso.

---

## ⚙️ Creación de Tablas en MySQL

Las tablas en la base de datos se crean mediante las siguientes sentencias SQL:

```sql
CREATE TABLE `categorías` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(30) NOT NULL,
  PRIMARY KEY (`idCategoria`)
);

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`)
);

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `stock` int(30) NOT NULL,
  `idCategoria` int(12) NOT NULL,
  `precio` int(10) NOT NULL,
  PRIMARY KEY (`idProducto`),
  KEY `fk_categorias` (`idCategoria`),
  CONSTRAINT `fk_categorias` FOREIGN KEY (`idCategoria`) REFERENCES `categorías` (`idCategoria`)
);

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `Rsocial` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  PRIMARY KEY (`idProveedor`)
);

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `tipoUsuario` varchar(20) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`idUsuario`)
);
🛠️ Operaciones CRUD
La aplicación permite realizar las siguientes operaciones en las tablas de la base de datos:

Crear: Inserción de nuevos registros en las tablas de productos, clientes, proveedores, categorías y usuarios.

Leer: Consulta y visualización de datos almacenados.

Actualizar: Modificación de registros existentes.

Eliminar: Borrado de registros innecesarios.

Estas operaciones se implementan mediante clases específicas que permiten ejecutar las sentencias SQL necesarias para interactuar con la base de datos.

🚀 Justificación del Proyecto
El objetivo principal de este proyecto es resolver problemas comunes en la gestión de inventarios en pequeñas y medianas empresas, como el desabastecimiento o el exceso de productos. Al automatizar los procesos, se reduce la carga administrativa, se mejora la eficiencia operativa y se permite a los gerentes tomar decisiones informadas basadas en datos en tiempo real. Además, la aplicación contribuye a la satisfacción del cliente al garantizar la disponibilidad de productos y mejorar la rapidez en los pedidos.

🗂️ Estructura del Proyecto
El proyecto sigue el patrón de diseño Modelo-Vista-Controlador (MVC), lo que facilita su escalabilidad y mantenimiento. La aplicación está organizada en los siguientes paquetes:

InventarioTFG: Contiene el archivo principal que inicia la aplicación.

Vista: Contiene las clases encargadas de la interfaz gráfica.

Modelo: Contiene las clases que representan las entidades de la base de datos.

Controlador: Gestiona las operaciones CRUD y la interacción entre la vista y el modelo.

Notificación: Gestiona las notificaciones del usuario.

Librerías: Contiene las bibliotecas necesarias para la aplicación, como la conexión con MySQL.

🎯 Objetivos de la Aplicación
El objetivo principal de la aplicación es implementar un sistema de gestión de inventarios eficiente, utilizando operaciones CRUD y un sistema de roles con diferentes privilegios de usuario. Algunas de las funcionalidades clave incluyen:

Gestión de categorías, clientes, proveedores, usuarios y productos.

Diferentes tipos de usuarios: Administrador, Almacenero y Vendedor, con diferentes permisos de acceso.

Interfaz gráfica intuitiva construida con Swing.

📝 Conclusiones
La implementación de esta aplicación ha demostrado ser una solución práctica y accesible para la gestión de inventarios en pequeñas y medianas empresas. La estructura modular y la integración con MySQL garantizan un sistema robusto, escalable y fácil de mantener. Además, la interfaz gráfica proporciona una experiencia de usuario amigable y fácil de usar.

En el futuro, se planean actualizaciones para añadir funcionalidades como gráficos interactivos y la generación de reportes detallados en formato PDF, lo que mejorará aún más la eficiencia de la gestión de inventarios.

🔧 Instalación
Para instalar y ejecutar el proyecto, sigue estos pasos:

Clona el repositorio o descarga el archivo del proyecto.

Importa el proyecto en un IDE de Java (NetBeans, IntelliJ, etc.).

Configura MySQL y crea la base de datos Inventario.

Conecta la aplicación a la base de datos.

Ejecuta el archivo principal para iniciar la aplicación.

🤝 Contribuciones
Si deseas contribuir a este proyecto, no dudes en hacer un fork y enviar un pull request. ¡Todas las contribuciones son bienvenidas!

```
