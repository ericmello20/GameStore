package servlets.dlc;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Dlc;
import model.Jogo;
import servlets.GenericServlet;
import dao.JogoDAO;

@WebServlet("/dlc")
public class DlcServlet extends GenericServlet<Dlc> {

    @Override
    protected Dlc preencherEntidade(HttpServletRequest request) {

        Dlc dlc = new Dlc(
                request.getParameter("nome"),
                request.getParameter("desenvolvedora"),
                request.getParameter("descricao"),
                Double.parseDouble(request.getParameter("valor")),
                Double.parseDouble(request.getParameter("pCusto")),
                null);
        
        dlc.setId(request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0);

        String dataLancStr = request.getParameter("dataLancamento");
        if (dataLancStr != null && !dataLancStr.isEmpty()) {
            dlc.setDataLancamento(LocalDate.parse(dataLancStr));
        }

        dlc.setDataCriacao(LocalDate.now());

        String jogoIdStr = request.getParameter("jogo_id");
        if (jogoIdStr != null && !jogoIdStr.isEmpty()) {
            try {
                int jogoId = Integer.parseInt(jogoIdStr);
                JogoDAO jogoDAO = new JogoDAO();
                Jogo jogoBase = jogoDAO.buscarPorId(jogoId);
                if (jogoBase != null) {
                    dlc.setJogoBase(jogoBase);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dlc;
    }
}
