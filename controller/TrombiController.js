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

    $scope.reset = function(user) {
		People.reset();
		user.name = "";
		user.firstname="";
    }

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
				$http.get(url)
					.success(function(data, status, headers, config) {
						var length = data.length;
						for(var i=0; i<length; i++) {
							People.add(data[i]);
						}
					})
					.error(function(data, status, headers, config) {
						console.log("Error" + status);
				  });
				$location.path("/data");
			}
		} else {
			//Do stuff to handle errors
			console.log("Oui faut des données quand même...");
		
		}
    }

    $scope.checkUrl = function(url) {
       return $http.head(url)
    		.success(function(data, status, headers, config) {		
				return  true;
    		})
    		.error(function(data, status, headers, config) {
				return false;
		 });
    }

    $scope.updateSelect = function() {
     		var url = " https://webapplis.utc.fr/Trombi_ws/mytrombi/structfils?lid=" + $scope.item;			
    		if($scope.checkUrl(url)) {
				SubStruct.reset();
				$http.get(url)
					.success(function(data, status, headers, config) {
						var length = data.length;
						var nbVal = 0
						for(var i=0; i<length; i++) {
							SubStruct.add(data[i]);
						}
					})
					.error(function(data, status, headers, config) {
						console.log("Error " + status);
				  });
		
				$scope.dataSsStruct = SubStruct;	
			}
    }

    $scope.getData = function() {
		
		if($scope.subData == null || $scope.subData == 0 ) {
			var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/resultstruct?pere=" + $scope.item + "&fils=0";
		} else {
			var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/resultstruct?pere=" + $scope.item + "&fils=" + $scope.subData;
		}
		
		
    	People.reset();
    	if($scope.checkUrl(url)) {
			$http.get(url)
					.success(function(data, status, headers, config) {
						var length = data.length;
						console.log(data);
						for(var i=0; i<length; i++) {
							People.add(data[i]);
						}
					})
					.error(function(data, status, headers, config) {
						console.log("Error" + status);
				  });
			$location.path("/data");
		}
    }

    $scope.init = function() {
    	// Initialisation du select des structures
    		var url = "https://webapplis.utc.fr/Trombi_ws/mytrombi/structpere";
    		$scope.checkUrl(url);
			$http.get(url)
				.success(function(data, status, headers, config) {
					var length = data.length;
					for(var i=0; i<length; i++) {
						Struct.add(data[i]);
					}
				})
				.error(function(data, status, headers, config) {
					console.log("Error" + status);
			  });
			$scope.dataStruct = Struct;

    }


    $scope.init();
}]);
	
