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
                <#include "fragments/formUserInput.ftl">
                <input type="submit" value="Add" />
            </form>
        </fieldset>
    </div>
    <div>
        <a href="/logout">Logout</a>
    </div>
</body>
</html>