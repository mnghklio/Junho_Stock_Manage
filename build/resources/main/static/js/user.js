var user = {
    init: function () {
        var _this = this;

        $(document).on('click', '#btn-signup', function () {
            _this.signup();
        });
    },

    signup: function () {
        var data = {
            email: $('#email').val(),
            password: $('#password').val(),
            name: $('#name').val(),
            auth: "user"
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/user/signup',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert(data.name + "님 환영합니다. 로그인 페이지로 이동합니다.");
            window.location.href = '/login';
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    }
}

user.init();