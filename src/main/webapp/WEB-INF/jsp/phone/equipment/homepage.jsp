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
            <a id="btnOpen2" class="bui-btn-inline"><i class="icon-menu"></i></a>
        </div>
    </header>
    <main>
        <%--轮播图--%>
        <div id="slide" class="bui-slide bui-slide-skin01"></div>

        <ul class="bui-list personal-info">
            <li class="bui-btn bui-box">
                <div class="thumbnail ring"><img src="images/demo/xiaowaji.jpg" alt=""></div>
                <div class="span1">
                    <h3 class="item-title">${name}</h3>
                    <p class="item-text">编码：562484</p>
                </div>
            </li>
        </ul>
        <ul class="bui-list contact-list">
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">维护人员</label>
                <div class="span1">
                    <div class="bui-value">${number}人</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">地区</label>
                <div class="span1">
                    <div class="bui-value">xxxxx</div>
                </div>
            </li>
            <li class="bui-btn bui-box clearactive">
                <label class="bui-label">所属工程</label>
                <div class="span1">
                    <div class="bui-value">asdasdsad</div>
                </div>
            </li>
        </ul>

        <%--弹出框--%>
        <div class="container-xy" id="btnTop">
            <a href="#">
                <div class="bui-btn round primary">
                    进行维护
                </div>
            </a>
        </div>

    </main>

</div>
</main>
</div>

<!-- 自定义弹出菜单结构	 -->
<div id="actionsheet" class="bui-actionsheet actionsheet-custom" style="display: none">
    <ul class="bui-nav-icon bui-fluid-4">
        <li class="bui-btn" onclick="to('/equipment_phone_slist');">
            <i class="icon"><img src="images/icon_see.png" alt=""></i>维护人员
        </li>
        <li class="bui-btn" onclick="to('/equipment_phone_rlist');">
            <i class="icon"><img src="images/icon_see.png" alt=""></i>维护记录
        </li>
        <li class="bui-btn" onclick="tomyrlist();">
            <i class="icon"><img src="images/icon_see.png" alt=""></i>我的记录
        </li>
    </ul>
</div>


<script>

    function to(url) {
        window.location.href = url+"?oid=${oid}";
    }


    function tomyrlist() {
        // 发送ajax校验登陆状态与权限
        $.post("/equipment_phone_myrlist_verification",
            {oid: ${oid}},
            function (data, status) {
                if (data == 3) {//0-无，1-有，3-未登录
                    bui.confirm("您还未登录，是否去登录", function (e) {
                        //this 是指点击的按钮
                        var text = $(e.target).text();

                        if (text == "确定") {
                            window.location.href = "/phonePage_login_login";
                        }
                        this.close()
                    });
                }else if(data == 1 || data == 0) {//无以前可能有权限
                    window.location.href = "/equipment_phone_myrlist?oid=${oid}"
                }
            });


    }


    bui.ready(function () {
        // 快速初始化 1.5.2 新增 data参数 动态渲染

        var uiSlide = bui.slide({
            id: "#slide",
            height: 380,
            autopage: true,
            data: [{
                image: "images/demo/wajueji.jpg",
                url: "#",
            }, {
                image: "images/demo/wajueji.jpg",
                url: "#",
            }, {
                image: "images/demo/wajueji.jpg",
                url: "#",
            }],
            loop: true,
        })


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


        // 文字提醒
        $('#btnTop').on("click", function () {
            // 发送ajax校验登陆状态与权限
            $.post("/equipment_phone_myrlist_verification",
                {oid: ${oid}},
                function (data, status) {
                    if (data == 3) {//0-无，1-有，3-未登录
                        bui.confirm("您还未登录，是否去登录", function (e) {
                            //this 是指点击的按钮
                            var text = $(e.target).text();

                            if (text == "确定") {
                                window.location.href = "/phonePage_login_login";
                            }
                            this.close()
                        });
                    }else if(data == 0) {
                        bui.confirm("您没有该设备的维护权限，是否申请维护权限？", function (e) {
                            //this 是指点击的按钮
                            var text = $(e.target).text();

                            if (text == "确定") {
                                bui.alert("已申请");
                            }
                            this.close()
                        });
                    }else if(data == 1) {
                        window.location.href = "/phonePage_equipment_weihu?oid=${oid}"
                    }
                });



        })
    })
</script>
</body>
</html>
