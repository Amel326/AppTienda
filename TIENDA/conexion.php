<?php  

class conexion{


    private $servername="localhost";
    private $user="root";
    private $password="root";
    private $bd="conexion";

    public $conexion;

    //abrir el flujo de la conexion
    public function conectar(){
        $this->conexion = new mysqli($this->servername, $this->user, $this->password, $this->bd);
        /*if ($this->conexion->connect_error) {
            die("Error de conexión: " . $this->conexion->connect_error);
        }else{
            echo "Conexion exitosa";
        }*/

    }

    public function datos($sql){
        return $this->conexion->query($sql);

    }
    // Método para cerrar la conexión a la base de datos
    public function cerrarConexion() {
        
            $this->conexion->close();
        
    }




}


?>