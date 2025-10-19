<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="model.Usuario" %>
            <% List<Usuario> clientes = (List<Usuario>) request.getAttribute("lista"); %>
                    <!DOCTYPE html>
                    <html lang="pt-br">

                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Listar Clientes</title>
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
                        <h2>Lista de Clientes</h2>
                        <table>
                            <tr>
                                <th>ID</th>
                                <th>Nome</th>
                                <th>Email</th>
                                <th>Data de Nascimento</th>
                                <th colspan="2">Ações</th>
                            </tr>
                            <% if (clientes !=null && !clientes.isEmpty()) { for (Usuario cliente : clientes) { %>
                                <tr>
                                    <td>
                                        <%= cliente.getId() %>
                                    </td>
                                    <td>
                                        <%= cliente.getNome() %>
                                    </td>
                                    <td>
                                        <%= cliente.getEmail() %>
                                    </td>
                                    <td>
                                        <%= cliente.getDataNascimento() !=null ? cliente.getDataNascimento()
                                            : "Não informado" %>
                                    </td>
                                    <td>
                                        <a href="cliente?acao=buscar&id=<%= cliente.getId() %>">Editar</a>
                                    </td>
                                    <td>
                                        <a href="cliente?acao=deletar&id=<%= cliente.getId() %>">Remover</a>
                                    </td>
                                </tr>
                                <% } } else { %>
                                    <tr>
                                        <td colspan="6">Nenhum cliente encontrado.</td>
                                    </tr>
                                    <% } %>
                        </table>
                    </body>

                    </html>