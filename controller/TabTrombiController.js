var trombiApp = angular.module('trombiApp');

trombiApp.controller('TabTrombiController', ['$scope',  'People', '$filter', '$mdDialog', function($scope, People, $filter, $mdDialog) {
	
	// Variable qui contiendra les données du modèle sur les personnes
	$scope.peopleData = [];
	
	// Variables de pagination
	$scope.currentPage = 0;
    $scope.pageSize = 9;
    $scope.filtre = '';

	
	// Retourne les données qui correspondent à la chaine donnée en filtre
    $scope.getData = function () {
       // https://docs.angularjs.org/api/ng/filter/filter
       return $filter('filter')($scope.peopleData, $scope.filtre);
    }

	// Calcul du nombre de page
     $scope.numberOfPages = function(){
        return Math.ceil($scope.getData().length/$scope.pageSize);                
    }

	// Mise à jour du nombre d'éléments à afficher 
    $scope.dropboxitemselected = function( number) {
      $scope.pageSize = number;
    }
	
	// Fonction qui initialise les données du trombinoscope
	$scope.init = function() {
		$scope.peopleData = People;
	};

	
	// Fenêtre ouverte avec des informations supplémentaires
	$scope.showDialog = function($person) {
		var parentEl = angular.element(document.body);
		console.log($person);
		$mdDialog.show({
		 clickOutsideToClose: true,
         template:
				'  <div class="modal-dialog">'
				+' <div class="modal-content">'
				+ '	 <div class="modal-body">'
				+ '<img src="https://demeter.utc.fr/portal/pls/portal30/portal30.get_photo_utilisateur_mini?username={{personne.login}}" onerror="this.src=\'resources/img/defaultImg.jpg\'"> </img>'
				+ '	<ul class="list-unstyled">'
				+ '	<li id="Name"> {{personne.nom}} </li>'
				+ '	<li id="Login"> Login :  {{personne.login}} </li>'
				+ '	<li id="Mail"> Email :  {{personne.mail}} </li>'
				+ '	<li><div id="Bureau"> Bureau :  {{personne.bureau}} <b ng-if="!personne.bureau">NA</b> </div></li>'
				+ '	<li><div id="SsStructure"> Sous-Structure	 : {{ personne.sousStructure}} <b ng-if="!personne.sousStructure">NA</b> </div> </li>'
				+ '	<li><div id="Structure"> Structure : {{ personne.structure}} <b ng-if="!personne.structure">NA</b> </div> </li>'
				+ '	<li><div id="Telephone"> Tél  : {{ personne.tel}} <b ng-if="!personne.tel">NA</b> </div> </li>'
				+ '	<li><div id="Telephone2"> Tél 2 : {{ personne.tel2}} <b ng-if="!personne.tel2">NA</b> </div> </li>'
				+ '	</ul></div></div></div></div>',
		controller: function($scope, $mdDialog, personne){
		   $scope.personne = personne;
		},
         locals: {
           personne: $person
         }});
	}
	
	
}]);


trombiApp.filter('startFrom', function() {
    return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
    }
});