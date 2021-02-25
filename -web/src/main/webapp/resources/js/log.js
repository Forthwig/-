const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const containere = document.getElementById('containere');
var menuCSSChange = document.getElementById('changecss');


signUpButton.addEventListener('click', () => {
    $('.containere').classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    $('.containere').classList.remove("right-panel-active");
});

function myFunction() {

    $('.container').css('background-color', '#485461');
    }