$(document).ready(function () {
    $(".box").click(function () {
        $(this).next().slideToggle("fast");
        $(this).find('i').toggle();
    });

    $("#submitFaq").click(function (event2) {
        event2.preventDefault();
        ajaxPostFAQ()
    });

    $(".remove").click(function () {
        var el = $(this);

        var id = el.parent().children(".fqid").html();
        console.log(id);

        //ajaxRemoveFAQ(id);


    });

});

function ajaxPostFAQ() {
    var formData = {
        engQuestion: $("#faq_eng").val(),
        estQuestion: $("#faq_est").val(),
        engAnswer: $("#faa_eng").val(),
        estAnswer: $("#faa_est").val()
    };
    console.log(formData);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/faq/save",
        data: JSON.stringify(formData),
        dateType: 'html',
        success: function (data) {
            console.log(data);
            console.log(formData);
        },
        error: function (e) {
        }
    });


}

function ajaxRemoveFAQ(id) {
    $.ajax({
        type: "GET",
        url: "/faq/remove" + id,

        success: function () {
            console.log("FAQ removed")
        }
        ,
        error: function (e) {
            console.log("error")

        }

    })
    ;
}

