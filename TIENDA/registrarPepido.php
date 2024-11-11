<?php
include 'conexion.php';

$conexionBD = new conexion();
$conexionBD->conectar(); 

$nombre_producto = $_POST['nombre_producto'];
$id_usuario = $_POST['id_usuario'];

// Preparar la consulta para insertar un nuevo pedido
$sentencia = $conexionBD->conexion->prepare("INSERT INTO pedido (nombreProducto, idusuario) VALUES (?, ?)");
$sentencia->bind_param('si', $nombre_producto, $id_usuario); // 'si' indica que el primer parámetro es un string y el segundo es un integer

if ($sentencia->execute()) {
    echo json_encode(["success" => true, "message" => "Pedido registrado exitosamente"]);
} else {
    echo json_encode(["success" => false, "message" => "Error al registrar el pedido"]);
}

$conexionBD->conexion->close();
?>
