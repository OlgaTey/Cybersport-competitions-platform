

document.getElementById("login-container").addEventListener("submit", function(event){
  event.preventDefault(); // Отменяем отправку формы

  // Получаем значения полей ввода
  var username = document.getElementById("login-username").value;
  var password = document.getElementById("login-password").value;

  // Получаем текущих пользователей из локального хранилища
  var users = JSON.parse(localStorage.getItem("users")) || {"users": []};

  // Проверяем существование пользователя с указанными данными
  var user = users.users.find(function(user){
      return user["reg-username"] === username && user["reg-password"] === password;
  });

  if(user) {
      alert("Авторизация успешна");
  window.location.href = "mainmenu.html";
  } else {
      alert("Неверное имя пользователя или пароль");
  }
});

// document.getElementById("login-container").addEventListener("submit", function(event){
//     event.preventDefault(); // Отменяем отправку формы

//     // Получаем значения полей ввода
//     var username = document.getElementById("login-username").value;
//     var password = document.getElementById("login-password").value;

//     var user = {
//       "login": username,
//       "password": password
//    };
//     // Получаем текущих пользователей из локального хранилища
//     var users = JSON.parse(localStorage.getItem("users")) || {"users": []};

//     // Проверяем существование пользователя с указанными данными
//     var user = users.users.find(function(user){
//         return user["reg-username"] === username && user["reg-password"] === password;
//     });

//     if(user) {
//         alert("Авторизация успешна");
// 		window.location.href = "mainmenu.html";
//     } else {
//         alert("Неверное имя пользователя или пароль, перейдите в регистрацию");
//    }
//     fetch("http://localhost:8080/profile", {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json"
//       },
//       body: JSON.stringify(user)
//     })
//     .then((response)=> {
      
//         localStorage.setItem("userid", response.id)
//         alert("Регистрация успешна и JSON-файл обновлен!");
      
        
//     })
//     .catch(function(error) {
//       alert("Произошла ошибка при обновлении JSON-файла: " + error.message);
//     });
// });
// document.getElementById("login-container").addEventListener("submit", function(event){
//   event.preventDefault(); // Отменяем отправку формы

//   // Получаем значения полей ввода
//   var username = document.getElementById("login-username").value;
//   var password = document.getElementById("login-password").value;

//   // Получаем текущих пользователей из локального хранилища
//   var users = JSON.parse(localStorage.getItem("users")) || {"users": []};

//   // Проверяем существование пользователя с указанными данными
//   var user = users.users.find(function(user){
//       return user["reg-username"] === username && user["reg-password"] === password;
//   });

//   if(user) {
//       alert("Авторизация успешна");
//   window.location.href = "mainmenu.html";
//   } else {
//       alert("Неверное имя пользователя или пароль");
//   }
// });