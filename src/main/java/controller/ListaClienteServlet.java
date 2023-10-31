package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.ClienteDAO;

@WebServlet("/home")
public class ListaClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        ClienteDAO cdao = new ClienteDAO();
        clientes = cdao.getClientes();
        req.setAttribute("listaClientes", clientes);

        RequestDispatcher dispatcher = req.getRequestDispatcher("cadastro2.jsp");
        dispatcher.forward(req, resp);
    }
}
