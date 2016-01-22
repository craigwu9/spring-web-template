define(['angular', 'jquery', 'urlParamUtl', 'myHttpService'],function() {

    var menuModule = angular.module('Menu', ['UrlParam', 'myHttpService']);

    menuModule.controller('MenuCtrl', ['$scope', 'myHttpService', 'UrlParamUtil',function($scope, myHttpService, UrlParamUtil){
        var activeMenuId =  UrlParamUtil.getValue('menuId');
        var showMenu = UrlParamUtil.getValue('menu');
        
        $scope.showMenu = true;
        $scope.menus = [];
        function setMenuActive(menus, activeMenuId) {
            for(var i=0; i<menus.length; i++) {
                if (menus[i].children && menus[i].children.length > 0) {
                    if (setMenuActive(menus[i].children, activeMenuId)) {
                        menus[i].openChild = 'in';
                        menus[i].active = 'active';
                        return true;
                    }
                } else {
                    if (menus[i].id == activeMenuId) {
                        menus[i].active = 'active';
                        return true;
                    }
                }
            }
            return false;
        }

        if (showMenu != "0") {

            myHttpService.get('/menu', function(data){
                $scope.menus = data;
                if (!activeMenuId) {
                    $('#activeMenuId').val();
                }
                if (activeMenuId) {
                    setMenuActive($scope.menus, activeMenuId);            
                }
            });

            $scope.arrowClicked = function(menu) {
                if (menu.openChild == '' || menu.openChild == undefined) {
                    menu.openChild = 'in';
                    menu.active = 'active';
                } else {
                    menu.openChild = '';
                    menu.active = '';
                }
            };

        } else {
            $('#navBar').hide();
            $("#page-wrapper").addClass('no-margin');
        }
        
        $scope.toggleMenu = function(show) {
            $scope.showMenu = show;
            if (show) {
                $("#page-wrapper").css('margin-left',250);
            } else {
                $("#page-wrapper").css('margin-left',0);
            }
        }
        
    }]).directive('d2jsMenu', function(){
        return {
            templateUrl: '/comp/menu/menu.html'
        };
    });
});
