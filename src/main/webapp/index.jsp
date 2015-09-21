<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/style_index.css" rel="stylesheet" type="text/css"/>
        <title>Итернет чат. Вход</title>        
    </head>
    <body>
        <div class="main">
            <div class="description">                
                <p class="title">Интернет чат</p>
                <p class="text">Описание возможностей:...</p>
                <p class="text">Проект находится в рабочей стадии.</p>
            </div>
            <div class="content">
                <div class="image">
                    <img src="Images/chat.png" alt="Интернет чат" width="200" height="200">
                </div>
                <div class="login">                    
                    <form name="user_name" action="Pages/main.jsp" method="POST">
                        Для входа введите Ваше имя: <input type="text" name="user_name" value="" size="30" />
                        <input type="submit" value="Вход" />
                    </form>
                </div>
            </div>
            <div>
                <p class="author">Разработчик: Бусыгин Дмитрий, 2015 г.</p>
            </div>            
        </div>    
    </body>
</html>
