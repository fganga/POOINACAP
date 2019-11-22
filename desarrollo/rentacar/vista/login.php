<?php
ini_set("display_errors",1);
$var_usuario=$_POST["txt_usuario"];
$var_clave = $_POST["txt_clave"];
include("../controlador/LoginController.php");
$obj_login = new LoginController();
$obj_login->login($var_usuario,$var_clave);

?>