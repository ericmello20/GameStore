<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="model.Jogo" %>
            <% List<Jogo> jogos = (List<Jogo>) request.getAttribute("lista"); %>
                    <!DOCTYPE html>
                    <html lang="pt-br">

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Listar Jogos</title>
                        <style>
                            table {
                                border-collapse: collapse;
                                width: 80%;
                            }

                            th,
                            td {
                                border: 1px solid #ccc;
                                padding: 8px;
                                text-align: left;
                            }

                            th {
                                background: #f2f2f2;
                            }

                            a {
                                margin-right: 8px;
                            }
                        </style>
                    </head>

                    <body>
                        <h2>Lista de Jogos</h2>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Desenvolvedora</th>
                                <th>Valor</th>
                                <th>Data de Lançamento</th>
                                <th colspan="2">Ações</th>
                            </tr>
                            <% if (jogos !=null && !jogos.isEmpty()) { for (Jogo jogo : jogos) { %>
                                <tr>
                                    <td>
                                        <%= jogo.getId() %>
                                    </td>
                                    <td>
                                        <%= jogo.getNome() %>
                                    </td>
                                    <td>
                                        <%= jogo.getDesenvolvedora() %>
                                    </td>
                                    <td>
                                        <%= jogo.getValor() %>
                                    </td>
                                    <td>
                                        <%= jogo.getDataLancamento() !=null ? jogo.getDataLancamento() : "Não informado"
                                            %>
                                    </td>
                                    <td>
                                        <a href="jogo?acao=buscar&id=<%= jogo.getId() %>">Editar</a>
                                    </td>
                                    <td>
                                        <a href="jogo?acao=deletar&id=<%= jogo.getId() %>">Remover</a>
                                    </td>
                                </tr>
                                <% } } else { %>
                                    <tr>
                                        <td colspan="7">Nenhum jogo encontrado.</td>
                                    </tr>
                                    <% } %>
                        </table>
                    </body>

                    </html>