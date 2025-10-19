<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Cadastre-se</title>
</head>

<body>
  <h2>x</h2>
  <form action="cliente" method="post">
    <input type="hidden" name="acao" value="cadastrar">

    <label for="nome">Nome: </label>
    <input type="text" name="nome" id="nome" class="nome" required /><br />

    <label for="email">Email: </label>
    <input type="email" name="email" id="email" class="email" required /><br />

    <label for="senha">Senha: </label>
    <input type="password" name="senha" id="senha" class="senha" required /><br />

    <label for="data_nascimento">Nascimento: </label>
    <input type="date" name="data_nascimento" id="data_nascimento" class="data_nascimento" required><br />

    <button type="submit">Enviar</button>
  </form>
</body>

</html>