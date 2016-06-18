<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: felipe
  Date: 15/06/16
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Lançar Nota</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">
            <form method="post" action="${pageContext.servletContext.contextPath}/nota/lancar">
                <fieldset>
                    Aluno:
                    <select name="aluno">
                        <option>Selecione...</option>
                        <c:forEach var="aluno" items="${requestScope['alunos']}">
                            <option value="${aluno.id}">${aluno.nome}</option>
                        </c:forEach>
                    </select>

                    Matéria:
                    <select name="materia">
                        <option>Selecione...</option>
                        <c:forEach var="materia" items="${requestScope['materias']}">
                            <option value="${materia.id}">${materia.nome}</option>
                        </c:forEach>
                    </select>

                    Nota: <input name="nota"id="nota"type="text" name="nota" />

                    <button class="btn btn-info" type="submit">Cadastrar</button>
                </fieldset>
            </form>
            <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/nota/listar">Voltar</a>
        </div>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
    <script>
        jQuery(function ($) {
            $("#nota").mask('99');
        });
    </script>
</html>
