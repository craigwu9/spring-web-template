define(['require','angular', 'menu'],function(require) {
    angular.module('indexApp', ['Menu']);

    require(['domReady!'], function(dom){
        angular.bootstrap(dom, ['indexApp']);
    });
});
