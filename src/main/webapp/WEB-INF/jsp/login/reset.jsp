<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="/css/bui.css">
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
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>重置密码</title>
</head>

<body>
    <div class="bui-page reset">
        <header class="bui-bar">
            <div class="bui-bar-left" onclick="bui.back();">
                <a onclick="bui.back()" class="bui-btn">
                    <i class="icon-back"></i>
                </a>
            </div>
            <div class="bui-bar-main">重置密码</div>
            <div class="bui-bar-right"></div>
        </header>
        <main>
            <div id="step"></div>
            <div class="bui-list">
                <div class="bui-btn bui-box">
                    <div class="bui-label">新密码</div>
                    <div class="span1">
                        <input type="password" class="bui-input" value="" placeholder="设置6-18位密码" minlength="6" maxlength="18">
                    </div>
                </div>
                <div class="bui-btn bui-box tip-box">
                    <div class="bui-label"></div>
                    <div class="span1" >
                        <div class="bui-fluid">
                            <div class="span4 p-strength" >
                                <div class="bui-box-space">
                                    <div class="span3">
                                        <div class="bui-btn danger">低</div>
                                    </div>
                                    <div class="span3">
                                        <div class="bui-btn warning">中</div>
                                    </div>
                                    <div class="span3">
                                        <div class="bui-btn success">高</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="span1 tip-wran-text" style="display: none;">
                        <i class="icon_infofill"></i> 输入密码格式不正确，请重新输入
                    </div>
                </div>
                <div class="bui-btn bui-box">
                    <div class="bui-label">确认新密码</div>
                    <div class="span1">
                        <input type="password" class="bui-input" value="" placeholder="" minlength="6" maxlength="18">
                    </div>
                </div>
            </div>
            <div class="container-xy">
                <div class="bui-btn round success" id="submit">提交</div>
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
    stepBar.value(1);
    
     $("#submit").on('click', function(event) {
         if ($("[type='password']").val()) {
                bui.load({url:"success.html"});
            }else{
             $(".tip-box .span1").eq(0).hide();
             $(".tip-box .span1").eq(1).show();
               return false;
          }
     });
    
})
</script>

</html>
