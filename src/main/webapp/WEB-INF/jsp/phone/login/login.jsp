<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>BUI示例</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="/bui/bui.css">
    <script src="/bui/zepto.js"></script>
    <script src="/bui/bui.js"></script>
    <style></style>
</head>
<body>

<style type="text/css">

    .login-page main {
        background: #fff center bottom no-repeat;
        background-size: 100% auto;

    }

    .login-page .logo h1 {
        font-size: .82rem;
        padding-left: .3rem;
    }

    .logo {
        height: 2rem;
        margin: 1.2rem auto 1rem auto;
        text-align: center;
    }

    .logo img {
        height: 1rem;
    }

    .login-form {
        padding-left: .6rem;
        padding-right: .6rem;
    }

    .login-form .bui-list {
        border-top: none;
        margin-bottom: .7rem;
    }

    .login-form > .bui-btn {
        margin-bottom: .3rem;
    }

    .login-form .bui-btn-text {
        margin-bottom: .2rem;
    }

    .bui-list > [class*=bui-btn]:last-child {
    }

    .login-form .bui-label {
        width: 0.5rem;
        margin-right: .2rem;
    }

    .login-form .icon-face,
    .login-form .icon-lock {
        font-size: 0.48rem;
    }

    .login-form .bui-input {
        height: .6rem;
        background: none;
    }

    .login-form .bui-btn-text {
        text-align: center;
        color: #666666;
        font-size: 0.2rem;
    }

    .copyright {
        font-size: 0.17rem;
        color: #999999;
        width: 100%;
        text-align: center;
        background-color: #ffffff;
        padding-bottom: 0.25rem;
    }

    .icon-eye:before {
        content: "\e680"
    }

    .icon-eye.active:before {
        content: "\e67f"
    }

</style>
<div class="bui-page login-page">
    <main>
        <form id="form" action="/staff_phone_login">
            <div class="logo bui-box-center">
                <img src="images/demo/logo.png" alt="">
                <h1>施工管理</h1>
            </div>
            <div class="login-form">
                <ul class="bui-list">
                    <li class="bui-btn bui-box clearactive">
                        <label class="bui-label" for="user"><i class="icon-face"></i></label>
                        <div class="span1">
                            <div class="bui-input user-input">
                                <input id="user" name="username" type="text" placeholder="用户名">
                            </div>
                        </div>
                    </li>
                    <li class="bui-btn bui-box clearactive">
                        <label class="bui-label" for="password"><i class="icon-lock"></i></label>
                        <div class="span1">
                            <div class="bui-input password-input">
                                <input id="password" name="password" type="password" placeholder="密码">
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="bui-btn round primary" onclick="commit();">
                    登录
                </div>
                <div class="bui-btn-text" href="#">注册</div>
                <div class="bui-btn-text">忘记密码</div>
            </div>
        </form>
    </main>

</div>
<script>
    function commit() {
        $("#form").submit();
    }

    /**
     * 通用登录模板,包含输入交互,提交需要自己绑定验证
     * 默认模块名: pages/login/login
     * @return {[object]}  [ 返回一个对象 ]
     */
    bui.ready(function () {

        var pageview = {};

        pageview.bind = function () {

            // 手机号,帐号是同个样式名, 获取值的时候,取的是最后一个focus的值
            var userInput = bui.input({
                id: ".user-input",
                callback: function (e) {
                    // 清空数据
                    this.empty();
                }
            })

            // 密码显示或者隐藏
            var password = bui.input({
                id: ".password-input",
                iconClass: ".icon-eye",
                onBlur: function (e) {
                    if (e.target.value == '') {
                        return false;
                    }
                    // 注册的时候校验只能4-18位密码
                    var rule = /^[a-zA-Z0-9_-]{3,18}$/;
                    if (!rule.test(e.target.value)) {
                        bui.hint("密码只能由4-18位字母或者数字上下横杠组成");
                        return false;
                    }

                    return true;
                },
                callback: function (e) {
                    //切换类型
                    this.toggleType();
                    //
                    $(e.target).toggleClass("active")
                }
            })

        }

        pageview.init = function () {

            // 绑定事件
            this.bind();
        }


        // 初始化
        pageview.init();

        // 输出模块
        return pageview;
    })
</script>
</body>
</html>
