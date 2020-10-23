window.onload = function(){
    if(window.localStorage.getItem("token") !== null) {
        $.ajax({
            type: 'GET',
            url:`/auth/check?token=${window.localStorage.getItem("token")}`,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function(data) {
            $('#login-button').css("display", "none");
            $('#header-username').text(data.username + " 님 환영합니다.");
        }).fail(function(err) {
        })
    }
};