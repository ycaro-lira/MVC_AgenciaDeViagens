package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/editar")
public class AlterarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_cliente = req.getParameter("id");
        ClienteDAO cdao = new ClienteDAO();
        Cliente clienteSelecionado = cdao.getClienteById(id_cliente);

        req.setAttribute("cliente", clienteSelecionado);

        RequestDispatcher rd = req.getRequestDispatcher("/alterarcliente.jsp");

        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente clienteAlterado = new Cliente();
        clienteAlterado.setId_cliente(req.getParameter("id"));
        clienteAlterado.setNome(req.getParameter("nome"));
        clienteAlterado.setEmail(req.getParameter("email"));
        clienteAlterado.setSenha(req.getParameter("senha"));

        ClienteDAO cd = new ClienteDAO();
        cd.update(clienteAlterado);
        resp.sendRedirect("home");
    }
}
