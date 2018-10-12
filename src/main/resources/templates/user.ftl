<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello!</title>
</head>
<body>

<br><br>
<tr></tr>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <#list users as u>
            <tr>
                <td>${u.name}</td>
                <td>${u.age}</td>
                    <form name="deleteUser" action="/user/delete/" method="post">
                        <td><button name="delete" onclick="location.href'/user/delete/'${u}">delete</button> </td>
                    </form>
                    <form name="deleteUser" action="/user/delete/" method="post">
                        <td>
                            <input type="submit" value="${u}">
                            <input type="hidden" name="name" value="${u.name}">
                            <input type="hidden" name="age" value="${u.age}">
                        </td>
                    </form>
            </tr>
        </#list>
    </table>
<br><br>
    <a href="addUser">Add new user</a>

</body>
</html>