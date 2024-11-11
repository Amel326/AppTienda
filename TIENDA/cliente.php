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
            <h1 class="m-0">Registro Cliente</h1>
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
            <!-- <h1>Registro </h1> -->
            <form action="" method="post">
              <div class="form-group">
                <label for="">Nombre</label>
                <input type="text"
                  class="form-control" name="nombre" id="nombre" aria-describedby="helpId" placeholder="Nombre">
                
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
                  <label for="">Usuario</label>
                  <input type="text"
                    class="form-control" name="usuario" id="usuario" aria-describedby="helpId" placeholder="Usuario">
                  
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                  <label for="">Password</label>
                  <input type="text"
                    class="form-control" name="password" id="password" aria-describedby="helpId" placeholder="Password">
                  
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

            

              <button type="submit" class="btn btn-primary">Registrar</button>

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