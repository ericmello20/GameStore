<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="model.Dlc, model.Jogo, java.util.List" %>

    <% Dlc dlc=(Dlc) request.getAttribute("entidade"); String urlSubmit=(String) request.getAttribute("urlSubmit"); if
      (urlSubmit==null) { urlSubmit=request.getContextPath() + "/dlc" ; } List<Jogo> jogos = (List<Jogo>)
        request.getAttribute("jogos");
        %>

        <html lang="pt-br">

        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>
            <%= dlc==null ? "Cadastro" : "Edição" %> de DLC
          </title>
          <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
        </head>

        <body>
          <main class="principal">
            <div class="principal-titulo">
              <h1>
                <%= dlc==null ? "Cadastro" : "Edição" %> de DLC
              </h1>
            </div>

            <form action="<%= urlSubmit %>" method="post">
              <div class="principal-formulario">


                <input type="hidden" name="id" value="<%= dlc != null ? dlc.getId() : "" %>">


                <input type="hidden" name="acao" value="<%= dlc != null ? "atualizar" : "cadastrar" %>">


                <div>
                  <label for="nome">Nome:</label>
                  <input id="nome" type="text" name="nome" value="<%= dlc != null ? dlc.getNome() : "" %>" required>
                </div>


                <div>
                  <label for="desenvolvedora">Desenvolvedora:</label>
                  <input id="desenvolvedora" type="text" name="desenvolvedora"
                    value="<%= dlc != null ? dlc.getDesenvolvedora() : "" %>" required>
                </div>


                <div>
                  <label for="descricao">Descrição:</label>
                  <textarea id="descricao" name="descricao" rows="4"
                    required><%= dlc != null ? dlc.getDescricao() : "" %></textarea>
                </div>


                <div>
                  <label for="valor">Valor (R$):</label>
                  <input id="valor" type="number" step="0.01" name="valor"
                    value="<%= dlc != null ? dlc.getValor() : "" %>" required>
                </div>


                <div>
                  <label for="pCusto">Preço de Custo (R$):</label>
                  <input id="pCusto" type="number" step="0.01" name="pCusto"
                    value="<%= dlc != null ? dlc.getPCusto() : "" %>" required>
                </div>


                <div>
                  <label for="jogo_id">Jogo Base:</label>
                  <select id="jogo_id" name="jogo_id">
                    <option value="">-- Selecione um jogo --</option>
                    <% if (jogos !=null) { for (Jogo j : jogos) { boolean selecionado=(dlc !=null && dlc.getJogoBase()
                      !=null && dlc.getJogoBase().getId()==j.getId()); %>
                      <option value="<%= j.getId() %>" <%=selecionado ? "selected" : "" %>><%= j.getNome() %>
                      </option>
                      <% } } %>
                  </select>
                </div>


                <div>
                  <label for="dataLancamento">Data de Lançamento:</label>
                  <input type="date" id="dataLancamento" name="dataLancamento"
                    value="<%= dlc != null && dlc.getDataLancamento() != null ? dlc.getDataLancamento() : "" %>">
                </div>


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