<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="model.Jogo" %>

    <% Jogo jogo=(Jogo) request.getAttribute("entidade"); String urlSubmit=(String) request.getAttribute("urlSubmit");
      if (urlSubmit==null) { urlSubmit=request.getContextPath() + "/jogo" ; } %>

      <html lang="pt-br">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
          <%= jogo==null ? "Cadastro" : "Edição" %> de Jogo
        </title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
      </head>

      <body>
        <main class="principal">
          <div class="principal-titulo">
            <h1>
              <%= jogo==null ? "Cadastro" : "Edição" %> de Jogo
            </h1>
          </div>

          <form action="<%= urlSubmit %>" method="post">
            <div class="principal-formulario">


              <input type="hidden" name="id" value="<%= jogo != null ? jogo.getId() : "" %>">


              <input type="hidden" name="acao" value="<%= jogo != null ? " atualizar" : "cadastrar" %>">


              <div>
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" value="<%= jogo != null ? jogo.getNome() : "" %>" required>
              </div>


              <div>
                <label for="desenvolvedora">Desenvolvedora:</label>
                <input id="desenvolvedora" type="text" name="desenvolvedora"
                  value="<%= jogo != null ? jogo.getDesenvolvedora() : "" %>" required>
              </div>


              <div>
                <label for="descricao">Descrição:</label>
                <textarea id="descricao" name="descricao" rows="4"
                  required><%= jogo != null ? jogo.getDescricao() : "" %></textarea>
              </div>

              <div>
                <label for="valor">Valor (R$):</label>
                <input id="valor" type="number" step="0.01" name="valor"
                  value="<%= jogo != null ? jogo.getValor() : "" %>" required>
              </div>


              <div>
                <label for="pCusto">Preço de Custo (R$):</label>
                <input id="pCusto" type="number" step="0.01" name="pCusto"
                  value="<%= jogo != null ? jogo.getPCusto() : "" %>" required>
              </div>


              <div>
                <label for="dataLancamento">Data de Lançamento:</label>
                <input type="date" id="dataLancamento" name="dataLancamento"
                  value="<%= jogo != null && jogo.getDataLancamento() != null ? jogo.getDataLancamento() : "" %>">
              </div>


              <div>
                <button type="submit">
                  <%= jogo==null ? "Cadastrar" : "Editar" %>
                </button>
              </div>
            </div>
          </form>
        </main>
      </body>

      </html>