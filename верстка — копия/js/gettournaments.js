var tournaments = document.getElementById("tournaments");

// Добавляем обработчик события "click" на кнопку
document.addEventListener("DOMContentLoaded", function() {
  var userid = localStorage.getItem("userid")
  
  fetch(`http://localhost:8080/tournaments`)
      .then(response => response.json())
      .then(tours => {
        tournaments.insertAdjacentHTML("afterbegin",` 
        <table bordercolor = white; border: 1px solid maroon>
            <tr>
            <th>№</th><th>Событие</th><th>Результат</th><th>Дата проведения</th><th>Статус участия</th>
          <p class = "box_round" >   Username: ${info.name}</p>
          <p background-color: #abd0f2 >   Login: ${info.nickname}</p>
          <p background-color: #abd0f2 >   Birthday: ${info.birthday.slice(0,10)}</p>
          <p background-color: #abd0f2 >   Country: ${info.country}</p>`)
      })
  // При нажатии на кнопку, перенаправляем на другой HTML файл
  //window.location.href = "index.html";
});
