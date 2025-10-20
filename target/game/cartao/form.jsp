<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="model.Cartao" %>
    <%@ page import="model.Usuario" %>

      <% Cartao cartao=(Cartao) request.getAttribute("entidade"); String urlSubmit=(String)
        request.getAttribute("urlSubmit"); if (urlSubmit==null) { // fallback se o servlet não setou a URL (evita /null)
        urlSubmit=request.getContextPath() + "/cartao" ; } %>

        <html lang="pt-br">

        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>
            <%= cartao==null ? "Cadastro" : "Edição" %> de Cartão
          </title>
          <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
        </head>

        <body>
          <main class="principal">
            <div class="principal-titulo">
              <h1>
                <%= cartao==null ? "Cadastro" : "Edição" %> de Cartão
              </h1>
            </div>

            <form action="<%= urlSubmit %>" method="post">
              <div class="principal-formulario">
                <input type="hidden" name="id" value="<%= cartao != null ? cartao.getId() : "" %>">
                <input type="hidden" name="acao" value="<%= cartao != null ? "atualizar" : "cadastrar" %>">

                <!-- Número do Cartão -->
                <div>
                  <label for="numero">Número do Cartão:</label>
                  <input id="numero" type="text" name="numero" value="<%= cartao != null ? cartao.getNumero() : "" %>"
                    required>
                </div>

                <!-- Bandeira -->
                <div>
                  <label for="bandeira">Bandeira:</label>
                  <input id="bandeira" type="text" name="bandeira"
                    value="<%= cartao != null ? cartao.getBandeira() : "" %>" required>
                </div>

                <!-- CVV -->
                <div>
                  <label for="cvv">CVV:</label>
                  <input id="cvv" type="text" name="cvv" value="<%= cartao != null ? cartao.getCvv() : "" %>" required>
                </div>

                <!-- CPF Titular -->
                <div>
                  <label for="cpfTitular">CPF do Titular:</label>
                  <input id="cpfTitular" type="text" name="cpfTitular"
                    value="<%= cartao != null ? cartao.getCpfTitular() : "" %>" required>
                </div>

                <!-- Validade -->
                <div>
                  <label for="validade">Validade:</label>
                  <input type="month" id="validade" name="validade"
                    value="<%= cartao != null ? cartao.getValidade() : "" %>" required>
                </div>

                <!-- Cliente -->
                <div>
                  <label for="cliente_id">Cliente (ID):</label>
                  <input type="number" id="cliente_id" name="cliente_id"
                    value="<%= cartao != null && cartao.getCliente() != null ? cartao.getCliente().getId() : "" %>"
                    required>
                </div>

                <div>
                  <button type="submit">
                    <%= cartao==null ? "Cadastrar" : "Editar" %>
                  </button>
                </div>
              </div>
            </form>
          </main>
        </body>

        </html>