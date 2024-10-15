-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2024 at 12:09 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistema_ventas`
--

-- --------------------------------------------------------

--
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `dpi` varchar(13) NOT NULL,
  `nit` varchar(20) NOT NULL,
  `numero` varchar(12) NOT NULL,
  `direccion` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nombre`, `dpi`, `nit`, `numero`, `direccion`) VALUES
(1, 'Juan Perez', '269004855080', '7845187', '77375187', '7ma avenida 2-3 zona 1 Guatemala'),
(3, 'Carlos Pérez', '1234567890123', '1234567', '12345678', 'Calle 1, Ciudad, Guatemala'),
(4, 'María López', '2345678901234', '2345678', '23456789', 'Avenida 2, Ciudad, Quetzaltenango'),
(5, 'Juan Gómez', '3456789012345', '3456789', '34567890', 'Calle 3, Ciudad, Escuintla'),
(6, 'Ana Martínez', '4567890123456', '4567890', '45678901', 'Avenida 4, Ciudad, Antigua Guatemala'),
(7, 'Luis Rodríguez', '5678901234567', '5678901', '56789012', 'Calle 5, Ciudad, Cobán'),
(8, 'Elena Torres', '6789012345678', '6789012', '67890123', 'Avenida 6, Ciudad, Zacapa'),
(9, 'Jorge Ramírez', '7890123456789', '7890123', '78901234', 'Calle 7, Ciudad, Chiquimula'),
(10, 'Sofía Castillo', '8901234567890', '8901234', '89012345', 'Avenida 8, Ciudad, Jutiapa'),
(11, 'Fernando Morales', '9012345678901', '9012345', '90123456', 'Calle 9, Ciudad, Jalapa'),
(12, 'Laura Fernández', '123456789012', '123456', '1234567', 'Avenida 10, Ciudad, Retalhuleu'),
(13, 'Gabriel Ruiz', '1123456789012', '1123456', '11234567', 'Calle 11, Ciudad, Totonicapán'),
(14, 'Andrea Chávez', '2234567890123', '2234567', '22345678', 'Avenida 12, Ciudad, Huehuetenango'),
(15, 'Daniel Vega', '3345678901234', '3345678', '33456789', 'Calle 13, Ciudad, San Marcos'),
(16, 'Isabel Méndez', '4456789012345', '4456789', '44567890', 'Avenida 14, Ciudad, Chimaltenango'),
(17, 'Mario Ortega', '5567890123456', '5567890', '55678901', 'Calle 15, Ciudad, Santa Rosa'),
(18, 'Lucía Herrera', '6678901234567', '6678901', '66789012', 'Avenida 16, Ciudad, Sololá'),
(19, 'Diego Castro', '7789012345678', '7789012', '77890123', 'Calle 17, Ciudad, Suchitepéquez'),
(20, 'Natalia Vásquez', '8890123456789', '8890123', '88901234', 'Avenida 18, Ciudad, Petén'),
(21, 'Ricardo Peña', '9901234567890', '9901234', '99012345', 'Calle 19, Ciudad, Izabal');

-- --------------------------------------------------------

