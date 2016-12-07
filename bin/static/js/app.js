angular.module('demo', [])
.controller('productController', function($scope, $http) {
	
	var baseUrl = "http://localhost:8080";
	
	function getAllProduct() {
	    $http.get(baseUrl + '/allProducts').then(function(response) {
            $scope.products = response.data;
        });
	}
	
	getAllProduct();

    
    $scope.addProduct = function () {
    	
		if($scope.addProductName=="" || $scope.addPrice==""){
			alert("Insufficient Data! Please provide values for task product name and price");
		}
		else{
			$http.post(baseUrl + '/addProduct', {
				productName: $scope.addProductName,
				price: $scope.addPrice
			}).
			success(function(data, status, headers) {
				getAllProduct();
			});
		}
     };
     
     $scope.searchProduct = function () {

	     if($scope.searchProductName=="" || !$scope.searchProductName){
	    	 getAllProduct();
		 } else {
			 $http.post(baseUrl + '/searchProduct', {
				 productName: $scope.searchProductName
			 }).
			 success(function(data, status, headers) {
				 $scope.products = data;
			 });
		 }
     };
});