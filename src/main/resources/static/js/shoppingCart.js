var check = false;
$(document).ready(function () {

    function changeVal(el) {
        var qt = parseFloat(el.parent().children(".qt").html());
        var price = parseFloat(el.parent().children(".unit-price").html());
        var eq = Math.round(price * qt * 100) / 100;

        el.parent().children(".full-price").html(eq + "€");

        changeTotal();
    }

    function changeTotal() {

        var price = 0;

        $(".full-price").each(function (index) {
            price += parseFloat($(".full-price").eq(index).html());
        });

        price = Math.round(price * 100) / 100;
        var tax = 0;//Math.round(price * 0.05 * 100) / 100;

        $(".shipping span").html(0);
        var shipping = parseFloat($(".shipping span").html());
        var fullPrice = Math.round((price + tax + shipping) * 100) / 100;

        if (price === 0) {
            fullPrice = 0;
        }

        $(".subtotal span").html(price);
        $(".total span").html(fullPrice);
    }


    $(".remove").click(function () {
        var el = $(this);

        var id = el.parent().parent().children(".forID").children("#pr-id").html();
        console.log(id);

        ajaxRemoveFromCart(id);

        hideFromCart(el);

        ifEmpty();
    });

    function hideFromCart(el) {
         el.parent().parent().addClass("removed");
         window.setTimeout(
             function () {
                 el.parent().parent().slideUp('fast', function () {
                     el.parent().parent().remove();
                     if ($(".product").length === 0) {
                         $("#cart").html("<h1>Empty</h1>");
                     }
                     changeTotal();
                 });
             }, 200);
    }

    $(".qt-plus").click(function () {
        $(this).parent().children(".qt").html(parseInt($(this).parent().children(".qt").html()) + 1);

        var id = $(this).parent().children("#pr-id").html();
        var amount = parseInt($(this).parent().children(".qt").html());
        //console.log(amount);
        console.log(id);

        ajaxUpdateCart(id, amount);

        $(this).parent().children(".full-price").addClass("added");

        var el = $(this);
        window.setTimeout(function () {
            el.parent().children(".full-price").removeClass("added");
            changeVal(el);
        }, 150);
    });

    $(".qt-minus").click(function () {

        var child = $(this).parent().children(".qt");

        if (parseInt(child.html()) > 1) {
            child.html(parseInt(child.html()) - 1);
        }

        var id = $(this).parent().children("#pr-id").html();
        var amount = parseInt($(this).parent().children(".qt").html());
        //console.log(amount);
        console.log(id);

        ajaxUpdateCart(id, amount);

        $(this).parent().children(".full-price").addClass("minused");

        var el = $(this);
        window.setTimeout(function () {
            el.parent().children(".full-price").removeClass("minused");
            changeVal(el);
        }, 150);
    });

    // for refreshing at the start
    $(".full-price").each(function () {
        var el = $(this);
        console.log(el);
        changeVal(el)
    });

    // updates items in session cart
    function ajaxUpdateCart(id, amount) {
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

    function ajaxRemoveFromCart(id) {
        $.ajax({
            type: "GET",
            url: "/cart/remove/" + id,

            success: function () {
                console.log("item removed")
            }
            ,
            error: function (e) {
                console.log("error")

            }

        })
        ;
    }

    console.log("loaded");

    function ifEmpty() {



    }


    /*// checkout
    $(".btn").click(function () {
        console.log("checkout");
        check = true;

        $(".remove").each(function () {
            console.log("hide");

            hideFromCart($(this));
        });


        //$(".remove").click(); // clicks all the remove buttons
        $(this).hide();//.parent().parent().hide();
        //document.getElementById()


    });*/
});

