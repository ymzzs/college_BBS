function ajaxAll() {

    $.ajax({
        type: "POST",
        url: "/LoginServlet?Login=1",
        data: $('#loginForm').serialize(),
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            if(data.checkName === "0")
            {
                document.getElementById("nameWrong").style.display = "";
                document.getElementById("nameCorrect").style.display = "none";
            }
            else
            {
                document.getElementById("nameWrong").style.display = "none";
                document.getElementById("nameCorrect").style.display = "";
                if(data.checkPass === "1")
                {
                    console.log("我登录了");
                    location.reload();
                }
            }

        }
    })
}

function ajaxName() {
    $.ajax({
        type: "POST",
        url: "/LoginServlet?Login=0",
        data: $('#loginForm').serialize(),
        dataType: "json",
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success: function (data) {
            if(data.checkName === "0")
            {
                document.getElementById("nameWrong").style.display = "";
                document.getElementById("nameCorrect").style.display = "none";
            }
            else
            {
                document.getElementById("nameWrong").style.display = "none";
                document.getElementById("nameCorrect").style.display = "";
            }
        }

    })
}
