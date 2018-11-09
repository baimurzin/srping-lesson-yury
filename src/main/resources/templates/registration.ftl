<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <script src="/js/jQuery.js"></script>
</head>
<body>
<dev>
     <#include "fragments/actionLine.ftl"><br>
</dev>
<fieldset>
    <form action="/registration" method="post" name="registration">
        <br><label>Login</label><br>
            <input name="login" type="text">
            <#if loginError??>
                <b style="color: red">${loginError}</b>
            </#if>
        <br><label>Email</label><br>
            <input name="email" type="text">
            <#if emailError??>
                <b style="color: red">${emailError}</b>
            </#if>
        <br><label>Password</label><br>
            <input name="password" type="password">
            <#if passwordError??>
                <b style="color: red">${passwordError}</b>
            </#if>
        <br><label>Confirm Password</label><br>
            <input name="confirmPassword" type="password">
             <#if confirmPasswordError??>
                <b style="color: red">${confirmPasswordError}</b>
             </#if>
        <br><input type="submit" value="Register">
    </form>
        <#if success??>
            <br><b style="color: green">${success}</b>
        </#if>
        <#if failure??>
            <br><b style="color: red">${failure}</b>
        </#if>
</fieldset>
</body>
</html>