function loadDoc(location) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("viewer").innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", location, true);
  xhttp.send();
}