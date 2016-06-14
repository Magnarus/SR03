var trombiApp = angular.module('trombiApp');

trombiApp.controller('TrombiController', ['$scope', '$http', 'People', 'Struct', 'SubStruct', '$location',
 function($scope, $http, People, Struct,SubStruct,  $location) {

    // Données récupérées via API REST
    $scope.peopleData = {};
    $scope.dataStruct = {};
    $scope.dataSsStruct = {};

    // Selected item
    $scope.item;
    $scope.subData;
	
	// Reinitialise les champs et les données utilisateurs
    $scope.reset = function(user) {
		People.reset();
		user.name = "";
		user.firstname="";
    }

	// Valide les input et récupère les données
    $scope.validate = function(user) {
    	People.reset();
		var firstName = "";
		var lastName="";
		if(user.hasOwnProperty("name") || user.hasOwnProperty("firstname")) {
			//Au moins un des champs est rempli
			if(user.hasOwnProperty("name") && user.name.length != 0) {
				lastName = user.name;
			}
			if(user.hasOwnProperty("firstname") && user.firstname.length != 0) {
				firstName = user.firstname;
			}
		
			// URL pour récupérer les données
			var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/result?nom=" + lastName + "&prenom=" + firstName;
			//On vérifie que l'url est OK
			if($scope.checkUrl(url)) {
				People.getData(url);				
				$location.path("/data");
			}
		} else {
			//Do stuff to handle errors
			console.log("Oui faut des données quand même...");
		
		}
    }

	// Vérifie la dispo d'une API donc l'url est donnée en paramètre
    $scope.checkUrl = function(url) {	

       return $http.head(url)
    		.success(function(data, status, headers, config) {		
				return  true;
    		})
    		.error(function(data, status, headers, config) {
				return false;
		 });
    }

	// Met à jour les données de sous-structure en fonction de la strucute sélectionnée par l'utilisateur
    $scope.updateSelect = function() {
     		var url = " https://webapplis.utc.fr/Trombi_ws/mytrombi/structfils?lid=" + $scope.item;			
    		if($scope.checkUrl(url)) {
				SubStruct.reset();
				SubStruct.getData(url);
				$scope.dataSsStruct = SubStruct;	
			}
    }
	
	// Récupère les données des utilisateurs par structure
    $scope.getData = function() {
		
		if($scope.subData == null || $scope.subData == 0 ) {
			var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/resultstruct?pere=" + $scope.item + "&fils=0";
		} else {
			var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/resultstruct?pere=" + $scope.item + "&fils=" + $scope.subData;
		}	
    	People.reset();
    	if($scope.checkUrl(url)) {
			People.getData(url); // Charge le modèle
			$location.path("/data");
		}
    }

	// Fonction initiale
    $scope.init = function() {
			// Initialisation du select des structures
    		var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/structpere";
    		if($scope.checkUrl(url)) {
				Struct.getData(url);
				$scope.dataStruct = Struct;
			} else {
				console.log("Error! Data could not be loaded, check CORS");
			}
			
    }


    $scope.init();
}]);