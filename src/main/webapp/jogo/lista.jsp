<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Jogo" %>
<% List<Jogo> jogos = (List<Jogo>) request.getAttribute("lista"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head><meta charset="UTF-8"><title>Listar Jogos</title></head>
<body>
  <h2>Lista de Jogos</h2>
  <a href="${pageContext.request.contextPath}/jogo?acao=inserir">Novo Jogo</a>
  <table border="1" cellpadding="6" cellspacing="0">
    <tr><th>ID</th><th>Nome</th><th>Desenvolvedora</th><th>Valor</th><th>Data Lançamento</th><th colspan="2">Ações</th></tr>
    <% if (jogos != null && !jogos.isEmpty()) {
         for (Jogo j : jogos) { %>
      <tr>
        <td><%= j.getId() %></td>
        <td><%= j.getNome() %></td>
        <td><%= j.getDesenvolvedora() %></td>
        <td><%= j.getValor() %></td>
        <td><%= j.getDataLancamento() != null ? j.getDataLancamento() : "Não informada" %></td>
        <td><a href="${pageContext.request.contextPath}/jogo?acao=editar&id=<%= j.getId() %>">Editar</a></td>
        <td><a href="${pageContext.request.contextPath}/jogo?acao=deletar&id=<%= j.getId() %>">Excluir</a></td>
      </tr>
    <%   }
       } else { %>
      <tr><td colspan="7">Nenhum jogo encontrado.</td></tr>
    <% } %>
  </table>
  <br><a href="${pageContext.request.contextPath}/">Voltar</a>
</body>
</html>
