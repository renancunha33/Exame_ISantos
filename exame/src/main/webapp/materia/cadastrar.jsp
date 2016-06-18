<%--
  Created by IntelliJ IDEA.
  User: felipe
  Date: 14/06/16
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Cadastro de Materias</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">

            <form method="post" action="${pageContext.servletContext.contextPath}/materia/cadastrar">

                <fieldset>

                    Nome :<input type="text" name="nome" />
                    <button class="btn btn-success" type="submit">Cadastrar</button>
                </fieldset>
            </form>
            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/materia/listar">Voltar</a>
        </div>
    </body>
</html>