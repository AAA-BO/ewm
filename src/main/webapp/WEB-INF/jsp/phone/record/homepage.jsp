<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>BUI示例</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
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

    .list-photo .photo-item {
        margin: .1rem 0;
        background: #efefef;
        min-height: 1.6rem;
    }

    .list-photo .photo-item img {
        width: 100%;
        height: auto;
    }
</style>
<div class="bui-page">
    <header class="bui-bar">
        <div class="bui-bar-left bui-bar-text">
            <a class="bui-btn" onclick="bui.back();"><i class="icon-back"></i>返回</a>
        </div>
        <div class="bui-bar-main">维护信息</div>
        <div class="bui-bar-right bui-bar-text">
        </div>
    </header>
    <main>
        <ul class="bui-list personal-info">
            <li class="bui-btn bui-box" onclick="to('/staff_phone_showQrcode','${staff.oid}');">
                <div class="thumbnail ring"><img src="demo/tx${staff.oid%5}.jpg" alt=""></div>
                <div class="span1">
                    <h3 class="item-title">${staff.name}</h3>
                    <p class="item-text">${staff.department} ${staff.phone}</p>
                </div>
            </li>
        </ul>
        <ul class="bui-list personal-info">
            <li class="bui-btn bui-box" onclick="to('/equipment_phone_home','${equipment.oid}');">
                <div class="thumbnail ring"><img src="demo/sb${equipment.oid%4}.jpg" alt=""></div>
                <div class="span1">
                    <h3 class="item-title">${equipment.name}</h3>
                    <p class="item-text">${equipment.site.name}</p>
                </div>
            </li>
        </ul>
        <ul class="bui-list contact-list">
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">维护时间</label>
                <div class="span1">
                    <div class="bui-value"><s:date name="date" format="yyyy年MM月dd日hh点mm分ss秒"/></div>
                </div>
            </li>

            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">概要信息</label>
                <div class="span1">
                    <div class="bui-value">${info}</div>
                </div>
            </li>

            <%--图集--%>
            <%--<ul class="bui-list list-photo">
                <li class="bui-btn">
                    <div class="bui-box-space">
                        <div class="span1">
                            <div class="photo-item">
                                <img src="images/demo/wajueji.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </li>
            </ul>--%>
        </ul>
        <%--弹出框--%>
        <div class="container-xy" id="btnTop">
            <a href="#">
                <div class="bui-btn round primary">
                    详细信息
                </div>
            </a>
        </div>
    </main>
</div>

<script>
    bui.ready(function () {
    })

    function to(url, oid) {
        window.location.href = url + "?oid=" + oid;
    }

    // 文字提醒
    $('#btnTop').on("click", function () {
        window.location.href = "/record_phone_xiangqing?oid=${oid}"
    })


</script>
</body>
</html>
