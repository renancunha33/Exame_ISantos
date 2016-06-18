<%-- 
    Document   : deletar
    Created on : 17/06/2016, 11:34:02
    Author     : renancunha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>eletar Aluno</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">
            <form method="post" action="${pageContext.servletContext.contextPath}/aluno/deletar">

                <fieldset>
                    Deletar Este código?
                    <input type="text" name="cd" value="<%= request.getParameter("cd")%>" readonly/>
                    <button class="btn btn-primary" type="submit">Deletar</button>
                </fieldset>
            </form>
            <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/aluno/listar">Voltar</a>
        </div>
    </body>
</html>
