$(document).ready(function () {

    //Product add form
    $("#productAdd").submit(function (event) {
        // Prevent the form from submitting via the browser.

        event.preventDefault();
        ajaxPost();
    })

});

function ajaxPostImage(){

    $.ajax({
        url : window.location+"/save/image",
        type: "POST",
        data: new FormData($("#productAdd")[4]),
        enctype: 'multipart/form-date',
        processData: false,
        contentType: false,
        cache: false,
        success: function (result) {
            $("#image").html(result)
        }
    })
}

function ajaxPost(){
    //Prepare form data
    var formData = {
        name: $("#name").val(),
        tag: $("#tag").val(),
        description: $("#description").val(),
        price: $("#price").val(),
        amount: $("#amount").val(),
        image: $("#image").val()
    };


    //DO POST
    //Send String data
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : window.location + "/save",
        data : JSON.stringify(formData),
        dataType : 'json',
        success : function(result){
            $("#getAddingStatus").html("<p th:text='#{add.ok}'>" +
                "<p> Product name ={" +result.data.name +
                "} tag={ "+ result.data.tag+ " " +
                "} description= {"+result.data.description+
                "} price={" +result.data.price+
                "} amount={"+result.data.amount+"}</p>")
            if (result.status ==="Done"){
                console.log(result);
                $("#getAddingStatus").html("<p th:text='#{add.ok}'>" +
                    "<p> Product name ={" +result.data.name +
                    "} tag={ "+ result.data.tag+ " " +
                    "} description= {"+result.data.description+
                    "} price={" +result.data.price+
                    "} amount={"+result.data.amount+"}</p>")
            }
            else {
                $("#getAddingStatus").html("<strong>Error</strong>")
            }
            console.log(result.status);
        },
        error : function (e) {
            alert("Error!");
            console.log("ERROR: ",e);
        }
    });

    resetData();

}

function resetData(){
     $("#name").val(""),
     $("#tag").val(""),
     $("#description").val(""),
     $("#price").val(""),
     $("#amount").val(""),
         $("#image").val("")
}