--
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `marca`, `categoria`, `precio`, `cantidad`) VALUES
(2, 'ASUS FX507ZC4-HN132 i7 12700H', 'Asus', 'NOTEBOOK', 8500, 2),
(3, 'GamePad Microsoft Inalambrico Xbox One', 'Microsoft', 'GAMEPAD', 510, 11),
(5, 'Monitor De 21.45 Modelo E2222H', 'Dell', 'MONITOR', 1200, 20),
(6, 'Monitor Led Asus Proart PA247CV 23.8', 'Asus', 'MONITOR', 2000, 10),
(9, 'Mando Play Station 5', 'Play Station', 'GAMEPAD', 550, 5),
(14, 'Laptop XPS 13', 'Dell', 'Computadora', 1200, 15),
(15, 'Monitor UltraSharp 27', 'Dell', 'Monitor', 450, 29),
(16, 'Teclado Mecanico RGB', 'Corsair', 'Accesorios', 130, 45),
(17, 'Mouse Inalambrico MX Master 3', 'Logitech', 'Accesorios', 100, 25),
(18, 'Tarjeta Grafica RTX 3060', 'Nvidia', 'COMPONENTES', 550, 6),
(19, 'Procesador Ryzen 7 5800X', 'AMD', 'COMPONENTES', 380, 18),
(20, 'Placa Base B550-A Pro', 'MSI', 'COMPONENTES', 200, 21),
(21, 'Memoria RAM 16GB DDR4', 'Kingston', 'COMPONENTES', 90, 32),
(22, 'Disco Duro Externo 1TB', 'Seagate', 'Almacenamiento', 80, 39),
(23, 'Impresora Multifuncional LaserJet', 'HP', 'Impresoras', 250, 10),
(24, 'Router Wi-Fi 6 AX1800', 'TP-Link', 'Dispositivos', 120, 24),
(25, 'Unidad SSD NVMe 1TB', 'Samsung', 'COMPONENTES', 150, 19),
(26, 'Camara Web C920', 'Logitech', 'Accesorios', 80, 15),
(27, 'Altavoces Bluetooth', 'JBL', 'MULTIMEDIA', 70, 40),
(28, 'Memoria USB 64GB', 'SanDisk', 'Almacenamiento', 15, 100),
(29, 'Tarjeta de Sonido Interna', 'Creative', 'COMPONENTES', 60, 11),
(30, 'Proyector HD', 'Epson', 'MULTIMEDIA', 300, 5),
(31, 'Tablet Galaxy Tab S7', 'Samsung', 'Movil', 650, 20),
(32, 'Cargador Inalambrico', 'Anker', 'Accesorios', 40, 59),
(33, 'UPS 1500VA', 'APC', 'Servidores', 200, 13),
(34, 'Gamepad Xbox', 'Microsoft', 'Perifericos', 60, 35),
(35, 'Silla Gamer', 'Cougar', 'Perifericos', 250, 9),
(36, 'Tarjeta de Memoria 128GB', 'SanDisk', 'Almacenamiento', 25, 90),
(37, 'Monitor Curvo 32', 'Samsung', 'Monitor', 400, 25),
(38, 'Mousepad Gamer XXL', 'Razer', 'Perifericos', 50, 55),
(39, 'Servidor PowerEdge T40', 'Dell', 'Servidores', 1000, 5),
(40, 'Switch Gigabit 8 Puertos', 'Netgear', 'Dispositivos', 70, 30),
(41, 'Disco Duro NAS 4TB', 'Western Digital', 'Almacenamiento', 120, 21),
(42, 'Cable HDMI 2.1 3m', 'Belkin', 'Suministros', 25, 100),
(43, 'Procesador Core i9-11900K', 'Intel', 'COMPONENTES', 600, 12),
(44, 'Microfono para Streaming', 'Blue', 'Accesorios', 110, 30),
(45, 'Switch Mecanico', 'Cherry', 'COMPONENTES', 40, 40),
(46, 'Smartphone Galaxy S21', 'Samsung', 'Movil', 800, 18),
(47, 'Memoria RAM 32GB DDR4', 'Corsair', 'COMPONENTES', 160, 15),
(48, 'Router Mesh Wi-Fi 6', 'ASUS', 'Dispositivos', 300, 8),
(49, 'Placa Base Z490-A', 'ASUS', 'COMPONENTES', 220, 16),
(50, 'Fuente de Poder 650W', 'EVGA', 'COMPONENTES', 90, 24),
(51, 'Monitor 4K UHD 28', 'LG', 'Monitor', 500, 12),
(52, 'Raton Gaming Viper', 'Razer', 'Perifericos', 80, 45),
(53, 'Camara de Seguridad Wi-Fi', 'Xiaomi', 'MULTIMEDIA', 60, 50),
(54, 'Toner LaserJet 26A', 'HP', 'Suministros', 80, 35),
(55, 'Controlador RAID', 'LSI', 'COMPONENTES', 180, 7),
(56, 'Impresora 3D Ender 3', 'Creality', 'Impresoras', 250, 10),
(57, 'Tarjeta Grafica RX 6700 XT', 'AMD', 'COMPONENTES', 550, 8),
(58, 'Memoria USB 128GB', 'Kingston', 'Almacenamiento', 30, 60),
(59, 'Disco Duro Externo 5TB', 'WD', 'Almacenamiento', 140, 20),
(60, 'Silla Oficina Ergonomica', 'Herman Miller', 'Perifericos', 850, 5),
(61, 'Camara Reflex EOS 90D', 'Canon', 'MULTIMEDIA', 1200, 7),
(62, 'Tarjeta Captura Video HD60', 'Elgato', 'ACCESORIOS', 150, 15);

