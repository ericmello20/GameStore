package servlets.cliente;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Biblioteca;
import model.Usuario;
import servlets.GenericServlet;

@WebServlet("/usuario")
public class ClienteServlet extends GenericServlet<Usuario> {

    
    @Override
    protected Usuario preencherEntidade(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        String dataNascimentoStr = request.getParameter("data_nascimento");
        LocalDate dataNascimento = null;
        if (dataNascimentoStr != null && !dataNascimentoStr.isEmpty()) {
            dataNascimento = LocalDate.parse(dataNascimentoStr);
        }

        Usuario usuario = new Usuario(nome, email, senha, dataNascimento);
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.trim().isEmpty()) {
            usuario.setId(Integer.parseInt(idStr));
        }
        // caso contrário NÃO chame setId(...) — mantenha id como null para novas
        // entidades

        usuario.setDataCriacao(LocalDate.now());

        return usuario;
    }
}
