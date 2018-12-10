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
        var tax = Math.round(price * 0.05 * 100) / 100
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
        el.parent().parent().addClass("removed");
        window.setTimeout(
            function () {
                el.parent().parent().slideUp('fast', function () {
                    el.parent().parent().remove();
                    if ($(".product").length === 0) {
                        if (check) {
                            $("#cart").html("<h1>---</h1>");
                        } else {
                            $("#cart").html("<h1>Empty</h1>");
                        }
                    }
                    changeTotal();
                });
            }, 200);
    });

    $(".qt-plus").click(function () {
        $(this).parent().children(".qt").html(parseInt($(this).parent().children(".qt").html()) + 1);

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

        $(this).parent().children(".full-price").addClass("minused");

        var el = $(this);
        window.setTimeout(function () {
            el.parent().children(".full-price").removeClass("minused");
            changeVal(el);
        }, 150);
    });
});
$(".btn").click(function () {
    check = true;
    //$(".remove").click();
    $(this).hide();

});