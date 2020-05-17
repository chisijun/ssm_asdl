/**
 * Created by wanfang on 2017/10/23 .
 */

/*提取接口公共部分*/
var ApiConf = {
	//webSocketServer:"ws://www.sangtech.cn/Dryer/websocket",
	//webSocketServer:"ws://192.168.1.111:8080/Dryer/websocket",
    //server:"http://192.168.1.100:8080/Dryer-0.0.1-SNAPSHOT/",
    //server:"http://192.168.1.107:8080/Dryer/",
    // server: "http://www.51cs8.com/Dryer/", //公司外网
    //server: "http://www.sangtech.cn/Dryer/", //小禾
	//server: "http://192.168.1.111:8080/heat/", //小禾
   server: "http://localhost:8080/asdl/", 
    token: window.sessionStorage.getItem('token'),
};

function WFang(api, callback, info, type, token) {
    //加载动画
    layer.load(2);
    //参数
    var data = info;
    var authorization = ApiConf.token;
    var contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    if (type == 'post') {
        contentType = 'application/json';
    } else if (type == 'postForm') {
        contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
        type = 'post';
    } else if (type == 'get') {
        contentType = 'application/x-www-form-urlencoded; charset=UTF-8';
    }
    if (typeof(data) === 'undefined') {
        layer.msg("提交的参数缺失", "出现错误了哦：");
        return;
    }
    if (authorization == null || authorization == undefined) {
        authorization = '';
    }
    if (token) {
        authorization = token;
    }
    window.ajax_request = $.ajax({
        type: type,
        dataType: 'json',
        async: 'false',
        xhrFields: {
            withCredentials: true
        },
        crossDomain: true,
        url: ApiConf.server + api,
        data: info,
        beforeSend: function(xhr) {
            xhr.setRequestHeader("authorization", authorization);
        },
        xhr: function() {
            myXhr = $.ajaxSettings.xhr();
            return myXhr;
        },
        success: function(data) {
            //停止加载动画
            layer.closeAll('loading');
            if (data.status) {
                callback(data);
            } else if (data.status == false) {
                callback(data);
            }
        },
        error: function(XMLHttpRequest) {
            if (XMLHttpRequest.status == 401) {
                layer.msg('请登录~~~');
                setTimeout(function() {
                    window.top.location.href = 'login.html';
                }, 1500)
            } else {
                layer.msg('服务器遇到了问题哦，请联系客服~~~');
            }
        },
        complete: function(XMLHttpRequest, textStatus) {
            window.ajax_request = null;
        },
        contentType: contentType
            //contentType:'application/x-www-form-urlencoded; charset=UTF-8'
    });
}

function user_login(userName, password) {
    var data = { name: userName, password: password }
    WFang("login/token", function(arr) {
        if (arr.status == false) {
            layer.msg(arr.message);
        } else {
            //二次验证人员  roleId为1  Web允许登录
            var token = arr.data.userId + '_' + arr.data.token;
            window.sessionStorage.setItem("token", token);
            yanzhen(userName, password, token);
        }
    }, data, 'postForm')
};
/**
 * 接口方法使用示例
 * 二次验证
 */
function yanzhen(userName, password, token) {
    WFang("user", function(arr) {
        if (arr.status == false) {
            layer.msg(arr.message);
        } else {
            //获取当前用户ID
            if (arr.data.list != '' && arr.data.userCode == 'admin') {
                if ($("#remid").is(':checked') == true) {
                    var username = $('#uname').val().trim();
                    var password = $('#upwd').val().trim();
                    $.cookie("rmbUser", "true", { expires: 30 });
                    $.cookie("username", userName, { expires: 30 });
                    $.cookie("password", password, { expires: 30 });
                } else {
                    $.cookie("rmbUser", "false", { expire: -1 });
                    $.cookie("username", "", { expires: -1 });
                    $.cookie("password", "", { expires: -1 });
                }
                window.sessionStorage.setItem("userId", arr.data.id);
                window.sessionStorage.setItem('tk_uname', arr.data.userName);
                window.sessionStorage.setItem('tk_uid', arr.data.id);
                var jumpto = "index.html";
                layer.msg('登录成功', { icon: 1 });
                setTimeout(function() {
                    window.location.replace(jumpto);
                }, 1800);
            } else {
                layer.msg('该账号不能登录后台管理系统');
            }
        }
    }, {}, 'get', token)
};

function logout() {
    WFang("user/loginOut", function(arr) {
        if (arr.status) {
            // TODO clear all cookies
            /*$.cookie("rmbUser", "false", { expire: -1 });
	   	    $.cookie("username", "", { expires: -1 });
	   	    $.cookie("password", "", { expires: -1 });*/
            layer.msg("退出登录");
            window.sessionStorage.setItem('tk_uname', '');
            setTimeout("window.location.href='login.html'", 1000);
        }
    }, {}, 'get');
}

function createCode() {
    var code = "";
    var codeLength = 4; //验证码的长度
    var random = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
        'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    ]; //随机数
    for (var i = 0; i < codeLength; i++) { //循环操作
        var index = Math.floor(Math.random() * 26); //取得随机数的索引（0~35）
        code += random[index]; //根据索引取得随机数加到code上
    }
    $('.yzm').html(code); //把code值赋给验证码
}

function getLocalTime(nS) {
    return new Date(parseInt(nS)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
}

function getUrl() {
    var search = location.search;
    var params = {};
    if (params != '') {
        var ps = search.slice(1).split('&');
        for (var i = 0; i < ps.length; i++) {
            var arr = ps[i].split('=');
            params[arr[0]] = arr[1];
        }
    }
    return params;
}

function Trim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

function getLen(str) {
    var len = 0;
    for (var i = 0; i < str.length; i++) {
        if (str.charCodeAt(i) > 255) { //charCodeAt() 方法可返回指定位置的字符的 Unicode 编码
            len += 2;
        } else {
            len++;
        }
    }
    return len;
}

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
        xhr.addEventListener("load", function(evt) {
            Toast(null, null, null, 3);
            callback(evt);
        }, false);
    }
    xhr.addEventListener("error", uploadFailed, false);
    xhr.addEventListener("abort", uploadCanceled, false);
    xhr.open("POST", ApiConf.server + ApiConf.case_upload_img);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send(fd);
}

/*文件上传(待续)*/
function uploadFile() {
    var that = this; //保存当前this
    var file = that.files[0];
    var fd = new FormData();
    fd.append("file", file);
    fd.append("fileDesc", "test");
    layer.load(0);
    $.ajax({
        async: true,
        url: ApiConf + 'Resource/ResourceAdd',
        type: "POST",
        dataType: 'json',
        data: fd,
        contentType: false,
        beforeSend: function(xhr) {
            xhr.setRequestHeader("authorization", token);
        },
        xhr: function() {
            myXhr = $.ajaxSettings.xhr();
            return myXhr;
        },
        success: function(arr) {
            //头像id
            that.setAttribute('name', arr.data[0].resourceid);
            layer.msg('文件上传成功', { icon: 1 });
            layer.closeAll('loading');
        },
        error: function() {
            layer.msg("上传失败");
            return;
        },
        cache: false,
        processData: false
    });
}