<?php 

session_start();
include 'conexion.php';

$conexionBD = new conexion();
$conexionBD->conectar();

/**************/

if ($_SERVER["REQUEST_METHOD"] == "POST") {

  // Obtenemos los valores enviados por el formulario
  $usuario = $_POST['usuario'];
  $password = $_POST['password'];

  $sql = "select idUsuario,usuario,password,nombre,apellidoPat from usuario where usuario='$usuario' and password='$password'";
  $resultado = $conexionBD->datos($sql);

  $fila = mysqli_fetch_assoc($resultado);
   
  

  

 if($resultado->num_rows>0){
  echo $_SESSION['nombre'] = $fila['nombre'];
  echo $_SESSION['apellidoPat'] = $fila['apellidoPat'];
  /*datos de usuario*/
  $fila = mysqli_fetch_assoc($resultado); //array asociativo
  /*$idUsuario = $fila['idUsuario'];
  $nombre = $fila['nombre'];
  $apellidoPat = $fila['apellidoPat'];*/
      header("Location: principal.php"); // Ejemplo de redirección
      exit(); //salir flujo
  } else {

  ?>  
    <div class="alert alert-warning">
    <strong>Advertencia!</strong> El usuario o password que ingreso no es el correcto
    </div>

<?php
  }
}

?>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Log in</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="assets/plugins/fontawesome-free/css/all.min.css">
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="assets/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/dist/css/adminlte.min.css">
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>Sistema</b> Medico</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      

      <form action="login.php" method="post">
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="usuario" placeholder="Usuario" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="password" placeholder="Contraseña" required>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          
          <!-- /.col -->
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">Ingresar</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

      
      
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="assets/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="assets/dist/js/adminlte.min.js"></script>
</body>
</html>
