-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2023 pada 18.14
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbmobil`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbdata`
--

CREATE TABLE `tbdata` (
  `idMobil` int(11) NOT NULL,
  `namaMobil` varchar(100) NOT NULL,
  `merkMobil` varchar(100) NOT NULL,
  `hargaMobil` int(11) NOT NULL,
  `jenisTransmisit` int(11) NOT NULL,
  `tenagaListrik` int(11) NOT NULL,
  `kapasitas` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbdata`
--

INSERT INTO `tbdata` (`idMobil`, `namaMobil`, `merkMobil`, `hargaMobil`, `jenisTransmisit`, `tenagaListrik`, `kapasitas`) VALUES
(1, 'new', 'Toyota', 1, 4, 1200, 8),
(2, '2', 'BMW', 2, 2, 2, 6),
(3, '3', 'Honda', 3, 3, 3, 7),
(4, '4', 'Hyundai', 4, 4, 4, 8),
(5, '5', 'Toyota', 5, 1, 5, 5),
(6, '6', 'BMW', 6, 2, 6, 6);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbuser`
--

CREATE TABLE `tbuser` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbuser`
--

INSERT INTO `tbuser` (`username`, `password`) VALUES
('1', '1'),
('2', '2'),
('3', '3');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbdata`
--
ALTER TABLE `tbdata`
  ADD PRIMARY KEY (`idMobil`);

--
-- Indeks untuk tabel `tbuser`
--
ALTER TABLE `tbuser`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbdata`
--
ALTER TABLE `tbdata`
  MODIFY `idMobil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
