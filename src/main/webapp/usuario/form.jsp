<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="model.Usuario" %>

    <% Usuario usuario=(Usuario) request.getAttribute("entidade"); String urlSubmit=(String)
      request.getAttribute("urlSubmit"); if (urlSubmit==null) { // Fallback padrão se o servlet não definir a URL
      urlSubmit=request.getContextPath() + "/usuario" ; } %>

      <html lang="pt-br">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
          <%= usuario==null ? "Cadastro" : "Edição" %> de Cliente
        </title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
      </head>

      <body>
        <main class="principal">
          <div class="principal-titulo">
            <h1>
              <%= usuario==null ? "Cadastro" : "Edição" %> de Cliente
            </h1>
          </div>

          <form action="<%= urlSubmit %>" method="post">
            <div class="principal-formulario">


              <input type="hidden" name="id" value="<%= usuario != null ? usuario.getId() : "" %>">


              <input type="hidden" name="acao" value="<%= usuario != null ? "atualizar" : "cadastrar" %>">


              <div>
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" value="<%= usuario != null ? usuario.getNome() : "" %>"
                  required>
              </div>


              <div>
                <label for="email">Email:</label>
                <input id="email" type="email" name="email" value="<%= usuario != null ? usuario.getEmail() : "" %>"
                  required>
              </div>


              <div>
                <label for="senha">Senha:</label>
                <input id="senha" type="password" name="senha" value="<%= usuario != null ? usuario.getSenha() : "" %>"
                  required>
              </div>


              <div>
                <label for="dataNascimento">Data de Nascimento:</label>
                <input type="date" id="dataNascimento" name="data_nascimento"
                  value="<%= usuario != null ? usuario.getDataNascimento() : "" %>" required>
              </div>


              <div>
                <button type="submit">
                  <%= usuario==null ? "Cadastrar" : "Editar" %>
                </button>
              </div>
            </div>
          </form>
        </main>
      </body>

      </html>