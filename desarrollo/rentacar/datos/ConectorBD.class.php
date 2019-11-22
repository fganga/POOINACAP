<?php 
Class ConectorBD {

    private  $server = "mysql:host=localhost;dbname=rentacar";
    
    private  $user = "root";
    
    private  $pass = "inacap.2019";
    
    private $options  = array(PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,);
    
    protected $con;
     
                  public function abrirConexion()
    
                   {
    
                   try
    
                     {
    
                $this->con = new PDO($this->server, $this->user,$this->pass,$this->options);
    
                return $this->con;
    
                      }
    
                   catch (PDOException $e)
    
                     {
    
                         echo "Problemas con la conexión " . $e->getMessage();
    
                     }
    
                   }
    
    public function closeConnection() {
    
           $this->con = null;
    
    }
    
}

?>