-- --------------------------------------------------------

--
-- Table structure for table `proveedores`
--

CREATE TABLE `proveedores` (
  `idProveedor` int(11) NOT NULL,
  `nit` bigint(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `proveedores`
--

INSERT INTO `proveedores` (`idProveedor`, `nit`, `nombre`, `direccion`, `email`, `telefono`) VALUES
(3, 512585, 'Macro Sistemas', '7ma avenia zona 4 Quetzaltenango', 'ventas@macrosistemas.com', '84529878'),
(4, 74154, 'Compu Mayoristas', '1ra avenida zona 4 Quetzaltenango', 'ventas@compumayoristas.com', '77375148'),
(93, 12345678, 'Tech Store', 'Calle Principal 1', 'contacto@techstore.com', '55571001'),
(94, 87654321, 'Computers World', 'Avenida 2, Zona 3', 'ventas@computersworld.com', '55571002'),
(95, 13579246, 'Hardware Solutions', 'Calle Secundaria 45', 'soporte@hardwaresolutions.com', '55571003'),
(96, 24681357, 'PC Outlet', 'Boulevard Digital 32', 'info@pcoutlet.com', '55571004'),
(97, 11223344, 'Laptop Center', 'Zona Comercial 5', 'ventas@laptopcenter.com', '55571005'),
(98, 44332211, 'Componentes XYZ', 'Plaza Central 12', 'servicio@componentesxyz.com', '55571006'),
(99, 22334455, 'Byte Store', 'Avenida Informática 18', 'contacto@bytestore.com', '55571007'),
(100, 55667788, 'NetShop', 'Centro Digital 4', 'ventas@netshop.com', '55571008'),
(101, 99887766, 'TechPlanet', 'Calle del Progreso 22', 'contacto@techplanet.com', '55571009'),
(102, 66778899, 'CyberSpace', 'Zona Electrónica 10', 'soporte@cyberspace.com', '55571010'),
(103, 99882211, 'Global Tech', 'Boulevard Global 9', 'ventas@globaltech.com', '55571011'),
(104, 33445566, 'Innovatech', 'Calle Innovación 7', 'info@innovatech.com', '55571012'),
(105, 77441122, 'Smart Tech', 'Avenida Digital 13', 'ventas@smarttech.com', '55571013'),
(106, 88990011, 'Bits & Bytes', 'Zona Electrónica 20', 'contacto@bitsbytes.com', '55571014'),
(107, 22330011, 'FastPC', 'Calle de los Bytes 14', 'soporte@fastpc.com', '55571015'),
(108, 44556677, 'Digital Hub', 'Centro Comercial 2', 'ventas@digitalhub.com', '55571016'),
(109, 88991100, 'CompuMundo', 'Boulevard Tecnológico 6', 'info@compumundo.com', '55571017'),
(110, 33441122, 'TechLabs', 'Avenida Desarrollo 30', 'contacto@techlabs.com', '55571018'),
(111, 55667799, 'IT Shop', 'Calle Tecnología 17', 'ventas@itshop.com', '55571019'),
(112, 99001122, 'CompuExpress', 'Zona Comercial 8', 'info@compuexpress.com', '55571020'),
(113, 11112233, 'ProPC', 'Plaza Tecnología 5', 'ventas@propc.com', '55571021'),
(114, 33221144, 'TechZone', 'Centro Electrónico 3', 'soporte@techzone.com', '55571022'),
(115, 55667788, 'IT Corner', 'Calle Red 11', 'ventas@itcorner.com', '55571023'),
(116, 99887755, 'CompuBest', 'Boulevard Informático 12', 'info@compubest.com', '55571024'),
(117, 77665544, 'Store PC', 'Calle Software 19', 'contacto@storepc.com', '55571025'),
(118, 55443322, 'ByteStore', 'Avenida Tecnología 23', 'ventas@bytestore.com', '55571026'),
(119, 11223355, 'TechMarket', 'Zona PC 4', 'soporte@techmarket.com', '55571027'),
(120, 88990022, 'CompuMega', 'Calle Informática 15', 'info@compumega.com', '55571028'),
(121, 33445577, 'PC Master', 'Avenida Red 21', 'contacto@pcmaster.com', '55571029'),
(122, 55669988, 'DigitalWorld', 'Zona Tech 7', 'ventas@digitalworld.com', '55571030'),
(123, 99003344, 'CompuService', 'Boulevard Electrónico 5', 'soporte@compuservice.com', '55571031'),
(124, 11225566, 'IT Max', 'Calle Tecnología 6', 'info@itmax.com', '55571032'),
(125, 33223344, 'FastTech', 'Centro Comercial Digital 14', 'ventas@fasttech.com', '55571033'),
(126, 55668899, 'PC Solutions', 'Boulevard Progreso 2', 'soporte@pcsolutions.com', '55571034'),
(127, 99882233, 'GlobalBytes', 'Calle Futuro 18', 'info@globalbytes.com', '55571035'),
(128, 77662211, 'DigitalNet', 'Avenida Red 24', 'ventas@digitalnet.com', '55571036'),
(129, 55443366, 'CyberHub', 'Zona Electrónica 1', 'contacto@cyberhub.com', '55571037'),
(130, 11225577, 'BitTech', 'Calle Tech 8', 'ventas@bittech.com', '55571038'),
(131, 88991133, 'NetTech', 'Centro Informático 16', 'info@nettech.com', '55571039'),
(132, 33446677, 'PC Pro', 'Boulevard Desarrollo 22', 'soporte@pcpro.com', '55571040'),
(133, 55669944, 'StoreTech', 'Avenida Comercial 9', 'ventas@storetech.com', '55571041'),
(135, 11224433, 'CompuStore', 'Boulevard Digital 10', 'ventas@compustore.com', '55571043'),
(136, 33227766, 'PC Digital', 'Centro Comercial Electrónico 3', 'soporte@pcdigital.com', '55571044'),
(137, 55669922, 'Bytes Solutions', 'Calle Futuro 7', 'info@bytessolutions.com', '55571045'),
(138, 99883344, 'Tech World', 'Avenida Progreso 11', 'ventas@techworld.com', '55571046'),
(139, 77662233, 'IT Global', 'Zona Comercial Digital 19', 'soporte@itglobal.com', '55571047');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `tipoUsuario` enum('Administrador','Usuario') DEFAULT NULL,
  `fechaCreacion` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `usuario`, `nombre`, `password`, `tipoUsuario`, `fechaCreacion`) VALUES
(1, 'admin', 'Administrador', 'admin321', 'Administrador', '2024-10-08'),
(2, 'luish', 'Luis Hernandez', 'luis123', 'Usuario', '2024-10-08'),
(5, 'sarag12', 'Sara Gonzales', 'sarag987', 'Administrador', '2024-10-11'),
(6, 'carlosH', 'Carlos Herrera', 'carlos123', 'Usuario', '2024-10-11'),
(8, 'usuarioprueba', 'Usuario de Prueba', 'passwordprueba', 'Usuario', '2024-10-11'),
(11, 'usuario2', 'Pedro Gonzales', '56465456456', 'Usuario', '2024-10-13');

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `numeroFactura` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `nombreCliente` varchar(100) NOT NULL,
  `total` float NOT NULL,
  `fechaVenta` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`idVenta`, `numeroFactura`, `idCliente`, `nombreCliente`, `total`, `fechaVenta`) VALUES
