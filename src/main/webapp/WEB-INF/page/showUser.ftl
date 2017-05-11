
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息列表</title>
</head>
<body>
    <#if (userList)??>
        <#list userList as vo>
            姓名：${vo.name} &nbsp;&nbsp;手机号：${vo.phone} &nbsp;&nbsp;邮箱：${vo.address} &nbsp;&nbsp;<br>
        </#list>
    </#if>
</body>
</html>
