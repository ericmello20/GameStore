<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title>Painel Administrativo - Game Store</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                padding: 20px;
            }

            h1 {
                color: #333;
            }

            ul {
                list-style: none;
                padding: 0;
            }

            li {
                margin-bottom: 8px;
            }

            a {
                text-decoration: none;
                color: #007bff;
            }

            a:hover {
                text-decoration: underline;
            }

            hr {
                margin-top: 30px;
            }
        </style>
    </head>

    <body>
        <h1>Painel Administrativo - Game Store</h1>
        <h2>Gerenciamento</h2>

        <h3>Clientes</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/usuario?acao=inserir">Cadastrar Cliente</a></li>
            <li><a href="${pageContext.request.contextPath}/usuario?acao=listar">Listar Clientes</a></li>
        </ul>

        <h3>Cartões</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/cartao?acao=inserir">Cadastrar Cartão</a></li>
            <li><a href="${pageContext.request.contextPath}/cartao?acao=listar">Listar Cartões</a></li>
        </ul>

        <h3>Jogos</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/jogo?acao=inserir">Cadastrar Jogo</a></li>
            <li><a href="${pageContext.request.contextPath}/jogo?acao=listar">Listar Jogos</a></li>
        </ul>

        <h3>DLCs</h3>
        <ul>
            <li><a href="${pageContext.request.contextPath}/dlc?acao=inserir">Cadastrar DLC</a></li>
            <li><a href="${pageContext.request.contextPath}/dlc?acao=listar">Listar DLCs</a></li>
        </ul>

        <hr>
        <p>Sistema de Administração da Game Store</p>
    </body>

    </html>