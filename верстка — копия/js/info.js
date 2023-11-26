var infojs = document.getElementById("info");

// Добавляем обработчик события "click" на кнопку
document.addEventListener("DOMContentLoaded", function() {
  var userid = localStorage.getItem("userid")
  fetch(`http://localhost:8080/profile/1`)
      .then(response => response.json())
      .then(info => {
        infojs.insertAdjacentHTML("afterbegin",` 
          <p class = "box_round" >   Username: ${info.name}</p>
          <p background-color: #abd0f2 >   Login: ${info.nickname}</p>
          <p background-color: #abd0f2 >   Birthday: ${info.birthday.slice(0,10)}</p>
          <p background-color: #abd0f2 >   Country: ${info.country}</p>`)
      })
  // При нажатии на кнопку, перенаправляем на другой HTML файл
  //window.location.href = "index.html";
});

//fetch('https://jsonplaceholder.typicode.com/todos/1')
//fetch('http://localhost:8080/info')