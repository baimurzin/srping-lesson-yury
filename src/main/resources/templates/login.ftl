<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="/js/jQuery.js"></script>
</head>
<body>
    <fieldset>
        <form id="login" action="/login" method="post">
            <label>Login</label><br>
                <input name="login" id="login" type="text">
            <br><label>Password</label><br>
                <input name="password" id="password" type="password">
            <br><input type="submit" value="login">
        </form>
    </fieldset>
</body>
</html>