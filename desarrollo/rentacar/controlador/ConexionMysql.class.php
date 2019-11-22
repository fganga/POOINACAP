<?php
class ConexionMysql{
    

function conectar(){
    $servername = "localhost";
$username 	= "root";
$password 	= "inacap.2019";
$dbname     = "rentacar";
    $obj_mysql=@new mysqli ($servername,$username,$password,$dbname); 

        if ($obj_mysql->connect_error) {
            die("Error en la conexión :" . $objetoMySQLi->connect_error);
        } 
 return $obj_mysql;
}
}
?>