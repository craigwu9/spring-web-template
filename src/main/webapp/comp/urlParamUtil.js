define(['angular'],function(angular) {

    var urlParam = angular.module('UrlParam',[]);

    urlParam.factory('UrlParamUtil', function(){
        var vars = {};
        var hashes = window.location.href.slice(window.location.href.indexOf('?')+1).split('&');
        for(var i=0; i<hashes.length; i++) {
            var hash = hashes[i].split('=');
            var value = decodeURIComponent(hash[1]);
            if (value.indexOf('#') > 0) {
                value = value.substring(0, value.indexOf("#"));
            }
            vars[hash[0]] = value;
        }
        return {
            'getValue': function(paramName){
                return vars[paramName];
            }
        }
    });
});