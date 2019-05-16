<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>维护组</title>
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

    .list-photo .photo-title {
        margin: .1rem 0;
    }

    .list-photo .photo-item {
        margin: .1rem 0;
        background: #efefef;
        min-height: 1.6rem;
    }
</style>
<div class="bui-page">
    <header class="bui-bar">
        <div class="bui-bar-left bui-bar-text">
            <a class="bui-btn" onclick="bui.back();"><i class="icon-back"></i>返回</a>
        </div>
        <div class="bui-bar-main">列表</div>
        <div class="bui-bar-right bui-bar-text">
        </div>
    </header>
    <main>

        <ul class="bui-list personal-info">
            <li class="bui-btn bui-box">
                <div class="span1">
                    <h3 class="item-title">${name}</h3>
                </div>
            </li>
        </ul>
        <ul class="bui-list contact-list">
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">说明信息</label>
                <div class="span1">
                    <div class="bui-value">${info}</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive" onclick="to('/site_phone_slist');">
                <label class="bui-label">员工数量</label>
                <div class="span1">
                    <div class="bui-value">共${staffNumber}位</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive" onclick="to('/site_phone_elist');">
                <label class="bui-label">设备数量</label>
                <div class="span1">
                    <div class="bui-value">共${equipmentNumber}台</div>
                </div>
            </li>
        </ul>
    </main>

</div>
</main>
</div>

<script>
    function to(url,oid) {
        if(oid==null) {
            window.location.href = url+"?oid=${oid}";
        }else {
            window.location.href = url+"?oid="+oid;
        }
    }
    bui.ready(function () {
    })
</script>
</body>
</html>
