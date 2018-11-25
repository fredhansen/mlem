$(document).ready(function () {

    $("#categoryChange").submit(function (event) {
        event.preventDefault();
        ajaxPostCategory();
    })
});

function ajaxPostCategory(){
    var formData = {
        name : $("#cat_name").val()
    };
    console.log(formData);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url : window.location + "/update",
        data : JSON.stringify(formData),
        dateType: "html",
        success : function (data) {
            $("#getCategoryStatus").text(data.toString())
        },
        error: function (e){
            $("#getCategoryStatus").text("Return data is null! => Error")
        }
    });
}