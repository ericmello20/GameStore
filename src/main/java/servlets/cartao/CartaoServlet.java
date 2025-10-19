package servlets.cartao;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Cartao;
import model.Usuario;
import servlets.GenericServlet;
import dao.UsuarioDao;

@WebServlet("/cartao")
public class CartaoServlet extends GenericServlet<Cartao> {

    @Override
    protected Cartao preencherEntidade(HttpServletRequest request) {
        Cartao cartao = new Cartao();

        cartao.setBandeira(request.getParameter("bandeira"));
        cartao.setNumero(request.getParameter("numero"));
        cartao.setCvv(request.getParameter("cvv"));
        cartao.setCpfTitular(request.getParameter("cpfTitular"));

        String validadeStr = request.getParameter("validade");
        if (validadeStr != null && !validadeStr.isEmpty()) {
            cartao.setValidade(LocalDate.parse(validadeStr + "-01"));
        }

        String clienteIdStr = request.getParameter("cliente_id");
        if (clienteIdStr != null && !clienteIdStr.isEmpty()) {
            try {
                int clienteId = Integer.parseInt(clienteIdStr);

                UsuarioDao usuarioDAO = new UsuarioDao();
                Usuario cliente = usuarioDAO.buscarPorId(clienteId);

                cartao.setCliente(cliente);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cartao.setDataCriacao(LocalDate.now());

        return cartao;
    }

}
