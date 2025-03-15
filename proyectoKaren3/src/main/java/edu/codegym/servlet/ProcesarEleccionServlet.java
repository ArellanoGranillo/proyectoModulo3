package edu.codegym.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/procesarEleccion")
public class ProcesarEleccionServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Iniciando Servlet de decisión del primer nivel");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if (opcion == null) {
            response.sendRedirect("procesarEleccion.jsp");
            return;
        }

        System.out.println("Opción elegida: " + opcion);

        switch (opcion) {
            case "puerta":
                response.sendRedirect("perder.jsp");
                break;
            case "ducto":
                response.sendRedirect("segundaEleccion.jsp");
                break;
            default:
                response.sendRedirect("procesarEleccion.jsp");
                break;
        }
    }
}
