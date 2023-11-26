document.getElementById("registration-container").addEventListener("submit", function(event){
  event.preventDefault(); // Отменяем отправку формы

  // Получаем значения полей ввода
  var username = document.getElementById("reg-username").value;
  var password = document.getElementById("reg-password").value;

  // Создаем новый объект пользователя
  var user = {
      "reg-username": username,
      "reg-password": password
  };

  // Получаем текущих пользователей из локального хранилища
  var users = JSON.parse(localStorage.getItem("users")) || {"users": []};

  // Добавляем нового пользователя
  users.users.push(user);

  // Сохраняем обновленный список пользователей в локальном хранилище
  localStorage.setItem("users", JSON.stringify(users));

  // Отправляем обновленный список пользователей на сервер
  fetch("https://reqres.in/api/products/3", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(users)
    
  })
  .then(function(response) {
    if(response.ok) {
      alert("Регистрация успешна и JSON-файл обновлен!");
    } else {
      alert("Произошла ошибка при обновлении JSON-файла.");
    }
  })
  .catch(function(error) {
    alert("Произошла ошибка при обновлении JSON-файла: " + error.message);
  });

});


// document.getElementById("registration-container").addEventListener("submit", function(event){
//     event.preventDefault(); // Отменяем отправку формы

//     // Получаем значения полей ввода
//     var username = document.getElementById("reg-username").value;
//     var password = document.getElementById("reg-password").value;

//     // Создаем новый объект пользователя
//     var user = {
//         "reg-username": username,
//         "reg-password": password
//     };

//     // Получаем текущих пользователей из локального хранилища
//     var users = JSON.parse(localStorage.getItem("users")) || {"users": []};
  
//     // Добавляем нового пользователя
//     users.users.push(user);

//     // Сохраняем обновленный список пользователей в локальном хранилище
//     localStorage.setItem("users", JSON.stringify(users));

//     // Отправляем обновленный список пользователей на сервер
//     fetch("https://reqres.in/api/products/3", {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json"
//       },
//       body: JSON.stringify(users)
//     })
//     .then((response)=> {
//       if(response.ok) {
//         //localStorage.setItem("userid", response.id)
//         alert("Регистрация успешна и JSON-файл обновлен!");
//       } else {
//         alert("Произошла ошибка при обновлении JSON-файла.");
//       }
//     })
//     .catch(function(error) {
//       alert("Произошла ошибка при обновлении JSON-файла: " + error.message);
//     });

// });