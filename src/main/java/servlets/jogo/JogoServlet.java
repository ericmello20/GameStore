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

        Jogo jogo = new Jogo(
                request.getParameter("nome"),
                request.getParameter("desenvolvedora"),
                request.getParameter("descricao"),
                Double.parseDouble(request.getParameter("valor")),
                Double.parseDouble(request.getParameter("pCusto")));
        jogo.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);
        String dataLancStr = request.getParameter("dataLancamento");
        if (dataLancStr != null && !dataLancStr.isEmpty()) {
            jogo.setDataLancamento(LocalDate.parse(dataLancStr));
        }

        jogo.setDataCriacao(LocalDate.now());

        return jogo;
    }
}
