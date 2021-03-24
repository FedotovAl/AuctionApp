"use strict"

document.addEventListener('DOMContentLoaded', () => {
    let items = document.querySelectorAll(".maybe");

    for (let i = 0; i < items.length; i++) {
        console.log(items[i]);
        console.log(items[i].innerHTML);
        if (items[i].innerHTML === ""){
            items[i].innerHTML = "Empty data";
        }
    }
})