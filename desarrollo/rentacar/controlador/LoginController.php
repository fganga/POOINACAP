<?php 

class LoginController  {
    
   function conectarBD(){
    include_once '../datos/ConectorBD.class.php';
    $conectorBD= new ConectorBD();
    $conexionBD = $conectorBD->abrirConexion();
    return $conexionBD;
  
   }
 
  function login($usuario,$clave){
      //Verificamos usuario y clave
      echo $existe = $this->verificarUsuarioClave($usuario,$clave);
      if($existe==1){
        header("Location:inicio.php");
      }else{
        header("Location:index.php");
      }
    }
  function verificarUsuarioClave($usuario,$clave){

        
        try
        {
            $conexionBD = $this->conectarBD();
           
            $sql = "SELECT 1  as cantidad from Usuario where username='$usuario' and password='$clave'" ;
            $ejecucion=$conexionBD->query($sql);
            $resultado = $ejecucion -> rowCount();
            return $resultado;
            
        }
        catch (PDOException $e)
        {
            echo "Error" . $e->getMessage();

          }
  }
  function obtenerUsuarios(){
    include_once '../modelo/Usuario.class.php';
    $listaUsuarios = [];  
    try
    {
        $conexionBD = $this->conectarBD();
       
        $sql = "SELECT * from Usuario" ;
        $ejecucion=$conexionBD->query($sql);
        $usuarios = $ejecucion -> fetchAll();
        foreach ($usuarios as $usuario) {
          $listaUsuarios[] = new Usuario($row);
      }
        
    }
    catch (PDOException $e)
    {
        echo "Error" . $e->getMessage();

      }
}
}

?>