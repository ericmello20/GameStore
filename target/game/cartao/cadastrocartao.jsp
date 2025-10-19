<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Cadastrar Cartão</title>
</head>

<body>
  <form action="cartao" method="post">
    <input type="hidden" name="acao" value="cadastrar" />

    <label for="bandeira">Bandeira:</label>
    <input type="text" name="bandeira" id="bandeira" class="bandeira" required /><br />

    <label for="numero">Número:</label>
    <input type="text" name="numero" id="numero" class="numero" maxlength="16" required /><br />

    <label for="cvv">CVV:</label>
    <input type="text" name="cvv" id="cvv" class="cvv" maxlength="3" required /><br />

    <label for="cpfTitular">CPF do Titular:</label>
    <input type="text" name="cpfTitular" id="cpfTitular" class="cpfTitular" required /><br />

    <label for="validade">Validade:</label>
    <input type="month" name="validade" id="validade" class="validade" required /><br />

    <label for="cliente_id">ID do Cliente:</label>
    <input type="number" name="cliente_id" id="cliente_id" class="cliente_id" required /><br />

    <button type="submit">Enviar</button>
  </form>
</body>

</html>