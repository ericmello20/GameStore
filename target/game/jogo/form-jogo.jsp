<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="model.Jogo" %>
    <%@ page import="model.Usuario" %>
      <% Jogo jogo=(Jogo) request.getAttribute("entidade"); %>
        <html lang="pt-br">

        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>
            <%= jogo==null ? "Cadastro" : "Edição" %> de Jogo
          </title>
          <link rel="stylesheet" href="./css/style.css">
        </head>

        <body>
          <main class="principal">
            <div class="principal-titulo">
              <h1>
                <%= jogo==null ? "Cadastro" : "Edição" %> de Jogo
              </h1>
            </div>

            <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
              <div class="principal-formulario">
                <input type="hidden" name="id" value="<%= jogo != null ? jogo.getId() : "" %>">
                <input type="hidden" name="acao" value="<%= jogo != null ? " atualizar" : "cadastrar" %>">

                <!-- Nome do Jogo -->
                <div>
                  <label for="nome">Nome: </label>
                  <input id="nome" type="text" name="nome" value="<%= jogo != null ? jogo.getNome() : "" %>" required>
                </div>

                <!-- Desenvolvedora -->
                <div>
                  <label for="desenvolvedora">Desenvolvedora: </label>
                  <input id="desenvolvedora" type="text" name="desenvolvedora"
                    value="<%= jogo != null ? jogo.getDesenvolvedora() : "" %>" required>
                </div>

                <!-- Descrição -->
                <div>
                  <label for="descricao">Descrição: </label>
                  <input id="descricao" type="text" name="descricao"
                    value="<%= jogo != null ? jogo.getDescricao() : "" %>" required>
                </div>

                <!-- Valor -->
                <div>
                  <label for="valor">Valor: </label>
                  <input id="valor" type="number" name="valor" step="0.01"
                    value="<%= jogo != null ? jogo.getValor() : "" %>" required>
                </div>

                <!-- Preço de Custo -->
                <div>
                  <label for="pcusto">Preço de Custo: </label>
                  <input id="pcusto" type="number" name="pcusto" step="0.01"
                    value="<%= jogo != null ? jogo.getPCusto() : "" %>" required>
                </div>

                <!-- Data de Lançamento -->
                <div>
                  <label for="dataLancamento">Data de Lançamento: </label>
                  <input type="date" id="dataLancamento" name="dataLancamento"
                    value="<%= jogo != null ? jogo.getDataLancamento() : "" %>" required>
                </div>

                <div>
                  <button>
                    <%= jogo==null ? "Cadastrar" : "Editar" %>
                  </button>
                </div>
              </div>
            </form>
          </main>
        </body>

        </html>