<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Авторизация</title>  

    </head>
    <body>
        <div class="header"> <h1>Авторизация</h1> </div>
<form action="j_security_check" method="POST">
    
    <div id="loginBox">
        <p><strong>Логин:</strong>
            <input placeholder="Введите логин" type="text" size="20" name="j_username"></p>
        <p><strong>Пароль:</strong>
            <input placeholder="Введите пароль" type="password" size="20" name="j_password"></p>
        <p><input type="submit" value="Авторизоваться"></p>
    </div>
</form>
    </body>
</html>


