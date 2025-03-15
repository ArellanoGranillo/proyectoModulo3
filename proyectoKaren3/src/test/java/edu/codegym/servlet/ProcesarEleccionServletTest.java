package edu.codegym.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class ProcesarEleccionServletTest {

    private ProcesarEleccionServlet servlet;
      private HttpServletRequest request;
    private HttpServletResponse resp;
    private HttpSession session;
    private ServletContext context;
    private ServletConfig servletConfig;

    @BeforeEach
    void setUp() {
        servlet = new ProcesarEleccionServlet();
        request = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        context = mock(ServletContext.class);
        servletConfig = mock(ServletConfig.class);

        when(servletConfig.getServletContext()).thenReturn(context);
        try {
            servlet.init(servletConfig);  // Inicializamos el servlet
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSinOpcionElegida() throws ServletException, IOException {

        when(request.getParameter("opcion")).thenReturn(null);

        servlet.doPost(request, resp);

        verify(resp).sendRedirect("procesarEleccion.jsp");
    }

    @Test
    void testOpcionPuerta() throws ServletException, IOException {

        when(request.getParameter("opcion")).thenReturn("puerta");

        servlet.doPost(request, resp);

        verify(resp).sendRedirect("perder.jsp");
    }

    @Test
    void testOpcionDucto() throws ServletException, IOException {

        when(request.getParameter("opcion")).thenReturn("ducto");

        servlet.doPost(request, resp);

        verify(resp).sendRedirect("segundaEleccion.jsp");
    }

}
