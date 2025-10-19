<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Cadastrar DLC</title>
</head>

<body>
  <form action="dlc" method="post">
    <input type="hidden" name="acao" value="cadastrar" />

    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" class="nome" required /><br />

    <label for="desenvolvedora">Desenvolvedora:</label>
    <input type="text" name="desenvolvedora" id="desenvolvedora" class="desenvolvedora" required /><br />

    <label for="descricao">Descricao:</label>
    <textarea name="descricao" id="descricao" class="descricao" rows="4" cols="40" required></textarea><br />

    <label for="valor">Valor (R$):</label>
    <input type="number" name="valor" id="valor" class="valor" step="0.01" required /><br />

    <label for="pCusto">Preco de Custo (R$):</label>
    <input type="number" name="pCusto" id="pCusto" class="pCusto" step="0.01" required /><br />

    <label for="dataLancamento">Data de Lancamento:</label>
    <input type="date" name="dataLancamento" id="dataLancamento" class="dataLancamento" required /><br />

    <label for="jogo_id">ID do Jogo Base:</label>
    <input type="number" name="jogo_id" id="jogo_id" class="jogo_id" required /><br />

    <button type="submit">Enviar</button>
  </form>
</body>

</html>