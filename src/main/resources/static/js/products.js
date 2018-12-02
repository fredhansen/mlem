$(document).ready(function() {
    $("#categorySelect").dblclick(function(event) {
        event.preventDefault();
        ajaxGetCategory()
    });
    $("#addButton").click(function(event) {
        event.preventDefault();
        ajaxPostImage()
    });
    $("#categoryAdd").submit(function(event2) {
        event2.preventDefault();
        ajaxPostCategory()
    })
});

function ajaxPostImage() {
    var form = $("#uploadForm")[0];
    var data = new FormData(form);
    $.ajax({
        type: "POST",
        enctype: "multipart/form-data",
        url: "/products/add/image/save",
        data: data,
        processData: !1,
        contentType: !1,
        cache: !1,
        timeout: 1000000,
        success: function(data) {
            ajaxPostProduct(data)
        }
    })
}

function ajaxPostProduct(imageName) {
    var formData = {
        name: $("#name").val(),
        tag: $("#tag").val(),
        description: $("#description").val(),
        categoryId: $("#categorySelect option:selected").val(),
        price: $("#price").val(),
        amount: $("#amount").val(),
        image: imageName
    };
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/products/add/save",
        data: JSON.stringify(formData),
        dataType: 'html',
        success: function(data) {
            $("#getAddingStatus").text(data.trim());
            console.log(data)
        },
        error: function(e) {
            alert("Error!");
            console.log("ERROR: ", e)
        }
    });
    resetDataProduct()
}

function resetDataProduct() {
    $("#name").val(""), $("#tag").val(""), $("#description").val(""), $("#price").val(""), $("#amount").val(""), $("#image").val("")
}

function resetDataCategory() {
    $("#cat.name").val("");
    $("#cat.desc").val("")
}

function ajaxPostCategory() {
    var formData = {
        name: $("#cat_name").val(),
        descritpion: $("#cat_desc").val()
    };
    console.log(formData);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/products/add/category/save",
        data: JSON.stringify(formData),
        dateType: 'html',
        success: function(data) {
            console.log(data);
            $("#getCategoryStatus").text(JSON.stringify(data))
        },
        error: function(e) {
            $("#getCategoryStatus").
            text("Return data is null! => Error")
        }
    });
    resetDataCategory()
}

function ajaxGetCategory() {
    $.ajax({
        type: 'GET',
        url: "/products/add/category/show",
        success: function(data) {
            $("#categorySelect").empty();
            for (item in data) {
                $("#categorySelect").append($("<option>", {
                    value: data[item].id,
                    text: data[item].name
                }))
            }
        },
        error: function(e) {
            alert("Error " + JSON.stringify(e))
        }
    })
}