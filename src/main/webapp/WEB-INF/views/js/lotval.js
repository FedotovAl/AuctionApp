"use strict"

document.addEventListener('DOMContentLoaded', () => {
	const form = document.querySelector("form");

	const regExpDate = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))/;

	var minDate = new Date(new Date().setDate(new Date().getDate() + 2));
	var dd = String(minDate.getDate()).padStart(2, '0');
	var mm = String(minDate.getMonth() + 1).padStart(2, '0'); //January is 0!
	var yyyy = minDate.getFullYear();
	minDate = yyyy + '-' + mm + '-' + dd;
	document.getElementById("date").min = minDate;

	var maxDate = new Date(new Date().setDate(new Date().getDate() + 30));
	dd = String(maxDate.getDate()).padStart(2, '0');
	mm = String(maxDate.getMonth() + 1).padStart(2, '0'); //January is 0!
	yyyy = maxDate.getFullYear();
	maxDate = yyyy + '-' + mm + '-' + dd;
	document.getElementById("date").max = maxDate;


	console.log(document.getElementById("date"));

	let errors = 0;

	function isInt(n){
    	return Number(n) === n && n % 1 === 0;
	}

	function isFloat(n){
    	return Number(n) === n && n % 1 !== 0;
	}

	const compl = () => {
		alert("Lot created!");
	}

	const validateElem = (elem) => {
		
		if (elem.name === "startPrice"){
			if (elem.value !==""){
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
				if (!isInt(Number(elem.value)) && !isFloat(Number(elem.value))){
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					elem.nextElementSibling.textContent = "Not a number";
					errors++;
					console.log("error");
				}
				
				if (Number(elem.value) < 0.1){
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					elem.nextElementSibling.textContent = "price must be >= 0.1";
					errors++;
					console.log("error");
				}
				

			} else {
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
			}
		}
		if (elem.name === "bidInc"){
			if (elem.value !==""){
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
				if (!isInt(Number(elem.value)) && !isFloat(Number(elem.value))){
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					elem.nextElementSibling.textContent = "Not a number";
					errors++;
					console.log("error");
				}
				
				if (Number(elem.value) < 0.1){
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					elem.nextElementSibling.textContent = "bid inc >= 0.1";
					errors++;
					console.log("error");
				}
			} else {
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
			}
		}


		if (elem.name === "stopDate"){
			console.log(elem.value);
			if (elem.value !==""){
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";

			} else {
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
			}
		}

	}


	for (let elem of form.elements){
		if (elem.tagName !== "BUTTON"){
			elem.addEventListener("blur", () =>{
				validateElem(elem);
			});
		}
	}

	form.addEventListener("submit", (even) => {
		even.preventDefault();
		errors = 0;

		for (let elem of form.elements){
			validateElem(elem);
			console.log(errors);
			if (elem.tagName !== "BUTTON" && elem.tagname !== "DIV"
				&& 
				(elem.id === "price" || elem.id === "inc" || elem.id === "date")
			){
				if (elem.value === ""){
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					elem.nextElementSibling.textContent = "Field is empty";
					errors++;

				}
			}
		}
		if (errors === 0){
			//compl();
			form.submit();
			form.reset();
		}
	})
})