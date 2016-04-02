 var trombiApp = angular.module('trombiApp');
trombiApp.factory('SubStruct', [  '$http', function ($http) {
    var SubStruct = [];
	
    SubStruct.add = function (item) {
        SubStruct.push(item);
    };

	SubStruct.reset = function() {
		SubStruct.splice(0,SubStruct.length)
	 };
	 
	 SubStruct.getData = function(url) {
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
	};
	 
    return SubStruct;
}]);