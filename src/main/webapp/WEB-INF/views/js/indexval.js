"use strict"

document.addEventListener('DOMContentLoaded', () => {

let lots = document.querySelectorAll(".lots_item");

function isInt(n){
    	return Number(n) === n && n % 1 === 0;
	}

function isFloat(n){
   	return Number(n) === n && n % 1 !== 0;
}

for (let i = 0; i < lots.length; i++){
	
	let errors = 0;
	let elem = lots[i].querySelector(".bid__field");
	console.log(elem);
	let er = lots[i].querySelector(".errorind");
	console.log(er);
	let price = lots[i].querySelector("._pr").innerHTML;
	console.log(price);
	let inc = lots[i].querySelector("._inc").innerHTML;
	console.log(inc);
	let offer = lots[i].querySelector("._offer").innerHTML;
	console.log(offer);
	let form = lots[i].querySelector(".lot__item__form");
	console.log(form);




	const compl = () => {
		alert("Bid created!");
	}

	const validateElem = (elem) => {
		console.log(elem);
		if (elem.value !== ""){
			elem.style.border = "1px solid black";
				er.textContent = "";
			if (!isInt(Number(elem.value)) && !isFloat(Number(elem.value))){
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					er.textContent = "Not a number";
					errors++;
					console.log("error");
			} else if(elem.value < 0){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					er.textContent = "Bid < 0";
					errors++;
					console.log("error");
			} else if (offer === "" && (Number(price) > elem.value)){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					er.textContent = "Bid < start_price";
					errors++;
					console.log("error");
			} else if (offer !=="" && Number(offer) + Number(inc) > elem.value){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					er.textContent = "Bid < best_offer + bid_inc";
					errors++;
					console.log("error");
			}

		} else {
				er.textContent = "";
				elem.style.border = "1px solid black";
		}
	}
	


	if (elem !== null) {
		elem.addEventListener("blur", () => {
			validateElem(elem);
		});
	}


	if(form !== null) {
		form.addEventListener("submit", (even) => {
			even.preventDefault();
			errors = 0;


			validateElem(elem);

			if (elem.value === "") {
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
				er.textContent = "Field is empty";
				errors++;
				console.log("error");

			}

			console.log(errors);
			if (errors === 0) {
				//compl();
				form.submit();
				form.reset();
			}
		})
	}
}
})




