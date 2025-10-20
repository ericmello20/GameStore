package servlets.cartao;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Cartao;
import model.Usuario;
import servlets.GenericServlet;
import dao.UsuarioDAO;

@WebServlet("/cartao")
public class CartaoServlet extends GenericServlet<Cartao> {

    @Override
    protected Cartao preencherEntidade(HttpServletRequest request) {
        Cartao cartao = new Cartao();

        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                cartao.setId(Integer.parseInt(idStr));
            } catch (NumberFormatException e) {

            }
        }

        cartao.setNumero(request.getParameter("numero"));
        cartao.setBandeira(request.getParameter("bandeira"));
        cartao.setCvv(request.getParameter("cvv"));
        cartao.setCpfTitular(request.getParameter("cpfTitular"));

        String validadeStr = request.getParameter("validade");
        if (validadeStr != null && !validadeStr.trim().isEmpty()) {
            try {
                cartao.setValidade(LocalDate.parse(validadeStr + "-01"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String clienteIdStr = request.getParameter("cliente_id");
        if (clienteIdStr != null && !clienteIdStr.trim().isEmpty()) {
            try {
                Integer cid = Integer.parseInt(clienteIdStr);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario cliente = usuarioDAO.buscarPorId(cid);
                if (cliente != null) {
                    cartao.setCliente(cliente);
                } else {

                    throw new NumberFormatException("Cliente não encontrado: " + cid);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        cartao.setDataCriacao(LocalDate.now());
        return cartao;
    }

}
