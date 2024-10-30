package com.edutecno.servlet;

import com.edutecno.dao.DepartamentoDAO;
import com.edutecno.dao.impl.DepartamentoDAOImpl;
import com.edutecno.model.Departamento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/departamento")
public class DepartamentoServlet extends HttpServlet {
    private DepartamentoDAO departamentoDAO;

    @Override
    public void init() throws ServletException {
        departamentoDAO = new DepartamentoDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filtro = request.getParameter("filtro");
        List<Departamento> departamentos = departamentoDAO.obtenerDepartamentosPorFiltro(filtro != null ? filtro : "");
        request.setAttribute("departamentos", departamentos);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
