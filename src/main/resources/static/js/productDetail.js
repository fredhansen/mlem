function ajaxPostToCart() {
    var amount = parseInt(document.getElementById('number').value, 10);
    //get the ID from URL
    var id = window.location.pathname.substr(window.location.pathname.lastIndexOf('/') + 1, window.location.pathname.length);
    console.log(amount);
    console.log(window.location.pathname.substr(window.location.pathname.lastIndexOf('/') + 1, window.location.pathname.length));

    $.ajax({
        type: "GET",
        url: "/cart/add/" + id + "/" + amount,

        success: function () {
            console.log("success")
        }
        ,
        error: function (e) {
            console.log("error")

        }

    })
    ;

}


//BUTTONS

function increaseValue() {
    var value = parseInt(document.getElementById('number').value, 10);
    value = isNaN(value) ? 0 : value;
    value++;
    document.getElementById('number').value = value;
}

function decreaseValue() {
    var value = parseInt(document.getElementById('number').value, 10);
    value = isNaN(value) ? 0 : value;
    value < 1 ? value = 1 : '';
    value--;
    document.getElementById('number').value = value;
};