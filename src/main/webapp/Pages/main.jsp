<%@page import="com.busdmv.backend.beans.Messages"%>
<%@page import="com.busdmv.backend.beans.MessagesList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Css/style_main.css" rel="stylesheet" type="text/css"/>
        <title>Интернет чат</title>
    </head>
    <body>
        <div class="main">

            <div class="description">                
                <p class="title">Интернет чат</p>
                <div class="image">
                    <img src="../Images/chat.png" alt="Интернет чат" width="150" height="150">
                </div>
            </div>


            <div class="content">
                <div class="message_post">

                    <%
                        request.setCharacterEncoding("UTF-8");
                        if (request.getParameter("user_name") != null) {
                            session.setAttribute("user_name", request.getParameter("user_name"));
                        }
                    %>
                    Здравствуйте, <%=session.getAttribute("user_name")%> ! Введите сообщение и нажмите "Отправить", для отправки сообщения в чат.


                    <form name="message_post" action="Здесь он должен отправлять сообщение в БД" method="POST">
                        <input type="text" name="message_post" value="" size="100" />
                        <input type="submit" value="Отправить" />
                    </form>
                </div>

                <div class="author_list">
                    <form name="author_list">
                        Показать все сообщения пользователя:
                        <select name="author_list">
                            <option>User 1</option>
                            <option>User 2</option>
                            <option>User 3</option>
                            <option>User 4</option>
                        </select>
                        <input type="submit" value="Ok" />
                    </form>
                </div>     
            </div>


            <div class="messages">
                <table class="table">
                    <thead>
                        <tr>
                            <th style="width: 5%">id</th>
                            <th style="width: 15%">client_id</th>
                            <th style="width: 80%">message</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>                        
                    </tbody>
                </table>

            </div>

            <h4>Список авторов:</h4>
            <ul class="nav">
                <% MessagesList messagesList = new MessagesList();
                    for (Messages messages : messagesList.getMessagesList()) {
                %>
                <li><a href="#"><%=messages.getClientId()%></a></li>

                <%}%>
            </ul>


            <div>
                <p class="author">Разработчик: Бусыгин Дмитрий, 2015 г.</p>
            </div>            
        </div> 

    </body>
</html>
