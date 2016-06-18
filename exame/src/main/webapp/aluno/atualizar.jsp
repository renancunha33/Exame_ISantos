<%-- 
    Document   : atualizar
    Created on : 17/06/2016, 12:07:58
    Author     : renancunha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Atualizar aluno</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">
            <form method="post" action="${pageContext.servletContext.contextPath}/aluno/atualizar">

                <fieldset>
                    Código :<input type="text" name="cd" value="<%= request.getParameter("atualiza")%>" readonly/>
                    Novo nome :<input type="text" name="nome" />
                    <button class="btn btn-primary" type="submit">Atualizar</button>
                </fieldset>
            </form>
            <a class="btn btn-primary" href="../aluno/listar.jsp">Voltar</a>
        </div>
    </body>
</html>
