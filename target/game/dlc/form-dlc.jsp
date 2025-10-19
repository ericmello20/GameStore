<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="model.Dlc" %>
    <%@ page import="model.Jogo" %>
      <% Dlc dlc=(Dlc) request.getAttribute("entidade"); // Obtém a entidade DLC da requisição %>
        <html lang="pt-br">

        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>
            <%= dlc==null ? "Cadastro" : "Edição" %> de DLC
          </title>
          <link rel="stylesheet" href="./css/style.css">
        </head>

        <body>
          <main class="principal">
            <div class="principal-titulo">
              <h1>
                <%= dlc==null ? "Cadastro" : "Edição" %> de DLC
              </h1>
            </div>

            <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
              <div class="principal-formulario">
                <!-- ID -->
                <input type="hidden" name="id" value="<%= dlc != null ? dlc.getId() : "" %>">
                <!-- Ação (Cadastrar ou Editar) -->
                <input type="hidden" name="acao" value="<%= dlc != null ? " atualizar" : "cadastrar" %>">

                <!-- Nome -->
                <div>
                  <label for="nome">Nome: </label>
                  <input id="nome" type="text" name="nome" value="<%= dlc != null ? dlc.getNome() : "" %>" required>
                </div>

                <!-- Desenvolvedora -->
                <div>
                  <label for="desenvolvedora">Desenvolvedora: </label>
                  <input id="desenvolvedora" type="text" name="desenvolvedora"
                    value="<%= dlc != null ? dlc.getDesenvolvedora() : "" %>" required>
                </div>

                <!-- Descrição -->
                <div>
                  <label for="descricao">Descrição: </label>
                  <input id="descricao" type="text" name="descricao"
                    value="<%= dlc != null ? dlc.getDescricao() : "" %>" required>
                </div>

                <!-- Valor -->
                <div>
                  <label for="valor">Valor: </label>
                  <input id="valor" type="number" name="valor" step="0.01"
                    value="<%= dlc != null ? dlc.getValor() : "" %>" required>
                </div>

                <!-- Custo -->
                <div>
                  <label for="custo">Custo: </label>
                  <input id="custo" type="number" name="custo" step="0.01"
                    value="<%= dlc != null ? dlc.getPCusto() : "" %>" required>
                </div>

                <!-- Jogo Base -->
                <div>
                  <label for="jogo_id">Jogo Base (ID): </label>
                  <input id="jogo_id" type="number" name="jogo_id"
                    value="<%= dlc != null && dlc.getJogoBase() != null ? dlc.getJogoBase().getId() : "" %>" required>
                </div>

                <!-- Data de Lançamento -->
                <div>
                  <label for="dataLancamento">Data de Lançamento: </label>
                  <input type="date" id="dataLancamento" name="dataLancamento"
                    value="<%= dlc != null ? dlc.getDataLancamento() : "" %>" required>
                </div>

                <!-- Botão de envio -->
                <div>
                  <button type="submit">
                    <%= dlc==null ? "Cadastrar" : "Editar" %>
                  </button>
                </div>
              </div>
            </form>
          </main>
        </body>

        </html>