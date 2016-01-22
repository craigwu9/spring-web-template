/**
 *
 */
define(['angular', 'loadingOverlay'],function(angular) {

    angular.module('myHttpService', ['loadingOverlay'])
    .factory('myHttpService', function($http, loadingOverlay){
    	/**
    	 * default error dialog
    	 */
    	function showSystemErrorDialog() {
            alert("有错误发生");
    	}

        /**
         * 检查是否需要跳转到登陆页
         */
        function checkIfJumpToLogin(response) {
            if (response.data && (typeof response.data == 'string') && response.data.indexOf('登陆页') > 0) {
                window.location.href='/login.html';
                return true;
            }
            return false;
        }

        return {
            'post':function(url, data, sucess, error, headers) {
            	if (typeof data == 'function') {
            		error = sucess;
            		sucess = data;
            		data = {};
            	}
            	loadingOverlay.show();
                var config = {};
                if (headers) {
                    config.headers = headers;
                }

            	$http.post(url, data, config).then(
            		function(response){
                        if (checkIfJumpToLogin(response)) {
                            return;
                        }
            			loadingOverlay.hide();
            			if (sucess != undefined && typeof sucess == 'function') {
            				sucess(response.data);
            			}
            		},
            		function(reason){
          				loadingOverlay.hide();
            			if (error != undefined && typeof error == 'function') {
            				error(reason);
            			} else {
            				// default error process.
            				showSystemErrorDialog();
            			}
            		}
            	);
            },
            'get': function(url, param, sucess, error) {
            	if (typeof param == 'function') {
            		error = sucess;
            		sucess = param;
            		param = {};
            	}
            	loadingOverlay.show();
            	$http.get(url, {'params':param}).then(
    				function(response){
                        if (checkIfJumpToLogin(response)) {
                            return;
                        }
            			loadingOverlay.hide();
            			if (sucess != undefined && typeof sucess == 'function') {
            				sucess(response.data);
            			}
            		},
            		function(reason){
          				loadingOverlay.hide();
            			if (error != undefined && typeof error == 'function') {
            				error(reason);
            			} else {
            				// default error process.
            				showSystemErrorDialog();
            			}
            		}
            	);
            },
            'delete': function(url, sucess, error) {
            	loadingOverlay.show();
            	$http.delete(url).then(
    				function(response){
                        if (checkIfJumpToLogin(response)) {
                            return;
                        }
            			loadingOverlay.hide();
            			if (sucess != undefined && typeof sucess == 'function') {
            				sucess(response.data);
            			}
            		},
            		function(reason){
          				loadingOverlay.hide();
            			if (error != undefined && typeof error == 'function') {
            				error(reason);
            			} else {
            				// default error process.
            				showSystemErrorDialog();
            			}
            		}
            	);
            }
        };
    });
});