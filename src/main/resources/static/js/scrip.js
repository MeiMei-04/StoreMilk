let slideIndex = 0;
showSlides();

function showSlides() {
    let i;
    let slides = document.getElementsByClassName("mySlides");
    let dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {
        slideIndex = 1
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
    setTimeout(showSlides, 2000); // Change image every 2 seconds
}

//set default ??ng nh?p
document.addEventListener('DOMContentLoaded', function () {
    fetch('http://localhost:8080/session-info')
            .then(response => response.json())
            .then(data => {
                const isLogin = data.login;
                const username = data.username;
                const idcv = data.idcv;
                console.log(data.idcv)
                const userLinkElement = document.getElementById('user-link');

                if (!isLogin) {
                    userLinkElement.innerHTML = '<a class="nav-link" href="/login"><i class="fa-solid fa-right-to-bracket"></i> Login</a>';
                } else {
                    userLinkElement.innerHTML = `<a class="nav-link" href="/user/detail"><i class="fa-solid fa-circle-user"></i>${username}</a>`;
                }
            })
            .catch(error => console.error('Error:', error));
});