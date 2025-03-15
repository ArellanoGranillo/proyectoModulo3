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

@WebServlet("/final")
public class FinalServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Iniciando Servlet final");
    }
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
            String desafio = request.getParameter("desafio");
            HttpSession sesion = request.getSession();
            ServletContext contexto = getServletContext();

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
            playerStats[1]++; // Aumentar victorias
            stats.put(playerName, playerStats);

            System.out.println(playerName + " ha ganado. Victorias: " + playerStats[1]);

            if ("true".equals(desafio)) {
                System.out.println("Jugador aceptó el desafío, redirigiendo al inicio");
                resp.sendRedirect("index.jsp"); // Ahora apunta correctamente al formulario de nombre
            } else {
                System.out.println("Jugador rechazó el desafío, redirigiendo a perder.jsp");
                resp.sendRedirect("perder.jsp");
            }
        }
    }
