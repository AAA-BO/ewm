<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>后台管理</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">建筑施工管理系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="images/user.jpg" class="layui-nav-img">
                    ${loginUser.name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/staff_logout">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul id="id_leftNav" class="layui-nav layui-nav-tree" lay-filter="leftNav">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">维护人员</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/page_staff_list">人员管理</a></dd>
                        <dd><a href="/page_staff_relevance">关联设备</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公司设备</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/page_equipment_list">设备管理</a></dd>
                        <dd><a href="/page_equipment_list">设备管理2</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">维护记录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/page_record_list">记录管理</a></dd>
                        <dd><a href="/page_record_list">记录管理2</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding-left: 8px;">
            <div class="layui-tab" lay-allowClose="true" lay-filter="tabs">
                <ul class="layui-tab-title">
                </ul>
                <div class="layui-tab-content">
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com
    </div>
</div>


</div>
<script src="js/jquery.js"></script>
<script src="layui/layui.all.js"></script>

<script>

    // nav tab 的操作
    layui.use('element', function () {
        var innetTabNumber = 0;
        var opedTabArray = new Array();

        var element = layui.element;


        // 为左侧导航栏的a标签添加click事件，取消a标签的跳转功能
        $("#id_leftNav a").click(function () {
            return false;
        });

        // 监听导航栏点击
        element.on('nav(leftNav)', function (elem) {
            console.log(elem); //得到当前点击的DOM对象
            var href = elem.attr("href");

            // 判断是否为导航分类页
            if (href == 'javascript:;') {
                return;
            }

            var text = elem.text();

            //  是否已打开
            var findFlag = opedTabArray.indexOf(text, 0);
            if (findFlag != -1) { // 找到
                element.tabChange("tabs", text);
                return;
            }

            // 添加新tab
            element.tabAdd('tabs', {
                title: text
                , content: ' <iframe width="100%" height="725"  frameborder="0"  scrolling="yes" src="' + href + '"></iframe>' //支持传入html
                , id: text
            });
            // 选中新增的tab
            element.tabChange("tabs", text);
            // 将新增tab id加入 opedTabArray中
            opedTabArray.push(text);
        });


        // 监听tab的删除
        element.on('tabDelete(tabs)', function (data) {
            // tab删除后从opedTabArray中移除其id
            opedTabArray.splice(data.index - innetTabNumber, 1);
        });
    });
</script>
</body>
</html>