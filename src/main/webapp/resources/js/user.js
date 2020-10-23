function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

var user ={
    init: function () {
        var _this = this;
        $('#oneline-post').on('click', function () {
            _this.oneline();
        });
    },
    oneline: function() {
        var data = {
            category: '한줄평',
            title: $('#oneline-input').val(),
            content: $('#oneline-input').val(),
            writer:  window.localStorage.getItem("token"),
            troller: getParameterByName('username')
        };
        if(data.content == "") {
            alert('한줄평을 입력해주세요.');
            return;
        }
        $.ajax({
            type: 'POST',
            url:'/board/insert',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data:JSON.stringify(data)
        }).done(function() {
            $('#oneline-input').val('');
            alert('한줄평이 등록되었습니다.');
            location.href = location.href;
        }).fail(function(err) {
            alert("오류가 발생하였습니다.(로그인 필요)");
        })
    }
}

user.init();

function timeForToday(value) {
    const today = new Date();
    const timeValue = new Date(value);

    const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);
    if (betweenTime < 1) return '방금전';
    if (betweenTime < 60) {
        return `${betweenTime}분전`;
    }

    const betweenTimeHour = Math.floor(betweenTime / 60);
    if (betweenTimeHour < 24) {
        return `${betweenTimeHour}시간전`;
    }

    const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
    if (betweenTimeDay < 365) {
        return `${betweenTimeDay}일전`;
    }

    return `${Math.floor(betweenTimeDay / 365)}년전`;
}

$(".troll-time").each(function(i, e) {
    textValue = $(this).text();
    $(this).text(timeForToday(textValue));
})