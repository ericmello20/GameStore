<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Dlc" %>
<% List<Dlc> dlcs = (List<Dlc>) request.getAttribute("lista"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head><meta charset="UTF-8"><title>Listar DLCs</title></head>
<body>
  <h2>Lista de DLCs</h2>
  <a href="${pageContext.request.contextPath}/dlc?acao=inserir">Nova DLC</a>
  <table border="1" cellpadding="6" cellspacing="0">
    <tr><th>ID</th><th>Nome</th><th>Desenvolvedora</th><th>Valor</th><th>Jogo Base</th><th colspan="2">Ações</th></tr>
    <% if (dlcs != null && !dlcs.isEmpty()) {
         for (Dlc d : dlcs) { %>
      <tr>
        <td><%= d.getId() %></td>
        <td><%= d.getNome() %></td>
        <td><%= d.getDesenvolvedora() %></td>
        <td><%= d.getValor() %></td>
        <td><%= d.getJogoBase() != null ? d.getJogoBase().getNome() : "Não associado" %></td>
        <td><a href="${pageContext.request.contextPath}/dlc?acao=editar&id=<%= d.getId() %>">Editar</a></td>
        <td><a href="${pageContext.request.contextPath}/dlc?acao=deletar&id=<%= d.getId() %>">Excluir</a></td>
      </tr>
    <%   }
       } else { %>
      <tr><td colspan="7">Nenhuma DLC encontrada.</td></tr>
    <% } %>
  </table>
  <br><a href="${pageContext.request.contextPath}/">Voltar</a>
</body>
</html>
