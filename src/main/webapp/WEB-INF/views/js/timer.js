"use strict"

document.addEventListener('DOMContentLoaded', () => {

function cicle(){
	let items = document.querySelectorAll(".lots_item");

	for (let i = 0; i < items.length; i++){
		let d = Date.parse(items[i].querySelector("._stopdate").innerHTML);
		var myfunc = setInterval(function() {
			var now = new Date().getTime();
			var timeleft = d - now;

			if (timeleft < 0) {
    			// clearInterval(myfunc);
    			items[i].querySelector("._d").innerHTML = "";
    			items[i].querySelector("._h").innerHTML = "";
    			items[i].querySelector("._m").innerHTML = "";
    			items[i].querySelector("._s").innerHTML = "TIME UP!";
    			items[i].querySelector(".lot__item__form").style.display = "none";
			} else {
    
				var days = Math.floor(timeleft / (1000 * 60 * 60 * 24));
				var hours = Math.floor((timeleft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
				var minutes = Math.floor((timeleft % (1000 * 60 * 60)) / (1000 * 60));
				var seconds = Math.floor((timeleft % (1000 * 60)) / 1000);


				items[i].querySelector("._d").innerHTML = days + "d ";
				items[i].querySelector("._h").innerHTML = hours + "h ";
				items[i].querySelector("._m").innerHTML = minutes + "m ";
				items[i].querySelector("._s").innerHTML = seconds + "s";
			}

			items = document.querySelectorAll(".lots_item");
		}, 100)

	}
}
	
cicle();
})