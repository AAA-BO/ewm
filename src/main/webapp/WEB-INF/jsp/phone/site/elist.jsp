<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>所维护设备</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="/bui/bui.css">
    <script src="/bui/zepto.js"></script>
    <script src="/bui/bui.js"></script>
    <style></style>
</head>
<body>

<style>
    .list-photo {
        border-top: 0;
    }

    .list-photo .bui-btn {
        padding: .1rem .2rem;
    }

    .list-photo .photo-title {
        line-height: 1.5;
        margin-bottom: .1rem;
        color: #333;
        /*超出两行截取*/
        overflow: hidden;
        display: -webkit-box;
        display: box;
        text-overflow: ellipsis;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
    }

    .list-photo .bui-box-space {
        margin-left: -.2rem;
        margin-right: -.2rem;
        width: auto;
    }

    .list-photo .photo-title {
        margin: .1rem 0;
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

    .list-photo .photo-desc {
        margin: .1rem 0;
        text-align: left;
    }

    .list-photo .thumbnail {
        margin: .1rem .2rem;
        margin-left: 0;
        width: 1.5rem;
        height: 1.2rem;
        background: #efefef;
    }

    .list-photo .span1 ~ .thumbnail {
        margin-right: 0;
    }

    .list-photo .photo-cover {
        padding: 0;
        position: relative;
        display: block;
        height: 3rem;
        width: 100%;
        overflow: hidden;
        background: #e1e1e1;
    }

    .list-photo .photo-cover .photo-img {
        margin: 0;
        background: none;
        height: 100%;
    }

    .list-photo .photo-cover .photo-img img {
        /*height: 100%;*/
        width: 100%;
        object-fit: cover;
        object-position: center;
    }

    .list-photo .photo-cover .photo-title {
        position: absolute;
        bottom: 0;
        left: 0;
        right: 0;
        z-index: 5;
        width: 100%;
        margin: 0;
        padding: 0 .2rem;
        padding-top: .1rem;
        padding-bottom: .1rem;
        line-height: 1.7;
        color: #fff;
    }
</style>
<div class="bui-page">
    <header class="bui-bar">
        <div class="bui-bar-left bui-bar-text">
            <a class="bui-btn" onclick="bui.back();"><i class="icon-back"></i>返回</a>
        </div>
        <div class="bui-bar-main">所维护设备</div>
        <div class="bui-bar-right">
        </div>
    </header>
    <main>
        <ul class="bui-list list-photo contact-list">
            <%--维护组--%>
            <s:iterator value="#request.equipments" var="equipment">
                <li class="bui-btn" onclick="to('/equipment_phone_home','${equipment.oid}');">
                    <div class="bui-box-space">
                        <div class="span1">
                            <div class="photo-item">
                                <img src="demo/sb${equipment.oid%4}.jpg" alt="">
                            </div>
                            <div class="photo-info">
                                <h3 class="photo-title">${equipment.name}</h3>
                                <div class="photo-desc">
                                    <span class="time">所在场地：${equipment.site.name}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </s:iterator>
        </ul>
    </main>
</div>
<script>
    bui.ready(function () {
    })

    function to(url, eid) {
        window.location.href = url + "?oid=" + eid;
    }
</script>
</body>
</html>