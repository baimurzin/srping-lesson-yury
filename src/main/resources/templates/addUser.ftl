<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new user</title>
</head>
<body>
<script src="/js/validationUserFormInput.js"></script>
    <div>
        <legend>Add user</legend>
            <br>
        <fieldset>
            <form onsubmit="return validateUser()" action="/addUser" name="User" method="post">
                <label>Name:
                    <input name="name" type="text">
                    <br>
                    <p id="errName"></p>
                <#if nameError??>
                    ${nameError}
                </#if>
                    <br>
                <label>Age:
                    <input name="age" type="number">
                    <br>
                    <p id="errAge"></p>
                <#if ageError??>
                    ${ageError}
                </#if>
                    <br>
                <input type="submit" value="Add" />
            </form>
        </fieldset>
    </div>
</body>
</html>