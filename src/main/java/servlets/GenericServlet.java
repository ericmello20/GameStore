package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import model.Entidade;
import model.Usuario;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import dao.GenericDAO;

public abstract class GenericServlet<T extends Entidade> extends HttpServlet {
    protected GenericDAO<T> dao;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    @Override
    public void init() throws ServletException {
        super.init();
        // Descobre a classe de T em tempo de execução
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

        // tenta instanciar DAO por convenção: dao.<NomeClasse>DAO
        String daoClassName = "dao." + clazz.getSimpleName() + "DAO";
        try {
            Class<?> daoClass = Class.forName(daoClassName);
            this.dao = (GenericDAO<T>) daoClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new ServletException("Erro ao inicializar DAO para " + clazz.getSimpleName(), e);
        }
    }

    protected abstract T preencherEntidade(HttpServletRequest request);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String acao = request.getParameter("acao");
            if (acao == null)
                acao = "listar";

            if (acao.equals("listar")) {
                List<T> lista = dao.listarTodos();
                request.setAttribute("lista", lista);
                
                try {
                    request.getRequestDispatcher("/" + clazz.getSimpleName().toLowerCase() + "/lista.jsp")
                            .forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                return;
            } else if (acao.equals("inserir")) {
                request.setAttribute("entidade", null);
                request.setAttribute("urlSubmit", request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase());
                try {
                    request.getRequestDispatcher("/" + clazz.getSimpleName().toLowerCase() + "/form.jsp")
                            .forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                return;
            } else if (acao.equals("editar")) {
                String idStr = request.getParameter("id");
                if (idStr != null) {
                    try {
                        Integer id = Integer.parseInt(idStr);
                        T entidade = dao.buscarPorId(id);
                        request.setAttribute("entidade", entidade);
                        request.setAttribute("urlSubmit",
                                request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase());
                        request.getRequestDispatcher("/" + clazz.getSimpleName().toLowerCase() + "/form.jsp")
                                .forward(request, response);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                response.sendRedirect(
                        request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase() + "?acao=listar");
                return;
            } else if (acao.equals("deletar")) {
                String idStr = request.getParameter("id");
                if (idStr != null) {
                    try {
                        Integer id = Integer.parseInt(idStr);
                        dao.deletar(id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                response.sendRedirect(
                        request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase() + "?acao=listar");
                return;
            } else {
                response.sendRedirect(
                        request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase() + "?acao=listar");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession(false);
            Usuario usuario = null;
            if (session != null) {
                usuario = (Usuario) session.getAttribute("usuarioLogado");
            }

            String idStr = request.getParameter("id");
            boolean ehAtualizacao = idStr != null && !idStr.trim().isEmpty();

            T entidade = preencherEntidade(request);

            if (ehAtualizacao) {
                dao.atualizar(entidade, usuario);
            } else {
                dao.salvar(entidade, usuario);
            }

            response.sendRedirect(
                    request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase() + "?acao=listar");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
