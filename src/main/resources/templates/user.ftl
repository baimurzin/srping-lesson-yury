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
                <td>
                    <a href="user/delete/${u}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
<br><br>
    <a href="addUser">Add new user</a>

</body>
</html>