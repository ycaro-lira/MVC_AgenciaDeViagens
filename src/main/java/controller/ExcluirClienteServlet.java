package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteDAO;

@WebServlet("/excluir")
public class ExcluirClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCliente = req.getParameter("id");

        ClienteDAO cdao = new ClienteDAO();

        cdao.removeById(idCliente);

        resp.sendRedirect("home");
    }
}
