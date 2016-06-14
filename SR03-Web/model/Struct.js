 var trombiApp = angular.module('trombiApp');
trombiApp.factory('Struct',[ '$http', function ($http){
    var Struct = [];
	
    Struct.add = function (item) {
        Struct.push(item);
    };

	Struct.reset = function() {
		Struct.splice(0,Struct.length)
	 };
	 
	Struct.getData = function(url) {
		$http.get(url)
			.success(function(data, status, headers, config) {
				var length = data.length;
				var nbVal = 0
				for(var i=0; i<length; i++) {
					Struct.add(data[i]);
				}
			})
			.error(function(data, status, headers, config) {
				console.log("Error " + status);
			});
	};
	
    return Struct;
}]);