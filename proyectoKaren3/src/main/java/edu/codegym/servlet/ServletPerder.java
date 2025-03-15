package edu.codegym.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/perder")
public class ServletPerder extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Iniciando Servlet perder");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String desafio = request.getParameter("desafio");
        HttpSession sesion = request.getSession();
        ServletContext contexto = getServletContext();

        // Obtener el nombre del jugador
        String playerName = (String) sesion.getAttribute("playerName");
        if (playerName == null) {
            resp.sendRedirect("nombre.jsp");
            return;
        }

        Map<String, int[]> stats = (Map<String, int[]>) contexto.getAttribute("estadisticas");
        if (stats == null) {
            stats = new HashMap<>();
            contexto.setAttribute("estadisticas", stats);
        }

        int[] playerStats = stats.getOrDefault(playerName, new int[]{0, 0});
        playerStats[0]++; // Aumentar derrotas
        stats.put(playerName, playerStats);

        System.out.println(playerName + " ha perdido. Derrotas: " + playerStats[0]);
        if ("true".equals(desafio)) {
            System.out.println("Jugador aceptó el desafío, redirigiendo al formulario de nombre");
            resp.sendRedirect("index.jsp");
        } else {
            System.out.println("Jugador rechazó el desafío, redirigiendo a perder.jsp");
            resp.sendRedirect("perder.jsp");
        }
    }
}
