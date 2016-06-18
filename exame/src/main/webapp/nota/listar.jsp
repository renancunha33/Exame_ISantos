<%--
  Created by IntelliJ IDEA.
  User: felipe
  Date: 15/06/16
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <title>Boletim</title>
    </head>
    <body style="background-color: #e7e7e7">
        <br>
        <div class="container">
            <form method="post" action="${pageContext.servletContext.contextPath}/nota/listar">
                <fieldset>
                    Aluno:
                    <select class="selectpicker" name="aluno">
                        <option>Selecione...</option>
                        <c:forEach var="aluno" items="${requestScope['alunos']}">
                            <option value="${aluno.id}">${aluno.nome}</option>
                        </c:forEach>
                    </select>
                    Matéria:
                    <select class="selectpicker"name="materia">
                        <option>Selecione...</option>
                        <c:forEach var="materia" items="${requestScope['materias']}">
                            <option value="${materia.id}">${materia.nome}</option>
                        </c:forEach>
                    </select>

                    <button class="btn btn-info" type="submit">Pesquisar</button>
                </fieldset>
            </form>

            <br>
            <a class="btn btn-info" href="${pageContext.servletContext.contextPath}/nota/lancar">Lançar Nota</a>
            <br>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Aluno</th>
                        <th>Materia</th>
                        <th>Nota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="nota" items="${requestScope['notas']}">
                        <tr>
                            
                            <td>${nota.aluno.nome}</td>
                            <td>${nota.materia.nome}</td>
                            <td>${nota.nota}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-info" href="../index.jsp">Voltar</a>
        </div>
    </body>
    
</html>
