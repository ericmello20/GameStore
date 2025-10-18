package servlets.cliente;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;

import model.Usuario;
import servlets.GenericServlet;

@WebServlet("/cliente")
public class ClienteServlet extends GenericServlet<Usuario> {

    @Override
    protected Usuario preencherEntidade(HttpServletRequest request) {
        Usuario usuario = new Usuario(
                request.getParameter("nome"),
                request.getParameter("email"),
                request.getParameter("senha"));

        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            usuario.setId(Integer.parseInt(idStr));
        }

        String dataNascimentoStr = request.getParameter("dataNascimento");
        if (dataNascimentoStr != null && !dataNascimentoStr.isEmpty()) {
            usuario.setDataNascimento(LocalDate.parse(dataNascimentoStr));
        }

        String dataCadastroStr = request.getParameter("dataCadastro");
        if (dataCadastroStr != null && !dataCadastroStr.isEmpty()) {
            usuario.setDataCadastro(LocalDate.parse(dataCadastroStr));
        } else {
            usuario.setDataCadastro(LocalDate.now());
        }

        return usuario;
    }
}
