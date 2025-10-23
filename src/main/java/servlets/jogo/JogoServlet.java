package servlets.jogo;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Jogo;
import servlets.GenericServlet;

@WebServlet("/jogo")
public class JogoServlet extends GenericServlet<Jogo> {

    @Override
    protected Jogo preencherEntidade(HttpServletRequest request) {
        // Coleta de parâmetros comuns
        String nome = request.getParameter("nome");
        String desenvolvedora = request.getParameter("desenvolvedora");
        String descricao = request.getParameter("descricao");

        double valor = 0;
        double pCusto = 0;
        try {
            valor = Double.parseDouble(request.getParameter("valor"));
            pCusto = Double.parseDouble(request.getParameter("pCusto"));
        } catch (NumberFormatException e) {
            // mantém 0 se houver erro de conversão
        }

        // Criação via construtor
        Jogo jogo = new Jogo(nome, desenvolvedora, descricao, valor, pCusto);

        // ID (edição)
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            try {
                jogo.setId(Integer.parseInt(idStr));
            } catch (NumberFormatException ignored) {}
        }

        // Datas
        String dataLancStr = request.getParameter("dataLancamento");
        if (dataLancStr != null && !dataLancStr.isEmpty()) {
            jogo.setDataLancamento(LocalDate.parse(dataLancStr));
        }

        jogo.setDataCriacao(LocalDate.now());
        return jogo;
    }
}
