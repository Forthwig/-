signUpButton = document.getElementById('signUp');
signInButton = document.getElementById('signIn');
containere = document.getElementById('containere');

signUpButton.addEventListener('click', () => {
    console.log("add")
    containere.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    containere.classList.remove("right-panel-active");
});