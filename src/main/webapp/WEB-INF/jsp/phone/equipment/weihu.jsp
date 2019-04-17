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

<style>
    .container-box {
        background: #fff;
    }
</style>
<div class="bui-page page-feedback">
    <header class="bui-bar">
        <div class="bui-bar-left bui-bar-text">
            <a class="bui-btn" onclick="bui.back();"><i class="icon-back"></i>返回</a>
        </div>
        <div class="bui-bar-main">评论</div>
        <div class="bui-bar-right">

        </div>
    </header>
    <main>
        <form id="form">
            <input type="hidden" name="equipment.oid" value="${param.oid}"/>
            <ul class="bui-list">
                <li class="bui-btn clearactive">
                    <div id="feedback" class="bui-input">
                        <textarea name="info" placeholder="请填写你的维护数据" id="" cols="30" rows="10"></textarea>
                    </div>
                </li>
            </ul>
            <div class="container-box">
                <!-- 上传的结构 -->
                <div id="buiPhoto" class="bui-upload bui-fluid-space-4">
                    <div class="span1">
                        <div id="btnUpload" class="bui-btn">
                            <i class="icon-plus large"></i>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-xy">
                <div class="bui-btn primary round" onclick="commit();">提交</div>
            </div>
        </form>
    </main>
</div>
<script>
    function commit() {
        $.post("/record_phone_weihu",
            $("#form").serialize(),
            function (data, status) {
                if (data == 1) {
                    bui.alert("添加成功");

                }
            });
        return false;
    }



    /**
 * 发布评论模块
 * 默认模块名: pages/comment/comment
 * @return {[object]}  [ 返回一个对象 ]
 */
bui.ready(function () {

    var pageview = {};

    // 模块初始化定义
    pageview.init = function () {
        // 长度限制
        var comment = bui.input({
            id: "#feedback",
            target: "textarea",
            showIcon: false,
            maxLength: 500,
            showLength: true
        })

        // 上传初始化
        this.upload();
    }

    // 上传
    pageview.upload = function () {
        // 拍照上传
        var photos = $("#buiPhoto");
        var uiUpload = bui.upload();


        // 上拉菜单 js 初始化:
        var uiActionsheet = bui.actionsheet({
            trigger: "#btnUpload",
            buttons: [{name: "拍照上传", value: "camera"}, {name: "从相册选取", value: "photo"}],
            callback: function (e) {
                var ui = this;
                var val = $(e.target).attr("value");
                switch (val) {
                    case "camera":
                        ui.hide();
                        uiUpload.add({
                            "from": "camera",
                            "onSuccess": function (val, data) {
                                // 展示本地图片
                                this.toBase64({
                                    onSuccess: function (url) {
                                        photos.prepend(templatePhoto(url))

                                    }
                                });

                                // 也可以直接调用start上传图片
                            }
                        })

                        break;
                    case "photo":
                        ui.hide();
                        uiUpload.add({
                            "from": "",
                            "onSuccess": function (val, data) {
                                // 展示本地图片
                                this.toBase64({
                                    onSuccess: function (url) {
                                        photos.prepend(templatePhoto(url))
                                    }
                                });
                                // 也可以直接调用start上传图片
                            }
                        })

                        break;
                    case "cancel":
                        ui.hide();
                        break;
                }
            }
        })

        function templatePhoto(url) {
            return '<div class="span1"> <div class="bui-upload-thumbnail"><img src="${url}" alt="" /></div> </div>';
        }

    }

    // 初始化
    pageview.init();

    // 输出模块
    return pageview;
})
</script>
</body>
</html>