<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Usuario" %>
<% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("lista"); %>
<!DOCTYPE html>
<html lang="pt-br">
<head><meta charset="UTF-8"><title>Listar Usuários</title></head>
<body>
  <h2>Lista de Usuários</h2>
  <a href="${pageContext.request.contextPath}/usuario?acao=inserir">Novo Usuário</a>
  <table border="1" cellpadding="6" cellspacing="0">
    <tr><th>ID</th><th>Nome</th><th>Email</th><th>Data Nascimento</th><th colspan="2">Ações</th></tr>
    <% if (usuarios != null && !usuarios.isEmpty()) {
         for (Usuario u : usuarios) { %>
      <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getNome() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getDataNascimento() != null ? u.getDataNascimento() : "Não informado" %></td>
        <td><a href="${pageContext.request.contextPath}/usuario?acao=editar&id=<%= u.getId() %>">Editar</a></td>
        <td><a href="${pageContext.request.contextPath}/usuario?acao=deletar&id=<%= u.getId() %>">Excluir</a></td>
      </tr>
    <%   }
       } else { %>
      <tr><td colspan="6">Nenhum usuário encontrado.</td></tr>
    <% } %>
  </table>
  <br><a href="${pageContext.request.contextPath}/">Voltar</a>
</body>
</html>
