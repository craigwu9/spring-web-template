define(['angular', 'jquery'],function(angular, jquery) {
    angular.module('loadingOverlay', [])
    .factory('loadingOverlay', function(){
        return {
            'show':function(){
                if (jquery('.loadingOverlay').length == 0) {
                    jquery('body').append('<div class="loadingOverlay" style="width:100%;height:100%;background-color:rgba(138,138,138, 0.4);'+
                                            'position:absolute;top:0;left:0;z-index:65536;"><div style="width:100%;height:100%;background:url(/images/loading.gif) no-repeat center 50%;"></div></div>');
                } else {
                    jquery('.loadingOverlay').show();
                }
            },
            'hide': function(){
                if (jquery('.loadingOverlay').length > 0) {
                    jquery('.loadingOverlay').hide();
                }
            }
        };
    });
});