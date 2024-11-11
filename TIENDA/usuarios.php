<?php 
session_start();
include 'conexion.php';

$conexionBD = new conexion();
$conexionBD->conectar();

?>

<?php  
  
  include 'header.php';
  include 'sidebarmenu.php';
  ?>
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Registro Usuarios</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
       
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <div class="col-md-3">
            
          </div>
          <div class="col-md-6">

          <?php
/*datos enviados desde formulario para registro*/
          if ($_SERVER["REQUEST_METHOD"] == "POST") {

                // Obtenemos los valores enviados por el formulario
                $idUsuario = $_POST['idUsuario '];
                $usuario = $_POST['usuario'];
                $password = $_POST['password'];
                $nombre = $_POST['nombre'];
                $apellidoPat = $_POST['apellidoPat'];
                $apellidoMat = $_POST['apellidoMat']; 
                $direccion = $_POST['direccion'];
                $celular= $_POST['celular'];
                

                $sql = "INSERT INTO usuario (idUsuario, usuario, password, nombre, apellidoPat, apellidoMat, direccion, celular, estado) 
                VALUES (NULL, '$usuario', '$password', '$nombre', '$apellidoPat', '$apellidoMat', '$direccion', '$celular', 'activo')";
                $conexionBD->datos($sql);

                ?>  
                <div class="success alert-success">
                <strong>Mensaje!</strong> El usuario se registro de manera exitosa
                </div>

                <?php

                }

                ?>


            <!-- <h1>Registro</h1> -->
            <form action="usuarios.php" method="post">
                <div class="form-group">
                    <label for="">Nombre</label>
                    <input type="text"
                    class="form-control" name="nombre" id="nombre" aria-describedby="helpId" placeholder="Nombre Usuario">
                    
                </div>
                <div class="row">   
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Apellido Paterno</label>
                            <input type="text"
                                class="form-control" name="apellidoPat" id="apellidoPat" aria-describedby="helpId" placeholder="Apellido Paterno">
                            
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="">Apellido Materno</label>
                            <input type="text"
                                class="form-control" name="apellidoMat" id="apellidoMat" aria-describedby="helpId" placeholder="Apellido Materno">
                            
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                        <label for="usuario">Usuario</label>
                        <input type="text"
                            class="form-control" name="usuario" id="usuario" aria-describedby="helpId" placeholder="usuario">
                        </div>
                    </div>
                    
                    <div class="col-md-6">
                        <div class="form-group">
                        <label for="">Password</label>
                        <input type="password"
                            class="form-control" name="password" id="password" aria-describedby="helpId" placeholder="password">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                        <label for="usuario">Direccion</label>
                        <input type="text"
                            class="form-control" name="direccion" id="direccion" aria-describedby="helpId" placeholder="direccion">
                        </div>
                    </div>
                    
                    <div class="col-md-6">
                        <div class="form-group">
                        <label for="">Celular</label>
                        <input type="text"
                            class="form-control" name="celular" id="celular" aria-describedby="helpId" placeholder="celular">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                          <label for="">Rol</label>
                          <select class="form-control" name="rol" id="rol">
                            <option value="administrador">Administrador</option>
                            <option value="paciente">Cliente</option>
                            <option></option>
                          </select>
                        </div>
                    </div>
                   
                </div>
              
              <button type="submit" class="btn btn-primary col-12">Registrar</button>

            </form>

          </div>
          <div class="col-md-3">
            
          </div>
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  

  <?php  
  include 'footer.php';
  ?>