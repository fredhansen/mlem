$(document).ready(function () {

    $("#categorySelect").dblclick(function (event) {
        event.preventDefault();
        ajaxGetCategory();
    });
    //Product add form
    $("#addButton").click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostImage();
    });

    $("#categoryAdd").submit(function (event2) {
        event2.preventDefault();
        ajaxPostCategory();
    })
});

// var imageName = undefined;

function ajaxPostImage() {
    var form = $("#uploadForm")[0];

    var data = new FormData(form);

    $.ajax({
        type : "POST",
        enctype : "multipart/form-data",
        url: window.location + '/image/save',
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 1000000,

        success: function (data) {
            // imageName = data;
            //$("#getImageStatus").html(data);
            ajaxPostProduct(data);
        }
    })

}


function ajaxPostProduct(imageName){
    //Prepare form data
    var formData = {
        name: $("#name").val(),
        tag: $("#tag").val(),
        description: $("#description").val(),
        categoryId: $("#categorySelect option:selected").val(),
        price: $("#price").val(),
        amount: $("#amount").val(),
        image: imageName
    };

    //DO POST
    //Send String data
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : window.location + "/save",
        data : JSON.stringify(formData),
        dataType : 'html',
        success : function(data){
            $("#getAddingStatus").text(data);
            console.log(data);
        },
        error : function (e) {
            alert("Error!");
            console.log("ERROR: ",e);
        }
    });
    resetDataProduct();
}

function resetDataProduct(){
     $("#name").val(""),
     $("#tag").val(""),
     $("#description").val(""),
     $("#price").val(""),
     $("#amount").val(""),
         $("#image").val("")
}

function resetDataCategory() {
    $("#cat.name").val(""),
    $("#cat.desc").val("")
}

function ajaxPostCategory(){
    var formData = {
        name : $("#cat_name").val(),
        descritpion : $("#cat_desc").val()
    };
    console.log(formData);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url : window.location + "/category/save",
        data : JSON.stringify(formData),
        dateType: "html",
        success : function (data) {
            $("#getCategoryStatus").text(data)
            },
            error: function (e){
                $("#getCategoryStatus").text("Return data is null! => Error")
        }
    });
    resetDataCategory()
}

function ajaxGetCategory(){
    $.ajax({
        type: 'GET',
        url: window.location +'/category/show',
        success : function (data) {
            $("#categorySelect").empty();
            for( item in data){
                $("#categorySelect").append($("<option>", {
                    value: data[item].id,
                    text: data[item].name
                }));

            }
        },
        error : function(e){
            alert("Error "+ JSON.stringify(e))
        }
    })
}