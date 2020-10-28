var stock = {
    init: function () {
        var _this = this;

        $(document).on('click', '#btn-saveStock', function () {
            _this.saveStock();
        });
        $(document).on('click', '#btn-classification', function () {
            _this.classificationSet($(this).attr('value'));
        });
        $(document).on('click', '#stockList tr', function () {
            _this.read($(this));
        });
    },

    saveStock: function () {
        var data = {
            client: $('#client').val(),
            classification: $('#classification').val(),
            modelName: $('#modelName').val(),
            price: $('#price').val(),
            site: $('#site').val(),
            itemNumber: $('#itemNumber').val(),
            user: $('#user').val(),
            supplyPrice: $('#supplyPrice').val(),
            vendor: $('#vendor').val(),
            memo: $('#memo').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/stock/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('재고가 저장되었습니다.');
            window.location.reload();
        }).fail(function () {
            alert(JSON.stringify(error));
        });
    },

    classificationSet: function (classification) {
        var company = $('#company').val();
        window.location.href = '/stock/' + company + '/' + classification;
    },

    read: function (tr) {
        var td = tr.children();

        var id = td.eq(0).text();

        if(id !== '번호') {
            window.location.href = '/stock/read/' + id;
        }
    }
}

stock.init();