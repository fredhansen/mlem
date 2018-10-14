document.addEventListener("DOMContentLoaded", function () {
    loadXMLDoc("/api/stats/os", 'oschart', 'OS');
    loadXMLDoc("/api/stats/browser", 'browserchart', 'Browser');
    loadXMLDoc("/api/stats/device", "devicechart",'Device')// see kutsub andmed välja
});

function loadXMLDoc(path,  div, label) { //  see uuendab
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //addData(chart, div, JSON.parse(xhttp.responseText)); // todo see vist vale
            console.log(JSON.parse(xhttp.responseText));

            var array = JSON.parse(xhttp.responseText);
            var indeks;
            var labels =[];
            var number = [];
            for (indeks = 0; indeks < array.length ; indeks++){
                if (array[indeks] === ""){
                    continue;
                }
                var osTemp = array[indeks];
                labels.push(osTemp[0]);
                number.push(osTemp[1]);
            }
            console.log(labels);
            console.log(number);
            var chart = new Chart(document.getElementById(div), { // see genereerib esialgse
                type: 'polarArea',
                data: {
                    labels: labels,
                    datasets: [
                        {
                            label: label,
                            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850", "#64CD3D"],
                            data: number /*todo andmed siia*/
                        }
                    ]
                },
                options: {
                    title: {
                        display: true,
                        text: label
                    }
                }
            });
        }
    };
    xhttp.open("GET", path, true);
    xhttp.send();
}
