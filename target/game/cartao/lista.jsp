<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="model.Cartao" %>
            <% List<Cartao> cartoes = (List<Cartao>) request.getAttribute("lista");
                    %>

                    <!DOCTYPE html>
                    <html lang="pt-br">

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Listar Cartões</title>
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
                        <h2>Lista de Cartões</h2>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Bandeira</th>
                                <th>Número</th>
                                <th>CPF Titular</th>
                                <th>Data de Validade</th>
                                <th>Cliente</th>
                                <th colspan="2">Ações</th>
                            </tr>

                            <% if (cartoes !=null && !cartoes.isEmpty()) { for (Cartao cartao : cartoes) { %>
                                <tr>
                                    <td>
                                        <%= cartao.getId() %>
                                    </td>
                                    <td>
                                        <%= cartao.getBandeira() %>
                                    </td>
                                    <td>
                                        <%= cartao.getNumero() %>
                                    </td>
                                    <td>
                                        <%= cartao.getCpfTitular() %>
                                    </td>
                                    <td>
                                        <%= cartao.getValidade() !=null ? cartao.getValidade() : "Não informada" %>
                                    </td>
                                    <td>
                                        <%= cartao.getCliente() !=null ? cartao.getCliente().getNome() : "Não associado"
                                            %>
                                    </td>
                                    <td><a href="cartao?acao=buscar&id=<%= cartao.getId() %>">Editar</a></td>
                                    <td><a href="cartao?acao=deletar&id=<%= cartao.getId() %>">Remover</a></td>
                                </tr>
                                <% } } else { %>
                                    <tr>
                                        <td colspan="8">Nenhum cartão encontrado.</td>
                                    </tr>
                                    <% } %>
                        </table>
                    </body>

                    </html>