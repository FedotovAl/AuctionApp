"use strict"

document.addEventListener('DOMContentLoaded', () => {
	const form = document.querySelector("form");
	let errors = 0;
	

	const compl = () => {
		alert("Login completed!");
	}

	const validateElem = (elem) => {
		
		if (elem.name === "login"){
			elem.nextElementSibling.textContent = "";
			elem.style.border = "1px solid black";
		}
		if (elem.name === "password"){
			elem.nextElementSibling.textContent = "";
			elem.style.border = "1px solid black";
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
			if (elem.tagName !== "BUTTON" && elem.tagName !== "DIV"){
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