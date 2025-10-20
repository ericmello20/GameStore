package servlets.cartao;

import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import model.Cartao;
import model.Usuario;
import servlets.GenericServlet;

@WebServlet("/cartao")
public class CartaoServlet extends GenericServlet<Cartao> {

    @Override
    protected Cartao preencherEntidade(HttpServletRequest request) {
        Cartao cartao = new Cartao();

        // --- ID (só converte se tiver valor) ---
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.trim().isEmpty()) {
            try {
                cartao.setId(Integer.parseInt(idStr));
            } catch (NumberFormatException e) {
                // Ignora ID inválido em cadastro novo
            }
        }

        // --- Campos básicos ---
        cartao.setNumero(request.getParameter("numero"));
        cartao.setBandeira(request.getParameter("bandeira"));
        cartao.setCvv(request.getParameter("cvv"));
        cartao.setCpfTitular(request.getParameter("cpfTitular"));

        // --- Validade (LocalDate) ---
        String validadeStr = request.getParameter("validade");
        if (validadeStr != null && !validadeStr.trim().isEmpty()) {
            try {
                cartao.setValidade(LocalDate.parse(validadeStr + "-01")); // converte yyyy-MM para yyyy-MM-01
            } catch (Exception e) {
                e.printStackTrace(); // apenas para debug
            }
        }

        // --- Cliente ---
        String clienteIdStr = request.getParameter("cliente_id");
        if (clienteIdStr != null && !clienteIdStr.trim().isEmpty()) {
            try {
                Usuario cliente = new Usuario();
                cliente.setId(Integer.parseInt(clienteIdStr));
                cartao.setCliente(cliente);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        cartao.setDataCriacao(LocalDate.now());
        return cartao;
    }

}
