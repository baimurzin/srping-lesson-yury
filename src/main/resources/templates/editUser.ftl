<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new user</title>
</head>
<body>
<div>
    <legend>Edit user</legend>
    <br>

    <fieldset>
        <form action="/editUser" name="User" method="post">
            <label>Name:
                <input name="name" type="text" value="${User.name}">
                <br>
                <#if nameError??>
                    ${nameError}
                </#if>
                <br>
                <label>Age:
                    <input name="age" type="number" value="${User.age}">
                    <br>
                <#if ageError??>
                    ${ageError}
                </#if>
                    <br>
                    <input type="hidden" name="id" value="${id}">
                <input type="submit" value="Edit" />
        </form>
    </fieldset>

</div>
</body>
</html>