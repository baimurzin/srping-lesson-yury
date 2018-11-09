<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List users</title>
</head>
<body>
<dev>
    <#include "fragments/actionLine.ftl"><br>
</dev>
<tr></tr>
<table border="1">
    <tr>
        <th>id</th>
        <th>Login</th>
        <th>Email</th>
        <th>Role</th>
        <th>Active</th>
    </tr>
        <#list listAuthUser as au>
            <tr>
                <td>${au.id}</td>
                <td>${au.login}</td>
                <td>${au.email}</td>
                <td>
            <#list au.roles as role>
                ${role}
            </#list>
                </td>
                <td>${au.active?string("Activated","Diactivated")}</td>
                <form name="deleteUser" action="/deleteAuthUser" method="post">
                    <td>
                        <input type="submit" value="Delete">
                        <input type="hidden" name="id" value="${au.id}">
                    </td>
                </form>
                <form name="activeAuthUser" action="/active" method="post">
                    <td>
                        <input type="submit" value="Activated/Deactivate">
                        <input type="hidden" name="id" value="${au.id}">
                    </td>
                </form>
            </tr>
        </#list>
</table>
</body>
</html>