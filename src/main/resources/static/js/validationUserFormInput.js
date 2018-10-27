function validateUser() {
    var name = document.forms["User"]["name"].value;
    var age = document.forms["User"]["age"].value;

    var input1 = false;
    var input2 = false;
    var textErr;

    if (name.length < 1 || name.length > 64){
        textErr = "Имя не долно быть пустым или превышать длину в 64 символа";
        document.getElementById("errName").innerHTML = textErr;
    }else {
        document.getElementById("errName").innerHTML = "";
        input1 = true;
    }

    if (age == null || age < 18 || age > 60){
        if (age == null){
            textErr = "Заполните возраст.";
            document.getElementById("errAge").innerHTML = textErr;
        }else {
            textErr = "Возраст не может быть меньше 18 и больше 60";
            document.getElementById("errAge").innerHTML = textErr;
        }
    }else {
        document.getElementById("errName").innerHTML = "";
        input2 = true;
    }

    if (input1 && input2){
        return true;
    }else {
        return false;
    }
}

$(document).ready(function () {
    $("#name").focusout(function () {
        var name = $("#name").val();
        if (name.length > 0){
            $.ajax({
                type: "POST",
                url: "/check",
                data: "name=" + name,
                dataType: 'json',
                success: function (result) {
                    if (result.status === "Done") {
                        if (result.data==="true") {
                            $("#errName").text("Пользователь с таким именем уже существует.");
                        } else {
                            $("#errName").text("");
                        }
                    } else {
                        $("#errName").text(result.data);
                    }
                }
            });
        }
    })
});
