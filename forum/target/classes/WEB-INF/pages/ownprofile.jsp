<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="UTF-8"/>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <title>${login}</title>
        <style>
           <%@include file='css/bootstrap.css' %>
           <%@include file='css/mystyle.css' %>
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <a href="/"><span>&nbsp;Главная</span></a>
            </div>
        </div>
        <br>
        <p>Логин: ${login}</p>
        <p>Email: ${email}</p>
        <p>Регистрация: ${dateofcreate}</p>
        <form action="http://localhost:8080/profile/${login}/changepass" method="post">
        	Изменить пароль: <input name="pass" type="password">
        	<input type="submit" value="Изменить">
        </form>
        <H3>${errorMessage}</H3>
        <img src="http://localhost:8080/image/${imageName}" width="100" height="125" align="left" vspace="5" hspace="5"/>
        <p><a href="/profile/${login}/find/messages"><span>Найти сообщения</span></a></p>
        <p><a href="/profile/${login}/find/threads"><span>Найти темы</span></a></p>
        <div style="clear: left"></div>
        <form action="http://localhost:8080/image/add" method="post" enctype="multipart/form-data">
        	<input name="data" type="file"><br>
        	<input type="submit"><br>
        </form>
    </body>
</html>