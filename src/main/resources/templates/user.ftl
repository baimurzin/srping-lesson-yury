<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello!</title>
</head>
<body>


<h2 class="hello-title">Hello ${name}!</h2>

<h3> Age: ${user.age}</h3>
<div>name user: ${user.name}</div>


<br><br><br>
<tr></tr>


<table border="1">
<#--//table row-->
    <tr>
    <#--//table heading-->
        <th>Age</th>
        <th>Name</th>
    </tr>


<#list users as u>
    <tr>
        <td>${u.age}</td>
        <td>${u.name}</td>
    </tr>
</#list>


</table>


</body>
</html>