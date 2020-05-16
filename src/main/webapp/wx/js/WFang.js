/**
 * Created by wanfang on 2017/10/23 .
 */

/*提取接口公共部分*/
var ApiConf = {
  userId:window.sessionStorage.getItem('userId'),
  	//webSocketServer:"ws://www.sangtech.cn/Dryer/websocket",
  	//webSocketServer:"ws://192.168.1.111:8080/Dryer/websocket",
  	server:"http://localhost:8080/heat/",//外网接口
  	//server:"http://www.sangtech.cn/Dryer/",//外网接口
	//server:"http://192.168.1.91:8080/",//微信支付测试接口
	//server:"http://192.168.1.100:8080/Dryer-0.0.1-SNAPSHOT/",//公司测试环境
  //token:'15_11e8311de6c146b99d36c5b9447d1dbb'//测试账号（有数据）池思军 15071392085
  //token:'23_8e298fb8f37d46d0837bd73a2791b492'//测试账号（有数据）诸葛亮 15071392090
  // server:"http://www.sangtech.cn/Dryer/",
  token:window.sessionStorage.getItem('token'),
};
/**
 * 调用接口方法
 * api:接口
 * callback:回调函数
 * info:参数
 * type:请求方式
 */
function WFang (api, callback, info, type, dataType, token, url) {
  layer.ready(function() {
    //加载动画
    layer.load(2);
    //参数
    var data = info;
    var authorization=ApiConf.token;
    var contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    if(type == 'post'){
    	contentType = 'application/json';
    }else if(type == 'postForm'){
        contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
        type = 'post';
    }else if(type == 'get'){
    	contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    }
    if (typeof(data) === 'undefined') {
        layer.msg("提交的参数缺失", "出现错误了哦：");
        return;
    }
    if(dataType==''||dataType==undefined){
      dataType='json';
    }
    if(authorization==null||authorization==undefined){
      authorization='';
      // if(authorization==''){
      //   var jumpto = "../login.html";
      //   window.location.replace(jumpto);
      // }
    }
    if(token){
      authorization=token;

    }
    window.ajax_request = $.ajax({
        type: type,
        dataType: dataType,
        timeout : 8000, //超时时间设置，单位毫秒
        async: 'false',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true, 
        url: ApiConf.server+api,
        data: info,
        beforeSend: function (xhr) {
          xhr.setRequestHeader("authorization", authorization);
        },
        success: function(data) {
        	//停止加载动画
            layer.closeAll('loading');
                  if (data.status) {
                      callback(data);
                  }
                  else if (data.status==false){
                      callback(data);
                  }
              },
        error: function(XMLHttpRequest) {
          if(XMLHttpRequest.status=='401'){
            layer.msg('请登录~~~');
            var prepage = window.location.pathname;
            window.sessionStorage.setItem('prepage',prepage);
            setTimeout(function(){
              var jumpto = "../login.html?url=" + url;
              window.location.replace(jumpto);
            },2000)
          }else{
            layer.msg('服务器遇到了问题哦，请联系客服~~~');
          }
          //停止加载动画
          layer.closeAll('loading');
        },
        complete: function(XMLHttpRequest,textStatus,status){
          if(status=='timeout'){
            layer.msg('连接超时~~~');
          }
            window.ajax_request = null;
        },
        contentType:contentType
        //contentType:'application/x-www-form-urlencoded; charset=UTF-8'
    });
  });
}

/**
 * 接口方法使用示例
 * 登录(包含cookie存储)
 */

/**
 * 接口方法使用示例
 * 注销
 */
function logout() {
	WFang ("user/loginOut",function(arr){
		if(arr.status){
			// TODO clear all cookies
			/*$.cookie("rmbUser", "false", { expire: -1 });
	   	    $.cookie("username", "", { expires: -1 });
	   	    $.cookie("password", "", { expires: -1 });*/
			layer.msg("退出登录");
			setTimeout("window.location.href='login.html'",1000);
		}
	},{},'get');
}

/**
 * 生成验证码方法
 * 可用于登录页面生成验证码
 */
function createCode(){
	var code = "";
	var codeLength = 4;//验证码的长度
    var random = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
         'S','T','U','V','W','X','Y','Z'];//随机数
    for( var i = 0; i < codeLength; i++ ) {//循环操作
       var index = Math.floor(Math.random()*26);//取得随机数的索引（0~35）
       code += random[index];//根据索引取得随机数加到code上
    }
     $('.yzm').html(code);//把code值赋给验证码
}

/**
 * 时间戳转换成日期对象
 */
