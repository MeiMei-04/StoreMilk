const container = document.getElementById('container');
    const registerBtn = document.getElementById('register');
    const loginBtn = document.getElementById('login');

    registerBtn.addEventListener('click', () => {
        container.classList.add("active");
    });

    loginBtn.addEventListener('click', () => {
        container.classList.remove("active");
    });
    document.getElementById("loginButton").addEventListener("click", function (event) {
        event.preventDefault();
        window.location.href = "/fshop";
    });