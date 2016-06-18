<%--
  Created by IntelliJ IDEA.
  User: felipe
  Date: 14/06/16
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Sistema</title>
    </head>
    <body style="background-color: #e7e7e7">
    <center>
        <br>
        <h1>Sistema de cadastro</h1>
        <div class="container">

            <a class="btn btn-primary"href="${pageContext.servletContext.contextPath}/aluno/listar">Alunos Cadastrados</a>

            <a class="btn btn-success"href="${pageContext.servletContext.contextPath}/materia/listar">Materias</a>

            <a class="btn btn-info"href="${pageContext.servletContext.contextPath}/nota/listar">Notas</a>

        </div>
    </center>
</body>

</html>
