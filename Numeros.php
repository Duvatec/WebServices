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

