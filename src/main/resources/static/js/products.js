
function vacuumPouches() {
    var elements1 = document.getElementsByClassName("vac_pouc"); //Elements which will be shown to user
    var elements2 = document.getElementsByClassName("plastic_bag"); //Elements which will be hidden
    var elements3 = document.getElementsByClassName("pack_material"); //Elements which will be hidden

    showLoop(elements1);
    hideLoop(elements2);
    hideLoop(elements3);
}

function plasticBags(){
    var elements1 = document.getElementsByClassName("plastic_bag"); //Elements which will be shown to user
    var elements2 = document.getElementsByClassName("vac_pouc"); //Elements which will be hidden
    var elements3 = document.getElementsByClassName("pack_material"); //Elements which will be hidden

    showLoop(elements1);
    hideLoop(elements2);
    hideLoop(elements3);
}

function packMaterial(){
    var elements1 = document.getElementsByClassName("pack_material"); //Elements which will be shown to user
    var elements2 = document.getElementsByClassName("plastic_bag"); //Elements which will be hidden
    var elements3 = document.getElementsByClassName("vac_pouc"); //Elements which will be hidden

    showLoop(elements1);
    hideLoop(elements2);
    hideLoop(elements3);
}
/*
function hideLoop(elements) {
    for (var i = 0; i < elements.length; i++){
        elements[i].style.display = "none";
    }
}

function showLoop(elements){
    for (var i = 0; i<elements.length; i++){
        elements[i].style.display = "inline-block";
    }
}

*/