(11, 1, 4, 'María López', 2200, '2024-10-13'),
(12, 2, 6, 'Ana Martínez', 3570, '2024-10-13'),
(13, 3, 8, 'Elena Torres', 7000, '2024-10-13'),
(14, 4, 5, 'Juan Gómez', 8500, '2024-10-13'),
(15, 5, 1, 'Juan Pérez', 8500, '2024-10-13'),
(16, 5, 1, 'Juan Pérez', 8500, '2024-10-13'),
(17, 6, 5, 'Juan Gómez', 1020, '2024-10-13'),
(18, 7, 5, 'Juan Gómez', 510, '2024-10-13'),
(19, 8, 15, 'Daniel Vega', 510, '2024-10-13'),
(20, 9, 5, 'Juan Gómez', 510, '2024-10-13'),
(21, 10, 10, 'Sofía Castillo', 360, '2024-10-13'),
(22, 11, 15, 'Daniel Vega', 2910, '2024-10-13'),
(23, 12, 11, 'Fernando Morales', 1200, '2024-10-14'),
(24, 13, 8, 'Elena Torres', 510, '2024-10-14'),
(25, 14, 18, 'Lucía Herrera', 200, '2024-10-14'),
(26, 15, 17, 'Mario Ortega', 300, '2024-10-14'),
(27, 16, 18, 'Lucía Herrera', 60, '2024-10-14'),
(28, 17, 18, 'Lucía Herrera', 200, '2024-10-14'),
(29, 18, 9, 'Jorge Ramírez', 1200, '2024-10-14'),
(30, 19, 18, 'Lucía Herrera', 550, '2024-10-14'),
(31, 20, 20, 'Natalia Vásquez', 80, '2024-10-14'),
(32, 21, 16, 'Isabel Méndez', 370, '2024-10-14'),
(33, 22, 15, 'Daniel Vega', 850, '2024-10-14'),
(34, 23, 5, 'Juan Gómez', 40, '2024-10-14'),
(35, 24, 20, 'Natalia Vásquez', 1360, '2024-10-14'),
(36, 25, 19, 'Diego Castro', 510, '2024-10-14'),
(37, 26, 19, 'Diego Castro', 80, '2024-10-14'),
(38, 27, 19, 'Diego Castro', 90, '2024-10-14'),
(39, 28, 12, 'Laura Fernández', 90, '2024-10-14'),
(40, 29, 17, 'Mario Ortega', 450, '2024-10-14'),
(41, 30, 15, 'Daniel Vega', 120, '2024-10-14'),
(42, 31, 15, 'Daniel Vega', 90, '2024-10-14'),
(43, 32, 20, 'Natalia Vásquez', 150, '2024-10-14'),
(44, 33, 18, 'Lucía Herrera', 250, '2024-10-14'),
(45, 34, 18, 'Lucía Herrera', 1200, '2024-10-14'),
(46, 35, 19, 'Diego Castro', 80, '2024-10-14'),
(47, 36, 18, 'Lucía Herrera', 550, '2024-10-14'),
(48, 37, 13, 'Gabriel Ruiz', 60, '2024-10-14'),
(49, 38, 16, 'Isabel Méndez', 250, '2024-10-14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `dpi` (`dpi`),
  ADD UNIQUE KEY `nit` (`nit`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indexes for table `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=149;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
