<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h3>Cadastro Cliente</h3>
    <form action="Inserir" method="post" class="form-control">
        <fieldset>
            <legend>Dados do Cliente</legend>
            <p>
                <label for="id_cliente">ID do Cliente:</label>
                <input type="text" id="id_cliente" name="id_cliente" size="40" class="form-control" required>
            </p>
            <p>
                <label for="nome">Nome:</label>
                <input type="text" id="nome" name="nome" size="40" class="form-control" required>
            </p>
            <p>
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" size="40" class="form-control" required>
            </p>
            <p>
                <label for="senha">Senha:</label>
                <input type="password" id="senha" name="senha" size="40" class="form-control" required>
            </p>
            <p>
                <input type="submit" value="Cadastrar Cliente" class="btn btn-primary">
            </p>
        </fieldset>
    </form>

    <br>
    <h5>Clientes Cadastrados</h5>
    <table class="table">
        <thead>
        <tr>
            <th>ID do Cliente</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaClientes}" var="cliente">
            <tr>
                <td>${cliente.id_cliente}</td>
                <td>${cliente.nome}</td>
                <td>${cliente.email}</td>
                <td>
                    <a href="editar?id=${cliente.id_cliente}" class="btn btn-success">Editar</a>
                    <a href="excluir?id=${cliente.id_cliente}" onclick="return confirm('Deseja Excluir?')" class="btn btn-danger">Excluir</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
