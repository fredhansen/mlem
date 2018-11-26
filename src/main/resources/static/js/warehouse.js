$(document).ready(function () {

    $("a.deleteHREF").on("click", function (event) {
        event.preventDefault();
        var a_href = $(this).attr("href");
        ajaxDelete(a_href);
    });
});

function ajaxDelete(clicked){
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
