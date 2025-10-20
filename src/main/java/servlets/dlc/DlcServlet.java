package servlets.dlc;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.JogoDAO;
import model.Dlc;
import model.Jogo;
import servlets.GenericServlet;

@WebServlet("/dlc")
public class DlcServlet extends GenericServlet<Dlc> {

    @Override
    protected Dlc preencherEntidade(HttpServletRequest request) {
        Dlc dlc = new Dlc();

        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                dlc.setId(Integer.parseInt(idStr));
            } catch (NumberFormatException ignored) {
            }
        }

        dlc.setNome(request.getParameter("nome"));
        dlc.setDesenvolvedora(request.getParameter("desenvolvedora"));
        dlc.setDescricao(request.getParameter("descricao"));

        try {
            String valorStr = request.getParameter("valor");
            if (valorStr != null && !valorStr.isEmpty()) {
                dlc.setValor(Double.parseDouble(valorStr));
            }
        } catch (NumberFormatException e) {

        }

        try {
            String pCustoStr = request.getParameter("pCusto");
            if (pCustoStr != null && !pCustoStr.isEmpty()) {
                dlc.setPCusto(Double.parseDouble(pCustoStr));
            }
        } catch (NumberFormatException e) {

        }

        JogoDAO jogoDAO = new JogoDAO();
        Jogo jogoBase = null;
        String jogoIdStr = request.getParameter("jogo_id");
        if (jogoIdStr == null || jogoIdStr.isEmpty()) {

        } else {
            try {
                int jogoId = Integer.parseInt(jogoIdStr);
                jogoBase = jogoDAO.buscarPorId(jogoId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        dlc.setJogoBase(jogoBase);

        String dataLancStr = request.getParameter("dataLancamento");
        if (dataLancStr != null && !dataLancStr.isEmpty()) {
            dlc.setDataLancamento(LocalDate.parse(dataLancStr));
        }

        dlc.setDataCriacao(LocalDate.now());
        return dlc;
    }

    @Override
    protected void doPost(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response)
            throws IOException {
        try {

            Dlc entidade = preencherEntidade(request);

            if (entidade.getJogoBase() == null) {
                request.setAttribute("erro", "É obrigatório selecionar um jogo base existente para a DLC.");
                // repopular lista de jogos para o form
                JogoDAO jogoDAO = new JogoDAO();
                request.setAttribute("jogos", jogoDAO.listarTodos());
                request.setAttribute("entidade", entidade);
                request.setAttribute("urlSubmit", request.getContextPath() + "/dlc");
                request.getRequestDispatcher("/dlc/form.jsp").forward(request, response);
                return;
            }

            boolean ehAtualizacao = entidade.getId() != null;
            if (ehAtualizacao) {
                dao.atualizar(entidade, (model.Usuario) request.getSession().getAttribute("usuarioLogado"));
            } else {
                dao.salvar(entidade, (model.Usuario) request.getSession().getAttribute("usuarioLogado"));
            }

            response.sendRedirect(request.getContextPath() + "/dlc?acao=listar");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
