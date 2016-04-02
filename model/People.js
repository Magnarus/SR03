var trombiApp = angular.module('trombiApp');
trombiApp.factory('People', ['$http', function ($http) {
    var People = [];
	
    People.add = function (item) {
        People.push(item);
    };

	People.reset = function() {
		People.splice(0,People.length)
	 };
	 
	People.getData = function(url) {
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
				 
	};
	 
    return People;
}]);