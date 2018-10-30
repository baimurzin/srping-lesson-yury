<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new user</title>
    <script src="/js/jQuery.js"></script>
</head>
<body>
<script src="/js/validationUserFormInput.js"></script>
    <div>
        <legend>Add user</legend>
            <br>
        <fieldset>
            <form onsubmit="return validateUser()" action="/addUser" name="User" method="post">
                <label>Name:
                    <input id="name" name="name" type="text">
                    <br>
                     <#if nameError??>
                        ${nameError}
                    </#if>
                    <p id="errName" style="color: red"></p>
                    <br>
                <label>Age:
                    <input id="age" name="age" type="number">
                    <br>
                     <#if ageError??>
                          ${ageError}
                     </#if>
                    <p id="errAge" style="color: red"></p>
                    <br>
                <input type="submit" value="Add" />
            </form>
        </fieldset>
    </div>
</body>
</html>