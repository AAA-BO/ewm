<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="/css/bui.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <!-- 依赖库 手机调试的js引用顺序如下 -->
    <script src="/js/zepto.js"></script>
    <!-- 原生库 -->
    <!-- <script src="/js/cordova.js"></script> -->
    <!-- <script src="/js/bingotouch.js"></script> -->
    <!-- 移动端快速点击插件 -->
    <script src="/js/plugins/fastclick.js"></script>
    <!-- BUI库 -->
    <script src="/js/bui.js"></script>
    <!-- 应用的相关配置 -->
    <script src="/js/app/_config.js"></script>
    <title>完成</title>
</head>

<body>
    <div class="bui-page">
        <header class="bui-bar">
            <div class="bui-bar-left" onclick="bui.back();">
                <a onclick="bui.back()" class="bui-btn">
                    <i class="icon-back"></i>
                </a>
            </div>
            <div class="bui-bar-main">完成</div>
            <div class="bui-bar-right"></div>
        </header>
        <main>
            <div id="step"></div>
            <div class="msg">
                <i class="icon-successfill"></i>
                <div class="msg-content container-xy">你的密码找回成功，请用新密码登录~</div>
                <div class="bui-box-center bui-intervel bui-box-vertical">
                    <div class="bui-btn success round">
                        <a href="login.jsp">返回登录</a>
                    </div>
                    <p>页面将在<span id="countdown">9</span>秒后自动关闭</p>
                </div>
            </div>
        </main>
        <footer></footer>
    </div>
</body>
<script src="/js/app/rStepBar.js"></script>
<script type="text/javascript">
bui.ready(function(viewport) {

    var option = {
        id: "#step",
        data: ["身份验证", "重置密码", "完成"]
    }
    var stepBar = new rStepbar(option);
    stepBar.value(2);
   

    var count=10;
    // setInterval(function (argument) {
    //    if (count<=0) {
    //      bui.load({url:"login.jsp"});
    //      return;
    //    }
    //    count--;
    //    $("#countdown").text(count);
    // }, 1000)

})
</script>

</html>
