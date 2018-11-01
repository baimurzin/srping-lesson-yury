<label>New name:
    <input name="name" type="text" value="${User.name}">
    <br>
                <#if nameError??>
                    ${nameError}
                </#if>
    <p id="errName" style="color: red"></p>
    <br>
    <label>New age:
        <input name="age" type="number" value="${User.age}">
        <br>
                    <#if ageError??>
                        ${ageError}
                    </#if>
        <p id="errAge" style="color: red"></p>
        <br>