var require = {
    urlArgs: "bust=2016011101",          // 版本变更后用来更新浏览器缓存
    paths:{
        'jquery': 'lib/sbAdmin2/bower_components/jquery/dist/jquery.min',
        'bootstrap': 'lib/sbAdmin2/bower_components/bootstrap/dist/js/bootstrap.min',
        'sbAdmin2': 'lib/sbAdmin2/dist/js/sb-admin-2',
        'domReady': 'lib/requirejs/domReady',
        'angular': 'lib/angularjs/angular.1.4.3.min',
        'urlParamUtl': '/comp/urlParamUtil',
        'loadingOverlay': '/comp/loadingOverlay',
        'myHttpService': '/comp/myHttpService',
        'menu': '/comp/menu/menu'
    },

    shim: {
        'jquery': {
            exports: 'jquery'
        },
        'bootstrap': {
            deps: ['jquery']
        },
        'sbAdmin2': {
            deps: ['jquery', 'bootstrap']
        },
        'angular': {
            exports: 'angular'
        }
    }
};
