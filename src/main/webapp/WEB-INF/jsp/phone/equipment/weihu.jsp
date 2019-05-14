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

<style>
    .container-box {
        background: #fff;
    }
    input {
        text-align: right;
    }
</style>
<div class="bui-page page-feedback">
    <header class="bui-bar">
        <div class="bui-bar-left bui-bar-text">
            <a class="bui-btn" onclick="bui.back();"><i class="icon-back"></i>返回</a>
        </div>
        <div class="bui-bar-main">维护信息</div>
        <div class="bui-bar-right">

        </div>
    </header>
    <main>
        <form id="form">
            <input type="hidden" name="equipment.oid" value="${param.oid}"/>
            <s:iterator value="#request.mubanLlist" var="mubanitem">
                <s:if test="filedType=='文本框'">
                    <ul class="bui-list">
                        <li class="bui-btn bui-box clearactive">
                            <label class="bui-label">${filedName}</label>
                            <div class="span1">
                                <div class="bui-input user-input">
                                    <input name="${filedName}" type="text" class="bui-input" placeholder="请输入相关数据">
                                </div>
                            </div>
                        </li>
                    </ul>
                </s:if>
                <s:elseif test="filedType=='文本域'">
                    <div class="section-title">${filedName}</div>
                    <div class="bui-input">
                        <textarea name="${filedName}" placeholder="请输入相关数据" cols="20" rows="8"></textarea>
                    </div>
                </s:elseif>
                <s:elseif test="filedType=='数字'">
                    <ul class="bui-list">
                        <li class="bui-btn bui-box clearactive">
                            <label class="bui-label">${filedName}</label>
                            <div class="span1">
                                <div class="bui-input user-input">
                                    <input name="${filedName}" type="number" class="bui-input">
                                </div>
                            </div>
                        </li>
                    </ul>
                </s:elseif>
                <s:elseif test="filedType=='日期时间'">
                    <ul class="bui-list bui-select-form">
                        <li class="bui-btn bui-box">
                            <label>${filedName}</label>
                            <div class="span1"><input  type="text" id="date_${oid}" readonly
                                                      class="bui-input timeInput" name="${filedName}"></div>
                            <i class="icon-listright"></i>
                        </li>
                    </ul>
                    <script>
                        bui.ready(function () {
                            var input = $("#date_${oid}");
                            var uiPickerdate = bui.pickerdate({
                                handle: "#date_${oid}",
                                formatValue: "yyyy-MM-dd hh:mm:ss",
                                onChange: function (value) {
                                    input.val(value);
                                }
                            });
                        });
                    </script>
                </s:elseif>
                <s:elseif test="filedType=='下拉列表'">
                    <div class="section-title">${filedName}</div>
                    <ul class="bui-list">
                        <s:iterator value="filedItem.split('\\\\|')" id="thums">
                            <li class="bui-btn bui-box">
                                <div class="span1"><label for="${oid}_${thums}">${thums}</label></div>
                                <input id="${oid}_${thums}" type="radio" class="bui-choose" name="${filedName}"
                                       value="${thums}"></li>
                        </s:iterator>
                    </ul>
                </s:elseif>
                <s:elseif test="filedType=='单选按钮'">
                    <div class="section-title">${filedName}</div>
                    <ul class="bui-list">
                        <s:iterator value="filedItem.split('\\\\|')" id="thums">
                            <li class="bui-btn bui-box">
                                <div class="span1"><label for="${oid}_${thums}">${thums}</label></div>
                                <input id="${oid}_${thums}" type="radio" class="bui-choose" name="${filedName}"
                                       value="${thums}"></li>
                        </s:iterator>
                    </ul>
                </s:elseif>
                <s:elseif test="filedType=='复选框'">
                    <div class="section-title">${filedName}</div>
                    <div class="bui-fluid-space-3">
                        <s:iterator value="filedItem.split('\\\\|')" id="thums">
                            <div class="span1">
                                <input type="checkbox" class="bui-check" name="${filedName}[${thums}]" check="${thums}" uncheck="${thums}">
                            </div>
                        </s:iterator>
                    </div>
                    <div class="section-title"></div>
                </s:elseif>
            </s:iterator>

            <div class="section-title">概要信息</div>
            <div class="bui-input">
                <textarea name="info" placeholder="请填写概要信息" cols="20" rows="8"></textarea>
            </div>

            <div class="container-xy">
                <div class="bui-btn primary round" onclick="commit();">提交</div>
            </div>
        </form>
    </main>
</div>
<script>
    bui.ready(function () {
    })
    function commit() {
        $.post("/record_phone_weihu",
            $("#form").serialize(),
            function (data, status) {
                if (data == 1) {
                    bui.alert("添加成功");
                }else if (data == 2) {
                    bui.confirm("您还未登录，是否去登录", function (e) {
                        var text = $(e.target).text();
                        if (text == "确定") {
                            window.location.href = "/phonePage_login_login";
                        }
                        this.close()
                    });
                }
            });
        return false;
    }
</script>
</body>
</html>