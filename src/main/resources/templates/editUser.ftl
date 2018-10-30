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
            <label>New name:
                <input name="name" type="text" value="${User.name}">
                <br>
                <#if nameError??>
                     ${nameError}
                </#if>
                <p id="errName" style="color: red"></p>
                <br>
            <label>New age:
                <input name="age" type="number" value="${User.age}">
                    <br>
                    <#if ageError??>
                        ${ageError}
                    </#if>
                    <p id="errAge" style="color: red"></p>
                <br>
                <input type="hidden" name="id" value="${User.id}">
                <input type="submit" value="Edit" />
        </form>
    </fieldset>
</div>
</body>
</html>