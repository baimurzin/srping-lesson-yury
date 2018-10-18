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
                <p id="errName" style="text-decoration-color: red"></p>
                    <#if nameError??>
                        ${nameError}
                    </#if>
                <br>
            <label>New age:
                <input name="age" type="number" value="${User.age}">
                    <br>
                    <p id="errAge"></p>
                    <#if ageError??>
                        ${ageError}
                    </#if>
                <br>
                <input type="hidden" name="id" value="${User.id}">
                <input type="submit" value="Edit" />
        </form>
    </fieldset>

</div>
</body>
</html>