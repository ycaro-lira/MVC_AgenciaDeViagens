package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.ClienteDAO;

@WebServlet("/Inserir")
public class InserirClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idCliente = request.getParameter("id_cliente");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Cliente objCliente = new Cliente();

        objCliente.setId_cliente(idCliente);
        objCliente.setNome(nome);
        objCliente.setEmail(email);
        objCliente.setSenha(senha);

        ClienteDAO cdao = new ClienteDAO();
        cdao.save(objCliente);

        response.sendRedirect("inicio.html");
    }
}
