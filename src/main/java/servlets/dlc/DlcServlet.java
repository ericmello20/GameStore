package servlets.dlc;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dlc;
import model.Jogo;
import dao.JogoDAO;
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

        String dataLancStr = request.getParameter("dataLancamento");
        if (dataLancStr != null && !dataLancStr.isEmpty()) {
            try {
                dlc.setDataLancamento(LocalDate.parse(dataLancStr));
            } catch (Exception e) {

            }
        }

        dlc.setDataCriacao(java.time.LocalDate.now());
        return dlc;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {

            String jogoIdStr = request.getParameter("idJogo");
            Jogo jogoBase = null;
            if (jogoIdStr == null || jogoIdStr.trim().isEmpty()) {
                request.setAttribute("erro", "É obrigatório informar o ID do jogo base.");
            } else {
                try {
                    int jogoId = Integer.parseInt(jogoIdStr.trim());
                    JogoDAO jogoDAO = new JogoDAO();
                    jogoBase = jogoDAO.buscarPorId(jogoId);
                    if (jogoBase == null) {
                        request.setAttribute("erro", "Jogo com ID " + jogoId + " não encontrado.");
                    }
                } catch (NumberFormatException nfe) {
                    request.setAttribute("erro", "ID do jogo inválido.");
                }
            }

            if (request.getAttribute("erro") != null) {

                JogoDAO jogoDAO = new JogoDAO();
                request.setAttribute("jogos", jogoDAO.listarTodos());

                Dlc entidade = preencherEntidade(request);
                request.setAttribute("entidade", entidade);
                request.setAttribute("urlSubmit", request.getContextPath() + "/dlc");
                request.getRequestDispatcher("/dlc/form.jsp").forward(request, response);
                return;
            }

            Dlc entidade = preencherEntidade(request);
            entidade.setJogoBase(jogoBase);

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
