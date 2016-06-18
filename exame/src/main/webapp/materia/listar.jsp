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
        <title>Lista de Matérias</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">
            <a class="btn btn-success" href="${pageContext.servletContext.contextPath}/materia/cadastrar">Cadastrar nova matéria</a>
            <br>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Editar</th>
                        <th>Apagar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="materia" items="${requestScope['materias']}">
                        <tr>
                            <td>${materia.id}</td>
                            <td>${materia.nome}</td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/materia/deletar">
                                    <button type="submit" class="btn btn-danger btn-sm" name="cd" value="${materia.id}">
                                        Excluir ${materia.nome}
                                    </button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/materia/atualizar">
                                    <button type="submit" class="btn btn-warning btn-sm" name="atualiza" value="${materia.id}">
                                        Atualizar ${materia.nome}
                                    </button>
                                </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-success" href="../index.jsp">Voltar</a>
        </div>
    </body>
</html>
