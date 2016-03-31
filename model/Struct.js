 var trombiApp = angular.module('trombiApp');
trombiApp.factory('Struct', function () {
    var Struct = [];
	
    Struct.add = function (item) {
        Struct.push(item);
    };

	Struct.reset = function() {
		Struct.splice(0,Struct.length)
	 };
    return Struct;
});