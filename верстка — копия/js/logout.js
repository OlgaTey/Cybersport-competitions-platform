var button = document.getElementById("buttonlogout");

// Добавляем обработчик события "click" на кнопку
button.addEventListener("click", function() {
  // При нажатии на кнопку, перенаправляем на другой HTML файл
  window.location.href = "index.html";
});
// var button = document.getElementById("buttonlogout");
// var kaknibud = document.getElementById("kakoy");
// // Добавляем обработчик события "click" на кнопку
// button.addEventListener("click", function() {
//   localStorage.removeItem("userid")
//   fetch('https://jsonplaceholder.typicode.com/todos')
//       .then(response => response.json())
//       .then(tournaments => {
//         console.log(tournaments)
//       //   kaknibud.insertAdjacentHTML("afterbegin",` 
//       //   <h2>
//       //   ${tournaments.info.name}
            
//       //   </h2>` )
//       })
//   // При нажатии на кнопку, перенаправляем на другой HTML файл
//   //window.location.href = "index.html";
// });
//fetch('https://jsonplaceholder.typicode.com/todos/1')
//fetch('http://localhost:8080/tournaments')