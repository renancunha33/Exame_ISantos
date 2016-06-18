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
        <title>Lista de Alunos</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">
            <a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/aluno/cadastrar">Cadastrar novo aluno</a>
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
                    <c:forEach var="aluno" items="${requestScope['alunos']}">
                        <tr>
                            <td>${aluno.id}</td>
                            <td>${aluno.nome}</td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/aluno/deletar">
                                    <button type="submit" class="btn btn-danger btn-sm" name="cd" value="${aluno.id}">
                                        Excluir ${aluno.nome}
                                    </button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.servletContext.contextPath}/aluno/atualizar">
                                    <button type="submit" class="btn btn-warning btn-sm" name="atualiza" value="${aluno.id}">
                                        Atualizar ${aluno.nome}
                                    </button>
                                </form>
                            </td>
                        </tr>   
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="../index.jsp">Voltar</a>
        </div>
    </body>
</html>
