var trombiApp = angular.module('trombiApp');
trombiApp.factory('People', function () {
    var People = [];
	
    People.add = function (item) {
        People.push(item);
    };

	People.reset = function() {
		People.splice(0,People.length)
	 };
    return People;
});