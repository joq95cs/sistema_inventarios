-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-01-2025 a las 05:28:00
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_inventarios`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alertas_stock`
--

CREATE TABLE `alertas_stock` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `stock_actual` int(11) NOT NULL,
  `stock_min` int(11) NOT NULL,
  `stock_ideal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacenes`
--

CREATE TABLE `almacenes` (
  `id` int(11) NOT NULL,
  `almacen` varchar(50) NOT NULL DEFAULT '',
  `id_producto_stock` int(11) NOT NULL,
  `costo_promedio` double NOT NULL DEFAULT 0,
  `costo_total` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacenes_observaciones`
--

CREATE TABLE `almacenes_observaciones` (
  `id` int(11) NOT NULL,
  `id_almacen` int(11) NOT NULL,
  `observaciones` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `analisis_financiero`
--

CREATE TABLE `analisis_financiero` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `suma` double NOT NULL DEFAULT 0,
  `mensual` double NOT NULL DEFAULT 0,
  `diario` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_productos`
--

CREATE TABLE `bitacora_productos` (
  `id` int(11) NOT NULL,
  `evento` varchar(50) NOT NULL DEFAULT '',
  `descripcion` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora_usuarios`
--

CREATE TABLE `bitacora_usuarios` (
  `id` int(11) NOT NULL,
  `evento` varchar(50) NOT NULL DEFAULT '',
  `descripcion` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `bitacora_usuarios`
--

INSERT INTO `bitacora_usuarios` (`id`, `evento`, `descripcion`, `fecha_hora`) VALUES
(13, 'INSERCION', 'USUARIO INSERTADO: [id: 5 | username: juana | password: loca | nombre: juanita | apellido_paterno: loquita | apellido_materno: No definido | tipo_usuario: General]', '2024-12-20 01:00:50'),
(14, 'ELIMINACION', 'USUARIO ELIMINADO: [id: 5 | username: juana | password: loca | nombre: juanita | pellido_paterno: loquita | apellido_materno: No definido | tipo_usuario: General]', '2024-12-20 01:01:12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costos`
--

CREATE TABLE `costos` (
  `id` int(11) NOT NULL,
  `id_productos_stock` int(11) NOT NULL,
  `costo_promedio` double NOT NULL DEFAULT 0,
  `costo_total` double NOT NULL DEFAULT 0,
  `id_productos_proveedores` int(11) NOT NULL,
  `id_productos_precios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costos_observaciones`
--

CREATE TABLE `costos_observaciones` (
  `id` int(11) NOT NULL,
  `id_costos` int(11) NOT NULL,
  `observaciones` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas`
--

CREATE TABLE `entradas` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 0,
  `id_usuario` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas_observaciones`
--

CREATE TABLE `entradas_observaciones` (
  `id` int(11) NOT NULL,
  `id_entrada` int(11) NOT NULL,
  `observaciones` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entradas_pedidos`
--

CREATE TABLE `entradas_pedidos` (
  `id` int(11) NOT NULL,
  `id_entrada` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `fecha_pedido` varchar(50) NOT NULL DEFAULT '',
  `fecha_llegada` varchar(50) NOT NULL DEFAULT '',
  `costo_pedido` double NOT NULL DEFAULT 0,
  `id_proveedor_contacto` int(11) NOT NULL,
  `estatus` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos_observaciones`
--

CREATE TABLE `pedidos_observaciones` (
  `id` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `observaciones` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL DEFAULT 'No definido',
  `stock_min` int(11) NOT NULL DEFAULT 0,
  `stock_max` int(11) NOT NULL DEFAULT 0,
  `stock_ideal` int(11) NOT NULL DEFAULT 0,
  `stock_reorden` int(11) NOT NULL DEFAULT 0,
  `stock_max_pedido` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `categoria`, `stock_min`, `stock_max`, `stock_ideal`, `stock_reorden`, `stock_max_pedido`) VALUES
('p02', 'Producto 02', 'c02', 26, 94, 2, 84, 30),
('p03', 'Producto 03', 'c03', 48, 27, 60, 99, 95),
('p04', 'Producto 04', 'c04', 77, 96, 24, 62, 51),
('p05', 'Producto 05', 'c05', 8, 26, 13, 33, 58),
('p06', 'Gelatinas', 'c06', 83, 62, 84, 75, 64),
('p07', 'Producto 07', 'c07', 80, 3, 67, 14, 33),
('p08', 'Producto 08', 'c08', 79, 10, 5, 11, 0),
('p09', 'galletitas', 'c09', 71, 12, 59, 34, 24),
('p11', 'Producto 11', 'c11', 23, 60, 58, 21, 10),
('p12', 'camijshdhd', 'c12', 54, 44, 54, 63, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_observaciones`
--

CREATE TABLE `productos_observaciones` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `observaciones` text NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_pedidos`
--

CREATE TABLE `productos_pedidos` (
  `id` int(11) NOT NULL,
  `id_producto_stock` int(11) NOT NULL,
  `unidades_pedidas` int(11) NOT NULL DEFAULT 0,
  `kilos_pedidos` double NOT NULL DEFAULT 0,
  `costo_unitario` double NOT NULL DEFAULT 0,
  `costo_total` double NOT NULL DEFAULT 0,
  `id_pedido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_precios`
--

CREATE TABLE `productos_precios` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `precio_venta` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_proveedores`
--

CREATE TABLE `productos_proveedores` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `precio_compra` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos_stock`
--

CREATE TABLE `productos_stock` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `stock_actual` int(11) NOT NULL DEFAULT 0,
  `stock_estado` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `direccion` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores_contactos`
--

CREATE TABLE `proveedores_contactos` (
  `id` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `tipo_contacto` varchar(50) NOT NULL DEFAULT '',
  `contacto` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores_observaciones`
--

CREATE TABLE `proveedores_observaciones` (
  `id` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `observaciones` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas`
--

CREATE TABLE `salidas` (
  `id` int(11) NOT NULL,
  `id_producto` varchar(50) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 0,
  `id_usuario` int(11) NOT NULL,
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salidas_observaciones`
--

CREATE TABLE `salidas_observaciones` (
  `id` int(11) NOT NULL,
  `id_salida` int(11) NOT NULL,
  `observaciones` text NOT NULL DEFAULT '',
  `fecha_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(64) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL DEFAULT 'No definido',
  `tipo_usuario` varchar(50) NOT NULL DEFAULT 'General'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `nombre`, `apellido_paterno`, `apellido_materno`, `tipo_usuario`) VALUES
(4, 'Joqsan', 'b7060f0ada34701e6b39b0ca817d1b48ff98b1fc5204137274246f29d5a18a54', 'Joqsan Adalid', 'Castellanos', 'Alicea', 'Admin'),
(7, 'joq', '123', 'Adalid', 'Castellanos', 'No definido', 'General'),
(8, 'juana', 'loca', 'juanita', 'loquita', 'No definido', 'General');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_contactos`
--

CREATE TABLE `usuarios_contactos` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL DEFAULT 0,
  `tipo_contacto` varchar(50) NOT NULL DEFAULT '',
  `contacto` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alertas_stock`
--
ALTER TABLE `alertas_stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_alertas_stock` (`nombre`),
  ADD KEY `fk2_alertas_stock` (`stock_actual`),
  ADD KEY `fk4_alertas_stock` (`stock_min`),
  ADD KEY `fk3_alertas_stock` (`stock_ideal`);

--
-- Indices de la tabla `almacenes`
--
ALTER TABLE `almacenes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_almacen` (`id_producto_stock`);

--
-- Indices de la tabla `almacenes_observaciones`
--
ALTER TABLE `almacenes_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_almacen_observaciones` (`id_almacen`);

--
-- Indices de la tabla `analisis_financiero`
--
ALTER TABLE `analisis_financiero`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_analisis_financiero` (`id_producto`);

--
-- Indices de la tabla `bitacora_productos`
--
ALTER TABLE `bitacora_productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `bitacora_usuarios`
--
ALTER TABLE `bitacora_usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `costos`
--
ALTER TABLE `costos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_costos` (`id_productos_stock`),
  ADD KEY `fk2_costos` (`id_productos_proveedores`),
  ADD KEY `fk3_costos` (`id_productos_precios`);

--
-- Indices de la tabla `costos_observaciones`
--
ALTER TABLE `costos_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_costos_observaciones` (`id_costos`);

--
-- Indices de la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_entradas` (`id_producto`),
  ADD KEY `fk2_entradas` (`id_usuario`);

--
-- Indices de la tabla `entradas_observaciones`
--
ALTER TABLE `entradas_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_entradas_observaciones` (`id_entrada`);

--
-- Indices de la tabla `entradas_pedidos`
--
ALTER TABLE `entradas_pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_entradas_pedidos` (`id_entrada`),
  ADD KEY `fk2_entradas_pedidos` (`id_pedido`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_pedidos` (`id_proveedor_contacto`);

--
-- Indices de la tabla `pedidos_observaciones`
--
ALTER TABLE `pedidos_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_pedidos_observaciones` (`id_pedido`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_nombre` (`nombre`) USING BTREE,
  ADD KEY `key_stock_min` (`stock_min`) USING BTREE,
  ADD KEY `key_nombre` (`nombre`),
  ADD KEY `key_stock_ideal` (`stock_ideal`);

--
-- Indices de la tabla `productos_observaciones`
--
ALTER TABLE `productos_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_productos_pedidos` (`id_producto_stock`),
  ADD KEY `fk2_productos_pedidos` (`id_pedido`);

--
-- Indices de la tabla `productos_precios`
--
ALTER TABLE `productos_precios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_productos_precios` (`id_producto`);

--
-- Indices de la tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_productos_proveedores` (`id_producto`),
  ADD KEY `fk2_productos_proveedores` (`id_proveedor`);

--
-- Indices de la tabla `productos_stock`
--
ALTER TABLE `productos_stock`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_productos_stock` (`id_producto`),
  ADD KEY `key_stock_actual` (`stock_actual`) USING BTREE;

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores_contactos`
--
ALTER TABLE `proveedores_contactos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_proveedores_contacto` (`id_proveedor`);

--
-- Indices de la tabla `proveedores_observaciones`
--
ALTER TABLE `proveedores_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_proveedores_observaciones` (`id_proveedor`);

--
-- Indices de la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_salidas` (`id_producto`),
  ADD KEY `fk2_salidas` (`id_usuario`);

--
-- Indices de la tabla `salidas_observaciones`
--
ALTER TABLE `salidas_observaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_salida` (`id_salida`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_username` (`username`) USING BTREE,
  ADD UNIQUE KEY `unique_password` (`password`) USING BTREE;

--
-- Indices de la tabla `usuarios_contactos`
--
ALTER TABLE `usuarios_contactos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk1_usuarios_contacto` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alertas_stock`
--
ALTER TABLE `alertas_stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `almacenes`
--
ALTER TABLE `almacenes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `almacenes_observaciones`
--
ALTER TABLE `almacenes_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `analisis_financiero`
--
ALTER TABLE `analisis_financiero`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `bitacora_productos`
--
ALTER TABLE `bitacora_productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `bitacora_usuarios`
--
ALTER TABLE `bitacora_usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `costos`
--
ALTER TABLE `costos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `costos_observaciones`
--
ALTER TABLE `costos_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entradas`
--
ALTER TABLE `entradas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entradas_observaciones`
--
ALTER TABLE `entradas_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entradas_pedidos`
--
ALTER TABLE `entradas_pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pedidos_observaciones`
--
ALTER TABLE `pedidos_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos_observaciones`
--
ALTER TABLE `productos_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos_precios`
--
ALTER TABLE `productos_precios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos_stock`
--
ALTER TABLE `productos_stock`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores_contactos`
--
ALTER TABLE `proveedores_contactos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedores_observaciones`
--
ALTER TABLE `proveedores_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `salidas`
--
ALTER TABLE `salidas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `salidas_observaciones`
--
ALTER TABLE `salidas_observaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuarios_contactos`
--
ALTER TABLE `usuarios_contactos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alertas_stock`
--
ALTER TABLE `alertas_stock`
  ADD CONSTRAINT `fk1_alertas_stock` FOREIGN KEY (`nombre`) REFERENCES `productos` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_alertas_stock` FOREIGN KEY (`stock_actual`) REFERENCES `productos_stock` (`stock_actual`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk3_alertas_stock` FOREIGN KEY (`stock_ideal`) REFERENCES `productos` (`stock_ideal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk4_alertas_stock` FOREIGN KEY (`stock_min`) REFERENCES `productos` (`stock_min`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `almacenes`
--
ALTER TABLE `almacenes`
  ADD CONSTRAINT `fk1_almacen` FOREIGN KEY (`id_producto_stock`) REFERENCES `productos_stock` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `almacenes_observaciones`
--
ALTER TABLE `almacenes_observaciones`
  ADD CONSTRAINT `fk1_almacen_observaciones` FOREIGN KEY (`id_almacen`) REFERENCES `almacenes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `analisis_financiero`
--
ALTER TABLE `analisis_financiero`
  ADD CONSTRAINT `fk1_analisis_financiero` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `costos`
--
ALTER TABLE `costos`
  ADD CONSTRAINT `fk1_costos` FOREIGN KEY (`id_productos_stock`) REFERENCES `productos_stock` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_costos` FOREIGN KEY (`id_productos_proveedores`) REFERENCES `productos_proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk3_costos` FOREIGN KEY (`id_productos_precios`) REFERENCES `productos_precios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `costos_observaciones`
--
ALTER TABLE `costos_observaciones`
  ADD CONSTRAINT `fk1_costos_observaciones` FOREIGN KEY (`id_costos`) REFERENCES `costos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `entradas`
--
ALTER TABLE `entradas`
  ADD CONSTRAINT `fk1_entradas` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_entradas` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `entradas_observaciones`
--
ALTER TABLE `entradas_observaciones`
  ADD CONSTRAINT `fk1_entradas_observaciones` FOREIGN KEY (`id_entrada`) REFERENCES `entradas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `entradas_pedidos`
--
ALTER TABLE `entradas_pedidos`
  ADD CONSTRAINT `fk1_entradas_pedidos` FOREIGN KEY (`id_entrada`) REFERENCES `entradas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_entradas_pedidos` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `fk1_pedidos` FOREIGN KEY (`id_proveedor_contacto`) REFERENCES `proveedores_contactos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos_observaciones`
--
ALTER TABLE `pedidos_observaciones`
  ADD CONSTRAINT `fk1_pedidos_observaciones` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_observaciones`
--
ALTER TABLE `productos_observaciones`
  ADD CONSTRAINT `fk1_productos_observaciones` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_pedidos`
--
ALTER TABLE `productos_pedidos`
  ADD CONSTRAINT `fk1_productos_pedidos` FOREIGN KEY (`id_producto_stock`) REFERENCES `productos_stock` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_productos_pedidos` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_precios`
--
ALTER TABLE `productos_precios`
  ADD CONSTRAINT `fk1_productos_precios` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_proveedores`
--
ALTER TABLE `productos_proveedores`
  ADD CONSTRAINT `fk1_productos_proveedores` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_productos_proveedores` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos_stock`
--
ALTER TABLE `productos_stock`
  ADD CONSTRAINT `fk1_productos_stock` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proveedores_contactos`
--
ALTER TABLE `proveedores_contactos`
  ADD CONSTRAINT `fk1_proveedores_contacto` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proveedores_observaciones`
--
ALTER TABLE `proveedores_observaciones`
  ADD CONSTRAINT `fk1_proveedores_observaciones` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `salidas`
--
ALTER TABLE `salidas`
  ADD CONSTRAINT `fk1_salidas` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2_salidas` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `salidas_observaciones`
--
ALTER TABLE `salidas_observaciones`
  ADD CONSTRAINT `fk1_salida` FOREIGN KEY (`id_salida`) REFERENCES `salidas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios_contactos`
--
ALTER TABLE `usuarios_contactos`
  ADD CONSTRAINT `fk1_usuarios_contacto` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
