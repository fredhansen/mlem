$(document).ready(function () {

    $("#delete").on("click", function (event) {
        event.preventDefault();
        var a_href = $(this).attr("href");
        ajaxDeleteProduct(a_href);
    })

});

function ajaxDeleteProduct(clicked){
    //Prepare form data

    //DO POST
    //Send String data
    $.ajax({
        type : "POST",
        url : clicked ,
        success : function(data){
            console.log(data)
        },
        error : function (e) {
            alert("Error!");
            console.log("ERROR: ",e);
        }
    });
}