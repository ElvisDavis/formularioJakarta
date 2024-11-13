<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--Importamos la biblioteca map--%>
<%@page import="java.util.Map" %>

<%--Implementamos un scriplet--%>
<%
Map<String, String> errores= (Map<String, String>)request.getAttribute("errores");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario</title>
</head>
<body>
<h1>Manejo de formularios</h1>

<%--Implementamos una condición para saber si errores esta vacio o no --%>

<%
if(errores != null && errores.size()>0){
%>
<ul>
    <%
        //listamos los errores que tenemos
        for (String error: errores.values()) {%>
            <li><%=error%></li>

     <%   }%>
</ul>
<%}%>

</ul>

<div>
    <form action="/formulario/registro" method="post">
        <div>
            <label for="usuario">Usuario</label>
            <input name="username" type="text" id="usuario" placeholder="Ingres el usuario">
            <%
                if(errores !=null & errores.containsKey("username")){
                    out.println("<div style='color:red;'>"+errores.get("username")+"</div>");
                }
            %>
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="password">
        </div>
        <div>
            <label for="email">Correo Electrónico</label>
            <input type="email" name="email" id="email" placeholder="email">
        </div>
        <!--Generando los select-->
        <div>
            <label>Paises</label>
            <div>
                <select name="pais" id="pais">
                    <option value="">---Selecionar el país---</option>
                    <option value="EC" selected>Ecuador</option>
                    <option value="MX">México</option>
                    <option value="CL">Chile</option>
                    <option value="AR">Argentina</option>
                    <option value="PE">Perú</option>

                </select>
            </div>
        </div>

        <!--Select del Lenguaje de programación -->
        <div>
            <label for="lenguajes">Lenguajes de programación </label>
            <div>
                <select name="lenguajes" id="lenguajes" multiple>
                    <option value="Java" selected>Java SE</option>
                    <option value="jakartaee" selected>Jakarta EE</option>
                    <option value="spring">Spring Boot</option>
                    <option value="javaScript">JavaScript</option>
                    <option value="angular">Angular</option>
                </select>
            </div>
        </div>

        <!--Checkbox para roles-->
        <div>
            <label>Roles</label>
            <div>
                <input type="checkbox" name="roles" value="ROLE_ADMIN">
                <label >Administrador</label>
            </div>
            <div>
                <input type="checkbox" name="roles" value="ROLE_USER" checked>
                <label>Usuario</label>
            </div>
            <div>
                <input type="checkbox" name="roles" value="ROLE_DIGI">
                <label>Digitador</label>
            </div>
        </div>

        <!--Radio buttons idiomas-->
        <div>
            <label>Idiomas</label>
            <div>
                <input type="radio" name="idioma" value="es">
                <label>Español</label>
            </div>
            <div>
                <input type="radio" name="idioma" value="en">
                <label>Ingles</label>
            </div>
            <div>
                <input type="radio" name="idioma" value="ru">
                <label>RUSO</label>
            </div>
        </div>
        <!--Checkbox para habilitar el usuario-->
        <div>
            <label for="habilitar">Habilitar</label>
            <div>
                <input type="checkbox" name="habilitar" id="habilitar" checked>
            </div>
        </div>
        <div>
            <input type="submit" value="Enviar">
        </div>

    </form>
</div>

</body>
</html>