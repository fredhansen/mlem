
var map = L.map('map').setView([51.505, -0.09], 13);
L.tileLayer('https://api.mapbox.com/styles/v1/mlem/cjm9g1htl3vos2sqp7n422ewn.html?fresh=true&title=true&access_token=pk.eyJ1IjoibWxlbSIsImEiOiJjam05ZDZ1eGEwdnk3M3dsa2RqMjM4azQ2In0.quEXab3D04cgEUBQURS8tw#12.0/48.866500/2.317600/0', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox.streets',
    accessToken: 'pk.eyJ1IjoibWxlbSIsImEiOiJjam05ZDg1ejIwNGtzM3ZsaHBiamRoN2ZjIn0.4Ep6XVwHcsASywUkecPWIw'
}).addTo(map);

L.marker([51.5, -0.09]).addTo(map)
    .bindPopup('WG')
    .openPopup();

// todo see ei tööta, aga oleks parem lahendus