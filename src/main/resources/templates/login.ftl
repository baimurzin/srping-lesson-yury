<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="/js/jQuery.js"></script>
</head>
<body>
    <dev>
         <#include "fragments/actionLine.ftl"><br>
    </dev>
    <fieldset>
        <form id="login" action="/login" method="post">
            <label>Login</label><br>
                <input name="username" id="login" type="text">
            <br><label>Password</label><br>
                <input name="password" id="password" type="password">
            <br><input type="submit" value="login">
        </form>
    </fieldset>
</body>
</html>