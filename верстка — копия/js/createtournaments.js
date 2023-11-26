var button = document.getElementById("createtour");
var manageridnick = document.getElementById("manageridnick").value;
var referee = document.getElementById("referee").value;
var isofficial = document.getElementById("isofficial").value;
if (isofficial == "да"){
    isofficial = true;
}else{
    isofficial = false;
}
var infoname = document.getElementById("infoname").value;
var infostart_date = document.getElementById("infostart_date").value;
var infofinish_date = document.getElementById("infofinish_date").value;
var infoprize_pool = document.getElementById("infoprize_pool").value;
var infodiscipline = document.getElementById("infodiscipline").value;
var infostart_registration = document.getElementById("infostart_registration").value;
var infoend_registration = document.getElementById("infoend_registration").value;

console.log(infoprize_pool)
button.addEventListener("click", function() {
    // Получаем значения полей ввода


    // Создаем новый объект пользователя
    var tournament = {

        "manager":{
            "nickname": manageridnick,
            "chiefId": 2
        },
        "refereesProfileId": [referee],
        "isOfficial": isofficial,
        "info": {
    
        "name": infoname,
        "start_date": infostart_date,
        "finish_date": infofinish_date,
        "prize_pool": infoprize_pool,
        "discipline": infodiscipline,
        "start_registration": infostart_registration,
        "end_registration": infoend_registration
      }
    };
     

    fetch("http://localhost:8080/tournament", {
        method: "POST",
        mode: 'cors',
        cache: 'no-cache',
        credentials: 'same-origin' ,
        headers: {
        "Content-Type": "application/json"
        },
        body: JSON.stringify(tournament)
        })
        .then(response=>response.json)
        .then(function(response) {
        if(response.ok) {
        // Данные успешно переданы
        console.log("Данные успешно переданы");
        } else {
        // Произошла ошибка при передаче данных
        console.log("Произошла ошибка при передаче данных");
        }
        })
        .catch(function(error) {
        // Произошла ошибка во время передачи данных
        console.log("Произошла ошибка во время передачи данных: " + error.message);
        });

});