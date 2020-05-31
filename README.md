# Consumo de Servicios web con Volley, esta creado en Java pero se puede implementar facilmente en Kotlin
Este es un ejemplo para consumir servicios RESTful, tambien te permite hacer la deserialización de un Json
y pasarlo facilmente a una clase o arreglo.

El servicio de ejemplo ya no esta disponible pero se puede tomar cualquier otro servicio web.

Para este ejemplo se monto un servicio php el cual regresa números.

<?php 	
	class Rest {
		public function response(){
			$method = $_SERVER['REQUEST_METHOD'];
			$numero = 0;
			$codMessage = 100;
			if ($method == 'POST') {
				$j = json_decode(file_get_contents("php://input"));
				$numero =  $j->{"Num"};
			} elseif ($method == 'GET') {
				$numero = $_GET["Num"];
			} else {
				$codMessage = 200;
			}
			
			if (is_numeric($numero)) {
				$message = "Tu numero es de ".strlen($numero)." digito(s)";
			} else {
				$message = "No enviaste numeros";
			}
			
			$Json=array( "Mensaje"=>$message, "CodMensaje"=>$codMessage,"Metodo"=>$method);
			echo json_encode($Json);
		}
		
	}

	$api = new Rest;
	$api->response();
?>

