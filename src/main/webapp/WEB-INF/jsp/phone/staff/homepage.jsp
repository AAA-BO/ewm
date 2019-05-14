<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>员工信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="/bui/bui.css">
    <script src="/bui/zepto.js"></script>
    <script src="/bui/bui.js"></script>
    <style></style>
</head>
<body>


<style type="text/css">

    .personal-info {
        margin-top: 0;
        margin-bottom: .2rem;
    }

    .personal-info .bui-btn {
        padding-top: .3rem;
        padding-bottom: .3rem;
    }

    .personal-info .icon {
        margin-right: 0;
    }

    .contact-list {
        border-top: none;
        margin-bottom: .2rem;
        padding: 0 0.2rem;
        background-color: #ffffff;
    }

    .contact-list .bui-btn {
        padding-left: 0;
        padding-top: .3rem;
        padding-bottom: .3rem;
    }

    .contact-list li:last-child {
        border-bottom: none;
    }
</style>
<div class="bui-page">
    <header class="bui-bar">
        <div class="bui-bar-left bui-bar-text">
            <a class="bui-btn" onclick="bui.back();"><i class="icon-back"></i>返回</a>
        </div>
        <div class="bui-bar-main">员工信息</div>
        <div class="bui-bar-right bui-bar-text">
            <%--<a id="btnOpen2" class="bui-btn-inline"><i class="icon-menu"></i></a>--%>
        </div>
    </header>
    <main>
        <ul class="bui-list personal-info">
            <li class="bui-btn bui-box">
                <div class="thumbnail ring"><img src="demo/tx${oid%5}.jpg" alt=""></div>
                <div class="span1">
                    <h3 class="item-title">${name}</h3>
                    <p class="item-text">${sex} ${age}岁</p>
                </div>
            </li>
        </ul>
        <ul class="bui-list contact-list">
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">所属部门</label>
                <div class="span1">
                    <div class="bui-value">${department}</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive" onclick="to('/site_phone_home',${site.oid});">
                <label class="bui-label">所在工地</label>
                <div class="span1">
                    <div class="bui-value">${site.name}</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">拥有职称</label>
                <div class="span1">
                    <div class="bui-value">${zhicheng}</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">手机号码</label>
                <div class="span1">
                    <div class="bui-value">${phone}</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">电子邮箱</label>
                <div class="span1">
                    <div class="bui-value">${email}</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive" onclick="to('/staff_phone_mlist');">
                <label class="bui-label">有维护组</label>
                <div class="span1">
                    <div class="bui-value">共${maintainGroupNumber}个</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive" onclick="to('/staff_phone_elist');">
                <label class="bui-label">维护设备</label>
                <div class="span1">
                    <div class="bui-value">共${equipmentNumber}台</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive" onclick="to('/staff_phone_rlist');">
                <label class="bui-label">维护记录</label>
                <div class="span1">
                    <div class="bui-value">共${recordNumber}条</div>
                </div>
            </li>
        </ul>
    </main>
</div>


<script>
    bui.ready(function () {
    })

    function to(url,oid) {
        if(oid==null) {
            window.location.href = url+"?oid=${oid}";
        }else {
            window.location.href = url+"?oid="+oid;
        }
    }

    bui.ready(function () {
        //自定义弹出菜单初始化
        var dialog = bui.dialog({
            id: "#actionsheet",
            position: "bottom",
            effect: "fadeInUp",
            onMask: function (argument) {
                dialog.close();
            }
        });

        $('#btnOpen2').on("click", function (argument) {
            dialog.open();
        })

    })
</script>
</body>
</html>
