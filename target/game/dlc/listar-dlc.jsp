<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="model.Dlc" %>
            <% List<Dlc> dlcs = (List<Dlc>) request.getAttribute("lista"); %>
                    <!DOCTYPE html>
                    <html lang="pt-br">

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Listar DLCs</title>
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
                        <h2>Lista de DLCs</h2>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Desenvolvedora</th>
                                <th>Valor</th>
                                <th>Data de Lançamento</th>
                                <th>Jogo Base</th>
                                <th colspan="2">Ações</th>
                            </tr>
                            <% if (dlcs !=null && !dlcs.isEmpty()) { for (Dlc dlc : dlcs) { %>
                                <tr>
                                    <td>
                                        <%= dlc.getId() %>
                                    </td>
                                    <td>
                                        <%= dlc.getNome() %>
                                    </td>
                                    <td>
                                        <%= dlc.getDesenvolvedora() %>
                                    </td>
                                    <td>
                                        <%= dlc.getValor() %>
                                    </td>
                                    <td>
                                        <%= dlc.getDataLancamento() !=null ? dlc.getDataLancamento() : "Não informado"
                                            %>
                                    </td>
                                    <td>
                                        <%= dlc.getJogoBase() !=null ? dlc.getJogoBase().getNome() : "Não informado" %>
                                    </td>
                                    <td>
                                        <a href="dlc?acao=buscar&id=<%= dlc.getId() %>">Editar</a>
                                    </td>
                                    <td>
                                        <a href="dlc?acao=deletar&id=<%= dlc.getId() %>">Remover</a>
                                    </td>
                                </tr>
                                <% } } else { %>
                                    <tr>
                                        <td colspan="8">Nenhuma DLC encontrada.</td>
                                    </tr>
                                    <% } %>
                        </table>
                    </body>

                    </html>