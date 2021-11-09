const userTF = document.getElementById("userTF");
const passTF = document.getElementById("passTF");
const loginBTN = document.getElementById("loginBTN");

const getRequest = ()=>{
    fetch("api/users/getall").then(response=>{
        response.json().then(json=>{
            console.log(json);
        });
    })
}

const createUser = async ()=>{
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
        "id": "id",
        "name": "Af",
        "age": 10
    });

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw
    };

    fetch("api/users/create", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));

}

loginBTN.addEventListener("click", createUser);



