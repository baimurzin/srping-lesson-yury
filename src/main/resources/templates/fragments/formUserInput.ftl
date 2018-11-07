<label>New name:
    <input name="name" type="text" value=<#if User??>"${User.name}"</#if>>
    <br>
                <#if nameError??>
                    ${nameError}
                </#if>
    <p id="errName" style="color: red"></p>
    <br>
    <label>New age:
        <input name="age" type="number" value=<#if User??>"${User.age}"</#if>>
        <br>
                    <#if ageError??>
                        ${ageError}
                    </#if>
        <p id="errAge" style="color: red"></p>
        <br>