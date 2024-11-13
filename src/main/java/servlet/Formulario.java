package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/registro")
public class Formulario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //Segunda parte del formulario
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        boolean habilitar = req.getParameter("habilitar") != null && req.getParameter("habilitar").equals("on");

        //Implementamos un ArrayList para guardar los posibles errores de digitalización
        Map<String, String> errores = new HashMap<>();
        if (username == null || username.isBlank()) {
            errores.put("username","El username es requerido");
        }

        if (password == null || password.isBlank()) {
            errores.put("password","El password es requerido");
        }
        if (email == null || !email.contains("@")) {
            errores.put("email","El email es requerido, y tiene que tener un formato de correo");
        }
        if (pais == null || pais.isBlank()) {
            errores.put("pais","El pais es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes","debe seleccionar al menos una opción");
        }
        if (roles == null || roles.length == 0) {
            errores.put("roles","Debe seleccionar al menos un rol");
        }
        if (idioma == null) {
            errores.put("idioma","Debe seleccionar al menos una opcion");
        }
        if (errores.isEmpty()) {
            try (PrintWriter out = resp.getWriter()) {
                //Creo la plantilla html
                out.print("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta charset=\"utf-8\">");
                out.println("<title>Resultado Formulario</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>resultado formualrio</h1>");
                out.println("<div>");


                out.println("<p>User: " + username + "</p>");
                out.println("<p>Password: " + password + "</p>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Pais: " + pais + "</p>");
                out.println("<h2>Lenguajes</h2>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    out.println("<p>" + lenguaje + "</p>");
                });

                out.println("<p> habilitar " + habilitar + "</p>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }

        } else {
           /* errores.forEach(error -> {
                out.println("<p>" + errores + "</p>");
            });*/
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }


        //Vamos añadir un boton para regresar
        // out.println("<p><a href=\"/formulario/index.jsp\">Volver</a></p>");


    }
}
