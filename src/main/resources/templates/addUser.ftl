<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new user</title>
</head>
<body>
    <div>
        <legend>Add user</legend>
            <br>

        <fieldset>
            <form action="/addUser" name="User" method="post">
                <label>Name:
                    <input name="name" type="text">
                    <br>
                <#if nameError??>
                    ${nameError}
                </#if>
                    <br>
                <label>Age:
                    <input name="age" type="number">
                    <br>
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