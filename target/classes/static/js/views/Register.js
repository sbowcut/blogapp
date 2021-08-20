import createView from "../createView.js";

export default function Register(props) {
    return `
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form id="login-form">
            <label for="username">Username</label>
            <input id="username" name="username" type="text"/>
            <label for="email">Email</label>
            <input id="email" name="email" type="text"/>
            <label for="password">Password</label>
            <input id="password" name="password" type="password"/>
            <input id="register-btn" type="button" value="Log In"/>
        </form>
    </body>
</html>`;

}

export function createRegisterEvent(){
    RegisterEvent()
}

function RegisterEvent(){
    $("#register-btn").click(function (){

        let newUser ={
            username: $("#username").val(),
            email: $("#email").val(),
            password: $("#password").val(),
            role: 'USER'

        }

        console.log(newUser)

        let request = {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(newUser)
        };

        fetch("http://localhost:8080/api/users", request)
            .then((response) => {
                console.log(response.status)
                createView("/");
            });
    })
}