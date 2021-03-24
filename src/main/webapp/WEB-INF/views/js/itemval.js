"use strict"

document.addEventListener('DOMContentLoaded', () => {
	const form = document.querySelector("form");
	let errors = 0;

	const regExpLogin = /^[a-z0-9_-]{3,16}$/;
	const regExpPass = /^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,50}$/;

	const compl = () => {
		alert("Item created!");
	}

	const validateElem = (elem) => {
		
		if (elem.name === "name"){
			if ((elem.value.length < 8 || elem.value.length > 50) && elem.value !==""){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
				elem.nextElementSibling.textContent = "8 - 50 symbols";
				errors++;
				console.log("error");
			} else {
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
			}
		}
		if (elem.name === "description"){
			if ((elem.value.length < 10 || elem.value.length > 255) && elem.value !==""){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
				elem.nextElementSibling.textContent = "10 - 255 symbols";
				errors++;
				console.log("error");
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
			if (elem.tagName !== "BUTTON" && elem.tagname !== "DIV"){
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