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

        String idStr = request.getParameter("id");
        Usuario usuario = null;

        if (idStr != null && !idStr.trim().isEmpty()) {
            
            try {
                Integer id = Integer.parseInt(idStr);
                usuario = dao.buscarPorId(id);
                if (usuario == null) {
                  
                    usuario = new Usuario(nome, email, senha, dataNascimento);
                    usuario.setId(id);
                } else {
                   
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);
                    usuario.setDataNascimento(dataNascimento);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                usuario = new Usuario(nome, email, senha, dataNascimento);
            }
        } else {
           
            usuario = new Usuario(nome, email, senha, dataNascimento);
        }

       
        if (usuario.getId() == null) {
            usuario.setDataCriacao(LocalDate.now());
           
            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setCliente(usuario);
            usuario.setBiblioteca(biblioteca);
        }

        return usuario;
    }
}
