<?php
include 'conexion.php';

$conexionBD = new conexion();
$conexionBD->conectar();  

$idUsuario = $_POST['idusu'];

$sql = "DELETE FROM usuario WHERE idUsuario=$idUsuario";

$datos=$conexionBD->datos($sql);

?>