package servlets.dlc;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import dao.JogoDAO;
import model.Dlc;
import model.Jogo;
import servlets.GenericServlet;

@WebServlet("/dlc")
public class DlcServlet extends GenericServlet<Dlc> {

    @Override
    protected Dlc preencherEntidade(HttpServletRequest request) {
        // Parâmetros herdados de Conteudo
        String nome = request.getParameter("nome");
        String desenvolvedora = request.getParameter("desenvolvedora");
        String descricao = request.getParameter("descricao");

        double valor = 0;
        double pCusto = 0;
        try {
            valor = Double.parseDouble(request.getParameter("valor"));
            pCusto = Double.parseDouble(request.getParameter("pCusto"));
        } catch (NumberFormatException e) {
            // mantém 0 se erro
        }

        // Obter Jogo base
        Jogo jogoBase = null;
        String jogoIdStr = request.getParameter("jogo_id");
        if (jogoIdStr != null && !jogoIdStr.isEmpty()) {
            try {
                int jogoId = Integer.parseInt(jogoIdStr);
                JogoDAO jogoDAO = new JogoDAO();
                jogoBase = jogoDAO.buscarPorId(jogoId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Criar via construtor
        Dlc dlc = new Dlc(nome, desenvolvedora, descricao, valor, pCusto, jogoBase);

        // ID (edição)
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            try {
                dlc.setId(Integer.parseInt(idStr));
            } catch (NumberFormatException ignored) {}
        }

        // Datas
        String dataLancStr = request.getParameter("dataLancamento");
        if (dataLancStr != null && !dataLancStr.isEmpty()) {
            dlc.setDataLancamento(LocalDate.parse(dataLancStr));
        }

        dlc.setDataCriacao(LocalDate.now());
        return dlc;
    }
}
