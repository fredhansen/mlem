var osNames = ["Windows", "Mac OS X", "Android", "Linux", "iOS", "Other"];
var osSet = [
    {
        label: "OS",
        backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850", "#64CD3D"],
        data: [2478,5267,734,784,433,3333] /*todo andmed siia*/
    }
];

var osChart = new Chart(document.getElementById("osChart"), {
    type: 'polarArea',
    data: {
        labels: osNames,
        datasets: osSet
    },
    options: {
        title: {
            display: true,
            text: 'OS'
        }
    }
});
