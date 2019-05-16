<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>维护详情</title>
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
        <ul class="bui-list contact-list">
            <s:iterator value="#request.data">
                <li class="bui-btn bui-box clearactive">
                    <label class="bui-label"><s:property value="key"/></label>
                    <div class="span1">
                        <div class="bui-value"><s:property value="value"/></div>
                    </div>
                </li>
            </s:iterator>
        </ul>
    </main>
</div>

<script>
    bui.ready(function () {
    })

</script>
</body>
</html>
