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
<#--//table row-->
    <tr>
    <#--//table heading-->
        <th>Name</th>
        <th>Age</th>
    </tr>

<#list users as u>
    <tr>
        <td>${u.name}</td>
        <td>${u.age}</td>
    </tr>
</#list>

</table>

<br><br>
    <a href="addUser">Add new user</a>

</body>
</html>