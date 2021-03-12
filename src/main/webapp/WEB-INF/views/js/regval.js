"use strict"

document.addEventListener('DOMContentLoaded', () => {
	const form = document.querySelector("form");
	const pass1 = document.getElementById("password1");
	const pass2 = document.getElementById("password2");
	let errors = 0;

	const regExpLogin = /^[A-Za-z0-9_-]{3,16}$/;
	const regExpPass = /^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,50}$/;

	const compl = () => {
		alert("Registration completed!");
	}

	const validateElem = (elem) => {
		console.log(elem.name);
		console.log(elem.value);
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
		if (elem.name === "address"){
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
		if (elem.name === "login"){
			if (!regExpLogin.test(elem.value) && elem.value !== ""){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
				elem.nextElementSibling.textContent = "Incorrect login";

				if (elem.value.length < 3 || elem.value.length > 16){
				 elem.nextElementSibling.textContent = "3 - 16 symbols";
				}
				errors++;
				console.log("error");
			} else {
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
			}
		}
		if (elem.name === "password"){
			if (!regExpPass.test(elem.value) && elem.value !== ""){
				elem.style.border = "1px solid rgba(181, 39, 40, 1)";
				elem.nextElementSibling.textContent = "min 2A min 3a min 21 min 1$";
				if (elem.value.length < 8 || elem.value.length > 50){
				 elem.nextElementSibling.textContent = "8+ symbols";
				}
				errors++;
				console.log("error");
			} else {
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
			}
		}
		if (elem.name === "pass2"){

			if (elem.value !==""){
				elem.nextElementSibling.textContent = "";
				elem.style.border = "1px solid black";
				if (pass1.value !== pass2.value){
					elem.nextElementSibling.textContent = "passwords are not equals";
					elem.style.border = "1px solid rgba(181, 39, 40, 1)";
					errors++;
					console.log("error");
				}
				
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
			compl();
			form.submit();
			form.reset();
		} else {

		}
	})
})