<?php
// Archivo: listaUsuarios.php

include 'conexion.php';

$conexionBD = new conexion();
$conexionBD->conectar();

$sql = "SELECT * FROM producto WHERE categoria = 'componentes';";
$resultado = $conexionBD->datos($sql);

$usuarios = array();

if ($resultado->num_rows > 0) {
    while ($fila = $resultado->fetch_assoc()) {
        $usuarios[] = $fila; // Añadir cada usuario al array
    }
    echo json_encode($usuarios, JSON_UNESCAPED_UNICODE);
} else {
    echo json_encode([]);
}
echo $usuarios[0];

$conexionBD->cerrarConexion();
?>
