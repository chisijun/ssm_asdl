/**
 * Created by pengcan on 2017/12/26.
 */
//公司内网
//var ApiConf='http://192.168.1.100:8080/NursingCloud-0.0.1-SNAPSHOT/';
//公司外网
//var ApiConf='http://www.51cs8.com/NursingCloud/';
//公司外网 wx
//var ApiConf='http://www.51cs8.com/NursingWx/';


var token = window.localStorage.getItem('token');

$(function(){
  /************设置底层rem************/
  defaultfont();
  /*之所以要延时100ms再调用这个函数是因为
   如果不这样屏幕宽度加载会有误差*/
  setTimeout(function(){
    defaultfont();
  }, 100);
  function defaultfont() {
    var sw = $(window).width()>750?750:$(window).width();
    var pw = 750;
    var f = 100*sw/pw;//设置100px 便于计算 且chrome浏览器最小辨识12px
    $('html').css('font-size', f+'px');
  }
  //如果页面宽度变更，刷新页面
  var w_height=$(window).width();
  $(window).resize(function(){
    if($(window).width()!=w_height)
    {
      window.location.reload();
    }
  });

});