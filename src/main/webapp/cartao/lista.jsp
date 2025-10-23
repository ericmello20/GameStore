<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Cartao" %>
<% List<Cartao> cartoes = (List<Cartao>) request.getAttribute("lista"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Listar Cartões</title>
</head>
<body>
  <h2>Lista de Cartões</h2>
  <a href="${pageContext.request.contextPath}/cartao?acao=inserir">Novo Cartão</a>
  <table border="1" cellpadding="6" cellspacing="0">
    <tr>
      <th>ID</th><th>Bandeira</th><th>Número</th><th>CPF Titular</th><th>Validade</th><th>Cliente</th><th colspan="2">Ações</th>
    </tr>
    <% if (cartoes != null && !cartoes.isEmpty()) {
         for (Cartao c : cartoes) { %>
      <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getBandeira() %></td>
        <td><%= c.getNumero() %></td>
        <td><%= c.getCpfTitular() %></td>
        <td><%= c.getValidade() != null ? c.getValidade() : "Não informada" %></td>
        <td><%= c.getCliente() != null ? c.getCliente().getNome() : "Não associado" %></td>
        <td><a href="${pageContext.request.contextPath}/cartao?acao=editar&id=<%= c.getId() %>">Editar</a></td>
        <td><a href="${pageContext.request.contextPath}/cartao?acao=deletar&id=<%= c.getId() %>">Excluir</a></td>
      </tr>
    <%   }
       } else { %>
      <tr><td colspan="8">Nenhum cartão encontrado.</td></tr>
    <% } %>
  </table>
  <br><a href="${pageContext.request.contextPath}/">Voltar</a>
</body>
</html>
