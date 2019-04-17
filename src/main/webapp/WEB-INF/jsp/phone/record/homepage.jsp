<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>BUI示例</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/buijs/lib/latest/bui.css">
    <script src="https://cdn.jsdelivr.net/npm/buijs/lib/zepto.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/buijs/lib/latest/bui.js"></script>
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
    .list-photo .photo-item img{
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
            <%--<a id="btnOpen2" class="bui-btn-inline"><i class="icon-menu"></i></a>--%>
        </div>
    </header>
    <main>


        <ul class="bui-list contact-list">
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">任务编号</label>
                <div class="span1">
                    <div class="bui-value">2587155</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">维护时间</label>
                <div class="span1">
                    <div class="bui-value"><s:date name="date" format="yyyy年MM月dd日hh点mm分ss秒" /></div>
                </div>
            </li>

            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">留言</label>
                <div class="span1">
                    <div class="bui-value">${info}</div>
                </div>
            </li>
            <ul class="bui-list personal-info">
                <li class="bui-btn bui-box" onclick="to('/staff_phone_showQrcode','${staff.oid}');">
                    <div class="thumbnail ring"><img src="images/face.png" alt=""></div>
                    <div class="span1">
                        <h3 class="item-title">${staff.name}</h3>
                        <p class="item-text">用户体验部</p>
                    </div>
                </li>
            </ul>
            <ul class="bui-list personal-info">
                <li class="bui-btn bui-box" onclick="to('/equipment_phone_home','${equipment.oid}');">
                    <div class="thumbnail ring"><img src="images/demo/xiaowaji.jpg" alt=""></div>
                    <div class="span1">
                        <h3 class="item-title">${equipment.name}</h3>
                        <p class="item-text">编码：562484</p>
                    </div>
                </li>
            </ul>

            <%--图集--%>
            <ul class="bui-list list-photo">
                <li class="bui-btn">
                    <div class="bui-box-space">
                        <div class="span1">
                            <div class="photo-item">
                                <img src="images/demo/wajueji.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </li>
                <li class="bui-btn">
                    <div class="bui-box-space">
                        <div class="span1">
                            <div class="photo-item">
                                <img src="images/demo/wajueji.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </li>
                <li class="bui-btn">
                    <div class="bui-box-space">
                        <div class="span1">
                            <div class="photo-item">
                                <img src="images/demo/wajueji.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </li>
            </ul>


        </ul>
    </main>
</div>

<!-- 自定义弹出菜单结构	 -->
<%--<div id="actionsheet" class="bui-actionsheet actionsheet-custom" style="display: none">
    <ul class="bui-nav-icon bui-fluid-4">
        <li class="bui-btn">
            <i class="icon"><img src="images/icon_see.png" alt=""></i>管理设备
        </li>
        <li class="bui-btn">
            <i class="icon"><img src="images/icon_see.png" alt=""></i>维护记录
        </li>
    </ul>
</div>--%>


<script>

    function to(url,oid) {
        window.location.href = url+"?oid="+oid;
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
