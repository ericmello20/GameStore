<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Dlc, model.Jogo, java.util.List" %>

<%
    Dlc dlc = (Dlc) request.getAttribute("entidade");
    String urlSubmit = (String) request.getAttribute("urlSubmit");
    if (urlSubmit == null) {
        urlSubmit = request.getContextPath() + "/dlc";
    }
    List<Jogo> jogos = (List<Jogo>) request.getAttribute("jogos"); // opcional, usado se quiser mostrar lista
    String erro = (String) request.getAttribute("erro");
%>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title><%= (dlc == null ? "Cadastro" : "Edição") %> de DLC</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <main class="principal">
        <div class="principal-titulo">
            <h1><%= (dlc == null ? "Cadastro" : "Edição") %> de DLC</h1>
        </div>

        <% if (erro != null && !erro.isEmpty()) { %>
            <p style="color:red;"><%= erro %></p>
        <% } %>

        <form action="<%= urlSubmit %>" method="post">
            <input type="hidden" name="id" value="<%= (dlc != null ? dlc.getId() : "") %>">

            <div>
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="nome" value="<%= (dlc != null ? dlc.getNome() : "") %>" required>
            </div>

            <div>
                <label for="desenvolvedora">Desenvolvedora:</label>
                <input id="desenvolvedora" type="text" name="desenvolvedora"
                       value="<%= (dlc != null ? dlc.getDesenvolvedora() : "") %>">
            </div>

            <div>
                <label for="descricao">Descrição:</label>
                <textarea id="descricao" name="descricao" rows="4"><%= (dlc != null ? dlc.getDescricao() : "") %></textarea>
            </div>

            <div>
                <label for="valor">Valor (R$):</label>
                <input id="valor" type="number" step="0.01" name="valor"
                       value="<%= (dlc != null ? dlc.getValor() : "") %>">
            </div>

            <div>
                <label for="pCusto">Preço de Custo (R$):</label>
                <input id="pCusto" type="number" step="0.01" name="pCusto"
                       value="<%= (dlc != null ? dlc.getPCusto() : "") %>">
            </div>

            <div>
                <label for="idJogo">ID do Jogo Base:</label>
                <input id="idJogo" type="number" name="idJogo" value="<%= (dlc != null && dlc.getJogoBase() != null ? dlc.getJogoBase().getId() : "") %>" required>
                <small>Digite o ID do jogo (ex.: 1)</small>
            </div>

            <div>
                <label for="dataLancamento">Data de Lançamento:</label>
                <input id="dataLancamento" type="date" name="dataLancamento"
                       value="<%= (dlc != null && dlc.getDataLancamento() != null ? dlc.getDataLancamento().toString() : "") %>">
            </div>

            <div style="margin-top:10px;">
                <input type="submit" value="<%= (dlc == null ? "Cadastrar" : "Atualizar") %>">
            </div>
        </form>

        <hr/>

        <%-- Opcional: mostrar lista de jogos abaixo para referência (se foi carregada pelo servlet) --%>
        <% if (jogos != null && !jogos.isEmpty()) { %>
            <h3>Jogos disponíveis (id : nome)</h3>
            <ul>
            <% for (Jogo j : jogos) { %>
                <li><%= j.getId() %> : <%= j.getNome() %></li>
            <% } %>
            </ul>
        <% } %>

    </main>
</body>
</html>
