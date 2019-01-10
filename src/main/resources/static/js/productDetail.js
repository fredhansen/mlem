function ajaxPostToCart() {
    // Get the snackbar DIV
    var x = document.getElementById("snackbar");

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

    // Add the "show" class to DIV
    x.className = "show";

    // After 3 seconds, remove the show class from DIV
    setTimeout(function () {
        x.className = x.className.replace("show", "");
    }, 3000);

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

//GALLERY

function myFunction(imgs) {
    // Get the expanded image
    var expandImg = document.getElementById("expandedImg");
    // Get the image text
    var imgText = document.getElementById("imgtext");
    // Use the same src in the expanded image as the image being clicked on from the grid
    expandImg.src = imgs.src;
    // Use the value of the alt attribute of the clickable image as text inside the expanded image
    imgText.innerHTML = imgs.alt;
    // Show the container element (hidden with CSS)
    expandImg.parentElement.style.display = "block";
}