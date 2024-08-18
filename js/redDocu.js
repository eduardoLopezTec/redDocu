
const icon = document.getElementById("loginIcon");
const list = document.getElementById("loginList");

icon.addEventListener("click", () => {
  list.classList.toggle("showLogin");
});

const iconMenu = document.getElementById("menu-icon");
const showMenu = document.getElementById("navigation");
 iconMenu.addEventListener("click", () => {
  showMenu.classList.toggle("showNavigation");
 });


 const respuestas = document.querySelectorAll(".contPregunta");

 respuestas.forEach(contPregunta => {
  contPregunta.addEventListener("click", () => {
    contPregunta.classList.toggle("mostrar");
  })
 });