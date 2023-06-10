-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-06-2023 a las 08:41:38
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crud_corte3`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `nombre` varchar(200) NOT NULL,
  `cedula` int(200) NOT NULL,
  `clave` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`nombre`, `cedula`, `clave`) VALUES
('diego rodirguez', 1234567890, '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE `eventos` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre_evento` varchar(200) NOT NULL,
  `fecha_evento` varchar(200) NOT NULL,
  `duracion` varchar(200) NOT NULL,
  `valor` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`id`, `nombre_evento`, `fecha_evento`, `duracion`, `valor`) VALUES
(6, 'paseo a la mesa', '2023-06-12', '1 dia', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

CREATE TABLE `noticias` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `noticia` varchar(200) NOT NULL,
  `fecha_noticia` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`id`, `noticia`, `fecha_noticia`) VALUES
(7, 'calzones en el balcon', '2023-06-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `residentes`
--

CREATE TABLE `residentes` (
  `nombre` varchar(200) NOT NULL,
  `cedula` int(200) NOT NULL,
  `correo` varchar(200) NOT NULL,
  `clave` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `residentes`
--

INSERT INTO `residentes` (`nombre`, `cedula`, `correo`, `clave`) VALUES
('fernando alvarez', 12346675, 'asasas@gmail.com', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saloncomunal`
--

CREATE TABLE `saloncomunal` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `reservacion` varchar(200) NOT NULL,
  `fecha_reservacion` varchar(200) NOT NULL,
  `hora_reservacion` varchar(200) NOT NULL,
  `id_residente` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `saloncomunal`
--

INSERT INTO `saloncomunal` (`id`, `reservacion`, `fecha_reservacion`, `hora_reservacion`, `id_residente`) VALUES
(1, 'fiesta de cumpleaños', '10-06-2022', '05:00', 12346675);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `cedula` int(200) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `cargo` varchar(200) NOT NULL,
  `empresa` varchar(200) NOT NULL,
  `clave` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`cedula`, `nombre`, `cargo`, `empresa`, `clave`) VALUES
(2233445, 'omar duarte', 'vigilante', 'vigilantes la guardia', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `noticias`
--
ALTER TABLE `noticias`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indices de la tabla `residentes`
--
ALTER TABLE `residentes`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `saloncomunal`
--
ALTER TABLE `saloncomunal`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `id_residente` (`id_residente`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `eventos`
--
ALTER TABLE `eventos`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `noticias`
--
ALTER TABLE `noticias`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `saloncomunal`
--
ALTER TABLE `saloncomunal`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `saloncomunal`
--
ALTER TABLE `saloncomunal`
  ADD CONSTRAINT `saloncomunal_ibfk_1` FOREIGN KEY (`id_residente`) REFERENCES `residentes` (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
