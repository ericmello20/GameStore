package servlets;

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
    public GenericServlet() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        this.dao = new GenericDAO<T>(clazz) {

        };

    }

    // método utilitário para pegar o usuário logado
    protected Usuario getUsuarioLogado(HttpServletRequest request) {
        return (Usuario) request.getSession().getAttribute("usuarioLogado");

    }

    protected abstract T preencherEntidade(HttpServletRequest request);

    protected void inserirBibliotecaJogo(T entidade, Usuario Usuario) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acao = request.getParameter("acao");
        if (acao == null)
            acao = "listar";
        Usuario usuario = getUsuarioLogado(request);
        String urlSubmit = request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase();
        request.setAttribute("urlSubmit", urlSubmit);
        if (usuario == null) {
            /**
             * Implementar redirecionamento para página de acesso negado. Faremos mais para
             * frente
             * response.sendRedirect("acesso-negado.jsp");
             * return;
             */
        }

        try {
            if (acao.equals("inserir")) {
                try {
                    request.getRequestDispatcher(clazz.getSimpleName().toLowerCase() + "/form.jsp").forward(request,
                            response);

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            else if (acao.equals("listar")) {
                List<T> lista = dao.listarTodos();
                request.setAttribute("lista", lista);
                try {
                    request.getRequestDispatcher(clazz.getSimpleName().toLowerCase() + "/lista.jsp").forward(request,
                            response);

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            else if (acao.equals("listarPorId")) {
                int idBuscar = Integer.parseInt(request.getParameter("id"));
                T entidade = dao.buscarPorId(idBuscar);
                request.setAttribute("entidade", entidade);
                try {
                    request.getRequestDispatcher(clazz.getSimpleName().toLowerCase() + "/form.jsp").forward(request,
                            response);

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }

            else if (acao.equals("deletar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deletar(id);
                response.sendRedirect(urlSubmit + "?acao=listar");

            }

        } catch (Exception e) {
            e.printStackTrace();
            // response.sendRedirect("erro.jsp");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acao = request.getParameter("acao");
        Usuario usuario = getUsuarioLogado(request);
        String urlSubmit = request.getContextPath() + "/" + clazz.getSimpleName().toLowerCase();
        request.setAttribute("urlSubmit", urlSubmit);

        try {
            if (acao.equals("cadastrar")) {
                T entidade = preencherEntidade(request);
                dao.salvar(entidade, usuario);
                inserirBibliotecaJogo(entidade, usuario);

            }

            else if (acao.equals("atualizar")) {
                T entidadeAtualizada = preencherEntidade(request);
                dao.atualizar(entidadeAtualizada, usuario);

            }

            response.sendRedirect(urlSubmit + "?acao=listar");

        } catch (Exception e) {
            e.printStackTrace();
            // response.sendRedirect("erro.jsp");

        }

    }

}