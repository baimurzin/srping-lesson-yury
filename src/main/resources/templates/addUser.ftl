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
            <form onsubmit="validateUser()" action="/addUser" name="User" method="post">
                <label>Name:
                    <input id="name" name="name" type="text">
                    <br>
                    <p id="errName" style="color: red"></p>
                <#if nameError??>
                    ${nameError}
                </#if>
                    <br>
                <label>Age:
                    <input id="age" name="age" type="number">
                    <br>
                    <p id="errAge" style="color: red"></p>
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