function getLocalTime(nS) {     
	return new Date(parseInt(nS)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");   
}  

/**
 * 截取url参数
 * 用于截取页面之间传递的参数
 */
function getUrl(){
	var search = location.search;
	var params = {};
	if(params != ''){
		var ps = search.slice(1).split('&');
		for(var i = 0;i < ps.length;i++){
			var arr = ps[i].split('=');
			params[arr[0]] = arr[1];
		}
	}
	return params;
}

function getUrlParameters(parameter){
    var currLocation = window.location.search;
    if (currLocation.indexOf("?") == -1){
        return false;
    }
    var parArr = currLocation.split("?")[1].split("&"),
        returnBool = true;
    for(var i = 0; i < parArr.length; i++){
        parr = parArr[i].split("=");
        if(parr[0] == parameter){
            return decodeURIComponent(parr[1]);
            //returnBool = true;
        }else{
            returnBool = false;
        }
    }
    if(!returnBool) return false;
}

/**
 * 去除前后空格
 * 前端传给后台的参数需去除前后空格
 */
function Trim(str){ 
    return str.replace(/(^\s*)|(\s*$)/g, ""); 
}

/**
 * 获得字符串长度
 * 可用于表单输入长度验证
 */
function getLen(str){
    var len = 0;
    for(var i = 0;i < str.length;i++){
        if(str.charCodeAt(i)>255){//charCodeAt() 方法可返回指定位置的字符的 Unicode 编码
            len += 2;
        }else{
            len++;
        }
    }
    return len;
}

/**
 * 图片压缩上传
 * 上传前用js对图片压缩，把利用canvas生成的base64字符串，传入后台，
 * （无所谓ajax或者form，同时也可以解决图片无刷新上传），
 * 在Java后台将获取到的base64字符串输出为图片，即可。
 */
function caseUploadFile(files, callback) {
    var fd = new FormData();
    fd.append("fileCommon.fileSource", "lists");
    fd.append("fileCommon.fileType", "JPG,BMP,GIF,TIF,PNG");
    for (var i = 0; i < files.length; i++) {
    	var file = files[i];
        var URL = window.URL || window.webkitURL;
        var blob = URL.createObjectURL(file);
        //画图
        var img = new Image();
        img.src = blob;
        img.onload = function() {
            var that = this;
            //生成比例
            var w = that.width,
                h = that.height,
                scale = w / h;
            w = 640 || w;
            h = w / scale;

            //生成canvas
            var canvas = document.createElement('canvas');
            var ctx = canvas.getContext('2d');
            $(canvas).attr({
                width: w,
                height: h
            });
            ctx.drawImage(that, 0, 0, w, h);
            /**
             * 生成base64
             * 兼容修复移动设备需要引入mobileBUGFix.js
             */
            var base64 = canvas.toDataURL('image/jpeg', 0.8 || 0.8);
            
            // 修复IOS
            if (navigator.userAgent.match(/iphone/i)) {
                var mpImg = new MegaPixImage(img);
                mpImg.render(canvas, {
                    maxWidth: w,
                    maxHeight: h,
                    quality: obj.quality || 0.8
                });
                base64 = canvas.toDataURL('image/jpeg', 0.8 || 0.8);
            }

            // 修复android
            if (navigator.userAgent.match(/Android/i)) {
                var encoder = new JPEGEncoder();
                base64 = encoder.encode(ctx.getImageData(0, 0, w, h), 0.8 * 100 || 80);
            }
            imgData = base64;
            fd.append("files.filess", files[0]);
        };
    }
    var xhr = new XMLHttpRequest();
    if (typeof(callback) === 'function') {
        xhr.addEventListener("load", function (evt) {
            Toast(null, null, null, 3);
            callback(evt);
        }, false);
    }
    xhr.addEventListener("error", uploadFailed, false);
    xhr.addEventListener("abort", uploadCanceled, false);
    xhr.open("POST", ApiConf.server + ApiConf.case_upload_img);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.send(fd);
}

/*文件上传(待续)*/
function uploadFile(){
    var that=this;//保存当前this
    var file = that.files[0];
    var fd = new FormData();
    fd.append("file", file);
    fd.append("fileDesc", "test");
    layer.load(0);
    $.ajax({
      	  async: true,
	      url: ApiConf+'Resource/ResourceAdd',
	      type: "POST",
	      dataType: 'json',
	      data: fd,
	      contentType: false,
	      beforeSend: function (xhr) {
	          xhr.setRequestHeader("authorization", token);
	      },
          xhr: function() {
              myXhr = $.ajaxSettings.xhr();
              return myXhr;
          },
          success:function(arr) {
          	  //头像id
              that.setAttribute('name',arr.data[0].resourceid);
              layer.msg('文件上传成功',{icon: 1});
              layer.closeAll('loading');
          },
          error:function() {
              layer.msg("上传失败");
          },
          cache:false,
          processData:false
    });
}

