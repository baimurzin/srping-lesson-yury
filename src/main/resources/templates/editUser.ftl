<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
</head>
<body>
<script src="/js/validationUserFormInput.js"></script>
<div>
    <legend>Edit user</legend>
    <br>
    <fieldset>
        <form onsubmit="return validateUser()" action="/editUser" name="User" method="post">
                <#include "fragments/formUserInput.ftl">
                <input type="hidden" name="id" value="${User.id}">
                <input type="submit" value="Edit" />
        </form>
    </fieldset>
</div>
<div>
    <a href="/logout">Logout</a>
</div>
</body>
</html>