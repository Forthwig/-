console.log("cc c'est moi moumou la reine des mouettes")
signUpButton = document.getElementById('signUp');
console.log("cc c'est moi moumou la reine des mouettesx2")
signInButton = document.getElementById('signIn');
containere = document.getElementById('containere');
container = document.getElementById('container');
menuCSSChange = document.getElementById('changecss');

signUpButton.addEventListener('click', () => {
    console.log("add")
    containere.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    containere.classList.remove("right-panel-active");
});

function myFunction() {

    container.css('background-color', '#485461');
    }