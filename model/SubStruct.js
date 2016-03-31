 var trombiApp = angular.module('trombiApp');
trombiApp.factory('SubStruct', function () {
    var SubStruct = [];
	
    SubStruct.add = function (item) {
        SubStruct.push(item);
    };

	SubStruct.reset = function() {
		SubStruct.splice(0,SubStruct.length)
	 };
    return SubStruct;
});