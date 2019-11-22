<?php
class ConexionMysql{


function conectar(){
 $servername = 'localhost';
 $username 	= 'root';
 $password 	= 'inacap.2019';
 $dbname     = 'rentacar';
    $obj_mysql=@new mysqli ($this->$servername,$this->$username,$this->$password,$this->$dbname); 

        if ($obj_mysql->connect_error) {
            die("Error en la conexión :" . $objetoMySQLi->connect_error);
        } 
}
}
?>